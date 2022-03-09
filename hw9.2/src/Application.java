public class Application {
    public static void main(String[] args) {

    View[] elements = {
            new TextView("Описание лабуды"),
            new ButtonView("Кнопка"),
            new ImageView("D:/pictures", "button", 5.6),
            new View("Купить", 1000, 5000, 50)
    };


    System.out.println(ElementInfo.printInfo());


}

}
