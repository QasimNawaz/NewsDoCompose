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
    tabGradient = listOf(GradiantValue1, GradiantValue2),
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    textPrimary = Neutral7,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    cardBackground = Neutral0,
    cardContent = Neutral6,
    bottomBarBackground = Primary,
    bottomBarItemColor = Primary_20,
    flashWhite = FlashWhite,
    isDark = false
)

private val DarkColorPalette = NewsDoComposeColors(
    tabGradient = listOf(GradiantValue1, GradiantValue2),
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    textPrimary = Neutral0,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    cardBackground = Neutral8,
    cardContent = Neutral0,
    bottomBarBackground = Primary,
    bottomBarItemColor = Primary_20,
    flashWhite = FlashWhite,
    isDark = true
)

//private val LightColorPalette = NewsDoComposeColors(
//    brand = Shadow5,
//    brandSecondary = Ocean3,
//    uiBackground = OrangeWhite,
//    uiBorder = Neutral4,
//    uiFloated = FunctionalGrey,
//    textPrimary = Shadow1,
//    textSecondary = Neutral7,
//    primary = Primary,
//    flashWhite = FlashWhite,
//    textHelp = Neutral6,
//    textInteractive = Neutral0,
//    textLink = Ocean11,
//    iconSecondary = Neutral7,
//    iconInteractive = Neutral0,
//    iconInteractiveInactive = Neutral1,
//    error = FunctionalRed,
//    cardBackground = Neutral0,
//    cardContent = Neutral6,
//    bottomBarBackground = Primary,
//    bottomBarItemColor = Primary_20,
//    gradient2_3 = listOf(GradiantValue1, GradiantValue2),
//    tornado1 = listOf(Shadow4, Ocean3),
//    isDark = false
//)
//
//private val DarkColorPalette = NewsDoComposeColors(
//    brand = Shadow1,
//    brandSecondary = Ocean2,
//    uiBackground = CharcoalBlack,
//    uiBorder = Neutral3,
//    uiFloated = FunctionalDarkGrey,
//    textPrimary = Shadow1,
//    textSecondary = Neutral0,
//    primary = Primary,
//    flashWhite = FlashWhite,
//    textHelp = Neutral1,
//    textInteractive = Neutral7,
//    textLink = Ocean2,
//    iconPrimary = Shadow1,
//    iconSecondary = Neutral0,
//    iconInteractive = Neutral7,
//    iconInteractiveInactive = Neutral6,
//    error = FunctionalRedDark,
//    cardBackground = Neutral8,
//    cardContent = Neutral0,
//    bottomBarBackground = Primary,
//    bottomBarItemColor = Primary_20,
//    gradient2_3 = listOf(GradiantValue1, GradiantValue2),
//    tornado1 = listOf(Shadow4, Ocean3),
//    isDark = true
//)

@Composable
fun NewsDoComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.background.copy(alpha = AlphaNearOpaque)
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
    tabGradient: List<Color>,
    primary: Color,
    onPrimary: Color,
    secondary: Color,
    onSecondary: Color,
    textPrimary: Color,
    error: Color,
    onError: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    cardBackground: Color,
    cardContent: Color,
    bottomBarBackground: Color,
    bottomBarItemColor: Color,
    flashWhite: Color,
    isDark: Boolean
) {
    var tabGradient by mutableStateOf(tabGradient)
        private set
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var error by mutableStateOf(error)
        private set
    var onError by mutableStateOf(onError)
        private set
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var cardBackground by mutableStateOf(cardBackground)
        private set
    var cardContent by mutableStateOf(cardContent)
        private set
    var bottomBarBackground by mutableStateOf(bottomBarBackground)
        private set
    var bottomBarItemColor by mutableStateOf(bottomBarItemColor)
        private set
    var flashWhite by mutableStateOf(flashWhite)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: NewsDoComposeColors) {
        tabGradient = other.tabGradient
        primary = other.primary
        onPrimary = other.onPrimary
        secondary = other.secondary
        onSecondary = other.onSecondary
        textPrimary = other.textPrimary
        error = other.error
        onError = other.onError
        background = other.background
        onBackground = other.onBackground
        surface = other.surface
        onSurface = other.onSurface
        cardBackground = other.cardBackground
        cardContent = other.cardContent
        bottomBarBackground = other.bottomBarBackground
        bottomBarItemColor = other.bottomBarItemColor
        flashWhite = other.flashWhite
        isDark = other.isDark
    }

    fun copy(): NewsDoComposeColors = NewsDoComposeColors(
        tabGradient = tabGradient,
        primary = primary,
        onPrimary = onPrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        textPrimary = textPrimary,
        error = error,
        onError = onError,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        cardBackground = cardBackground,
        cardContent = cardContent,
        bottomBarBackground = bottomBarBackground,
        bottomBarItemColor = bottomBarItemColor,
        flashWhite = flashWhite,
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
