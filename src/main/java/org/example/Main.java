package org.example;

public class Main {
    public static void main(String[] args) {
        String filename = "todos.json";
        Parser jsonParser = new JsonParser(filename);
        TodoList todoList = jsonParser.parse();

        Exporter consoleExporter = new ConsoleExporter();
        Exporter jsonExporter = new JsonExporter(filename);

        switch (Action.fromString(args[0])) {
            case ADD:
                todoList.add(new Todo(args[1]));
                break;
            case LIST:
                consoleExporter.export(todoList);
                break;
            case REMOVE:
                todoList.remove(Integer.parseInt(args[1]) - 1);
                jsonExporter.export(todoList);
                break;
            case DONE:
                todoList.markAsDone(Integer.parseInt(args[1]) - 1);
                jsonExporter.export(todoList);
                break;
            case null:
                break;
        }
    }
}