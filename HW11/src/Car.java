public class Car {
    private String brandName;
    private String modelName;
    private int year;
    private int distance;

    public Car(String brandName, String modelName, int year, int distance) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
        this.distance = distance;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getYear() {
        return year;
    }

    public int getDistance() {
        return distance;
    }

}
