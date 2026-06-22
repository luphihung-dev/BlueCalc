package com.luphihung.bluecalc.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.luphihung.bluecalc.R

@Composable
fun BlueCalcTheme(
    content: @Composable () -> Unit
) {
    val lightScheme = lightColorScheme(
        primary = colorResource(R.color.bluecalc_primary),
        onPrimary = colorResource(R.color.bluecalc_on_primary),
        primaryContainer = colorResource(R.color.bluecalc_primary_container),
        background = colorResource(R.color.bluecalc_background),
        onBackground = colorResource(R.color.bluecalc_text),
        surface = colorResource(R.color.bluecalc_surface),
        onSurface = colorResource(R.color.bluecalc_text),
        onSurfaceVariant = colorResource(R.color.bluecalc_text_secondary),
        error = colorResource(R.color.bluecalc_error)
    )

    MaterialTheme(
        colorScheme = lightScheme,
        typography = Typography,
        content = content
    )
}
