Simple MVVM To-Do App

A minimal To-Do List application built using Jetpack Compose, Room, and MVVM architecture.
The goal of this project is to demonstrate clean architecture, separation of concerns, and reactive UI patterns using modern Android tools.

⸻

Overview

This app allows users to:
•	Add new tasks
•	Mark tasks as completed
•	Set optional deadlines
•	Delete tasks
•	Persist data locally using Room

The codebase is structured to be easy to extend and suitable for beginners learning Android development.

⸻

Enhancements Added
•	Added deadline support to tasks
•	Implemented checkbox toggle to mark tasks as done
•	Added strikethrough styling for completed tasks
•	Updated Room schema and ViewModel logic to support new fields

⸻

Setup / Installation

1. Clone the repository

git clone YOUR_REPO_LINK

2. Open in Android Studio
   •	Use Android Studio Ladybug or newer
   •	Allow Gradle to sync

3. Run the app
   •	Emulator
   •	Or physical device with USB debugging enabled

4. Optionally install the Debug APK

Provide a debug APK in your repo under /apk/ for quick installation.

⸻

Architecture Notes
•	MVVM pattern for clear separation of concerns
•	Room Database for local persistence
•	ViewModel + LiveData for reactive UI state
•	Kotlin Coroutines for background database operations
•	Jetpack Compose for modern UI development

⸻

Trade-offs / Decisions
•	Used fallbackToDestructiveMigration() to simplify schema updates
•	Deadline stored as Long? (Unix timestamp) for easy Room compatibility
•	UI kept intentionally simple for clarity and maintainability

⸻

Future Improvements
•	Task sorting and filtering
•	Reminder notifications for deadlines
•	Better UI styling and animations
•	Dependency injection with Hilt
•	Compose UI tests