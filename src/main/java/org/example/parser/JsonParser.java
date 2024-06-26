package org.example.parser;

import org.example.model.Todo;
import org.example.model.TodoList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonParser implements Parser {
    String filename;

    public JsonParser(String filename) {
        this.filename = filename;
    }

    public TodoList parse() {
        List<Todo> todos = new ArrayList<>();

        try {
            if (!new File(filename).exists()) {
                return new TodoList(todos);
            }

            FileReader reader = new FileReader(filename);
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String text = (String) jsonObject.get("text");
                Date date = new Date((Long) jsonObject.get("date"));
                boolean done = (boolean) jsonObject.get("done");
                todos.add(new Todo(text, date, done));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new TodoList(todos);
    }
}
