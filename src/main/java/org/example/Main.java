package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "todos.json";
        JsonParser jsonParser = new JsonParser(filename);
        TodoList todoList = new TodoList(jsonParser.parse());

        todoList.add(new Todo("Buy milk"));

        JsonExporter jsonExporter = new JsonExporter(filename, todoList);
        jsonExporter.export();
    }
}