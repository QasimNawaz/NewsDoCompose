# Android News App with Clean Architecture, Jetpack Compose, Hilt, and Room Database
This is a sample Android app built using Clean Architecture, Jetpack Compose, Hilt, and Room Database for displaying the latest news from various sources. The app fetches news data using [TheNewsAPI](https://www.thenewsapi.com/) and displays it in a modern and intuitive user interface.

# Screenshots

<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/ef84aaed-eabc-49e7-a445-5f9cb89775ec" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/ca928e08-c0d9-476a-8198-738f9f70a64b" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/c51e247c-6809-4227-9266-0700a2229809" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/cb3a900f-86d1-4ddb-958f-027856c12a70" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/4ddbdefe-8873-4997-b3b1-decf200839e8" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/f0014798-5cda-4ff5-a09f-5aad3be5f2a1" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/0e1356b4-36d0-4a23-a7d0-c353324eb337" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/bb272180-c686-4543-a0e7-46443e2d96ee" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewsDoCompose/assets/16431165/5493027e-12dc-4351-a556-6b7fd0c619ad" alt="Image" width="100" height="200">

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
This app was built by Qasim Nawaz as a sample project for learning Clean Architecture, Jetpack Compose, Hilt, and Room Database. The app uses data from [TheNewsAPI](https://www.thenewsapi.com/).
