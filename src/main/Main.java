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
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
            }

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
                    if (choice != -1) System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void addStudent() {

        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("ID cannot be empty. Please try again.");
            } else if (!id.matches("[a-zA-Z0-9]+")) {
                System.out.println("ID must contain only letters and numbers. Please try again.");
            } else if (manager.searchById(id) != null) {
                System.out.println("ID already exists. Please enter a different ID.");
            } else {
                break;
            }
        }


        String name;
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            } else if (!name.matches("[\\p{L}\\s]+")) {
                System.out.println("Name must contain only letters and spaces. Please try again.");
            } else {
                break;
            }
        }


        double marks = -1;
        while (true) {
            System.out.print("Enter marks (0-100): ");
            String input = sc.nextLine();
            try {
                marks = Double.parseDouble(input);
                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number (e.g., 7.5).");
            }
        }

        manager.addStudent(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        String id = sc.nextLine().trim();
        Student s = manager.searchById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }


        System.out.print("Enter new name (press Enter to keep current: " + s.getName() + "): ");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty()) {

            if (!newName.matches("[\\p{L}\\s]+")) {
                System.out.println("Invalid name format. Name must contain only letters and spaces. Update cancelled.");
                return;
            }
            s.setName(newName);
        }


        System.out.print("Enter new marks (press Enter to keep current: " + s.getMarks() + "): ");
        String marksInput = sc.nextLine().trim();
        if (!marksInput.isEmpty()) {
            try {
                double newMarks = Double.parseDouble(marksInput);
                if (newMarks < 0 || newMarks > 10) {
                    System.out.println("Marks must be between 0 and 10. Update cancelled.");
                    return;
                }
                s.setMarks(newMarks);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Update cancelled.");
                return;
            }
        }


        boolean ok = manager.updateStudent(id, s.getName(), s.getMarks());
        if (ok) System.out.println("Updated successfully.");
        else System.out.println("Update failed.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        String id = sc.nextLine().trim();
        boolean ok = manager.deleteStudent(id);
        if (ok) System.out.println("Deleted successfully.");
        else System.out.println("Student not found.");
    }

    private static void searchById() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine().trim();
        Student s = manager.searchById(id);
        if (s != null) System.out.println(s);
        else System.out.println("Not found.");
    }

    private static void searchByName() {
        System.out.print("Enter name keyword: ");
        String kw = sc.nextLine().trim();
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