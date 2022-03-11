import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String name;
    private String description;

    private List<Action> actions = new ArrayList<>();
    private Action onStartAction;

    boolean isBackAvailable;

    public Screen(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void onStart() {
        if (onStartAction != null) {
            onStartAction.getCallback().onAction();
        }
    }

    public boolean hasActions() {
        return !actions.isEmpty() || isBackAvailable;
    }

    public boolean hasOnStartAction() {
        return onStartAction != null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addAction(String transitionName, ICallBack callback) {
        actions.add(new Action(transitionName, callback));
    }

    public void setOnStartAction(Action action) {
        onStartAction = action;
    }

    public void setBackAvailable() {
        isBackAvailable = true;
    }

    public String getActions() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < actions.size(); i++) {
            builder.append(String.format("%d: %s\n", i + 1, actions.get(i).getName()));
        }
        if (isBackAvailable) {
            builder.append(String.format("%d: %s\n", actions.size() + 1, "Back"));
        }
        return builder.toString();
    }

    public void doAction(int actionIndex) {
        actions.get(actionIndex).getCallback().onAction();
    }

    public boolean isActionBack(int actionIndex) {
        return actionIndex == actions.size();
    }

}
