package com.example.vkedu.presentation.applist

sealed interface AppListEvent {
    data object ToolbarClicked : AppListEvent
}
