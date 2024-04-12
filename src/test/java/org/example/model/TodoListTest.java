package org.example.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TodoListTest {

    private TodoList todoList;

    @Before
    public void setup() {
        todoList = new TodoList(new ArrayList<>());
    }

    @Test
    public void testAdd() {
        Todo todo = new Todo("Test todo");
        todoList.add(todo);
        assertTrue(todoList.getTodos().contains(todo));
    }

    @Test
    public void testRemove() {
        Todo todo = new Todo("Test todo");
        todoList.add(todo);
        todoList.remove(0);
        assertFalse(todoList.getTodos().contains(todo));
    }

    @Test
    public void testMarkAsDone() {
        Todo todo = new Todo("test todo");
        todoList.add(todo);
        todoList.markAsDone(0);
        assertTrue(todoList.getTodos().get(0).isDone());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMarkAsDoneWithInvalidIndex() {
        todoList.markAsDone(0);
    }

    @Test
    public void testGetTodos() {
        List<Todo> todos = new ArrayList<>();
        Todo todo1 = new Todo("Test todo");
        Todo todo2 = new Todo("Test todo 2");
        todos.add(todo1);
        todos.add(todo2);

        TodoList todoList = new TodoList(todos);
        assertEquals(todos, todoList.getTodos());
    }
}