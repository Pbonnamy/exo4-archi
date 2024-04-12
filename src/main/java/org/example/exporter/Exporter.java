package org.example.exporter;

import org.example.model.TodoList;

public interface Exporter {
    void export(TodoList todoList);
}
