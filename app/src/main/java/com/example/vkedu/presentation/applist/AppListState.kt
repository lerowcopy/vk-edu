package com.example.vkedu.presentation.applist

import androidx.compose.runtime.Immutable
import com.example.vkedu.domain.applist.AppInfo

@Immutable
sealed interface AppListState {
    data object Loading : AppListState
    data class Content(val apps: List<AppInfo>) : AppListState
}
