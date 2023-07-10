package repository;

import entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository{
    public Todolist[] data = new Todolist[10];
    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull(){
        //cek apakah model penuh?
        var isFull = true;
        for(int i = 0; i < data.length ; i++){
            if(data[i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        //jika penuh, kita resize ukuran model, menjadi 2x lipat
        if(isFull()){
            var temp = data;

            data = new Todolist[data.length * 2];

            for(int i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }

    }
    @Override
    public void add(Todolist todolist) {
        resizeIfFull();

        //tambahkan ke posisi data arraynya yang NULL
        for (var i = 0 ; i < data.length ; i++){
            if(data[i] == null){
                data[i] = todolist;
                //dibreak agar tidak terjadi perulangan terus ditiap index
                break;
            }
        }

    }

    @Override
    public boolean remove(Integer number) {
        //bagimana jika number melebihin length model
        // contoh ada data 10, berarti memiliki index dari 0 -9
        // jika user memasukan 11, maka 11 -1 itu 10. dan 10 itu tidak ada didalam index atau data.length
        //kecuali user memasukan angka 10, maka no 10 akan terhapus. Kenapa karena 10 - 1 merupakan index ke 9, dan
        // data ke 10 merupkan index ke -9
        if((number -1 ) >= data.length){
            return false;
        }//number belum diisi, walaupun masih dalam kapasitas length yang memadai
        else if (data[number -1] == null) {
            return false;
        }// number nya ada
        else{
            for(int i = (number - 1); i <data.length; i++){
                //data tidak dihapus, hanya ditimpa dengan data selanjutnya
                //untuk data terahir kita ubah dulu menjadi null
                if(i == (data.length -1)){
                    //nilai untuk index akhir kita beri null, karena nilai dari index sebelumnya akan maju kedepan 1 langkah
                    data[i] = null;
                }else{
                    data[i] = data[i +1];
                }
            }
            return true;
        }
    }
}
