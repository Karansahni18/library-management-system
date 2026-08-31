# Library Management System

A console-based Java application to manage books, members, and borrowing/returning workflows.

## Features
- Add and track books with availability status
- Support for Student and Faculty members with different borrowing limits
- Borrow and return books with due-date tracking
- List all currently available books

## Tech Stack
- Java (core — OOP, collections, generics)

## Project Structure
```
src/com/karan/library
├── model/       → Book, Member, StudentMember, FacultyMember, BorrowRecord, BookStatus
├── repository/  → Library (in-memory storage)
├── service/     → BorrowingService (business logic)
└── Main.java    → entry point
```
## How to Run
1. Clone the repo: `git clone https://github.com/Karansahni18/library-management-system.git`
2. Open in VS Code with the Java Extension Pack installed
3. Run `Main.java`

## What I Learned
- OOP fundamentals: inheritance, abstraction, polymorphism, composition
- Separating concerns across model/repository/service layers
- Git and GitHub basics: init, commit, push
