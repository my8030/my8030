public class Main {
    public static void main(String[] args) {
        Tram[] trams = {
                new Tram(30, 60.1, 0.1, "Bumer", Math.random()),
                new Tram(28, 53, 0.2, "Lamba", Math.random()),
                new Tram(25.3, 57, 0.3, "Gelik", Math.random()),
                new Tram(31.4, 62.2, 0.4, "Kopiyka", Math.random()),
                new Tram(38, 50.9, 0.5, "Zapar", Math.random()),
                new Tram(16, 71.6, 0.6, "Ferra", Math.random())
        };

        searchWinner(trams);
    }

    public static void searchWinner(Tram[] trams) {
        double[] speed = new double [trams.length];
        for (int i = 0; i < trams.length; i++) {
            speed[i] = trams[i].tramsFinishersSpeed();
            System.out.println("Train: " + trams[i].winnerName() + "\t Speed: " + speed[i]);
        }
        double winnerTram = speed[0];
        String winner = "All in drift";
        for (int i = 1; i < trams.length; i++) {
            if (speed[i] > winnerTram) {
                winnerTram = speed[i];
                winner = trams[i].winnerName();
            }
        }
        System.out.println("\n Winner is: " + winner);

    }
}
