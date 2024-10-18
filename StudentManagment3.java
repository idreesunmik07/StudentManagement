import java.time.LocalDateTime;
import java.util.Scanner;

public class StudentManagment3{


        private static Scanner scanner3 = new Scanner(System.in);
     static LocalDateTime local = LocalDateTime.now();


        public static void main(String[] args){
            StudentService studentService = new StudentServiceImpl3();

            while (true) {
                System.out.println("Wellcome to Student Management System \n Time "+local);
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Search Student");
                System.out.println("6. Sort Students");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner3.nextInt();
                scanner3.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        studentService.addStudent();


                        break;
                    case 2:
                        studentService.viewStudents();
                        break;
                    case 3:
                        studentService.updateStudent();
                        break;
                    case 4:
                        studentService.deleteStudent();
                        break;
                    case 5:
                        studentService.searchStudent();
                        break;
                    case 6:
                        studentService.sortStudents();
                        break;
                    case 7:
                        System.out.println("Exiting the program...");
                        scanner3.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }}
