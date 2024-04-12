package org.example;

public class Main {
    public static void main(String[] args) {
        String filename = "todos.json";
        Parser jsonParser = new JsonParser(filename);
        TodoList todoList = new TodoList(jsonParser.parse());

        switch (Action.fromString(args[0])) {
            case ADD:
                todoList.add(new Todo(args[1]));
                break;
            case LIST:
                Exporter consoleExporter = new ConsoleExporter(todoList);
                consoleExporter.export();
                break;
            case REMOVE:
                todoList.remove(Integer.parseInt(args[1]) - 1);
                break;
            case DONE:
                todoList.markAsDone(Integer.parseInt(args[1]) - 1);
                break;
            case null:
                break;
        }

        Exporter jsonExporter = new JsonExporter(filename, todoList);
        jsonExporter.export();
    }
}