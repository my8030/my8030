public class Transaction {
    String formattedDate;
    int number;
    String sender;
    String receiver;
    double sum;
    String comment;


    public Transaction(String formattedDate, int number, String sender, String receiver, double sum, String comment) {
        this.formattedDate = formattedDate;
        this.number = number;
        this.sender = sender;
        this.receiver = receiver;
        this.sum = sum;
        this.comment = comment;
    }


    public String getInfo() {
        String prefix = String.format("%s_%03d", formattedDate, number);
        String senderFtd = String.format("FROM=\"%s\"", sender);
        String receiverFtd = String.format("TO=\"%s\"", receiver);
        String sumFtd = String.format("SUM=%.2f", sum);
        String commentFtd = "";
        if (comment != null) {
            commentFtd = String.format("COMMENT=\"%s\"", comment);
        }

        return String.format("%s::%s; %s; %s; %s", prefix, senderFtd, receiverFtd, sumFtd, commentFtd);
    }
}
