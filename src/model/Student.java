package model;

public class Student {
    private String id;
    private String name;
    private double marks;

    // Constructor
    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    // Xếp loại dựa trên marks
    public String getRank() {
        if (marks < 50) return "Fail";
        else if (marks < 65) return "Medium";
        else if (marks < 75) return "Good";
        else if (marks < 90) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Marks: %.2f | Rank: %s",
                id, name, marks, getRank());
    }
}