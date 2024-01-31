import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private String address;
    private String contactNumber;

    public Student() {
    }

    public Student(String studentId, String name, String address, String contactNumber) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        studentId = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Address: ");
        address = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        contactNumber = scanner.nextLine();
    }

    public void print() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
    }
}

class Course {
    private String courseId;
    private String courseName;
    private String instructor;

    private ArrayList<Student> enrolledStudents;

    public Course() {
        enrolledStudents = new ArrayList<>();
    }

    public Course(String courseId, String courseName, String instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        enrolledStudents = new ArrayList<>();
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Course ID: ");
        courseId = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        courseName = scanner.nextLine();
        System.out.print("Enter Instructor: ");
        instructor = scanner.nextLine();
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void print() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);

        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            student.print();
            System.out.println("------");
        }
    }
}

public class StudentApp {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.read();
            studentList.add(student);

            Course course = new Course();
            course.read();
            course.addStudent(student);
            courseList.add(course);
        }

        System.out.println("\nStudent Details:");
        for (Student student : studentList) {
            student.print();
            System.out.println("------");
        }

        System.out.println("\nCourse Details:");
        for (Course course : courseList) {
            course.print();
            System.out.println("------");
        }
    }
}
