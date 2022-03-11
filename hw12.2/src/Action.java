public class Action {
    private String name;
    private ICallBack callback;

    public Action(String name, ICallBack callback) {
        this.name = name;
        this.callback = callback;
    }

    public String getName() {
        return name;
    }

    public ICallBack getCallback() {
        return callback;
    }
}
