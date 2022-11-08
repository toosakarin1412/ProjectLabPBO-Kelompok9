import menu.*;
import pelanggan.*;
import menu.*;
import java.util.ArrayList;

public class Main {
    private ArrayList<Menu> daftar_menu;
    private ArrayList<Pelanggan> cust;

    /**
     * Method Constuctor
     */
    public Main(){

    };

    /**
     * Baca Menu
     */
    public void readMenu(){

        // Implementasi

    };
    
    /**
     * Add Customer
     * @param customer object pelanggan 
     */
    public void addPelanggan(Pelanggan customer){
        cust.add(customer);
    };

    /**
     * Menghitung jumlah bill
     * @param customer object pelanggan 
     * @return total tagihan
     */
    public int totalBill(Pelanggan customer){
        int total = 0;

        // Implementasi

        return total;
    };
    
    public static void main(String[] args){
        
    };
}
