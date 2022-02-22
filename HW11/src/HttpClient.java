import java.util.Arrays;

public class HttpClient {
    private Car[] cars = new Car[1000];
    private int carsCount;

    public void addCar(Car car) throws Exception {
        generateError();

        cars[carsCount++] = car;
        System.out.println("Car was added");
    }

    public Car[] getAllCars() {
        return Arrays.copyOf(cars, carsCount);
    }
    private void generateError() throws Exception {
        double errorChance = Math.random();
        if (errorChance < 0.05) {
            throw new HttpException(1);
        } else if(errorChance < 0.3) {
            throw new HttpException(4);
        } else if(errorChance < 0.4) {
            throw new HttpException(2);
        } else if(errorChance < 0.5) {
            throw new HttpException(3);
        }
    }

}
