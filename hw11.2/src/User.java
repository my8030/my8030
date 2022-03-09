public class User {
    protected String userName;
    protected int countOfTrips;
    protected UserRating userRating;
    protected boolean premiumStatus;

    public User(String userName, int countOfTrips, UserRating userRating, boolean premiumStatus) {
        this.userName = userName;
        this.countOfTrips = countOfTrips;
        this.userRating = userRating;
        this.premiumStatus = premiumStatus;
    }

    public String getInfo() {
        String name = String.format("User: \"%s\"\t", userName);
        String trips = String.format("Count Of Trips: %s\t", countOfTrips);
        String rating = String.format("User Rating: \"%s\"\t", userRating);
        String status = String.format("Premium Status: %s", premiumStatus);
        return String.format("%s %s %s %s", name, trips, rating, status);
    }
}
