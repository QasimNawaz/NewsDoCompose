package com.qasimnawaz019.newsdocompose.ui.screens.profile

import android.content.Intent
import android.net.Uri
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme

@Composable
fun ProfileScreen() {

    val context = LocalContext.current

    val githubAnnotatedString = buildAnnotatedString {
        append("Github Profile: ")
        pushStringAnnotation(
            tag = "github",
            annotation = "https://github.com/QasimNawaz"
        )
        withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
            append("Link")
        }
        pop()
    }

    val linkdInAnnotatedString = buildAnnotatedString {
        append("LinkedIn Profile: ")
        pushStringAnnotation(
            tag = "linkedin",
            annotation = "https://www.linkedin.com/in/qasimnawaz019"
        )
        withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
            append("Link")
        }
        pop()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NewsDoComposeTheme.colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "Profile Picture"
        )
        Text(
            text = "Qasim Nawaz",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = NewsDoComposeTheme.colors.textPrimary
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Android Developer",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold,
            color = NewsDoComposeTheme.colors.textPrimary
        )
        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(text = githubAnnotatedString, onClick = { offset ->
            githubAnnotatedString.getStringAnnotations(tag = "github", start = offset, end = offset)
                .firstOrNull()?.let {
                    val urlIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(it.item)
                    )
                    context.startActivity(urlIntent)
                }
        })
        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(text = linkdInAnnotatedString, onClick = { offset ->
            linkdInAnnotatedString.getStringAnnotations(
                tag = "linkedin",
                start = offset,
                end = offset
            )
                .firstOrNull()?.let {
                    val urlIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(it.item)
                    )
                    context.startActivity(urlIntent)
                }
        })
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen()
}