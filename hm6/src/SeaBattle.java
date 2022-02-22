import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of levels: ");
        int levels = scanner.nextInt();

        GameField square = new GameField (new int[][]{
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0}
        });

        GameField squarePlayer = new GameField (new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });


        for (int k = 0; k < levels; k ++) {
            battle (square, squarePlayer);
            printField(squarePlayer);
        }
        theEnd(squarePlayer, square);
    }


    public static void battle (GameField square, GameField squarePlayer){
        int x = xCoordinate();
        int y = yCoordinate();
        int position = square.getValue(x, y);
        if (position == 0){
            squarePlayer.putValue(x, y, 3);
        } else if (position == 1){
            squarePlayer.putValue(x, y, 2);
        }
    }


    public static int xCoordinate (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the horizontal coordinate: ");
        int i = scanner.nextInt();
        return testCoordinate(i);
    }

    public static int yCoordinate (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vertical coordinate: ");
        int j = scanner.nextInt();
        return testCoordinate(j);
    }

    public static int testCoordinate(int coordinate){
        Scanner scanner = new Scanner(System.in);
        while (coordinate < 0 || coordinate >= 5) {
            if (coordinate > 4) {
                System.out.println("Shot past the field! Try again!");
                coordinate = scanner.nextInt();
            }
            if (coordinate < 0) {
                System.out.println("Shot past the field! Try again!");
                coordinate = scanner.nextInt();
            }
        }
        return coordinate;
    }

    public static void printField(GameField squarePlayer){
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 5; m++) {
                System.out.print("" + squarePlayer.printValue(n, m) + "\t");
                if (m == 4) {
                    System.out.println("\n");
                }
            }
        }
    }

    public static void theEnd(GameField squarePlayer, GameField square){
        System.out.println("\nGame over!\n");
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 5; m++) {
                if (square.getValue(n, m) == 1 && squarePlayer.getValue(n, m) == 0){
                    System.out.print("🚢\t");
                } else {
                    System.out.print("" + squarePlayer.printValue(n, m) + "\t");
                }
                if (m == 4) {
                    System.out.println("\n");
                }
            }
        }
    }

}