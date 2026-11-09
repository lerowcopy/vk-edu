package com.example.vkedu.ui.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkedu.R
import com.example.vkedu.data.AppInfo
import com.example.vkedu.ui.StatusBarIcons
import kotlinx.coroutines.flow.Flow

@Composable
fun AppDetailsScreen(
    onBackClick: () -> Unit,
    onShowcaseAppClick: (AppInfo) -> Unit,
    viewModel: AppDetailsViewModel = viewModel(factory = AppDetailsViewModel.Factory),
) {
    StatusBarIcons(darkIcons = MaterialTheme.colorScheme.background.luminance() > 0.5f)

    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
    ) { contentPadding ->
        when (val currentState = state) {
            is AppDetailsState.Loading -> {
                AppDetailsLoading(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Error -> {
                AppDetailsError(
                    onRefreshClick = { viewModel.getAppDetails() },
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Content -> {
                AppDetailsContent(
                    content = currentState,
                    onBackClick = onBackClick,
                    onShareClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onInstallClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onReadMoreClick = {
                        viewModel.collapseDescription()
                    },
                    onSimilarAppDownloadClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onDeveloperClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onShowcaseAppClick = onShowcaseAppClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }
        }
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppDetailsEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val underDevelopementText = stringResource(R.string.under_development)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppDetailsEvent.UnderDevelopment -> {
                    snackbarHostState.showSnackbar(underDevelopementText)
                }
            }
        }
    }
}