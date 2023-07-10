package view;

import service.TodolistService;
import util.InputUtil;

public class TodolistView {
    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodoList(){
        while(true){
            System.out.println("TODOLIST");

            todolistService.showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. keluar");
            var input = InputUtil.input("Pilih");

            if(input.equals("1")){
                addTodoList();
            }else if(input.equals("2")){
                removeTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Todo (x) jika batal");

        if(todo.equals("x")){
            //batal
        }else{
            todolistService.addTodoList(todo);
        }
    }

    public void removeTodoList(){
        System.out.println("Menghapus TODOLIST");

        var number =  InputUtil.input("No Todo, (x) jika batal");

        if(number.equals("x")){
            //
        }else{
            todolistService.removeTodoList(Integer.valueOf(number));
        }
    }
}
