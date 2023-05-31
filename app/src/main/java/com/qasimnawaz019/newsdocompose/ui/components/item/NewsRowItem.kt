package com.qasimnawaz019.newsdocompose.ui.components.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme

@Composable
fun NewsRowItem(
    news: Article?, onDetailClick: () -> Unit, onActionClick: (action: Int) -> Unit
) {
    news?.let { article ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onDetailClick.invoke() },
            contentAlignment = Alignment.BottomEnd
        ) {
            Card(
                modifier = Modifier.padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 20.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = 8.dp,
                backgroundColor = NewsDoComposeTheme.colors.cardBackground
            ) {
                Column() {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(article.imageUrl).build(),
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds,
                            alpha = 0.5f,
                            contentDescription = "article image",
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = article.source ?: "",
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 11.sp
                        )
                    }
                    Column(
                        modifier = Modifier.padding(
                            start = 10.dp, top = 10.dp, end = 10.dp, bottom = 35.dp
                        )
                    ) {
                        Text(
                            text = article.title ?: "",
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold

                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = article.title ?: "",
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.caption,
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp

                        )
                    }
                }
            }
            ArticleActions(
                actions = if (article.isFavourite) listOf(
                    R.drawable.ic_share, R.drawable.ic_bookmark_fill
                ) else listOf(R.drawable.ic_share, R.drawable.ic_bookmark),
                onActionClick = onActionClick
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArticleActions(
    actions: List<Int>, onActionClick: (action: Int) -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .padding(start = 0.dp, top = 2.dp, end = 24.dp, bottom = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        actions.forEach {
            Card(shape = RoundedCornerShape(6.dp),
                backgroundColor = NewsDoComposeTheme.colors.primary,
                onClick = {
                    onActionClick.invoke(it)
                }) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(id = it),
                    contentDescription = "icon",
                    tint = Color.White
                )
            }
        }
    }
}