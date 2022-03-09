import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDB {
    private static List<User> user = new ArrayList<>();
    static int userCount = 0;

    public void addNewUser(String userName, int countOfTrips, UserRating userRating, boolean premiumStatus){
        user.add(userCount, new User(userName, countOfTrips, userRating, premiumStatus));
        userCount++;
    }

    public static void deleteUserByName(String userName){
        for (int i = 0; i < userCount; i++) {
            if (user.get(i).userName.equals(userName)) {
                user.remove(i);
                userCount--;
            }
        }
    }

    public static void changeUserRatingByName(String userName, UserRating userRating){
        try {
            noUserException(userName);
            for (int i = 0; i < userCount; i++) {
                if (user.get(i).userName.equals(userName)) {
                    user.get(i).userRating = userRating;
                }
            }
        } catch (Exception e) {
            System.out.println("\t\tERROR!\n" + e);
            e.printStackTrace();
        }
    }

    public static void premiumStatus(String userName, boolean premiumStatus){
        try {
            noUserException(userName);
            for (int i = 0; i < userCount; i++) {
                if (user.get(i).userName.equals(userName)) {
                    user.get(i).premiumStatus = premiumStatus;
                }
            }
        } catch (Exception e) {
            System.out.println("\t\tERROR!\n" + e);
            e.printStackTrace();
        }
    }

    public static void userInfo(String userName){
        try {
            noUserException(userName);
            for (int i = 0; i < userCount; i++) {
                if (user.get(i).userName.equals(userName)) {
                    System.out.println(user.get(i).getInfo());
                }
            }
        } catch (Exception e) {
            System.out.println("\t\tERROR!\n" + e);
            e.printStackTrace();
        }
    }


    public static void sortUsersAlphabetically(){
        List<String> names = new ArrayList<>();
        for (int i = 0; i < userCount; i++) {
            names.add(user.get(i).userName);
        }
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length();
                if (result == 0) {
                    result = o1.compareTo(o2);
                }
                return result;
            }
        });
        for (String curItem : names) {
            System.out.println(curItem);
        }
    }

    public static void fullInfo(){
        for (int i = 0; i < userCount; i++) {
            System.out.println(user.get(i).getInfo());
        }
    }


    public static void noUserException(String userName) throws Exception {
        int number = 0;
        for (int i = 0; i < userCount; i++) {
            if (user.get(i).userName.equals(userName)) {
                number++;
            }
        }
        if (number == 0){
            throw new NoUserException();
        }
    }

}
