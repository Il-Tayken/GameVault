# 🎮 GameVault

A modern Android app for browsing and discovering video games, built with a Steam-inspired dark UI.

---

## 📱 Screenshots

| Game List | Platform Filter | Game Detail |
|-----------|----------------|-------------|
| Dark Steam-style list with ratings | Filter by PC, PS5, Xbox, Mobile | Hero image + stats + description |

---

## ✨ Features

- **Browse games** — scrollable list of top-rated games powered by the RAWG API
- **Filter by platform** — quickly filter games by PC, PlayStation 5, Xbox, or Mobile
- **Game detail** — full page with hero image, rating, Metacritic score, playtime, genres, description, developers, and publishers
- **Favorites** — mark any game as favourite; favourited games float to the top of the list
- **Offline support** — all data is cached in a local SQLDelight database

---

## 🏗️ Architecture

The project follows **Clean Architecture** with **MVVM** and is split into multiple Gradle modules:

```
GameVault/
├── app/                        # Entry point, navigation, theme
├── core/
│   ├── common/                 # Shared utilities (Resource wrapper)
│   ├── database/               # SQLDelight DB + Hilt module
│   └── network/                # Retrofit + RAWG API service + Hilt module
└── feature/
    ├── gamelist/               # Game list screen (domain / data / presentation)
    └── gamedetail/             # Game detail screen (domain / data / presentation)
```

Each feature module is structured by layer:

- **domain** — models, repository interfaces, use cases (pure Kotlin, no Android deps)
- **data** — repository implementations, mappers (network ↔ entity ↔ domain)
- **presentation** — ViewModel + Compose UI

---

## 🛠️ Tech Stack

| Layer | Library |
|-------|---------|
| UI | Jetpack Compose + Material 3 |
| Navigation | Navigation Compose |
| State | ViewModel + StateFlow |
| DI | Hilt |
| Network | Retrofit + OkHttp + kotlinx.serialization |
| Database | SQLDelight |
| Image loading | Coil |
| Language | Kotlin 2.0 |

---

## 🚀 Getting Started

### 1. Get a free RAWG API key

Register at [rawg.io/apidocs](https://rawg.io/apidocs) and copy your key (free tier: 20,000 requests/month).

### 2. Set your API key

Open `core/network/src/main/java/com/gamevault/network/api/RawgApiService.kt` and replace:

```kotlin
const val API_KEY = "YOUR_RAWG_API_KEY"
```

with your actual key.

### 3. Build & run

```bash
./gradlew assembleDebug
```

Or open the project in **Android Studio Hedgehog** (or newer) and press Run.

---

## 📦 Download

See the [Releases](../../releases) page to download the latest APK.

---

## 📋 Requirements

- Android 7.0+ (API 24)
- Android Studio Hedgehog or newer
- JDK 17

---

## 📄 License

MIT
