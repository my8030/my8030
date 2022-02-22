public class Triangle extends Shape {
    double sideA;
    double sideB;
    double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double calcSquare() {
        double halfPerimeter = calcPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
    @Override
    double calcPerimeter() {
        return sideA + sideB + sideC;
    }


    @Override
    public String toString() {
        return String.format("Triangle(side A: %.2f, side B: %.2f, side C: %.2f)", sideA, sideB, sideC);
    }
}


