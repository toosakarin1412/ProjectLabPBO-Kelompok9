package pelanggan;
import menu.*;
import java.util.ArrayList;

public class Pelanggan {
    private String nama;
    private ArrayList<Menu> order;

    public Pelanggan(){

    };

    public Pelanggan(String nama) 
    {
        this.nama = nama;
    }

    public String getNama() 
    {
        return this.nama;
    }

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public void addOrder(Menu pesan)
    {
        order.add(pesan);
    }

    public ArrayList<Menu> getOrder()
    {
        return this.order;
    }
}
