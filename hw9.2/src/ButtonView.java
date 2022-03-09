public class ButtonView extends View implements Display {
    public static String iconName;

    public ButtonView(String iconName) {
        this.iconName = iconName;
    }

    @Override
    public void click(){
        System.out.println("Не тикай мене!");
    }

    @Override
    public void longClick(){
        System.out.println("Та кажуш тобі - не тикай мене!");
    }

}
