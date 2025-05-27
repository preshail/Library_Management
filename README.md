
# 📚 Library Management System (LMS) — Java Console App

This is a simple **console-based Library Management System** built using Java. It allows users to manage a collection of books — including adding, updating, deleting, listing, searching, checking out, and checking in books.

---

## 📂 File Directory Structure
LibraryManagementSystem/
├── src/
│   └── net/
│       └── javaguides/
│           └── lms/
│               ├── Book.java
│               ├── LibraryManager.java
│               └── Main.java


---

## ⚙️ How It Works

The program provides a menu-driven interface to manage books in a library. Here's how the workflow goes:

1. **User is prompted with options** (Add, Update, Delete, etc.).
2. **Each option interacts with the `LibraryManager` class**, which performs operations on a list of `Book` objects.
3. **Book objects** are stored in memory (no file/database storage used).
4. **The `Main` class starts the app** by calling `LibraryManager.start()`.

---

## 📌 Features

- ✅ Add a book with ID, Title, and Author  
- ✅ Update book details by ID  
- ✅ Delete a book by ID  
- ✅ List all books in the library  
- ✅ Search for books by title or author  
- ✅ Check out a book (mark as borrowed)  
- ✅ Check in a book (mark as returned)  
- ✅ Exit the program gracefully  

---

##OUTPUT
![image](https://github.com/user-attachments/assets/d063ed0b-bed1-4b62-b386-8f7f6fdd0152)


## 🧪 How to Compile and Run

> **Step 1:** Open terminal inside the `LibraryManagementSystem/src` folder.

### ✅ Compile
```bash
javac net/javaguides/lms/*.java
### ✅ RUN
java net.javaguides.lms.Main ```


