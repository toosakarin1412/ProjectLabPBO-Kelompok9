import menu.*;
import pelanggan.*;
import menu.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 

public class Main {
    private ArrayList<Menu> daftar_menu = new ArrayList<Menu>();
    private ArrayList<Pelanggan> cust = new ArrayList<Pelanggan>(); 

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
     * Tampilkan menu
     */
    public void printMenu(){
        try{
            for(int i = 0;i < daftar_menu.size();i++){
                System.out.println("==============================");
                System.out.print("No : " + i + " ");
                System.out.println("Nama : " + daftar_menu.get(i).getNama());
                System.out.println("Harga : " + daftar_menu.get(i).getHarga());
                System.out.println("==============================");
            };
        }catch(NullPointerException e){
            System.out.println("TIDAK ADA MENU");
            System.out.println("==============================");
        }

    };

    /**
     * Tampilkan pelanggan
     */
    public void printPelanggan(){
        try{
            for(int i = 0;i < cust.size();i++){
                System.out.println("No : " + i + " ");
                System.out.println("Nama : " + cust.get(i).getNama());
                System.out.println("==============================");
            };
        }catch(NullPointerException e){
            System.out.println("TIDAK ADA PELANGGAN");
            System.out.println("==============================");
        }
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
        Scanner input = new Scanner(System.in);
        Main driver = new Main();
        
        while(true){
            System.out.println("==============================");
            System.out.println("APLIKASI KASIR RESTORAN XXX");
            System.out.println("==============================");
            System.out.println("1.MENU");
            System.out.println("2.PELANGGAN");
            System.out.println("3.HITUNG TAGIHAN");
            System.out.println("9.EXIT");
            System.out.println("==============================");

            int pilihan;
            try{
                pilihan = input.nextInt();
            }catch(InputMismatchException e){
                System.out.println("INPUT TIDAK VALID");
                System.out.println("==============================");
                input.nextLine();
                continue;
            };

            if(pilihan == 1){
                System.out.println("MENU");
                System.out.println("==============================");
                driver.printMenu();
            }else if(pilihan == 2){
                System.out.println("PELANGGAN");
                System.out.println("==============================");
                driver.printPelanggan();

                System.out.println("1.TAMBAH PELANGGAN");
                System.out.println("2.TAMBAH PESANAN");

                int pil;
                while(true){
                    try{
                        pil = input.nextInt();
                        break;
                    }catch(InputMismatchException e){
                        System.out.println("INPUT TIDAK VALID");
                        System.out.println("==============================");
                        input.nextLine();
                        continue;
                    }
                }

                if(pil == 1){
                    String namaPel;
                    System.out.println("==============================");
                    System.out.print("Nama : ");
                    input.nextLine();
                    namaPel = input.nextLine();

                    Pelanggan plg = new Pelanggan(namaPel);

                    driver.addPelanggan(plg);
                }else if(pil == 2){
                    driver.printPelanggan();

                    int pelIn;
                    while(true){
                        try {
                            System.out.println("==============================");
                            System.out.print("No Pel : ");
                            pelIn = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("INPUT TIDAK VALID");
                            System.out.println("==============================");
                            input.nextLine();
                            continue;
                        }
                    }

                    driver.printMenu();

                    int menIn;
                    while(true){
                        try {
                            System.out.println("==============================");
                            System.out.print("No Menu : ");
                            menIn = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("INPUT TIDAK VALID");
                            System.out.println("==============================");
                            input.nextLine();
                            continue;
                        }
                    }

                    System.out.println(pelIn);
                    System.out.println(menIn);
                }else{

                }
                
            }else if(pilihan == 3){
                System.out.println("TAGIHAN");
                System.out.println("==============================");
            }else if(pilihan == 9){
                break;
            }else{
                System.out.println("INPUT TIDAK SESUAI MENU");
                continue;
            }
        };
    };
}
