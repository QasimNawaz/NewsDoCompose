package com.qasimnawaz019.newsdocompose.ui.components.tabs

sealed class TabRowItem(
    val title: String,
    val query: String,
) {
    object Automobiles : TabRowItem(
        title = "Auto / Cars",
        query = "automobiles",
    )

    object Aviation : TabRowItem(
        title = "Aviation",
        query = "aviation",
    )

    object Banking : TabRowItem(
        title = "Banking",
        query = "banking",
    )

    object Business : TabRowItem(
        title = "Business",
        query = "business",
    )

    object Defence : TabRowItem(
        title = "Defence",
        query = "defence",
    )

    object Economics : TabRowItem(
        title = "Economics",
        query = "economics",
    )

    object Education : TabRowItem(
        title = "Education",
        query = "education",
    )

    object Energy : TabRowItem(
        title = "Energy",
        query = "energy",
    )

    object Engineering : TabRowItem(
        title = "Engineering",
        query = "engineering",
    )

    object Entertainment : TabRowItem(
        title = "Entertainment",
        query = "entertainment",
    )

    object Environment : TabRowItem(
        title = "Environment",
        query = "environment",
    )

    object IT : TabRowItem(
        title = "Information Technology (IT)",
        query = "it",
    )

    object Lifestyle : TabRowItem(
        title = "Lifestyle",
        query = "lifestyle"
    )

    object Media : TabRowItem(
        title = "Media",
        query = "media",
    )

    object Medical : TabRowItem(
        title = "Medical",
        query = "medical",
    )

    object Science : TabRowItem(
        title = "Science",
        query = "science"
    )

    object Sports : TabRowItem(
        title = "Sports",
        query = "sports",
    )

    object Tech : TabRowItem(
        title = "Tech",
        query = "tech",
    )

}

val tabRowItems = listOf(
    TabRowItem.Automobiles,
    TabRowItem.Aviation,
    TabRowItem.Banking,
    TabRowItem.Business,
    TabRowItem.Defence,
    TabRowItem.Economics,
    TabRowItem.Education,
    TabRowItem.Energy,
    TabRowItem.Engineering,
    TabRowItem.Entertainment,
    TabRowItem.Environment,
    TabRowItem.IT,
    TabRowItem.Lifestyle,
    TabRowItem.Media,
    TabRowItem.Medical,
    TabRowItem.Science,
    TabRowItem.Sports,
    TabRowItem.Tech,
)