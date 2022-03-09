class TransactionsDB implements ITransactionsDB{
    Transaction[] dataBase = new Transaction[1000];
    static int transactionsCount = 0;

    void addTransaction(String formattedDate, String senderName, String receiverName, double sum, String comment) {
        dataBase[transactionsCount] = new Transaction(formattedDate, transactionsCount + 1, senderName, receiverName, sum, comment);
        transactionsCount++;
    }

    void addAnonymousTransaction(String formattedDate, String senderName, String receiverName, double sum, String comment) {
        dataBase[transactionsCount] = new AnonymousTransaction(formattedDate, transactionsCount + 1, senderName, receiverName, sum, comment);
        transactionsCount++;
    }

    @Override
    public String curTransaction() {
        StringBuilder builder = new StringBuilder("");
        builder.append(transactionsCount + ": ");
        builder.append(dataBase[transactionsCount - 1].getInfo());
        builder.append('\n');
        return builder.toString();
    }

    @Override
    public String getFullInfo() {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < transactionsCount; i++) {
            builder.append(i + 1 + ": ");
            builder.append(dataBase[i].getInfo());
            builder.append('\n');
        }
        return builder.toString();
    }

    @Override
    public String getAnonymousFullInfo() {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < transactionsCount; i++) {
            if(dataBase[i] instanceof AnonymousTransaction){
                builder.append(i + 1 + ": ");
                builder.append(dataBase[i].getInfo());
                builder.append('\n');
            }
        }
        return builder.toString();
    }

    @Override
    public String getInfoBySenderName(String senderName) {
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

