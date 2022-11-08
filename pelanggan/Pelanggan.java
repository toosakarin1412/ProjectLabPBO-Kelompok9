package pelanggan;
import menu.*;

public class Pelanggan {
    private String nama;
    private Menu order[];

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

    }

    public Menu[] getOrder()
    {
        return this.order;
    }
}
