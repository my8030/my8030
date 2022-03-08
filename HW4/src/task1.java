import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] hello = {"Hello ", "Hi ", "Ciao ", "Howdy ", "Good afternoon "};
        System.out.println("Please enter your name!");
        String user = scanner.nextLine();
        System.out.println("How about saying hello to me?");
        String input = scanner.nextLine();
        if (input.equals("Hello")) {
            int number = (int) (Math.random() * (hello.length - 1));
            System.out.println("" + hello[number] + user + "!");
        } else {
            System.out.println("" + user + " I see bad manners in you. Go away!");
        }
    }
}
