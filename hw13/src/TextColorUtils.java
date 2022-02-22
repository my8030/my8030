public class TextColorUtils {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static String getInColor(String text, byte colorId) {
        switch (colorId) {
            case ColorIds.BLACK: return ANSI_BLACK + text + ANSI_RESET;
            case ColorIds.CYAN: return  ANSI_CYAN + text + ANSI_RESET;
            case ColorIds.BLUE: return  ANSI_BLUE + text + ANSI_RESET;
            case ColorIds.GREEN: return  ANSI_GREEN + text + ANSI_RESET;
            case ColorIds.PURPLE: return  ANSI_PURPLE + text + ANSI_RESET;
            case ColorIds.RED: return  ANSI_RED + text + ANSI_RESET;
            case ColorIds.WHITE: return  ANSI_WHITE + text + ANSI_RESET;
            case ColorIds.YELLOW: return  ANSI_YELLOW + text + ANSI_RESET;
            default: return  "" + text;
        }
    }
}

