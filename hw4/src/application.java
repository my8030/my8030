import java.util.Scanner;

public class application{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter M:");
        int number = scanner.nextInt();
        int square[][] = new int[number][number];
        for (int i = 0; i <= number-1; i++) {
            for (int j = 0; j <= number-1; j++) {
                square[i][j] = Math.abs(i - j);
                System.out.print(square[i][j] + "\t");
                if (j == number-1) {
                    System.out.println("\n");
                }
            }

        }
    }
}
