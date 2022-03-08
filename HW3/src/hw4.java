import java.util.Scanner;

public class hw4 {
    public static void print(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        int health = 3;
        int happiness = 3;
        Scanner scanner = new Scanner(System.in);
        print("Ваше здоров'я: 3" + "\n" + "Ваше щасття: 3" + "\n");
        print("⇐ Наліво підеш - жінку знайдеш (натисни 1)" + "\n" + "⇒ Направо підеш - багатий будеш  (натисни 2)" + "\n" + "⇑ Прямо підеш - дуба вріжеш  (натисни 3)" + "\n");

        for (int i = 0; i < 5; ++ i) {
            print("Куди підеш?" + "\n");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    health -= 1;
                    happiness += 1;
                    print("Ваше здоров'я: " + health + "\n" + "Ваше щасття: " + happiness + "\n");
                    break;
                case 2:
                    health += 1;
                    happiness -= 1;
                    print("Ваше здоров'я: " + health + "\n" + "Ваше щасття: " + happiness + "\n");
                    break;
                case 3:
                    health = 0;
                    happiness = 0;
                    print("Ваше здоров'я: " + health + "\n" + "Ваше щасття: " + happiness + "\n");
                    i = 5;
                    break;
                default:
                    break;
            }
            if (health == 0) {
                print("Ти врізав дуба! ✟ " + "\n");
                i = 5;
            }
        }
        System.out.println("Кінець!");
    }
}
