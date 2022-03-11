import java.util.*;

public class Language {
    public static Map<ScreenNamesAndDescriptions, String[]> lang = new HashMap<>();
    public static final int LANG_EN = 0;
    public static final int LANG_UK = 1;
    public static int language = LANG_EN;

    public static void setLanguage(int language) {
        Language.language = language;
    }

    public static String getTranslation (ScreenNamesAndDescriptions key){
        String uuu = lang.get(key)[language];
        return uuu;
    }

    public static void putTranslation (){
        lang.put(ScreenNamesAndDescriptions.AUTHORIZATION_SCREEN, new String[] {"Authorization Screen", "Авторизація"});
        lang.put(ScreenNamesAndDescriptions.HOME, new String[] {"Home", "Домашня сторінка"});
        lang.put(ScreenNamesAndDescriptions.SETTINGS, new String[] {"Settings", "Налаштування"});
        lang.put(ScreenNamesAndDescriptions.CART, new String[] {"Cart", "Кошик"});
        lang.put(ScreenNamesAndDescriptions.PRODUCTS_LIST, new String[] {"Products list", "Список продуктів"});
        lang.put(ScreenNamesAndDescriptions.FORGOT_PASSWORD, new String[] {"Forgot Password", "Пароль забуто"});
        lang.put(ScreenNamesAndDescriptions.SIGN_UP, new String[] {"Sign Up", "Вхід"});

        lang.put(ScreenNamesAndDescriptions.AUTHORIZATION_SCREEN_DESCRIPTION, new String[] {"Please login to the app", "Будь ласка, увійдіть до програми"});
        lang.put(ScreenNamesAndDescriptions.HOME_DESCRIPTION, new String[] {"This is home screen", "Це головний екран"});
        lang.put(ScreenNamesAndDescriptions.SETTINGS_DESCRIPTION, new String[] {"Here you can change app settings", "Тут ви можете змінити налаштування програми"});
        lang.put(ScreenNamesAndDescriptions.CART_DESCRIPTION, new String[] {"Here your products", "Тут ваші продукти"});
        lang.put(ScreenNamesAndDescriptions.PRODUCTS_LIST_DESCRIPTION, new String[] {"Please add products", "Тут ви можете додати продукти"});
        lang.put(ScreenNamesAndDescriptions.FORGOT_PASSWORD_DESCRIPTION, new String[] {"Please enter your email", "Будбласка введіть email"});
        lang.put(ScreenNamesAndDescriptions.SIGN_UP_DESCRIPTION, new String[] {"Please register", "Будьласка зареєструйтеся"});
    }

}
