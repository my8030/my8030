

import java.util.Scanner;
public class application {



    public application() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double a = scanner.nextDouble();
        System.out.println("b: ");
        double b = scanner.nextDouble();

        System.out.println("alfa: ");
        double alfa = scanner.nextDouble();
        System.out.println("beta: ");
        double beta = scanner.nextDouble();

        double c = Math.sqrt (a * a + b * b);
        double c1 = a / (Math.sin (alfa * Math.PI / 180));
        double c2 = b / Math.cos (beta  * Math.PI / 180);
        System.out.println("c = " + c + "\n" + "c1 = " + c1 + "\n" + "c2 = " + c2);
    }
}
