public class NoUserException extends Exception {
    @Override
    public String getMessage() {
        return "No such user!";
    }
}
