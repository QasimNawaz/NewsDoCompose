package com.qasimnawaz019.newsdocompose.ui.screens.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme

@OptIn(
    ExperimentalFoundationApi::class, ExperimentalAnimationApi::class, ExperimentalPagerApi::class
)
@Composable
fun OnBoardingScreen(
    onBoardingCompleted: () -> Unit, viewModel: OnBoardingViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(8f),
            pageCount = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        PageIndicator(
            numberOfPages = pages.size,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(0.2f),
            pagerState = pagerState
        )
        FinishButton(
            modifier = Modifier.weight(0.5f), pagerState = pagerState
        ) {
            viewModel.saveOnBoardingState(completed = true)
            onBoardingCompleted.invoke()
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = onBoardingPage.topBg),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Pager To Bg"
            )

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp),
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "Pager Image"
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = onBoardingPage.title,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            text = onBoardingPage.description,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier, pagerState: PagerState, onClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(), visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = NewsDoComposeTheme.colors.primary
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicator(
    numberOfPages: Int,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    selectedColor: Color = NewsDoComposeTheme.colors.primary,
    defaultColor: Color = Color.LightGray,
    defaultRadius: Dp = 10.dp,
    selectedLength: Dp = 50.dp,
    space: Dp = 15.dp,
    animationDurationInMillis: Int = 300,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space),
        modifier = modifier,
    ) {
        repeat(numberOfPages) { iteration ->
            PageIndicatorView(
                isSelected = pagerState.settledPage == iteration,
                selectedColor = selectedColor,
                defaultColor = defaultColor,
                defaultRadius = defaultRadius,
                selectedLength = selectedLength,
                animationDurationInMillis = animationDurationInMillis,
            )
        }
    }
}

@Composable
fun PageIndicatorView(
    isSelected: Boolean,
    selectedColor: Color,
    defaultColor: Color,
    defaultRadius: Dp,
    selectedLength: Dp,
    animationDurationInMillis: Int,
    modifier: Modifier = Modifier,
) {

    val color: Color by animateColorAsState(
        targetValue = if (isSelected) {
            selectedColor
        } else {
            defaultColor
        }, animationSpec = tween(
            durationMillis = animationDurationInMillis,
        )
    )
    val width: Dp by animateDpAsState(
        targetValue = if (isSelected) {
            selectedLength
        } else {
            defaultRadius
        }, animationSpec = tween(
            durationMillis = animationDurationInMillis,
        )
    )

    Canvas(
        modifier = modifier.size(
            width = width,
            height = defaultRadius,
        ),
    ) {
        drawRoundRect(
            color = color,
            topLeft = Offset.Zero,
            size = Size(
                width = width.toPx(),
                height = defaultRadius.toPx(),
            ),
            cornerRadius = CornerRadius(
                x = defaultRadius.toPx(),
                y = defaultRadius.toPx(),
            ),
        )
    }
}


@Composable
@Preview
fun OnBoardingScreenPreview() {
    OnBoardingScreen({})
}

sealed class OnBoardingPage(
    @DrawableRes val topBg: Int,
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {

    object First : OnBoardingPage(
        topBg = R.drawable.ic_onboarding_bg_one,
        image = R.drawable.ic_onboarding_one,
        title = "Explore The World",
        description = "Stay informed and discover the latest news with our intuitive onboarding news explore feature. Explore breaking news, stay up-to-date with your favorite topics, and uncover stories that matter to you. Start your news journey effortlessly with our mobile app."
    )

    object Second : OnBoardingPage(
        topBg = R.drawable.ic_onboarding_bg_two,
        image = R.drawable.ic_onboarding_two,
        title = "Stay Connected",
        description = "Stay connected with the world through our mobile app's comprehensive coverage of global news. From breaking headlines to in-depth analysis, our app brings you the latest updates from around the globe.  Whether you're interested in politics, business, technology, or culture, our app connects you to the pulse of world news, empowering you to stay informed and engaged wherever you are. Connect with the world at your fingertips with our mobile app's seamless access to global news."
    )

    object Third : OnBoardingPage(
        topBg = R.drawable.ic_onboarding_bg_three,
        image = R.drawable.ic_onboarding_three,
        title = "Your Interest",
        description = "Stay informed and up-to-date with the latest news, trends, and insights tailored specifically to your industry. Whether you're a finance professional, healthcare practitioner, technology enthusiast, or in any other field, our app brings you curated news articles, expert analysis, and relevant updates to help you stay ahead of the curve."
    )
}
