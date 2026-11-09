package com.example.vkedu.presentation.appdetails

import androidx.compose.runtime.Immutable
import com.example.vkedu.domain.appdetails.AppDetails
import com.example.vkedu.domain.appdetails.SimilarApp
import com.example.vkedu.domain.applist.AppInfo

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<SimilarApp>,
        val showcaseApps: List<AppInfo>,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}
