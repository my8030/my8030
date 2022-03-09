public class Application {
    public static void main(String[] args){

        SelectInterface interfaceOption = SelectInterface.ARRAYLIST;

        if (interfaceOption.equals(SelectInterface.ARRAY)){
            ConsoleMenu.consoleMenu();
        } else if (interfaceOption.equals(SelectInterface.ARRAYLIST)){
            ConsoleMenuCollection.consoleMenu();
        }
    }

}
