package menu;

/**
 * Abstract Class Menu, berisi semua method dan atribut yang ada pada sebuah Menu
 */
public abstract class Menu {
    protected String nama;
    protected int harga;

    /**
     * Mengembalikan harga dari menu
     * @return this.harga harga dari Menu
     */
    public int getHarga(){
        return this.harga;
    };

    /**
     * Mengembalikan nama dari menu
     * @return this.nama nama dari menu
     */
    public String getNama(){
        return this.nama;
    };

    /**
     * Atur nama dari menu
     * @param nama nama menu
     */
    public void setNama(String nama){
        this.nama = nama;
    };

    /**
     * Atur harga dari menu
     * @param harga harga menu
     */
    public void setHarga(int harga){
        this.harga = harga;
    };
}
