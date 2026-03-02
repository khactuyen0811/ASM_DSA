package main;

import manager.StudentManager;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Search student by ID");
            System.out.println("6. Search student by name");
            System.out.println("7. Sort by name (Bubble Sort)");
            System.out.println("8. Sort by marks descending (Quick Sort)");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    manager.displayAll();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchById();
                    break;
                case 6:
                    searchByName();
                    break;
                case 7:
                    manager.bubbleSortByName();
                    System.out.println("Sorted by name using Bubble Sort.");
                    manager.displayAll();
                    break;
                case 8:
                    manager.quickSortByMarksDesc();
                    System.out.println("Sorted by marks descending using Quick Sort.");
                    manager.displayAll();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        double marks = Double.parseDouble(sc.nextLine());
        manager.addStudent(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        String id = sc.nextLine();
        Student s = manager.searchById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new marks: ");
        double newMarks = Double.parseDouble(sc.nextLine());
        boolean ok = manager.updateStudent(id, newName, newMarks);
        if (ok) System.out.println("Updated successfully.");
        else System.out.println("Update failed.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        String id = sc.nextLine();
        boolean ok = manager.deleteStudent(id);
        if (ok) System.out.println("Deleted successfully.");
        else System.out.println("Student not found.");
    }

    private static void searchById() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        Student s = manager.searchById(id);
        if (s != null) System.out.println(s);
        else System.out.println("Not found.");
    }

    private static void searchByName() {
        System.out.print("Enter name keyword: ");
        String kw = sc.nextLine();
        List<Student> result = manager.searchByName(kw);
        if (result.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : result) {
                System.out.println(s);
            }
        }
    }
}