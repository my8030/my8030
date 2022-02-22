public class Square extends Rect {

    public Square(double side) {
        super(side, side);
    }

    @Override
    double calcPerimeter() {
        return 4 * width;
    }

    @Override
    public String toString() {
        return String.format("Square(side: %.2f)", width);
    }
}
