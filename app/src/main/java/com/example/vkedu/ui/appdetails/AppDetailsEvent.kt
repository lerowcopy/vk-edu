package com.example.vkedu.ui.appdetails

sealed interface AppDetailsEvent {
    data object UnderDevelopment : AppDetailsEvent
}