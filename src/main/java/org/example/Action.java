package org.example;

public enum Action {
    ADD("add"),
    LIST("list"),
    REMOVE("remove"),
    DONE("done");

    private final String action;

    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static Action fromString(String text) {
        for (Action action : Action.values()) {
            if (action.action.equalsIgnoreCase(text)) {
                return action;
            }
        }
        return null;
    }
}
