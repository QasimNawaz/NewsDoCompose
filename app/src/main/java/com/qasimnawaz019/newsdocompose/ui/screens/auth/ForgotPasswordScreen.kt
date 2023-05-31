package com.qasimnawaz019.newsdocompose.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.graphs.Graph
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme
import com.qasimnawaz019.newsdocompose.ui.components.NewsDoComposeLabelledCheckBox
import com.qasimnawaz019.newsdocompose.ui.components.NewsDoComposeOutlinedTextField
import com.qasimnawaz019.newsdocompose.ui.components.NewsDoComposeOutlinedTextFieldPassword
import com.qasimnawaz019.newsdocompose.ui.components.SocialButton

@Composable
fun ForgotPasswordScreen(navController: NavHostController) {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(value = false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = NewsDoComposeTheme.colors.surface)
            .padding(30.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.size(20.dp))
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "null",
                tint = NewsDoComposeTheme.colors.textPrimary
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Forgot\nPassword?",
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                color = NewsDoComposeTheme.colors.textPrimary
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Don’t worry! it happens. Please enter the\n" +
                        "address associated with your account.",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Light,
                color = NewsDoComposeTheme.colors.textPrimary.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.size(20.dp))
            NewsDoComposeOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = userName,
                onValueChange = { userName = it },
                label = "Email ID / Mobile number",
                iconDrawable = null
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, false),
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, backgroundColor = NewsDoComposeTheme.colors.primary
            )
        ) {
            Text(text = "Submit")
        }
    }
}