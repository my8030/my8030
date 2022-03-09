import java.util.Scanner;

public interface NewTransaction {

    static String senderName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sender name: ");
        return scanner.nextLine();
    }


    static String receiverName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter receiver name: ");
        return scanner.nextLine();
    }

    static int sum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sum: ");
        String sumTest = scanner.nextLine();
        while (!sumTest.matches("\\d*")) {
            System.out.println("Enter sum: ");
            sumTest = scanner.nextLine();
        }
        int sum = Integer.parseInt (sumTest);
        return sum;
    }

    static String comment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter comment: ");
        return scanner.nextLine();
    }
}
