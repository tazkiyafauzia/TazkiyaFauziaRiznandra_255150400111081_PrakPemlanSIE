public class Mobil {
    private String nopol;
    private String warna;
    private String merk;
    private int kecepatan;
    private int kecepatanms;
    private int jarak;
    private int waktu;

    public void setNopol(String n) {
        nopol = n;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setMerk(String m) {
        merk = m;
    }

    public void setKecepatan(int k) {
        kecepatan = k;
    }

    public void setWaktu(int w){
        waktu = w;
    }

    public void setJarak() {
        jarak = kecepatan * waktu;
    }

    public void ubahKecepatan(){
        kecepatanms = (kecepatan * 1000) / 3600; 
        System.out.println("Kecepatan dalam satuan m/s: "+ kecepatanms);
    }

    public void display() {
        System.out.println("Mobil bermerk " + merk);
        System.out.println("bernomor polisi " + nopol);
        System.out.println("serta memililki warna " + warna);
        System.out.println("bergerak dengan kecepatan " + kecepatan + " kpj");
        System.out.println("dengan waktu tempuh " + waktu + " jam");
        System.out.println("dengan jarak tempuh " + jarak + " km");
    }
}
