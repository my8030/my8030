public class Aplication {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(9.0),
                new Circle(16),
                new Square(16.0),
                new Triangle(13.0, 13, 13),
                new Circle(8),
                new Rect(9, 12),
                new Circle(19),
                new Rect(30, 7),
                new Triangle(5, 8, 6),
                new Rect(56, 97),
                new Square(25.0),
        };

        printSquares(shapes);
    }

    public static void printSquares(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i] + "; " + "Square = " + shapes[i].calcSquare() + "\t Perimeter = " + shapes[i].calcPerimeter());
        }
    }

}
