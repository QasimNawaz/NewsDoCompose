package com.qasimnawaz019.newsdocompose.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewsDoComposeLabelledCheckBox(
    modifier: Modifier,
    isChecked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    label: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { checked_ ->
                    onCheckedChange(checked_)
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = NewsDoComposeTheme.colors.primary,
                    uncheckedColor = NewsDoComposeTheme.colors.textSecondary.copy(alpha = 0.5f),
                    checkmarkColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.size(6.dp))
        Text(
            text = label,
            color = NewsDoComposeTheme.colors.textSecondary.copy(alpha = 0.5f),
            fontSize = 12.sp,
        )
    }
}