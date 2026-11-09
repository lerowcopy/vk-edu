package com.example.vkedu.presentation

sealed interface AppListEvent {
    data object ToolbarClicked : AppListEvent
}
