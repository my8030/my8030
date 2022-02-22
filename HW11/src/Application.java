public class Application {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        try {
            httpClient.addCar(new Car("Audi", "A6", 2001, 300));
        } catch (Exception exception) {
            System.out.println("Недопустимий формат");
           // System.out.println(exception);
//            exception.printStackTrace();
//            System.err.println();
        }

        try {
            httpClient.addCar(new Car("Honda ", "Dio", 1980, 800));
        } catch (Exception exception) {
            System.out.println("Тип даних не підходить");
           // System.out.println(exception);
//            exception.printStackTrace();
        }


        try {
            httpClient.addCar(new Car("BMW", "X5", 2005, 0));
        } catch (Exception exception) {
            System.out.println("Недопустимий формат");
          //  System.out.println(exception);
//            exception.printStackTrace();

        }

        try {
            httpClient.addCar(new Car(" ", "panamera ", 20188, 100));
        } catch (Exception exception) {
            System.out.println("Файл пошкоджений");
          //  System.out.println(exception);
//            exception.printStackTrace();

        }


        Car[] allCars = httpClient.getAllCars();
        printCarsInfo(allCars);
    }

    public static void printCarsInfo(Car[] cars) {
        for (Car curCar: cars) {
            System.out.println(curCar);
        }
    }
}




