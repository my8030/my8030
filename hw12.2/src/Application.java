import java.util.*;

public class Application {
    public static Scanner scanner = new Scanner(System.in);

    public static Map<ScreenId, Screen> screens = new HashMap<>();
    public static Stack<Screen> backStack = new Stack<>();


    public static void main(String[] args) {
        System.out.println("English: enter 0\n" +
                "Українська мова: введіть 1");
        int langChoice = Integer.valueOf(scanner.next());
        Language.setLanguage(langChoice);

        Language.putTranslation();
        setupAppScreens();

        backStack.push(screens.get(ScreenId.SPLASH));

        while (true) {
            Screen curScreen = backStack.peek();
            displayScreen(curScreen);
            curScreen.onStart(); // Виконує події які мають статись після переходу на екран
            if (curScreen.hasActions() && !curScreen.hasOnStartAction()) {
                int choice = Integer.valueOf(scanner.next()) - 1;
                if (curScreen.isActionBack(choice)) {
                    backStack.pop();
                } else {
                    curScreen.doAction(choice);
                }
            }
        }
    }




    private static void setupAppScreens() {

        Screen splashScreen = new Screen("Splash", "           .'\\   /`.\n" +
                "         .'.-.`-'.-.`.\n" +
                "    ..._:   .-. .-.   :_...\n" +
                "  .'    '-.(o ) (o ).-'    `.\n" +
                " :  _    _ _`~(_)~`_ _    _  :\n" +
                ":  /:   ' .-=_   _=-. `   ;\\  :\n" +
                ":   :|-.._  '     `  _..-|:   :\n" +
                " :   `:| |`:-:-.-:-:'| |:'   :\n" +
                "  `.   `.| | | | | | |.'   .'\n" +
                "    `.   `-:_| | |_:-'   .'\n" +
                "      `-._   ````    _.-'\n" +
                "          ``-------''");
        splashScreen.setOnStartAction(new Action("Show Auth screen", () -> {
            safeSleep(2000);

            backStack.push(screens.get(ScreenId.AUTH));
        }));


        Screen homeScreen = new Screen(Language.getTranslation(ScreenNamesAndDescriptions.HOME), Language.getTranslation(ScreenNamesAndDescriptions.HOME_DESCRIPTION));
        homeScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.SETTINGS), () -> backStack.push(screens.get(ScreenId.SETTINGS)));
        homeScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.PRODUCTS_LIST), () -> backStack.push(screens.get(ScreenId.PRODUCTS_LIST)));
        homeScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.CART), () -> backStack.push(screens.get(ScreenId.CART)));

        Screen settingsScreen = new Screen(Language.getTranslation(ScreenNamesAndDescriptions.SETTINGS), Language.getTranslation(ScreenNamesAndDescriptions.SETTINGS_DESCRIPTION));
        settingsScreen.setBackAvailable();

        Screen forgotPasswordScreen = new Screen(Language.getTranslation(ScreenNamesAndDescriptions.FORGOT_PASSWORD), Language.getTranslation(ScreenNamesAndDescriptions.FORGOT_PASSWORD_DESCRIPTION));
        forgotPasswordScreen.setBackAvailable();

        Screen signUpScreen = new Screen(Language.getTranslation(ScreenNamesAndDescriptions.SIGN_UP), Language.getTranslation(ScreenNamesAndDescriptions.SIGN_UP_DESCRIPTION));
        signUpScreen.setBackAvailable();

        Screen authScreen = new Screen(Language.getTranslation(ScreenNamesAndDescriptions.AUTHORIZATION_SCREEN), Language.getTranslation(ScreenNamesAndDescriptions.AUTHORIZATION_SCREEN_DESCRIPTION));
        authScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.HOME), () -> {
            backStack.push(screens.get(ScreenId.HOME));
        });
        authScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.SIGN_UP), () -> {
            backStack.push(screens.get(ScreenId.SIGN_UP));
        });
        authScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.FORGOT_PASSWORD), () -> {
            backStack.push(screens.get(ScreenId.FGT_PASS));
        });

        Screen cartScreen = new Screen(Language.getTranslation(ScreenNamesAndDescriptions.CART), Language.getTranslation(ScreenNamesAndDescriptions.CART_DESCRIPTION));
        cartScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.CART), new ICallBack() {
            @Override
            public void onAction() {
                Cart.addToCart("Молоко");
                Cart.addToCart("Батон");
                Cart.addToCart("Горілка");
                System.out.println("\n======== Products in Cart =======");
                Cart.printProductsInCart();
            }
        });
        cartScreen.setBackAvailable();

        Screen productsScreen = new Screen(Language.getTranslation(ScreenNamesAndDescriptions.PRODUCTS_LIST), Language.getTranslation(ScreenNamesAndDescriptions.PRODUCTS_LIST_DESCRIPTION));
        productsScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.PRODUCTS_LIST), new ICallBack() {
            @Override
            public void onAction() {
                System.out.println("======== Enter Products =======\n(Enter \"End\" to finish)\n");
                String newProduct = "";
                while (!newProduct.equals("End")){
                    newProduct = scanner.nextLine();
                    if(!newProduct.equals("End")){
                        Products.addProduct(newProduct);
                    }
                }
                System.out.println("======== Products in List =======");
                Products.printProductList();
            }
        });
        productsScreen.addAction(Language.getTranslation(ScreenNamesAndDescriptions.CART), () -> backStack.push(screens.get(ScreenId.CART)));
        productsScreen.setBackAvailable();

        screens.put(ScreenId.HOME, homeScreen);
        screens.put(ScreenId.SETTINGS, settingsScreen);
        screens.put(ScreenId.FGT_PASS, forgotPasswordScreen);
        screens.put(ScreenId.AUTH, authScreen);
        screens.put(ScreenId.SPLASH, splashScreen);
        screens.put(ScreenId.SIGN_UP, signUpScreen);
        screens.put(ScreenId.PRODUCTS_LIST, productsScreen);
        screens.put(ScreenId.CART, cartScreen);
    }

    private static void displayScreen(Screen curScreen) {
        System.out.printf("========%s=======%n", curScreen.getName());
        System.out.println(curScreen.getDescription());
        System.out.println(curScreen.getActions());
    }

    private static void safeSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
