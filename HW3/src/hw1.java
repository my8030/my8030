import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Швидкість в км/год: ");
        int speed = scanner.nextInt();
        System.out.println("Час в хвилинах: ");
        int minutes = scanner.nextInt();
        double time = minutes / 60;
        double distance = speed * time;
        System.out.println ("Ведмедик Бо зможе проїхати " + distance + " км");
    }
}
