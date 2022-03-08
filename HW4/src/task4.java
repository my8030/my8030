import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        String playerName;
        int dumplings = 21;
        while (dumplings >= 1){
            playerName = "Player 1";
            dumplings = dumplingsEater(playerName, dumplings);
            playerName = "Player 2";
            dumplings = dumplingsEater(playerName, dumplings);
        }
    }

    public static int dumplingsEater(String playerName, int dumplings){
        Scanner scanner = new Scanner(System.in);
        if (dumplings > 2){
            System.out.println("Enter how many dumplings does " + playerName + " want?");
            int player = scanner.nextInt();
            if (player > 5 || dumplings < player) {
                System.out.println("" + playerName + " you're too greedy! Take less!");
                player = scanner.nextInt();
            }
            if (player < 1) {
                System.out.println("" + playerName + " take up to 5 dumplings!");
                player = scanner.nextInt();
            }
            dumplings -= player;
            System.out.println("There are " + dumplings + " dumplings left!");

        } else if (dumplings != 0){
            System.out.println("" + playerName + " has lost! Go wash the dishes!");
            dumplings = 0;

        }
        return dumplings;
    }
}
