import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CollectionTransactionsDB implements ITransactionsDB{
    List<Transaction> dataBase = new ArrayList<>();
    static int transactionsCount = 0;

    void addCollectionTransaction(String senderName, String receiverName, double sum, String comment){
        try {
            checkFullDBException();
            dataBase.add(transactionsCount, new Transaction(localDateAndTime(), transactionsCount + 1, senderName, receiverName, sum, comment));
            transactionsCount++;
        } catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
    }

    void addCollectionAnonymousTransaction(String senderName, String receiverName, double sum, String comment) {
        try {
            checkFullDBException();
            dataBase.add(transactionsCount, new AnonymousTransaction(localDateAndTime(), transactionsCount + 1, senderName, receiverName, sum, comment));
            transactionsCount++;
        } catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
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
    }

    @Override
    public String localDateAndTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    @Override
    public String curTransaction() {
        StringBuilder builder = new StringBuilder("");
        try {
            checkEmptyDBException();
            builder.append(transactionsCount + ": ");
            builder.append(dataBase.get(transactionsCount - 1).getInfo());
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
                builder.append(dataBase.get(i).getInfo());
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
                if(dataBase.get(i) instanceof AnonymousTransaction){
                    builder.append(i + 1 + ": ");
                    builder.append(dataBase.get(i).getInfo());
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
                if (dataBase.get(i).sender.equals(senderName)) {
                    builder.append(i + 1 + ": ");
                    builder.append(dataBase.get(i).getInfo());
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
            dataBase.set(transactionsCount, null);
        } catch (Exception exception) {
            System.out.println("\t\tERROR!");
            System.out.println(exception);
        }
    }

}

