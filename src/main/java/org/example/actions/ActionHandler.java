package org.example.actions;

import org.example.ActionType;
import org.example.ConsoleExporter;
import org.example.JsonExporter;
import org.example.TodoList;

public class ActionHandler {
    public void handle(ActionType actionType, TodoList todoList, String filename, String... args) {

        switch (actionType) {
            case ADD:
                new AddAction(args[0], todoList, new JsonExporter(filename)).execute();
                break;
            case LIST:
                new ListAction(todoList, new ConsoleExporter()).execute();
                break;
            case REMOVE:
                new RemoveAction(Integer.parseInt(args[0]) - 1, todoList, new JsonExporter(filename)).execute();
                break;
            case DONE:
                new DoneAction(Integer.parseInt(args[0]) - 1, todoList, new JsonExporter(filename)).execute();
                break;
            case null:
                break;
        }
    }
}
