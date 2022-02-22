public class Rect extends Shape {
    double width;
    double height;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calcSquare() {
        return width * height;
    }
    @Override
    double calcPerimeter() {
        return (width + height) * 2;
    }


    @Override
    public String toString() {
        return String.format("Rect(width: %.2f, height: %.2f)", width, height);
    }
}
