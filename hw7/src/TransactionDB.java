public class TransactionDB {
    Transaction[] dataBase = new Transaction[1000];
    static int transactionsCount = 0;

    void addTransaction(String formattedDate, String senderName, String receiverName, double sum, String comment) {
        dataBase[transactionsCount] = new Transaction(formattedDate, transactionsCount + 1, senderName, receiverName, sum, comment);
        transactionsCount++;
    }


    String getFullInfo() {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < transactionsCount; i++) {
            builder.append(i + 1 + ": ");
            builder.append(dataBase[i].getInfo());
            builder.append('\n');
        }
        return builder.toString();
    }

    String getInfoBySenderName(String senderName) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < transactionsCount; i++) {
            if (dataBase[i].sender.equals(senderName)) {
                builder.append(i + 1 + ": ");
                builder.append(dataBase[i].getInfo());
                builder.append('\n');
            }
        }
        return builder.toString();
    }


}
