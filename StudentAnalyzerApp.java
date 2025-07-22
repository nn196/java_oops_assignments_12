import java.util.Scanner;

public class StudentAnalyzerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // INPUT
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        int[] marks = new int[5];
        int total = 0;
        int subjectPassBinary = 0;

        System.out.println("\nEnter marks for 5 subjects (out of 100):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];

            // Bitwise: If subject mark >= 40, set the corresponding bit to 1
            if (marks[i] >= 40) {
                subjectPassBinary |= (1 << i);  // Bitwise OR and Shift
            }
        }

        // Arithmetic Operators
        double average = total / 5.0;

        // Relational + Logical + Ternary
        char grade = (average >= 90) ? 'A' :
                     (average >= 75) ? 'B' :
                     (average >= 60) ? 'C' : 'F';

        System.out.print("Enter attendance percentage: ");
        int attendance = sc.nextInt();
        boolean isEligible = average >= 50 && attendance >= 75;

        // Compound Assignment + Unary
        int reward = 100;
        reward += 20;  // bonus
        reward -= 10;  // minor penalty
        reward *= 2;   // doubled due to participation
        reward /= 3;
        reward %= 7;

        // Unary Increment and Decrement
        int bonus = 5;
        bonus++;       // Post increment
        ++bonus;       // Pre increment
        bonus--;       // Post decrement
        int penalty = -bonus; // Unary minus

        // Bitwise Representation
        System.out.println("\nBinary Pass Status (5 subjects): " + String.format("%5s", Integer.toBinaryString(subjectPassBinary)).replace(' ', '0'));

        // Shift Operators: Encoding eligibility
        int encoded = isEligible ? (1 << 1) : 0; // Left shift to encode eligibility
        System.out.println("Eligibility Code (shifted): " + encoded);

        // OUTPUT
        System.out.println("\n----- STUDENT REPORT -----");
        System.out.println("Name     : " + name);
        System.out.println("ID       : " + id);
        System.out.println("Total    : " + total);
        System.out.printf("Average  : %.2f\n", average);
        System.out.println("Grade    : " + grade);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println("Eligibility: " + (isEligible ? "Yes" : "No"));
        System.out.println("Final Reward Points (compound ops): " + reward);
        System.out.println("Bonus (Unary): " + bonus + ", Penalty (Unary -): " + penalty);
        System.out.println("Bitwise Pass Representation: " + Integer.toBinaryString(subjectPassBinary));
        System.out.println("Shift Encoded Eligibility: " + encoded);
        System.out.println("Final Remark: " + (grade != 'F' && isEligible ? "Promoted" : "Needs Improvement"));

        sc.close();
    }
}
