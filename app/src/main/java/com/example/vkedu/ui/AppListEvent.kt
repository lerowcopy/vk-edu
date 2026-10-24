package com.example.vkedu.ui

sealed interface AppListEvent {
    data object ToolbarClicked : AppListEvent
}
