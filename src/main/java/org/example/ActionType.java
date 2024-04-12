package org.example;

public enum ActionType {
    ADD("add"),
    LIST("list"),
    REMOVE("remove"),
    DONE("done");

    private final String action;

    ActionType(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static ActionType fromString(String text) {
        for (ActionType actionType : ActionType.values()) {
            if (actionType.action.equalsIgnoreCase(text)) {
                return actionType;
            }
        }
        return null;
    }
}
