package com.ttlabz.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

val ColorScheme.extended: ExtendedColors
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedColors.current

@Immutable
data class ExtendedColors(
    // Button states
    val primaryHover: Color,
    val destructiveHover: Color,
    val destructiveSecondaryOutline: Color,
    val disabledOutline: Color,
    val disabledFill: Color,
    val successOutline: Color,
    val success: Color,
    val onSuccess: Color,
    val secondaryFill: Color,

    // Text variants
    val textPrimary: Color,
    val textTertiary: Color,
    val textSecondary: Color,
    val textPlaceholder: Color,
    val textDisabled: Color,

    // Surface variants
    val surfaceLower: Color,
    val surfaceHigher: Color,
    val surfaceOutline: Color,
    val overlay: Color,

    // Accent colors
    val accentBlue: Color,
    val accentPurple: Color,
    val accentViolet: Color,
    val accentPink: Color,
    val accentOrange: Color,
    val accentYellow: Color,
    val accentGreen: Color,
    val accentTeal: Color,
    val accentLightBlue: Color,
    val accentGrey: Color,

    // Cake colors for chat bubbles
    val cakeViolet: Color,
    val cakeGreen: Color,
    val cakeBlue: Color,
    val cakePink: Color,
    val cakeOrange: Color,
    val cakeYellow: Color,
    val cakeTeal: Color,
    val cakePurple: Color,
    val cakeRed: Color,
    val cakeMint: Color,
)

val LightExtendedColors = ExtendedColors(
    primaryHover = PomboBrand600,
    destructiveHover = PomboRed600,
    destructiveSecondaryOutline = PomboRed200,
    disabledOutline = PomboBase200,
    disabledFill = PomboBase150,
    successOutline = PomboBrand100,
    success = PomboBrand600,
    onSuccess = PomboBase0,
    secondaryFill = PomboBase100,

    textPrimary = PomboBase1000,
    textTertiary = PomboBase800,
    textSecondary = PomboBase900,
    textPlaceholder = PomboBase700,
    textDisabled = PomboBase400,

    surfaceLower = PomboBase100,
    surfaceHigher = PomboBase100,
    surfaceOutline = PomboBase1000Alpha14,
    overlay = PomboBase1000Alpha80,

    accentBlue = PomboBlue,
    accentPurple = PomboPurple,
    accentViolet = PomboViolet,
    accentPink = PomboPink,
    accentOrange = PomboOrange,
    accentYellow = PomboYellow,
    accentGreen = PomboGreen,
    accentTeal = PomboTeal,
    accentLightBlue = PomboLightBlue,
    accentGrey = PomboGrey,

    cakeViolet = PomboCakeLightViolet,
    cakeGreen = PomboCakeLightGreen,
    cakeBlue = PomboCakeLightBlue,
    cakePink = PomboCakeLightPink,
    cakeOrange = PomboCakeLightOrange,
    cakeYellow = PomboCakeLightYellow,
    cakeTeal = PomboCakeLightTeal,
    cakePurple = PomboCakeLightPurple,
    cakeRed = PomboCakeLightRed,
    cakeMint = PomboCakeLightMint,
)

val DarkExtendedColors = ExtendedColors(
    primaryHover = PomboBrand600,
    destructiveHover = PomboRed600,
    destructiveSecondaryOutline = PomboRed200,
    disabledOutline = PomboBase900,
    disabledFill = PomboBase1000,
    successOutline = PomboBrand500Alpha40,
    success = PomboBrand500,
    onSuccess = PomboBase1000,
    secondaryFill = PomboBase900,

    textPrimary = PomboBase0,
    textTertiary = PomboBase200,
    textSecondary = PomboBase150,
    textPlaceholder = PomboBase400,
    textDisabled = PomboBase500,

    surfaceLower = PomboBase1000,
    surfaceHigher = PomboBase900,
    surfaceOutline = PomboBase100Alpha10Alt,
    overlay = PomboBase1000Alpha80,

    accentBlue = PomboBlue,
    accentPurple = PomboPurple,
    accentViolet = PomboViolet,
    accentPink = PomboPink,
    accentOrange = PomboOrange,
    accentYellow = PomboYellow,
    accentGreen = PomboGreen,
    accentTeal = PomboTeal,
    accentLightBlue = PomboLightBlue,
    accentGrey = PomboGrey,

    cakeViolet = PomboCakeDarkViolet,
    cakeGreen = PomboCakeDarkGreen,
    cakeBlue = PomboCakeDarkBlue,
    cakePink = PomboCakeDarkPink,
    cakeOrange = PomboCakeDarkOrange,
    cakeYellow = PomboCakeDarkYellow,
    cakeTeal = PomboCakeDarkTeal,
    cakePurple = PomboCakeDarkPurple,
    cakeRed = PomboCakeDarkRed,
    cakeMint = PomboCakeDarkMint,
)

val LightColorScheme = lightColorScheme(
    primary = PomboBrand500,
    onPrimary = PomboBrand1000,
    primaryContainer = PomboBrand100,
    onPrimaryContainer = PomboBrand900,

    secondary = PomboBase700,
    onSecondary = PomboBase0,
    secondaryContainer = PomboBase100,
    onSecondaryContainer = PomboBase900,

    tertiary = PomboBrand900,
    onTertiary = PomboBase0,
    tertiaryContainer = PomboBrand100,
    onTertiaryContainer = PomboBrand1000,

    error = PomboRed500,
    onError = PomboBase0,
    errorContainer = PomboRed200,
    onErrorContainer = PomboRed600,

    background = PomboBrand1000,
    onBackground = PomboBase0,
    surface = PomboBase0,
    onSurface = PomboBase1000,
    surfaceVariant = PomboBase100,
    onSurfaceVariant = PomboBase900,

    outline = PomboBase1000Alpha8,
    outlineVariant = PomboBase200,
)

val DarkColorScheme = darkColorScheme(
    primary = PomboBrand500,
    onPrimary = PomboBrand1000,
    primaryContainer = PomboBrand900,
    onPrimaryContainer = PomboBrand500,

    secondary = PomboBase400,
    onSecondary = PomboBase1000,
    secondaryContainer = PomboBase900,
    onSecondaryContainer = PomboBase150,

    tertiary = PomboBrand500,
    onTertiary = PomboBase1000,
    tertiaryContainer = PomboBrand900,
    onTertiaryContainer = PomboBrand500,

    error = PomboRed500,
    onError = PomboBase0,
    errorContainer = PomboRed600,
    onErrorContainer = PomboRed200,

    background = PomboBase1000,
    onBackground = PomboBase0,
    surface = PomboBase950,
    onSurface = PomboBase0,
    surfaceVariant = PomboBase900,
    onSurfaceVariant = PomboBase150,

    outline = PomboBase100Alpha10,
    outlineVariant = PomboBase800,
)