package p1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double total;
    double avg;

    public Student(int id, String name, int m1, int m2, int m3) {
        this.id = id;
        this.name = name;
        this.total = m1 + m2 + m3;
        calculate();
    }

    public void calculate() {
        this.avg = total / 3.0;
    }

    public void display() {
        System.out.printf("ID: %-5d Name: %-10s Total: %-6.2f Average: %.2f%n",
                id, name, total, avg);
    }
}

public class Student1 {

    static Student[] std = new Student[50];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    // *** MARKS VALIDATION ***
    static int readMarks(String subject) {
        int marks;
        while (true) {
            try {
                System.out.print("Enter marks for " + subject + " (0-100): ");
                marks = sc.nextInt();
                if (marks < 0 || marks > 100)
                    throw new IllegalArgumentException("Marks must be between 0 and 100");
                return marks;
            } catch (InputMismatchException e) {
                System.out.println("❌ Enter numeric value only!");
                sc.next();
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    // *** SAVE TO FILE ***
    static void saveToFile(Student s) {
        try (FileWriter fw = new FileWriter("students.txt", true)) {
            fw.write(String.format(
                    "ID: %d | Name: %s | Total: %.2f | Average: %.2f%n",
                    s.id, s.name, s.total, s.avg));
        } catch (IOException e) {
            System.out.println("❌ Error writing to file");
        }
    }

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 8) {
            try {
                System.out.println("\n========================================");
                System.out.println("   STUDENT PERFORMANCE ANALYTICS");
                System.out.println("========================================");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Save Report");
                System.out.println("4. Delete Student");
                System.out.println("5. Top Student");
                System.out.println("6. Least Student");
                System.out.println("7. Sort by Average");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Name: ");
                        String name = sc.next();

                        int m1 = readMarks("DM");
                        int m2 = readMarks("PSTJ");
                        int m3 = readMarks("DDCA");

                        Student s = new Student(id, name, m1, m2, m3);
                        std[count++] = s;

                        saveToFile(s);
                        System.out.println("✅ Student added & saved successfully!");
                        break;

                    case 2:
                        if (count == 0) {
                            System.out.println("⚠ No students available");
                        } else {
                            for (int i = 0; i < count; i++)
                                std[i].display();
                        }
                        break;

                    case 3:
                        System.out.println("📁 Data is saved automatically on entry!");
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int rid = sc.nextInt();
                        boolean found = false;

                        for (int i = 0; i < count; i++) {
                            if (std[i].id == rid) {
                                for (int j = i; j < count - 1; j++)
                                    std[j] = std[j + 1];
                                count--;
                                found = true;
                                System.out.println("✅ Student deleted");
                                break;
                            }
                        }
                        if (!found)
                            System.out.println("❌ Student not found");
                        break;

                    case 5:
                        if (count == 0) break;
                        Student top = std[0];
                        for (int i = 1; i < count; i++)
                            if (std[i].avg > top.avg)
                                top = std[i];

                        System.out.println("🏆 Top Student:");
                        top.display();
                        break;

                    case 6:
                        if (count == 0) break;
                        Student least = std[0];
                        for (int i = 1; i < count; i++)
                            if (std[i].avg < least.avg)
                                least = std[i];

                        System.out.println("📉 Least Student:");
                        least.display();
                        break;

                    case 7:
                        for (int i = 0; i < count - 1; i++) {
                            for (int j = i + 1; j < count; j++) {
                                if (std[i].avg > std[j].avg) {
                                    Student temp = std[i];
                                    std[i] = std[j];
                                    std[j] = temp;
                                }
                            }
                        }
                        System.out.println("🔃 Students sorted by average");
                        break;

                    case 8:
                        System.out.println("👋 Exiting program...");
                        break;

                    default:
                        System.out.println("❌ Invalid choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Try again.");
                sc.next();
            }
        }
    }
}

