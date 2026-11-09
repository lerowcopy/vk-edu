package com.example.vkedu.presentation.appdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.vkedu.data.appdetails.SimilarAppMapper
import com.example.vkedu.data.appdetails.SimilarAppsApi
import com.example.vkedu.data.appdetails.SimilarAppsRepositoryImpl
import com.example.vkedu.data.appdetails.StubAppDetailsRepository
import com.example.vkedu.data.applist.AppInfoMapper
import com.example.vkedu.data.applist.AppListApi
import com.example.vkedu.data.applist.AppListRepositoryImpl
import com.example.vkedu.domain.appdetails.GetSimilarAppsUseCase
import com.example.vkedu.domain.appdetails.GetAppDetailsUseCase
import com.example.vkedu.domain.applist.GetShowcaseAppsUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppDetailsViewModel(
    private val getAppDetailsUseCase: GetAppDetailsUseCase,
    private val getSimilarAppsUseCase: GetSimilarAppsUseCase,
    private val getShowcaseAppsUseCase: GetShowcaseAppsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    private var loadingJob: Job? = null

    init {
        getAppDetails()
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        _state.update { currentState ->
            if (currentState is AppDetailsState.Content) {
                currentState.copy(descriptionCollapsed = true)
            } else {
                currentState
            }
        }
    }

    fun getAppDetails() {
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            _state.value = AppDetailsState.Loading

            try {
                val similarApps = getSimilarAppsUseCase()
                val showcaseApps = getShowcaseAppsUseCase()
                getAppDetailsUseCase("fa2e31b8-1234-4cf7-9914-108a170a1b01").collect { appDetails ->
                    val currentState = _state.value
                    _state.value = AppDetailsState.Content(
                        appDetails = appDetails,
                        similarApps = similarApps,
                        showcaseApps = showcaseApps,
                        descriptionCollapsed = (currentState as? AppDetailsState.Content)
                            ?.descriptionCollapsed ?: false,
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _state.value = AppDetailsState.Error
                Log.e("AppDetailsViewModel", "Failed to load app details", e)
            }
        }
    }

    companion object {
        // Вместо Hilt собираем зависимости вручную.
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AppDetailsViewModel(
                    getAppDetailsUseCase = GetAppDetailsUseCase(StubAppDetailsRepository()),
                    getSimilarAppsUseCase = GetSimilarAppsUseCase(
                        SimilarAppsRepositoryImpl(SimilarAppsApi(), SimilarAppMapper()),
                    ),
                    getShowcaseAppsUseCase = GetShowcaseAppsUseCase(
                        AppListRepositoryImpl(AppListApi(), AppInfoMapper()),
                    ),
                )
            }
        }
    }
}
