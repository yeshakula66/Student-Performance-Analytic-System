# Student Performance Analytics (Java)

A simple **Java console application** to manage and analyze student performance based on marks in three subjects.  
It allows adding, viewing, sorting, and analyzing students, and automatically saves records to a file.

---

##  Features

- Add student details (ID, Name, Marks)
- Automatic total & average calculation
- Input validation for marks (0–100)
- Display all students
- Delete student by ID
- Find **Top** and **Least** performing student
- Sort students by average marks
- Auto-save student reports to `students.txt`

---

## 🛠 Requirements

- Java JDK 8 or higher
- Command line / terminal

---

## ▶️ How to Run

1. Compile:
   ```bash
   javac student1.java
   ```

2. Run:
   ```bash
   java p1.student1
   ```

---

## 📋 Menu Options

1. Add Student  
2. Display Students  
3. Save Report (auto-saved on entry)  
4. Delete Student  
5. Top Student  
6. Least Student  
7. Sort by Average  
8. Exit  

---

##  Output File

All student entries are appended to:

```
students.txt
```

Format example:
```
ID: 1 | Name: John | Total: 250.00 | Average: 83.33
```

---

##  Future Improvements (Ideas)

- GUI version
- Database storage instead of text file
- Search by name
- Grade classification system

---

##  Author

Student Performance Analytics Project  
