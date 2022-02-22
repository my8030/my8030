public class Circle extends Shape {
    double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    @Override
    double calcSquare() {
        return Math.PI * Math.pow(diameter / 2, 2);
    }
    @Override
    double calcPerimeter() {
        return Math.PI * diameter;
    }


    @Override
    public String toString() {
        return String.format("Circle(diameter: %.2f)", diameter);
    }
}
