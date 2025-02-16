# Movie Recommendation System

## About This Project
This is a **beginner-level** project (read: my first ever attempt at making something functional in Java), so expect **sub-optimal code, extra files, and other such glorious messes**. If you find any oddities, just know that I probably forgot to delete them or didn’t know what I was doing at the time.

## Purpose
The goal of this project is to create a **Movie Recommendation System** that allows users to log in and receive movie suggestions based on various attributes such as genres, ratings, and directors. It reads data from CSV files and processes it into structured lists to make recommendations.

## Features
- **User Authentication**: Users must log in using credentials stored in `USERS.csv`.
- **Movie Data Processing**: Reads movie-related data (actors, directors, genres, etc.) from CSV files and stores them in `ArrayLists`.
- **Recommendation Logic**: Uses simple logic to suggest movies based on user preferences.

## File Structure
```
Movie-Recommendation-System/
│── src/
│   ├── MovieRecSys/                   # Core logic and execution
│   │   ├── MovieRecommendationSystem.java  # Main program execution
│   │   ├── UserAuthentication.java     # Handles login system
│   ├── Reading/                        # Reads data from CSV files
│   ├── Recommendation_Logics/          # Contains recommendation algorithms
│   ├── USERS/                          # Stores user credential files
│── bin/                                # Compiled Java files
│── README.md                           # This file
│── temp.csv                             # I don't even remember so I've no idea why this is here...
```

## Known Issues & TODOs
- **Extra files**: Some files are just hanging around doing nothing. They will be removed (eventually).
- **Login System Flaws**: The authentication system currently has some issues (like always logging in successfully). It needs debugging.
- **Better Recommendations**: Right now, the recommendation logic is basic. Improvements are planned.

## Final Notes
This was my first real project, so while it works (mostly), it’s probably not the most efficient thing in the world. If you’re here to judge, just know that **we all start somewhere!** 😆 But if you have suggestions, feel free to share!

