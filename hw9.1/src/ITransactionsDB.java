public interface ITransactionsDB {
    String curTransaction();
    String getFullInfo();
    String getAnonymousFullInfo();
    String getInfoBySenderName(String senderName);

}
