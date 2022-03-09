import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionsDB implements ITransactionsDB{
    Transaction[] dataBase = new Transaction[5];
    static int transactionsCount = 0;

    void addTransaction(String senderName, String receiverName, double sum, String comment){
        try {
            checkFullDBException();
            dataBase[transactionsCount] = new Transaction(localDateAndTime(), transactionsCount + 1, senderName, receiverName, sum, comment);
            transactionsCount++;
        } catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
    }

    void addAnonymousTransaction(String senderName, String receiverName, double sum, String comment) {
        try {
            checkFullDBException();
            dataBase[transactionsCount] = new AnonymousTransaction(localDateAndTime(), transactionsCount + 1, senderName, receiverName, sum, comment);
            transactionsCount++;
        } catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
    }

    @Override
    public String localDateAndTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    @Override
    public void checkEmptyDBException() throws Exception {
        if (transactionsCount <= 0){
            transactionsCount = 0;
            throw new EmptyDBException();
        }
    }

    @Override
    public void checkFullDBException() throws Exception {
        if (transactionsCount == dataBase.length){
            throw new FullDBException();
        }
    }

    @Override
    public String curTransaction() {
        StringBuilder builder = new StringBuilder("");
        try {
            checkEmptyDBException();
            builder.append(transactionsCount + ": ");
            builder.append(dataBase[transactionsCount - 1].getInfo());
            builder.append('\n');
        } catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
        return builder.toString();
    }

    @Override
    public String getFullInfo(){
        StringBuilder builder = new StringBuilder("");
        try {
            checkEmptyDBException();
            for (int i = 0; i < transactionsCount; i++) {
                builder.append(i + 1 + ": ");
                builder.append(dataBase[i].getInfo());
                builder.append('\n');
            }
        }
        catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
        return builder.toString();
    }

    @Override
    public String getAnonymousFullInfo(){
        StringBuilder builder = new StringBuilder("");
        try {
            checkEmptyDBException();
            for (int i = 0; i < transactionsCount; i++) {
                if(dataBase[i] instanceof AnonymousTransaction){
                    builder.append(i + 1 + ": ");
                    builder.append(dataBase[i].getInfo());
                    builder.append('\n');
                }
            }
        }
        catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
        return builder.toString();
    }

    @Override
    public String getInfoBySenderName(String senderName){
        StringBuilder builder = new StringBuilder();
        try {
            checkEmptyDBException();
            for (int i = 0; i < transactionsCount; i++) {
                if (dataBase[i].sender.equals(senderName)) {
                    builder.append(i + 1 + ": ");
                    builder.append(dataBase[i].getInfo());
                    builder.append('\n');
                }
            }
        }
        catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
        return builder.toString();
    }

    @Override
    public void deleteTransaction(){
        try {
            transactionsCount--;
            checkEmptyDBException();
            dataBase[transactionsCount] = null;
        } catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
    }

}

