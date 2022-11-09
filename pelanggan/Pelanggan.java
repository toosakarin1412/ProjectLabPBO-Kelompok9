package pelanggan;
import menu.*;
import java.util.ArrayList;

public class Pelanggan {
    private String nama;
    private ArrayList<Menu> order = new ArrayList<Menu>();

    /**
    * Method Constructor
    */
    public Pelanggan(){

    };

    /**
    * Method Constructor
    * @param nama pelanggan
    */
    public Pelanggan(String nama) 
    {
        this.nama = nama;
    }

    /**
    * Mengembalikan nama dari pelanggan
    * @return this.nama nama pelanggan
    */
    public String getNama() 
    {
        return this.nama;
    }

    /**
    * Mengatur nama pelanggan
    * @param nama nama pelanggan
    */
    public void setNama(String nama)
    {
        this.nama = nama;
    }

    /**
    * @param pesan pesan menu
    */
    public void addOrder(Menu pesan)
    {
        order.add(pesan);
    }

    /**
    * @return this.order
    */
    public ArrayList<Menu> getOrder()
    {
        return this.order;
    }
}
