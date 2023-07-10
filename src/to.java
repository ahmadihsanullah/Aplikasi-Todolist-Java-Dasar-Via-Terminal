class Laptop {
    static int totalLaptop = 0;
    static int[] total = {0,0,0,0,0,0,0,0};
    Laptop() {
        totalLaptop++;
        int total = this.total.length;
        System.out.println("Class Laptop ke-"+ totalLaptop +" dibuat" + total);
    }
}

class BelajarJava {
    public static void main(String args[]){
        Laptop laptopAndi = new Laptop();
        Laptop laptopLisa = new Laptop();
        Laptop laptopRudi = new Laptop();
        Laptop laptopAlex = new Laptop();
    }
}
