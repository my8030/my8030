import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        int a = (int) ( Math.random() * 10 + 1 );
        int b = (int) ( Math.random() * 10 + 1 );
        int operator = (int) ( Math.random() * 4 + 1 );
        double result = 0;
        switch (operator) {
            case 1: operator = 1;
                result = a + b;
                System.out.println ("" + a + " + " + b + " =");
                break;
            case 2: operator = 2;
                result = a - b;
                System.out.println ("" + a + " - " + b + " =");
                break;
            case 3: operator = 3;
                result = a * b;
                System.out.println ("" + a + " * " + b + " =");
                break;
            case 4: operator = 4;
                if (b != 0) {
                    result = (double) a / (double) b;
                    System.out.println ("" + a + " / " + b + " =");
                    break;
                } else {
                    result = (double) a / (double) b;
                    System.out.println ("" + a + " / " + b + " =");
                    break;
                }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваша відповідь: ");
        double answer = scanner.nextDouble();
        if (answer == result) {
            System.out.println("Правильно!");
        } else {
            System.out.println("Не правильно! Правильна відповідь: " + result);
        }
    }
}
