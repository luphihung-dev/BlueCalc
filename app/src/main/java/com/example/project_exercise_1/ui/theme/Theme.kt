package com.example.project_exercise_1.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.project_exercise_1.R

@Composable
fun ProjectExercise1Theme(
    content: @Composable () -> Unit
) {
    val lightScheme = lightColorScheme(
        primary = colorResource(R.color.clean_primary),
        onPrimary = colorResource(R.color.clean_on_primary),
        primaryContainer = colorResource(R.color.clean_primary_container),
        background = colorResource(R.color.clean_background),
        onBackground = colorResource(R.color.clean_text),
        surface = colorResource(R.color.clean_surface),
        onSurface = colorResource(R.color.clean_text),
        onSurfaceVariant = colorResource(R.color.clean_text_secondary),
        error = colorResource(R.color.clean_error)
    )

    MaterialTheme(
        colorScheme = lightScheme,
        typography = Typography,
        content = content
    )
}
