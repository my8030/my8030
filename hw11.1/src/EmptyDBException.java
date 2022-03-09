public class EmptyDBException extends Exception {
    @Override
    public String getMessage() {
        return "Transactions data base is empty!";
    }
}
