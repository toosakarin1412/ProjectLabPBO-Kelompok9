package menu;

public abstract class Menu {
    protected String nama;
    protected int harga;

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
