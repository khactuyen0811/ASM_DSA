package manager;

import model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> list;

    public StudentManager() {
        list = new ArrayList<>();
    }

    // Thêm sinh viên
    public void addStudent(Student s) {
        list.add(s);
    }

    // Sửa sinh viên theo id
    public boolean updateStudent(String id, String newName, double newMarks) {
        for (Student s : list) {
            if (s.getId().equals(id)) {
                s.setName(newName);
                s.setMarks(newMarks);
                return true;
            }
        }
        return false;
    }

    // Xoá sinh viên theo id
    public boolean deleteStudent(String id) {
        return list.removeIf(s -> s.getId().equals(id));
    }

    // Tìm kiếm sinh viên theo id (trả về đối tượng)
    public Student searchById(String id) {
        for (Student s : list) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    // Tìm kiếm sinh viên theo tên (gần đúng, không phân biệt hoa thường)
    public List<Student> searchByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student s : list) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Sắp xếp theo tên (A-Z) dùng Bubble Sort (minh hoạ cho M2)
    public void bubbleSortByName() {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getName().compareToIgnoreCase(list.get(j + 1).getName()) > 0) {
                    // Swap
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Sắp xếp theo điểm giảm dần dùng Quick Sort (minh hoạ cho M2)
    public void quickSortByMarksDesc() {
        quickSort(0, list.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = list.get(high).getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getMarks() >= pivot) { // descending
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Student temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Hiển thị danh sách
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    // Lấy toàn bộ danh sách (nếu cần)
    public List<Student> getAll() {
        return list;
    }
}