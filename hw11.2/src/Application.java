public class Application {
    public static void main(String[] args) {
        UsersDB users= new UsersDB();
        users.addNewUser("Vasko", 255, UserRating.VERY_BAD, false);
        users.addNewUser("Petro", 2, UserRating.BAD, true);
        users.addNewUser("Andriy", 10, UserRating.AVERAGE, false);
        users.addNewUser("Sashko", 5, UserRating.GOOD, true);
        users.addNewUser("Luka", 33, UserRating.NOT_BAD, false);
        users.addNewUser("Djamshut", 500, UserRating.VERY_GOOD, true);
        users.addNewUser("Nasayalnika", 1988, UserRating.OUR_BOSS, true);


        System.out.println("" + UsersDB.userInfo("Nasayalnika") + "\n");

        UsersDB.changeUserRatingByName("Petro", UserRating.OUR_BOSS);
        UsersDB.premiumStatus("Djamshut", false);
        UsersDB.deleteUserByName("Nasayalnika");
        UsersDB.fullInfo();
        System.out.println("\n");
        UsersDB.sortUsersAlphabetically();
    }
}
