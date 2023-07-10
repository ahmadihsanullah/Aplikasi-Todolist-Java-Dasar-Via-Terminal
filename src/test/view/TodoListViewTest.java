package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import test.service.TodolistServiceTest;
import view.TodolistView;

import static test.service.TodolistServiceTest.testShowTodolist;

public class TodoListViewTest {
    public static void main(String[] args) {

        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodolistRepository repository = new TodolistRepositoryImpl();
        TodolistService service = new TodolistServiceImpl(repository);
        TodolistView view = new TodolistView(service);

        service.addTodoList("Belajar Java Dasar");
        service.addTodoList("Belajar Java OOP");

        view.showTodoList();

    }

    public static void testAddTodoList() {
        TodolistRepository repository = new TodolistRepositoryImpl();
        TodolistService service = new TodolistServiceImpl(repository);
        TodolistView view = new TodolistView(service);

        view.addTodoList();

        service.showTodoList();

        view.addTodoList();

        service.showTodoList();

    }

    public static void testRemoveTodoList() {
        TodolistRepository repository = new TodolistRepositoryImpl();
        TodolistService service = new TodolistServiceImpl(repository);
        TodolistView view = new TodolistView(service);

        service.addTodoList("Belajar Java Dasar");
        service.addTodoList("Belajar Java OOP");
        service.addTodoList("Belajar Java Classess");

        service.showTodoList();

        view.removeTodoList();

        service.showTodoList();




    }
}
