# Simple MVVM To-Do App  
A clean, minimal, and modern To-Do List application built with **Jetpack Compose**, **Room**, and **MVVM architecture** — perfect for learning or extending with new features.

The goal of this project is to showcase best-practice Android development using modern tools while keeping the codebase simple, readable, and beginner-friendly.

## ✨ Features  
- **Add new tasks** with title and optional description  
- **Mark tasks as completed** with a single tap  
- **Set optional deadlines** (date & time picker)  
- **Strikethrough styling** for completed tasks  
- **Delete tasks** via swipe-to-dismiss  
- **Persistent storage** using Room Database  
- **Fully reactive UI** powered by StateFlow & LiveData  
- **100% Kotlin + Jetpack Compose** declarative UI  

## 🚀 Latest Enhancements  
- Deadline support with beautiful Material 3 date/time pickers  
- Checkbox toggle for instant completion status  
- Visual strikethrough on completed tasks  
- Updated Room schema & migration handling  
- Improved accessibility and dark mode support  

## 🛠️ Technology Stack  
- **UI**: Jetpack Compose (Material 3)  
- **Architecture**: MVVM + Clean Architecture principles  
- **Local Database**: Room (with fallbackToDestructiveMigration for simplicity)  
- **State Management**: ViewModel + StateFlow  
- **Asynchronous Operations**: Kotlin Coroutines + Flow  
- **Dependency Management**: Gradle Kotlin DSL + Version Catalog

  

## 📦 Installation  
```bash
# 1. Clone the repository
git clone https://github.com/yourusername/simple-mvvm-todo.git
cd simple-mvvm-todo

# 2. Open in Android Studio (Ladybug | 2024.2.1 or newer recommended)

# 3. Let Gradle sync automatically

# 4. Run on emulator or physical device
```

## 🎯 Key Implementation Highlights  
- **Separation of Concerns**: UI → ViewModel → Repository → Room  
- **Reactive Updates**: StateFlow collects Room Flow for instant UI refresh  
- **Immutability**: All UI state handled via immutable data classes  
- **Coroutines**: All database operations run off the main thread  
- **Material 3 Design**: Fully themed with dynamic color support  

## 🔒 Architecture Decisions & Trade-offs  
- `fallbackToDestructiveMigration()` used to avoid complex migration code (ideal for demo/learning apps)  
- Deadline stored as `Long?` (Unix timestamp) for easy Room serialization  
- No Hilt yet — keeps project lightweight and easy to understand  
- Swipe-to-delete implemented with `Dismissible` Compose API

## Screenshots
<img width="355" height="745" alt="image" src="https://github.com/user-attachments/assets/23b05475-5507-459f-910d-7f8ffa0d1439" />
<img width="355" height="745" alt="image" src="https://github.com/user-attachments/assets/278c4e8a-ff8d-4d83-aa10-08ae5b1b12fb" />
<img width="355" height="745" alt="image" src="https://github.com/user-attachments/assets/1ecad2ce-9eca-4a22-a9f9-a8f11b510168" />
<img width="355" height="745" alt="image" src="https://github.com/user-attachments/assets/cbf63df6-fa55-4d10-9985-8dae1fca5ff7" />





## Demo Video
https://github.com/user-attachments/assets/850d3fed-f911-4daf-bc6c-c7cecbc9452a



