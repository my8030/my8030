import java.util.Scanner;

public class hw2_3 {
    public hw2_3() {
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какое ваше имя?");
        String name = scanner.nextLine();

        System.out.println("Какая ваша фамилия?");
        String surname = scanner.nextLine();

        System.out.println("Какое ваше отчество?");
        String patronymic = scanner.nextLine();

        System.out.println("В какой стране вы живёте?");
        String country = scanner.nextLine();

        System.out.println("В каком городе вы живёте?");
        String city = scanner.nextLine();

        System.out.println("Что вы желаете приобрести?");
        String goods = scanner.nextLine();

        System.out.println("Как вы собираетесь это использовать?");
        String goal = scanner.nextLine();

        System.out.println("\n" + "Дорогой " + surname + " " + name + " " + patronymic + "!"  + "\n" + "Вы снова заказали у нас " + goods + ", но мы знаем, что вы точно не будете так " + goal + " " + goods + "!"  + "\n" + "Кроме того, мы не хотим отправлять посылку в " + country + " так-как не знаем где находится " + city + "."  + "\n" + "По-этому не ждите. Вашу оплату мы не вернём!"  + "\n" + "Будьте счастливы наш дорогой и любимый " + surname + " " + name + " " + patronymic + "!");
    }
}
