public class main {
    public static void main(String[] args) {
        Tram[] trams = {
                new Tram(35, 97.1, 0.1, "Porsche", Math.random()),
                new Tram(8, 53, 0.2, "BMW", Math.random()),
                new Tram(25.3, 87, 0.3, "VW", Math.random()),
                new Tram(31.4, 62.2, 0.4, "VAZ", Math.random()),
                new Tram(48, 50.9, 0.5, "LADA", Math.random()),
                new Tram(16, 51.6, 0.6, "MUSTANG", Math.random())
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
