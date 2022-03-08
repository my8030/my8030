import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {
    int a = (int) ( Math.random() * 10 + 1 );
    int b = (int) ( Math.random() * 10 + 1 );
    int result = a * b;
    System.out.println ("" + a + " * " + b + " =");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ваша відповідь: ");
    int answer = scanner.nextInt();
    if (answer == result) {
        System.out.println("Правильно!");
    } else {
        System.out.println("Не правильно! Правильна відповідь: " + result);
    }
}
}
