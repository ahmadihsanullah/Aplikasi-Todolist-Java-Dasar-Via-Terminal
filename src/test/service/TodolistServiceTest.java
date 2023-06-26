package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceTest {
    public static void main(String[] args) {
        testShowTodolist();
    }

    public static void testShowTodolist()
    {
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
        todolistRepository.data[0] = new Todolist("Belajar Java Dasar");
        todolistRepository.data[1] = new Todolist("Belajar Java OOP");
        todolistRepository.data[2] = new Todolist("Belajar Java Standard Classess");
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.showTodoList();
    }
}
