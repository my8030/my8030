public class AnonymousTransaction extends Transaction {

    public AnonymousTransaction(String formattedDate, int number, String sender, String receiver, double sum, String comment) {
        super(formattedDate, number, "Anonymous", receiver, sum, comment);
    }

}
