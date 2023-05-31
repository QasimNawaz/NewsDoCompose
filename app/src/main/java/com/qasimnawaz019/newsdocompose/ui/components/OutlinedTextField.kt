package com.qasimnawaz019.newsdocompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme

@Composable
fun NewsDoComposeOutlinedTextField(
    modifier: Modifier,
    value: String,
    onValueChange: ((String) -> Unit),
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    iconDrawable: Int?
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        trailingIcon = {
            iconDrawable?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "null",
                )
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = NewsDoComposeTheme.colors.primary,
            unfocusedBorderColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            textColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            focusedLabelColor = NewsDoComposeTheme.colors.primary,
            unfocusedLabelColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            cursorColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            trailingIconColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
        )
    )
}

@Composable
fun NewsDoComposeOutlinedTextFieldPassword(
    modifier: Modifier,
    value: String,
    onValueChange: ((String) -> Unit),
    label: String,
) {
    var showPassword by remember { mutableStateOf(value = false) }
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = label) },
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye),
                        contentDescription = "hide_password",
                    )
                }
            } else {
                IconButton(onClick = { showPassword = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye_slash),
                        contentDescription = "hide_password",
                    )
                }
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = NewsDoComposeTheme.colors.primary,
            unfocusedBorderColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            textColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            focusedLabelColor = NewsDoComposeTheme.colors.primary,
            unfocusedLabelColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            cursorColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
            trailingIconColor = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f),
        )
    )
}