package com.example.vkedu.ui

import androidx.compose.runtime.Immutable
import com.example.vkedu.data.AppInfo

@Immutable
sealed interface AppListState {
    data object Loading : AppListState
    data class Content(val apps: List<AppInfo>) : AppListState
}
