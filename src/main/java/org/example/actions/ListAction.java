package org.example.actions;

import org.example.Exporter;
import org.example.TodoList;

public class ListAction implements Action {
    private final TodoList todoList;
    private final Exporter exporter;

    public ListAction(TodoList todoList, Exporter exporter) {
        this.todoList = todoList;
        this.exporter = exporter;
    }

    public void execute() {
        this.exporter.export(this.todoList);
    }
}
