package com.example.vkedu.presentation.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.vkedu.data.applist.AppInfoMapper
import com.example.vkedu.data.applist.AppListApi
import com.example.vkedu.data.applist.AppListRepositoryImpl
import com.example.vkedu.domain.applist.GetAppsUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppListViewModel(
    private val getAppsUseCase: GetAppsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    fun onToolbarClick() {
        viewModelScope.launch {
            _events.send(AppListEvent.ToolbarClicked)
        }
    }

    private fun loadApps() {
        viewModelScope.launch {
            Log.d(TAG, "loadApps")
            _state.value = AppListState.Content(apps = getAppsUseCase())
        }
    }

    companion object {
        private const val TAG = "AppListViewModel"

        // Вместо Hilt собираем зависимости вручную.
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AppListViewModel(
                    getAppsUseCase = GetAppsUseCase(
                        AppListRepositoryImpl(AppListApi(), AppInfoMapper()),
                    ),
                )
            }
        }
    }
}
