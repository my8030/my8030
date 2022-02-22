public class GameField {
    public int[][] field;

    public GameField(int[][] field) {
        this.field = field;
    }

    public String printValue (int x, int y){
        if (field[x][y] == 0){
            return "_";
        } else if (field[x][y] == 1){
            return "🚢";
        } else if (field[x][y] == 2){
            return "💥";
        } else {
            return "*";
        }
    }

    public int getValue (int x, int y){
        if (field[x][y] == 0){
            return 0;
        } else if (field[x][y] == 1){
            return 1;
        } else if (field[x][y] == 2){
            return 2;
        } else {
            return 3;
        }
    }

    public void putValue (int x, int y, int z){
        if (z == 0){
            field[x][y] = 0;
        } else if (z == 1){
            field[x][y] = 1;
        } else if (z == 2){
            field[x][y] = 2;
        } else {
            field[x][y] = 3;
        }
    }

}

