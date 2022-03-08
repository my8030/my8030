import java.util.Scanner;

public class hw2_1 {
    public hw2_1() {
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        int a = scanner.nextInt();
        System.out.println("b: ");
        int b = scanner.nextInt();
        System.out.println("c: ");
        int c = scanner.nextInt();

        double D = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt (D))/(2 * a);
        double x2 = (-b - Math.sqrt (D))/(2 * a);
        System.out.println("x1 = " + x1 + "\n" + "x2 = " + x2);
    }
}

