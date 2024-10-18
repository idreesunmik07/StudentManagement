import java.util.ArrayList;
import java.util.Scanner;

public class StudentServiceImpl3 implements StudentService {
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();

    @Override
    public void addStudent() {
        int id;
        while (true) {
            System.out.print("Enter Student ID: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard invalid input
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        students.add(student);

        System.out.println("Student added successfully!");
    }



@Override

public void viewStudents() {
    System.out.println("Enter Student ID: ");
        scanner.nextInt();
       // scanner.nextLine();
    if (students.isEmpty()) {
        System.out.println("No students found.");
    } else {
        for (Student student : students) {
//            System.out.println("\\nID: " + student.getId());
//            System.out.println("Name: " + student.getName());
//            System.out.println("Age: " + student.getAge());
//            System.out.println("Grade: " + student.getGrade());
            System.out.println(student.toString());
        }
    }
}


@Override
public void updateStudent() {
    System.out.print("Enter Student ID to update: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    Student studentToUpdate = null;

    for (Student student : students) {
        if (student.getId() == id) {
            studentToUpdate = student;
            break;
        }
    }

    if (studentToUpdate == null) {
        System.out.println("Student not found.");
        return;
    }

    System.out.print("Enter new name (leave blank to keep current): ");
    String name = scanner.nextLine();
    if (!name.isEmpty()) {
        studentToUpdate.setName(name);
    }

    System.out.print("Enter new age (or 0 to keep current): ");
    int age = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    if (age != 0) {
        studentToUpdate.setAge(age);
    }

    System.out.print("Enter new grade (leave blank to keep current): ");
    String grade = scanner.nextLine();
    if (!grade.isEmpty()) {
        studentToUpdate.setGrade(grade);
    }

    System.out.println("Student updated successfully!");
}

@Override
public void deleteStudent() {
    System.out.print("Enter Student ID to delete: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    Student studentToRemove = null;

    for (Student student : students) {
        if (student.getId() == id) {
            studentToRemove = student;
            break;
        }
    }

    if (studentToRemove == null) {
        System.out.println("Student not found.");
    } else {
        students.remove(studentToRemove);
        System.out.println("Student deleted successfully!");
    }
}
@Override
public void searchStudent() {
    System.out.print("Enter Student Name to search: ");
    String name = scanner.nextLine();

    boolean found = false;
    for (Student student : students) {
        if (student.getName().equalsIgnoreCase(name)) {
            System.out.println("\\nID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Grade: " + student.getGrade());
            found = true;
        }
    }

    if (!found) {
        System.out.println("No student found with the name " + name);
    }
}
@Override
public void sortStudents() {
    if (students.isEmpty()) {
        System.out.println("No students to sort.");
        return;
    }

    students.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
    System.out.println("Students sorted by name.");
}
}