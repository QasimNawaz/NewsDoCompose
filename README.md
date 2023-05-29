# Android News App with Clean Architecture, Jetpack Compose, Hilt, and Room Database
This is a sample Android app built using Clean Architecture, Jetpack Compose, Hilt, and Room Database for displaying the latest news from various sources. The app fetches news data using [TheNewsAPI](https://www.thenewsapi.com/) and displays it in a modern and intuitive user interface.

# Screenshots

<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/94b02e5c-4154-42a9-94d3-28d9e6c4997e" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/2da87f8d-4859-485c-83f2-4235e657546d" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/c8d9e048-5b3d-4661-9323-e9cc3c1d0d8a" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/e19c3d37-2413-4915-ba13-6bda1fc0e5e7" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/898792d5-c7ac-40b4-a81a-34a32b4f337b" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/3d541801-bb1c-4d49-860a-4e9a4a2d7f79" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/1e83d042-7a5b-4e44-a9f2-d1c24952f405" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/25590336-6da3-4347-a6f0-4c61a3dd724e" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/805f14b0-8324-48a4-be08-01029857c90d" alt="Image" width="100" height="200">

# Features

- Fetches latest news from multiple sources using [TheNewsAPI](https://www.thenewsapi.com/)
- Displays news articles in a modern and intuitive UI using Jetpack Compose
- Supports infinite scrolling and pagination for loading more articles
- Allows users to search for articles by keyword
- Provides detailed information about individual articles, including author, date, and description
- Allows users to save articles for offline reading

# Tech Stack

- [Kotlin](https://kotlinlang.org/) programming language
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for building the UI
- [Navigation component](https://developer.android.com/jetpack/compose/navigation) to navigate between composables
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection
- [Room](https://developer.android.com/reference/android/arch/persistence/room/RoomDatabase) for local data storage
- [Retrofit](https://square.github.io/retrofit/) for making network requests
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for asynchronous programming
- [Coil](https://coil-kt.github.io/coil/) for image loading

# Architecture

The app follows the Clean Architecture principles, which consists of three main layers:

- Presentation Layer (UI): Contains the Jetpack Compose UI components, ViewModels, and UI-related logic.
- Domain Layer (Use Cases): Implements the business logic and use cases of the app.
- Data Layer: Handles data retrieval and storage, including remote API calls and local database operations.

# Getting Started

1. Clone this repository: `git clone https://github.com/QasimNawaz/NewsDoCompose.git`
2. Obtain an API key from [TheNewsAPI](https://www.thenewsapi.com/).
3. Add your API key to the `local.properties` file: `news_api_key=YOUR_API_KEY_HERE`
5. Open the project in Android Studio and run the app.

# Contributions
Contributions to the project are welcome! If you find any issues or have suggestions for improvements, please feel free to create a pull request or open an issue.

# Credits
This app was built by Qasim Nawaz as a sample project for learning Clean Architecture, Jetpack Compose, Hilt, and Room Database. The app uses data from **[TheNewsAPI](https://www.thenewsapi.com/).
