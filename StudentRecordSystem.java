import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String department;

    public Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

public class StudentRecordSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentRecordSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student department: ");
        String department = scanner.next();

        Student student = new Student(id, name, age, department);
        students.add(student);
        System.out.println("Student record added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found!");
        } else {
            for (Student student : students) {
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Department: " + student.getDepartment());
                System.out.println();
            }
        }
    }

    public void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student found!");
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Department: " + student.getDepartment());
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new student record");
            System.out.println("2. View all student records");
            System.out.println("3. Search for a student by ID");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.viewStudents();
                    break;
                case 3:
                    system.searchStudent();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}