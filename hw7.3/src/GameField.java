public class GameField {
    static public int[][] field;
    static Bacteria[] allBacteria;
    static int fieldWidth;
    static int bacteriaCount;
    static int foodCount;
    static int minCoordinate = -1;
    static int maxCoordinate = 1;


    static public void startParameters(int widthOfField, int bacterias, int food) {
        fieldWidth = widthOfField;
        bacteriaCount = bacterias;
        foodCount = food;
        field = new int[widthOfField][widthOfField];
        allBacteria = new Bacteria[bacteriaCount];
    }

    static public void putStartUnits() {
        putBacteria(allBacteria);
        putFood();
    }

    static public void moveBacteria(int bacteriaNumber, Bacteria[] allBacteria) {
        int currentHealth = allBacteria[bacteriaNumber].health;
        int currentX = allBacteria[bacteriaNumber].x;
        int currentY = allBacteria[bacteriaNumber].y;

        int newX = moveX(allBacteria[bacteriaNumber].x);
        int newY = moveY(allBacteria[bacteriaNumber].y);

        if (getValue(newX, newY) == 0) {
            putValue(newX, newY, 1);
            putValue(currentX, currentY, 0);
            varyCurrentBacteria(allBacteria, bacteriaNumber, newX, newY, currentHealth);
        }
        else if (getValue(newX, newY) == 1 && newX != currentX && newY != currentY) {
            putValue(newX, newY, 1);
            putValue(currentX, currentY, 0);
            int enemyBacteriaHealth = lookBacteriaHealth(allBacteria, newX, newY);
            if (enemyBacteriaHealth <= currentHealth) {
                currentHealth += enemyBacteriaHealth;
                killEnemyBacteriaHealth(allBacteria, newX, newY);
                varyCurrentBacteria(allBacteria, bacteriaNumber, newX, newY, currentHealth);
            } else {
                enemyBacteriaHealth += currentHealth;
                currentHealth = 0;
                varyEnemyBacteriaHealth(allBacteria, newX, newY, enemyBacteriaHealth);
                varyCurrentBacteria(allBacteria, bacteriaNumber, (fieldWidth + 1), (fieldWidth + 1), currentHealth);
            }
        }
        else if (getValue(newX, newY) == 2){
            putValue(newX, newY, 1);
            putValue(currentX, currentY, 0);
            currentHealth++;
            varyCurrentBacteria(allBacteria, bacteriaNumber, newX, newY, currentHealth);
        }
    }


    static public void varyCurrentBacteria(Bacteria[] allBacteria, int bacteriaNumber, int newX, int newY, int currentHealth) {
        allBacteria[bacteriaNumber].health = currentHealth;
        allBacteria[bacteriaNumber].x = newX;
        allBacteria[bacteriaNumber].y = newY;
    }


    static public int lookBacteriaHealth(Bacteria[] allBacteria, int needX, int needY) {
        int currentHealth = 0;
        for (int i = 0; i < bacteriaCount; i++) {
            if (allBacteria[i].x == needX && allBacteria[i].y == needY && allBacteria[i].health != 0) {
                currentHealth = allBacteria[i].health;
            }
        }
        return currentHealth;
    }

    static public void varyEnemyBacteriaHealth(Bacteria[] allBacteria, int needX, int needY, int newHealth) {
        for (int i = 0; i < bacteriaCount; i++) {
            if (allBacteria[i].x == needX && allBacteria[i].y == needY && allBacteria[i].health != 0) {
                allBacteria[i].health = newHealth;
            }
        }
    }

    static public void killEnemyBacteriaHealth(Bacteria[] allBacteria, int needX, int needY) {
        for (int i = 0; i < bacteriaCount; i++) {
            if (allBacteria[i].x == needX && allBacteria[i].y == needY) {
                allBacteria[i].health = 0;
                allBacteria[i].x = fieldWidth + 1;
                allBacteria[i].y = fieldWidth + 1;
            }
        }
    }

    static public int deadBacteriaCount(Bacteria[] allBacteria) {
        int deadBacteria = 0;
        for (int i = 0; i < bacteriaCount; i++) {
            if (allBacteria[i].health == 0){
                deadBacteria++;
            }
        }
        return deadBacteria;
    }

    static public void putBacteria(Bacteria[] allBacteria) {
        int health = 3;
        int bacteriasToPut = 0;
        int minCoordinate = 0;
        int maxCoordinate = fieldWidth - 1;
        while (bacteriasToPut < bacteriaCount){
            int x = (int) (Math.random() * (maxCoordinate - minCoordinate + 1) + minCoordinate);
            int y = (int) (Math.random() * (maxCoordinate - minCoordinate + 1) + minCoordinate);
            if (field[x][y] == 0){
                field[x][y] = 1;
                allBacteria[bacteriasToPut] = new Bacteria(x, y, health);
                bacteriasToPut++;
            }
        }
    }

    static public void putFood() {
        int foodToPut = 0;
        int minCoordinate = 0;
        int maxCoordinate = fieldWidth - 1;
        while (foodToPut < foodCount){
            int x = (int) (Math.random() * (maxCoordinate - minCoordinate + 1) + minCoordinate);
            int y = (int) (Math.random() * (maxCoordinate - minCoordinate + 1) + minCoordinate);
            if (field[x][y] == 0){
                field[x][y] = 2;
                foodToPut++;
            }
        }
    }

    static public String returnValue (int x, int y){
        String result = "";
        if (field[x][y] == 0){
            result =  "_";
        } else if (field[x][y] == 1){
            result =  "😈";
        } else if (field[x][y] == 2){
            result =  "♥";
        }
        return result;
    }




    static public int getValue (int x, int y){
        int result = 0;
        if (field[x][y] == 0){
            result = 0;
        } else if (field[x][y] == 1){
            result =  1;
        } else if (field[x][y] == 2){
            result =  2;
        }
        return result;
    }

    static public void putValue (int x, int y, int figure){
        if (figure == 0){
            field[x][y] = 0;
        } else if (figure == 1){
            field[x][y] = 1;
        } else if (figure == 2){
            field[x][y] = 2;
        }
    }


    static public int moveX(int x){
        if (x != 0 && x != fieldWidth - 1){
            x += randomThreeDigit();
        } else if (x == 0){
            x += (int) (Math.random() * (maxCoordinate + 1));
        } else if (x == fieldWidth - 1){
            x += (int) (Math.random() * (minCoordinate - 1));
        }
        return x;
    }

    static public int moveY(int y){
        if (y != 0 && y != fieldWidth - 1){
            y += randomThreeDigit();
        } else if (y == 0){
            y += (int) (Math.random() * (maxCoordinate + 1));
        } else if (y == fieldWidth - 1){
            y += (int) (Math.random() * (minCoordinate - 1));
        }
        return y;
    }

    static public int randomThreeDigit(){
        int random = 0;
        double rand = Math.random();
        if (rand < 0.34){
            random = -1;
        } else if (rand < 0.67){
            random = 0;
        } else {
            random = 1;
        }
        return random;
    }
}
