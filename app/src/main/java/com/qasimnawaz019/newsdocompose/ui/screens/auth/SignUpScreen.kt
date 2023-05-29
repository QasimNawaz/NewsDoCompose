package com.qasimnawaz019.newsdocompose.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun SignUpScreen(navController: NavHostController) {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(value = false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = NewsDoComposeTheme.colors.uiBackground)
            .padding(30.dp),
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Hello!",
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.Bold,
            color = NewsDoComposeTheme.colors.primary
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = "Signup to get started",
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Light,
            color = NewsDoComposeTheme.colors.textSecondary.copy(alpha = 0.5f)
        )
        Spacer(modifier = Modifier.size(20.dp))
        NewsDoComposeOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = "Username",
            iconDrawable = R.drawable.ic_profile
        )
        Spacer(modifier = Modifier.size(10.dp))
        NewsDoComposeOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            label = "Email",
            keyboardType = KeyboardType.Email,
            iconDrawable = R.drawable.ic_email
        )
        Spacer(modifier = Modifier.size(10.dp))
        NewsDoComposeOutlinedTextFieldPassword(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = "Password"
        )

        Spacer(modifier = Modifier.size(10.dp))
        NewsDoComposeLabelledCheckBox(
            modifier = Modifier
                .fillMaxWidth(),
            isChecked = isChecked,
            onCheckedChange = { isChecked = it },
            label = "Remember me"
        )
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.popBackStack()
                navController.navigate(Graph.MAIN)
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, backgroundColor = NewsDoComposeTheme.colors.primary
            )
        ) {
            Text(text = "Signup")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = "or continue with",
            color = NewsDoComposeTheme.colors.textSecondary.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
        ) {
            SocialButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                drawable = R.drawable.ic_google,
                label = "Google"
            )
            Spacer(modifier = Modifier.size(10.dp))
            SocialButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                drawable = R.drawable.ic_facebook,
                label = "Facebook"
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .wrapContentWidth()
        ) {
            Text(
                text = "Already have an account ? ",
                color = NewsDoComposeTheme.colors.textSecondary.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier.clickable { navController.popBackStack() },
                text = "Login",
                color = NewsDoComposeTheme.colors.primary,
                fontSize = 12.sp
            )
        }
    }
}

