import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Student {
    String name;
    String id;
    int[] marks = new int[5];
    int total = 0;
    float average;
    char grade;

    void inputDetails(Scanner sc) {
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter Student ID: ");
        id = sc.nextLine();

        System.out.println("Enter marks for 5 subjects (out of 100):");
        for (int i = 0; i < 5; i++) {
            while (true) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
                if (marks[i] >= 0 && marks[i] <= 100) {
                    break;
                } else {
                    System.out.println("Invalid mark! Enter a value between 0 and 100.");
                }
            }
            total += marks[i];
        }
        average = total / 5.0f;
        assignGrade();
    }

    void assignGrade() {
        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 40) grade = 'D';
        else grade = 'F';
    }

    void displayReport() {
        System.out.println("\n----- STUDENT REPORT CARD -----");
        System.out.println("Name     : " + name);
        System.out.println("ID       : " + id);
        System.out.println("Marks    : ");
        for (int i = 0; i < 5; i++) {
            System.out.println("  Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total    : " + total);
        System.out.printf("Average  : %.2f\n", average);
        System.out.println("Grade    : " + grade);
        System.out.println("--------------------------------");
    }

    void saveToFile() {
        try {
            FileWriter fw = new FileWriter("ReportCard_" + id + ".txt");
            fw.write("----- STUDENT REPORT CARD -----\n");
            fw.write("Name     : " + name + "\n");
            fw.write("ID       : " + id + "\n");
            fw.write("Marks    :\n");
            for (int i = 0; i < 5; i++) {
                fw.write("  Subject " + (i + 1) + ": " + marks[i] + "\n");
            }
            fw.write("Total    : " + total + "\n");
            fw.write(String.format("Average  : %.2f\n", average));
            fw.write("Grade    : " + grade + "\n");
            fw.write("--------------------------------\n");
            fw.close();
            System.out.println("Report successfully saved to file: ReportCard_" + id + ".txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the report: " + e.getMessage());
        }
    }
}

public class ReportCardApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student student = new Student();
        student.inputDetails(sc);
        student.displayReport();
        student.saveToFile();

        sc.close();
    }
}
