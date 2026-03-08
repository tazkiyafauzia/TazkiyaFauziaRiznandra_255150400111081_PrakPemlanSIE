import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //instansiasi objek bernama m1
        Mobil m1 = new Mobil();
      
        m1.setKecepatan(50);
        m1.setMerk(input.nextLine());
        m1.setNopol(input.nextLine());
        m1.setWarna("Merah");
        m1.setWaktu(2);
        m1.setJarak();
        m1.display();
        m1.ubahKecepatan();
      
        System.out.println("---------------");
      
        //instansiasi objek bernama m2
        Mobil m2 = new Mobil();
        m2.setKecepatan(100);
        m2.setMerk(input.nextLine());
        m2.setNopol(input.nextLine());
        m2.setWarna("Biru");
        m2.setWaktu(1);
        m2.setJarak();
        m2.ubahKecepatan();
        m2.display();
        m2.ubahKecepatan();
      
        System.out.println("---------------");
        System.out.println("Atribut pada objek m1 diubah.");
      
        //mengubah warna dari objek m1
        m1.setWarna("Hijau");
      
        //menampilkan hasil perubahan
        m1.display();
    }
}
