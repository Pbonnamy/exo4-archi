package org.example;

import org.example.actions.*;

public class Main {
    public static void main(String[] args) {
        String filename = "todos.json";
        Parser jsonParser = new JsonParser(filename);
        TodoList todoList = jsonParser.parse();

        ActionType actionType = ActionType.fromString(args[0]);

        String[] actionArgs = new String[args.length - 1];
        ActionHandler actionHandler = new ActionHandler();
        actionHandler.handle(actionType, todoList, filename, actionArgs);
    }
}