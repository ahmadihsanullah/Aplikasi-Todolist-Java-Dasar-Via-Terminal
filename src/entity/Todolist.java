package entity;

public class Todolist{
    private String todo;

    public Todolist() {
    }

    /**
     * constructor ke-2 berperan untuk menyimpan data yang dikirim, class diubah menjadi bentuk array
     * @param todo
     */
    public Todolist(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
