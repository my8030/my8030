import java.util.Scanner;

public class ConsoleMenuCollection implements NewTransaction {
    private static CollectionTransactionsDB receipt= new CollectionTransactionsDB();

    public static void consoleMenu(){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        final int REGISTER_NEW_TRANSACTION = 1;
        final int REGISTER_NEW_ANONYMOUS_TRANSACTION = 2;
        final int DISPLAY_ALL_TRANSACTIONS_ON_SCREEN = 3;
        final int DISPLAY_ALL_TRANSACTIONS_INFORMATION_BY_SENDER = 4;
        final int DISPLAY_CURRENT_TRANSACTION_INFORMATION = 5;
        final int DISPLAY_ALL_TRANSACTIONS_ON_SCREEN_ANONYMOUSLY = 6;
        final int DELETE_LAST_TRANSACTION = 7;
        final int FINISH_WORK = 8;
        final int OPTIONS_NUMBER = 8;

        while (number != OPTIONS_NUMBER){
            System.out.println("\nWhat do you want to do?\n" +
                    "Register a new transaction: please enter " + REGISTER_NEW_TRANSACTION  + ".\n" +
                    "Register a new anonymous transaction: please enter " + REGISTER_NEW_ANONYMOUS_TRANSACTION + ".\n" +
                    "Display all transactions on screen: please enter " + DISPLAY_ALL_TRANSACTIONS_ON_SCREEN + ".\n" +
                    "Display all transactions information by sender: please enter " + DISPLAY_ALL_TRANSACTIONS_INFORMATION_BY_SENDER + ".\n" +
                    "Display current transaction information: please enter " + DISPLAY_CURRENT_TRANSACTION_INFORMATION + ".\n" +
                    "Display all transactions on screen anonymously: please enter " + DISPLAY_ALL_TRANSACTIONS_ON_SCREEN_ANONYMOUSLY + ".\n" +
                    "Delete last transaction: please enter " + DELETE_LAST_TRANSACTION  + ".\n" +
                    "Finish work: please enter " + FINISH_WORK + ".\n");
            number = scanner.nextInt();
            switch (number) {
                case REGISTER_NEW_TRANSACTION : {
                    newTransaction();
                    break;
                }
                case REGISTER_NEW_ANONYMOUS_TRANSACTION: {
                    newAnonymousTransaction();
                    break;
                }
                case DISPLAY_ALL_TRANSACTIONS_ON_SCREEN: {
                    System.out.println(receipt.getFullInfo());
                    break;
                }
                case DISPLAY_ALL_TRANSACTIONS_INFORMATION_BY_SENDER: {
                    System.out.println("Please enter the sender's name.");
                    scanner.nextLine();
                    String searchSenderName = scanner.nextLine();
                    System.out.println(receipt.getInfoBySenderName(searchSenderName));
                    break;
                }
                case DISPLAY_CURRENT_TRANSACTION_INFORMATION: {
                    String curTransaction = receipt.curTransaction() + '\n';
                    System.out.println(curTransaction);
                    break;
                }
                case DISPLAY_ALL_TRANSACTIONS_ON_SCREEN_ANONYMOUSLY: {
                    System.out.println(receipt.getAnonymousFullInfo());
                    break;
                }
                case DELETE_LAST_TRANSACTION: {
                    receipt.deleteTransaction();
                    break;
                }
                case FINISH_WORK: {
                    System.out.println("Good Buy!\n");
                    break;
                }
                default: {
                    System.out.println("Please enter the correct number!\n");

                    break;
                }
            }
        }
    }


    public static void newTransaction(){
        receipt.addCollectionTransaction(NewTransaction.senderName(), NewTransaction.receiverName(), NewTransaction.sum(), NewTransaction.comment());
    }

    public static void newAnonymousTransaction(){
        receipt.addCollectionAnonymousTransaction(NewTransaction.senderName(), NewTransaction.receiverName(), NewTransaction.sum(), NewTransaction.comment());
    }


}
