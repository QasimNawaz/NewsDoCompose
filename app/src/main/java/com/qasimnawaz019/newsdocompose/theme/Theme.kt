/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qasimnawaz019.newsdocompose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette = NewsDoComposeColors(
    brand = Shadow5,
    brandSecondary = Ocean3,
    uiBackground = OrangeWhite,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textPrimary = Shadow1,
    textSecondary = Neutral7,
    primary = Primary,
    flashWhite = FlashWhite,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    cardBackground = Neutral0,
    cardContent = Neutral6,
    bottomBarBackground = Primary,
    bottomBarItemColor = Primary_20,
    gradient2_3 = listOf(GradiantValue1, GradiantValue2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

private val DarkColorPalette = NewsDoComposeColors(
    brand = Shadow1,
    brandSecondary = Ocean2,
    uiBackground = CharcoalBlack,
    uiBorder = Neutral3,
    uiFloated = FunctionalDarkGrey,
    textPrimary = Shadow1,
    textSecondary = Neutral0,
    primary = Primary,
    flashWhite = FlashWhite,
    textHelp = Neutral1,
    textInteractive = Neutral7,
    textLink = Ocean2,
    iconPrimary = Shadow1,
    iconSecondary = Neutral0,
    iconInteractive = Neutral7,
    iconInteractiveInactive = Neutral6,
    error = FunctionalRedDark,
    cardBackground = Neutral8,
    cardContent = Neutral0,
    bottomBarBackground = Primary,
    bottomBarItemColor = Primary_20,
    gradient2_3 = listOf(GradiantValue1, GradiantValue2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = true
)

@Composable
fun NewsDoComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.uiBackground.copy(alpha = AlphaNearOpaque)
        )
    }

    ProvideNewsDoComposeColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object NewsDoComposeTheme {
    val colors: NewsDoComposeColors
        @Composable get() = LocalNewsDoComposeColors.current
}

/**
 * NewsDoCompose custom Color Palette
 */
@Stable
class NewsDoComposeColors(
    gradient2_3: List<Color>,
    brand: Color,
    brandSecondary: Color,
    uiBackground: Color,
    uiBorder: Color,
    uiFloated: Color,
    textPrimary: Color = brand,
    textSecondary: Color,
    primary: Color,
    flashWhite: Color,
    textHelp: Color,
    textInteractive: Color,
    textLink: Color,
    tornado1: List<Color>,
    iconPrimary: Color = brand,
    iconSecondary: Color,
    iconInteractive: Color,
    iconInteractiveInactive: Color,
    error: Color,
    notificationBadge: Color = error,
    cardBackground: Color,
    cardContent: Color,
    bottomBarBackground: Color,
    bottomBarItemColor: Color,
    isDark: Boolean
) {
    var gradient2_3 by mutableStateOf(gradient2_3)
        private set
    var brand by mutableStateOf(brand)
        private set
    var brandSecondary by mutableStateOf(brandSecondary)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var uiBorder by mutableStateOf(uiBorder)
        private set
    var uiFloated by mutableStateOf(uiFloated)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var primary by mutableStateOf(primary)
        private set
    var flashWhite by mutableStateOf(flashWhite)
        private set
    var textHelp by mutableStateOf(textHelp)
        private set
    var textInteractive by mutableStateOf(textInteractive)
        private set
    var tornado1 by mutableStateOf(tornado1)
        private set
    var textLink by mutableStateOf(textLink)
        private set
    var iconPrimary by mutableStateOf(iconPrimary)
        private set
    var iconSecondary by mutableStateOf(iconSecondary)
        private set
    var iconInteractive by mutableStateOf(iconInteractive)
        private set
    var iconInteractiveInactive by mutableStateOf(iconInteractiveInactive)
        private set
    var error by mutableStateOf(error)
        private set
    var notificationBadge by mutableStateOf(notificationBadge)
        private set
    var cardBackground by mutableStateOf(cardBackground)
        private set
    var cardContent by mutableStateOf(cardContent)
        private set
    var bottomBarBackground by mutableStateOf(bottomBarBackground)
        private set
    var bottomBarItemColor by mutableStateOf(bottomBarItemColor)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: NewsDoComposeColors) {
        gradient2_3 = other.gradient2_3
        brand = other.brand
        brandSecondary = other.brandSecondary
        uiBackground = other.uiBackground
        uiBorder = other.uiBorder
        uiFloated = other.uiFloated
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        primary = other.primary
        flashWhite = other.flashWhite
        textHelp = other.textHelp
        textInteractive = other.textInteractive
        textLink = other.textLink
        tornado1 = other.tornado1
        iconPrimary = other.iconPrimary
        iconSecondary = other.iconSecondary
        iconInteractive = other.iconInteractive
        iconInteractiveInactive = other.iconInteractiveInactive
        error = other.error
        notificationBadge = other.notificationBadge
        cardBackground = other.cardBackground
        cardContent = other.cardContent
        bottomBarBackground = other.bottomBarBackground
        bottomBarItemColor = other.bottomBarItemColor
        isDark = other.isDark
    }

    fun copy(): NewsDoComposeColors = NewsDoComposeColors(
        gradient2_3 = gradient2_3,
        brand = brand,
        brandSecondary = brandSecondary,
        uiBackground = uiBackground,
        uiBorder = uiBorder,
        uiFloated = uiFloated,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        primary = primary,
        flashWhite = flashWhite,
        textHelp = textHelp,
        textInteractive = textInteractive,
        textLink = textLink,
        tornado1 = tornado1,
        iconPrimary = iconPrimary,
        iconSecondary = iconSecondary,
        iconInteractive = iconInteractive,
        iconInteractiveInactive = iconInteractiveInactive,
        error = error,
        notificationBadge = notificationBadge,
        cardBackground = cardBackground,
        cardContent = cardContent,
        bottomBarBackground = bottomBarBackground,
        bottomBarItemColor = bottomBarItemColor,
        isDark = isDark,
    )
}

@Composable
fun ProvideNewsDoComposeColors(
    colors: NewsDoComposeColors, content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalNewsDoComposeColors provides colorPalette, content = content)
}

private val LocalNewsDoComposeColors = staticCompositionLocalOf<NewsDoComposeColors> {
    error("No NewsDoComposeColorPalette provided")
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [NewsDoComposeTheme.colors].
 */
fun debugColors(
    darkTheme: Boolean, debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)
