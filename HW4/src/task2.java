import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] student = {"Andriy", "Anton", "Artem", "Alex", "Bohdan", "Zinoviy"};
        int number = student.length;
        String [] grade = new String [number];
        for (int i = 0; i <= number - 1; i++ ) {
            System.out.println("Set grade for student " + student[i] + ":");
            grade[i] = scanner.nextLine();
        }
        System.out.println("Which student's success do you want to receive information about?");
        int input = scanner.nextInt();
        if (input <= number && input > 0) {
            System.out.println("The grade of student " + student[input-1] + "is: " + grade[input-1]);
        } else {
            System.out.println("There is no such student!");
        }
    }
}
