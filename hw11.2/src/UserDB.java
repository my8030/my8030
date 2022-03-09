

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsersDB {
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
        for (int i = 0; i < userCount; i++) {
            if (user.get(i).userName.equals(userName)) {
                user.get(i).userRating = userRating;
            }
        }
    }

    public static void premiumStatus(String userName, boolean premiumStatus){
        for (int i = 0; i < userCount; i++) {
            if (user.get(i).userName.equals(userName)) {
                user.get(i).premiumStatus = premiumStatus;
            }
        }
    }

    public static String userInfo(String userName){
        String info = "No such user";
        for (int i = 0; i < userCount; i++) {
            if (user.get(i).userName.equals(userName)) {
                info = user.get(i).getInfo();
            }
        }
        return info;
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

}
