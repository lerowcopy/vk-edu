package com.example.vkedu.ui.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu.R
import com.example.vkedu.data.AppInfo
import com.example.vkedu.data.showcaseApps
import com.example.vkedu.ui.AppListItem
import com.example.vkedu.ui.theme.VkEduTheme

private const val APPS_PER_PAGE = 3

/**
 * Блок «Витрина»: заголовок и горизонтальный Pager, по 3 приложения на странице.
 * Вёрстка приложения — тот же [AppListItem], что и на экране списка.
 */
@Composable
fun Showcase(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pages = remember(apps) { apps.chunked(APPS_PER_PAGE) }
    val pagerState = rememberPagerState { pages.size }

    Column(modifier) {
        Text(
            text = stringResource(R.string.showcase_title),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(8.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 8.dp,
            verticalAlignment = Alignment.Top,
        ) { pageIndex ->
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                pages[pageIndex].forEach { app ->
                    AppListItem(
                        app = app,
                        onClick = { onAppClick(app) },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowcasePreview() {
    VkEduTheme {
        Showcase(
            apps = showcaseApps,
            onAppClick = {},
        )
    }
}
