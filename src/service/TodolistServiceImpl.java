package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService{

    private TodolistRepository todoListRepository;

    public TodolistServiceImpl(TodolistRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (var i = 0; i < model.length ; i ++){
            var todolist = model[i];
            var no = i + 1;

            if(todolist != null){
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todolist) {

    }

    @Override
    public void removeTodoList(Integer number) {

    }
}
