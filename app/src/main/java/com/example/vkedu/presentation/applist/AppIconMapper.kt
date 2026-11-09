package com.example.vkedu.presentation.applist

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkedu.domain.applist.AppIcon

/** Доменная иконка -> ImageVector. Compose-типы живут только в presentation. */
internal fun AppIcon.toImageVector(): ImageVector = when (this) {
    AppIcon.FACE -> Icons.Filled.Face
    AppIcon.SEND -> Icons.AutoMirrored.Filled.Send
    AppIcon.PLACE -> Icons.Filled.Place
    AppIcon.PLAY -> Icons.Filled.PlayArrow
    AppIcon.LOCK -> Icons.Filled.Lock
    AppIcon.CART -> Icons.Filled.ShoppingCart
    AppIcon.CALENDAR -> Icons.Filled.DateRange
    AppIcon.EMAIL -> Icons.Filled.Email
    AppIcon.EDIT -> Icons.Filled.Edit
    AppIcon.FAVORITE -> Icons.Filled.Favorite
    AppIcon.SEARCH -> Icons.Filled.Search
    AppIcon.LOCATION -> Icons.Filled.LocationOn
    AppIcon.INFO -> Icons.Filled.Info
    AppIcon.ACCOUNT -> Icons.Filled.AccountCircle
    AppIcon.THUMB_UP -> Icons.Filled.ThumbUp
    AppIcon.HOME -> Icons.Filled.Home
    AppIcon.BUILD -> Icons.Filled.Build
    AppIcon.DEFAULT -> Icons.Filled.Star
}
