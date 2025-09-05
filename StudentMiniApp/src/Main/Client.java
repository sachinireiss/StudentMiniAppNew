package Main;

import Model.Student;
import dao.StudentDaoInterface;
import dao.StudentDao;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        StudentDaoInterface dao = new StudentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Student Management Database");

        while (true) {
            System.out.println("\n1. Add Student" +
                    "\n2. Show All Students" +
                    "\n3. Show Student By ID" +
                    "\n4. Update Student" +
                    "\n5. Delete Student" +
                    "\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Year: ");
                    String year = sc.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine(); // consume newline

                    Student s = new Student(name, year, gpa);
                    if (dao.insertStudent(s)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Failed to add student.");
                    }
                    break;

                case 2:
                    dao.showAllStudent();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    dao.showStudentById(id);
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("What do you want to update?\n1. Name\n2. Year\n3. GPA");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = sc.nextLine();

                    if (dao.update(updateId, newValue, ch, null)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Failed to update student.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine();
                    if (dao.delete(delId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Failed to delete student.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
