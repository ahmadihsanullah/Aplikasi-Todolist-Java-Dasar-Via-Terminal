import java.util.Scanner;

public class AplikasiTodolist {
    /**
     * membuat model
     */
    public static String[] model = new String[10];
    public static void main(String[] args) {
       viewShowTodolist();
    }

    //BUSINESS LOGIC
    /**
     * menampilkan todolist
     */
    public static void showTodolist(){
        for (var i = 0; i < model.length ; i ++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }
    public static void testShowTodolist(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Java OOP";
        showTodolist();
    }

    /**
     * menambah todo ke list
     */
    public static void addTodolist(String todo){
        //cek apakah model penuh?
        var isFull = true;
        for(int i = 0; i < model.length ; i++){
            if(model[i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //jika penuh, kita resize ukuran model, menjadi 2x lipat
        if(isFull){
            var temp = model;

            model = new String[model.length * 2];

            for(int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }


        //tambahkan ke posisi data arraynya yang NULL
        for (var i = 0 ; i < model.length ; i++){
            if(model[i] == null){
                model[i] = todo;
                //dibreak agar tidak terjadi perulangan terus ditiap index
                break;
            }
        }
    }

    public static void testAddTodolist(){
        for (int i = 0; i < 25; i++) {
            addTodolist("Contoh Todo Ke." + i);
        }

        showTodolist();
    }

    /**
     * menghapus todolist
     */

    public static boolean removeTodolist(Integer number){
        //bagimana jika number melebihin length model
        if((number -1 ) >= model.length){
            return false;
        }//number belum diisi, walaupun masih dalam kapasitas length yang memadai
        else if (model[number -1] == null) {
            return false;
        }// number nya ada
        else{
            for(int i = (number - 1); i <model.length; i++){
                //data tidak dihapus, hanya ditimpa dengan data selanjutnya
                //untuk data terahir kita ubah dulu menjadi null
                if(i == (model.length -1)){
                    //nilai untuk index akhir kita beri null, karena nilai dari index sebelumnya akan maju kedepan 1 langkah
                    model[i] = null;
                }else{
                    model[i] = model[i +1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodolist(){
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");
        addTodolist("empat");
        addTodolist("lima");
        addTodolist("enam");
        addTodolist("tujuh");
        addTodolist("delapan");

        var result = removeTodolist(20);
        System.out.println(result);

        result = removeTodolist(8);
        System.out.println(result);

        result=removeTodolist(2);
        System.out.println(result);

        result=removeTodolist(1);
        System.out.println(result);

        showTodolist();
    }

    //INPUT
    public static String input(String info){
        Scanner scanner = new Scanner(System.in);
        System.out.print(info + " : ");
        String data =  scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);
    }
    //VIEW

    /**
     * menampilkan view todolist
     */
    public static void viewShowTodolist(){
        while(true){
            System.out.println("TODOLIST");

            showTodolist();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. keluar");
            var input = input("Pilih");

            if(input.equals("1")){
                viewAddShowTodolist();
            }else if(input.equals("2")){
                viewRemoveTodolist();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodolist(){
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");

        viewShowTodolist();
    }

    /**
     * menampilkan view menambah todolist
     */
    public static void viewAddShowTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x) jika batal");

        if(todo.equals("x")){
            //batal
        }else{
            addTodolist(todo);
        }

    }

    public static void testViewAddTodolist(){
        addTodolist("satu");
        addTodolist("dua");
        viewAddShowTodolist();
        showTodolist();

    }


    /**
     * menampilkan view menghapus todolist
     */
    public static void viewRemoveTodolist(){

        System.out.println("Menghapus TODOLIST");

        var number =  input("No Todo, (x) jika batal");

        if(number.equals("x")){
            //
        }else{
            boolean success = removeTodolist(Integer.valueOf(number));

            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodolist(){
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");
        viewRemoveTodolist();
        showTodolist();
    }
}
