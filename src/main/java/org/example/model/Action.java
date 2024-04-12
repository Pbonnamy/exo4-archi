package org.example.model;

public enum Action {
    ADD("add"),
    LIST("list"),
    REMOVE("remove"),
    DONE("done"),
    REPORT("report");

    private final String action;

    Action(String action) {
        this.action = action;
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
