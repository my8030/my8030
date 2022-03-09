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
            String sumTest = scanner.nextLine();
            while (!sumTest.matches("\\d*")) {
                System.out.println("Enter sum: ");
                sumTest = scanner.nextLine();
            }
            int sum = Integer.parseInt (sumTest);
            System.out.println("Enter comment: ");
            String comment = scanner.nextLine();

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            receipt.addTransaction(formattedDate, senderName, receiverName, sum, comment);
            return receipt;

        }

        public static TransactionsDB newAnonymousTransaction(TransactionsDB receipt){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter sender name: ");
            String senderName = scanner.nextLine();
            System.out.println("Enter receiver name: ");
            String receiverName = scanner.nextLine();
            System.out.println("Enter sum: ");
            String sumTest = scanner.nextLine();
            while (!sumTest.matches("\\d*")) {
                System.out.println("Enter sum: ");
                sumTest = scanner.nextLine();
            }
            int sum = Integer.parseInt (sumTest);
            System.out.println("Enter comment: ");
            String comment = scanner.nextLine();

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            receipt.addAnonymousTransaction(formattedDate, senderName, receiverName, sum, comment);
            return receipt;
        }

        public static void consoleMenu (TransactionsDB receipt){
            Scanner scanner = new Scanner(System.in);
            int number = 0;
            final int REGISTER_NEW_TRANSACTION = 1;
            final int REGISTER_NEW_ANONYMOUS_TRANSACTION = 2;
            final int DISPLAY_ALL_TRANSACTIONS_ON_SCREEN = 3;
            final int DISPLAY_ALL_TRANSACTIONS_INFORMATION_BY_SENDER = 4;
            final int DISPLAY_CURRENT_TRANSACTION_INFORMATION = 5;
            final int DISPLAY_ALL_TRANSACTIONS_ON_SCREEN_ANONYMOUSLY = 6;
            final int FINISH_WORK = 7;
            final int OPTIONS_NUMBER = 7;

            newTransaction(receipt);
            while (number != OPTIONS_NUMBER){
                System.out.println("What do you want to do?\n" +
                        "Register a new transaction: please enter " + REGISTER_NEW_TRANSACTION  + ".\n" +
                        "Register a new anonymous transaction: please enter " + REGISTER_NEW_ANONYMOUS_TRANSACTION + ".\n" +
                        "Display all transactions on screen: please enter " + DISPLAY_ALL_TRANSACTIONS_ON_SCREEN + ".\n" +
                        "Display all transactions information by sender: please enter " + DISPLAY_ALL_TRANSACTIONS_INFORMATION_BY_SENDER + ".\n" +
                        "Display current transaction information: please enter " + DISPLAY_CURRENT_TRANSACTION_INFORMATION + ".\n" +
                        "Display all transactions on screen anonymously: please enter " + DISPLAY_ALL_TRANSACTIONS_ON_SCREEN_ANONYMOUSLY + ".\n" +
                        "Finish work: please enter " + FINISH_WORK + ".\n");
                number = scanner.nextInt();
                switch (number) {
                    case REGISTER_NEW_TRANSACTION : {
                        newTransaction(receipt);
                        break;
                    }
                    case REGISTER_NEW_ANONYMOUS_TRANSACTION: {
                        newAnonymousTransaction(receipt);
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

    }
