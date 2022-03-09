public interface ITransactionsDB {
    String curTransaction() throws Exception;
    String getFullInfo() throws Exception;
    String getAnonymousFullInfo() throws Exception;
    String getInfoBySenderName(String senderName) throws Exception;
    void deleteTransaction() throws Exception;
    void checkEmptyDBException() throws Exception;
    void checkFullDBException() throws Exception;
    String localDateAndTime();

}
