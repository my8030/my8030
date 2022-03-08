import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String squarePlayer[][] = new String[5][5];
        String square[][] =    {{"_", "_", "_", "_", "0"},
                {"0", "_", "_", "_", "_"},
                {"_", "_", "0", "_", "_"},
                {"_", "_", "_", "_", "_"},
                {"_", "0", "_", "_", "_"}};

        String squarePlayer[][] =
                {{"_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_"}};

        for (int k = 0; k < 10; k ++) {
            System.out.println("Enter the horizontal coordinate: ");
            int i = scanner.nextInt();
            i = testCoordinate(i);

            System.out.println("Enter the vertical coordinate:");
            int j = scanner.nextInt();
            j = testCoordinate(j);

            if (square[i][j].equals("0")){
                squarePlayer[i][j] = "X";
            } else {
                squarePlayer[i][j] = "*";
            }

            for (int n = 0; n < 5; n++) {
                for (int m = 0; m < 5; m++) {
                    System.out.print("" + squarePlayer[n][m] + "\t");
                    if (m == 4) {
                        System.out.println("\n");
                    }
                }
            }

        }
        System.out.println("Game over!");
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
}
