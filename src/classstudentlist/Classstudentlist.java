package classstudentlist;

import java.util.ArrayList;
import java.util.Scanner;

// Class Student
class Student {

    String studentId;
    String fullName;
    String dateOfBirth;
    String major;
    float gpa;

    public void enterStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID student: ");
        studentId = scanner.nextLine();
        System.out.print("Enter fullname: ");
        fullName = scanner.nextLine();
        System.out.print("Enter birthday (dd/MM/yyyy): ");
        dateOfBirth = scanner.nextLine();
        System.out.print("Enter major: ");
        major = scanner.nextLine();
        System.out.print("Enter GPA: ");
        gpa = scanner.nextFloat();
    }

    public void displayStudentInfo() {
        System.out.println("ID: " + studentId + ", Name: " + fullName
                + ", Birthday: " + dateOfBirth + ", major: " + major
                + ", GPA: " + gpa);
    }
}

// Class StudentList
class StudentList {

    ArrayList<Student> studentList = new ArrayList<>();

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Empty student list!");
        } else {
            for (Student student : studentList) {
                student.displayStudentInfo();
            }
        }
    }

    public Student findStudentById(String idToFind) {
        for (Student student : studentList) {
            if (student.studentId.equals(idToFind)) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudentById(String idToDelete) {
        Student student = findStudentById(idToDelete);
        if (student != null) {
            studentList.remove(student);
            return true;
        }
        return false;
    }

    public boolean editStudentById(String idToEdit) {
        Student student = findStudentById(idToEdit);
        if (student != null) {
            System.out.println("Enter new student:");
            student.enterStudentInfo();
            return true;
        }
        return false;
    }
}

// Class Processor
public class Classstudentlist {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enter n student");
            System.out.println("2. Show all students information");
            System.out.println("3. Search students by ID");
            System.out.println("4. Delete student by ID");
            System.out.println("5. Edit student information according to ID");
            System.out.println("0. Exit");
            System.out.print("Chose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of students: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Bỏ qua dòng trống sau khi nhập số.
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter student information " + (i + 1));
                        Student student = new Student();
                        student.enterStudentInfo();
                        studentList.studentList.add(student);
                    }
                    break;
                case 2:
                    System.out.println("List of students:");
                    studentList.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter the student ID you are looking for: ");
                    String idToFind = scanner.nextLine();
                    Student student = studentList.findStudentById(idToFind);
                    if (student != null) {
                        student.displayStudentInfo();
                    } else {
                        System.out.println("No student found with this ID.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the student ID to delete: ");
                    String idToDelete = scanner.nextLine();
                    if (studentList.deleteStudentById(idToDelete)) {
                        System.out.println("Delete complete!");
                    } else {
                        System.out.println("No student found with this ID.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the student ID to edit: ");
                    String idToEdit = scanner.nextLine();
                    if (studentList.editStudentById(idToEdit)) {
                        System.out.println("Edit successful.");
                    } else {
                        System.out.println("No student found with this ID.");
                    }
                    break;
                case 0:
                    System.out.println("Exit program.");
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        } while (choice != 0);
    }
}
