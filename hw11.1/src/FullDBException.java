public class FullDBException extends Exception {
    @Override
    public String getMessage() {
        return "Transactions data base is full!";
    }
}
