package com.example.vkedu.ui

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Выбирает цвет иконок статус-бара для текущего экрана.
 *
 * С навигацией на одном Activity живут два экрана с разным фоном под статус-баром
 * (цветной тулбар у списка и светлый фон у карточки), поэтому стиль бара,
 * заданный один раз в MainActivity, подходит только одному из них.
 *
 * @param darkIcons true — тёмные иконки (для светлого фона), false — светлые (для тёмного).
 */
@Composable
fun StatusBarIcons(darkIcons: Boolean) {
    val view = LocalView.current
    val activity = LocalActivity.current
    if (!view.isInEditMode && activity != null) {
        DisposableEffect(activity, darkIcons) {
            WindowCompat.getInsetsController(activity.window, view)
                .isAppearanceLightStatusBars = darkIcons
            onDispose { }
        }
    }
}
