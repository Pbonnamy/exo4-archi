package org.example;

public class Main {
    public static void main(String[] args) {
        String filename = "todos.json";
        Parser jsonParser = new JsonParser(filename);
        TodoList todoList = new TodoList(jsonParser.parse());

        todoList.add(new Todo("Buy milk"));

        Exporter consoleExporter = new ConsoleExporter(todoList);
        consoleExporter.export();

        Exporter jsonExporter = new JsonExporter(filename, todoList);
        jsonExporter.export();
    }
}