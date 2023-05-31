# Android News App with Clean Architecture, Jetpack Compose, Hilt, and Room Database
This is a sample Android app built using Clean Architecture, Jetpack Compose, Hilt, and Room Database for displaying the latest news from various sources. The app fetches news data using [TheNewsAPI](https://www.thenewsapi.com/) and displays it in a modern and intuitive user interface.

# Screenshots

<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/f28aab04-187b-42ce-9c25-c47cac3ab5f3" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/d8a32483-d0f4-454a-a0f4-7ef5e3603a00" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/6609221f-5cb9-4412-820d-886d9c5373a9" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/a9bf6fa3-bc51-4d98-bb64-00dca61bc70a" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/2c36da26-1e4f-49e4-a561-128eaaab4dd9" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/f83fba71-53fa-437d-a1b1-c6b11e834ee8" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/79d16129-0b40-454e-9174-763a306b779f" alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/2a923507-fd90-4fdd-ac95-c3f8ab5dd87b " alt="Image" width="100" height="200">
<img src="https://github.com/QasimNawaz/NewDoCompose/assets/16431165/61fc0db3-6a2a-4421-ab48-9e8689dd879f" alt="Image" width="100" height="200">

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
3. Add your API key to the `local.properties` file: `API_KEY=YOUR_API_KEY_HERE`
5. Open the project in Android Studio and run the app.

# Contributions
Contributions to the project are welcome! If you find any issues or have suggestions for improvements, please feel free to create a pull request or open an issue.

# Credits
This app was built by Qasim Nawaz as a sample project for learning Clean Architecture, Jetpack Compose, Hilt, and Room Database. The app uses data from [TheNewsAPI](https://www.thenewsapi.com/).
