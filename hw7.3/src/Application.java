public class Application {
    public static void main(String[] args) {

        final int fieldWidth = 4;
        final int bacteriaCount = 5;
        final int foodCount = 5;

        GameField.startParameters(fieldWidth, bacteriaCount, foodCount);
        GameField.putStartUnits();


        while (GameField.deadBacteriaCount(GameField.allBacteria) != bacteriaCount - 1){
            for (int i = 0; i < bacteriaCount; i++) {
                while (GameField.allBacteria[i].health == 0) {
                    i++;
                    if (i == bacteriaCount){
                        break;
                    }
                }
                if (i != bacteriaCount) {
                    GameField.moveBacteria(i, GameField.allBacteria);
                    printField(fieldWidth);
                    System.out.println("=======================\n");
                }
            }
        }

    }
    public static void printField(int fieldWidth){
        for (int i = 0; i < fieldWidth; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                System.out.print("" + GameField.returnValue(j, i) + "\t");
                if (j == fieldWidth - 1) {
                    System.out.println("\n");
                }
            }
        }
    }

    public static void printFieldNumbers(int fieldWidth){
        for (int i = 0; i < fieldWidth; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                System.out.print("" + GameField.field[j][i] + "\t");
                if (j == fieldWidth - 1) {
                    System.out.println("\n");
                }
            }
        }
    }

    public static void printBacteriaInfo(int bacteriaCount){
        for (int i = 0; i < bacteriaCount; i++) {
            System.out.println("" + i + ": x=" + GameField. allBacteria[i].x + ";\t y=" + GameField. allBacteria[i].y + ";\t health=" + GameField. allBacteria[i].health + ";");
        }
    }
}
