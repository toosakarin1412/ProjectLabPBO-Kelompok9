package menu;

public class Menu {
    public String nama;
    public int harga;

    public Menu(){

    };

    public int getHarga(){
        return this.harga;
    };

    public String getNama(){
        return this.nama;
    };

    public void setNama(String nama){
        this.nama = nama;
    };

    public void setHarga(int harga){
        this.harga = harga;
    };
}
