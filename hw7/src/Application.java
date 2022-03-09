import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        TransactionsDB receipt = new TransactionsDB();
        consoleMenu(receipt);


    }

    public static TransactionsDB newTransaction(TransactionsDB receipt){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sender name: ");
        String senderName = scanner.nextLine();
        System.out.println("Enter receiver name: ");
        String receiverName = scanner.nextLine();
        System.out.println("Enter sum: ");
        int sum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter comment: ");
        String comment = scanner.nextLine();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        receipt.addTransaction(formattedDate, senderName, receiverName, sum, comment);
        return receipt;

    }

    public static void consoleMenu (TransactionsDB receipt){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (number != 4){
            System.out.println("What do you want to do?\n" +
                    "Register a new transaction: please enter 1.\n" +
                    "Display all transactions on screen: please enter 2.\n" +
                    "Get transaction information: please enter 3.\n" +
                    "Finish work: please enter 4.");
            number = scanner.nextInt();
            switch (number) {
                case 1: {
                    newTransaction(receipt);
                    break;
                }
                case 2: {
                    System.out.println(receipt.getFullInfo());

                    break;
                }
                case 3: {
                    System.out.println("Please enter the sender's name.");
                    scanner.nextLine();
                    String searchSenderName = scanner.nextLine();
                    System.out.println(receipt.getInfoBySenderName(searchSenderName));

                    break;
                }
                case 4: {
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
}
