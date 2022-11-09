import menu.*;
import pelanggan.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private ArrayList<Menu> daftar_menu = new ArrayList<Menu>();
    private ArrayList<Pelanggan> cust = new ArrayList<Pelanggan>();

    /**
     * Method Constuctor
     */
    public Main() {
        this.readMenu();
    };

    /**
     * Baca Menu dari file
     */
    public void readMenu() {
        try {
            File myObj = new File("menu.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                ArrayList<String> tokens = new ArrayList<String>();
                String data = myReader.nextLine();
                StringTokenizer st = new StringTokenizer(data, "$");

                while (st.hasMoreTokens()) {
                    tokens.add(st.nextToken());
                }

                if (tokens.get(0).equals("Makanan")) {
                    int harga = 0;
                    try {
                        harga = Integer.parseInt(tokens.get(2));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    Makanan mkn = new Makanan(tokens.get(1), harga);
                    daftar_menu.add(mkn);

                } else if (tokens.get(0).equals("Minuman")) {
                    int harga = 0;
                    try {
                        harga = Integer.parseInt(tokens.get(2));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    Jus js = new Jus(tokens.get(1), harga);
                    daftar_menu.add(js);
                }
            }

            AirMineral tmp = new AirMineral();
            daftar_menu.add(tmp);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Tidak dapat di load");
            e.printStackTrace();
        }
    };

    /**
     * Tampilkan menu
     */
    public void printMenu() {
        try {
            for (int i = 0; i < daftar_menu.size(); i++) {
                System.out.println("==============================");
                System.out.println("No : " + i + " ");
                System.out.println("Nama : " + daftar_menu.get(i).getNama());
                System.out.println("Harga : " + daftar_menu.get(i).getHarga());
                System.out.println("==============================");
            }
            ;
        } catch (NullPointerException e) {
            System.out.println("TIDAK ADA MENU");
            System.out.println("==============================");
        }

    };

    /**
     * Tampilkan pelanggan
     */
    public void printPelanggan() {
        try {
            for (int i = 0; i < cust.size(); i++) {
                System.out.println("No : " + i + " ");
                System.out.println("Nama : " + cust.get(i).getNama());
                System.out.println("==============================");
            }
            ;
        } catch (NullPointerException e) {
            System.out.println("TIDAK ADA PELANGGAN");
            System.out.println("==============================");
        }
    };

    /**
     * Add Customer
     * 
     * @param customer object pelanggan
     */
    public void addPelanggan(Pelanggan customer) {
        cust.add(customer);
    };
    
    /**
     * hapus pelanggan
     * 
     * @param index 
     */
    public void hapusPelanggan(int index) {
        this.cust.remove(index);
    };

    /**
     * Dapatkan objek pelanggan
     * 
     * @param index index
     * @return objek pelanggan
     */
    public Pelanggan getPelanggan(int index) {
        return this.cust.get(index);
    }
    
    /**
     * Dapatkan objek menu
     * 
     * @param index 
     * @return objek menu
     */
    public Menu getMenu(int index) {
        return this.daftar_menu.get(index);
    }

    /**
     * Menghitung jumlah bill
     * 
     * @param customer object pelanggan
     * @return total tagihan
     */
    public int totalBill(Pelanggan customer) {
        int total = 0;

        ArrayList<Menu> menuTmp = new ArrayList<Menu>();
        menuTmp = customer.getOrder();

        for (int i = 0; i < menuTmp.size(); i++) {
            total += menuTmp.get(i).getHarga();
        }
        ;

        return total;
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main driver = new Main();

        while (true) {
            System.out.println();
            System.out.println("==============================");
            System.out.println("APLIKASI KASIR RESTORAN XXX");
            System.out.println("==============================");
            System.out.println("1.MENU");
            System.out.println("2.PELANGGAN");
            System.out.println("3.HITUNG TAGIHAN");
            System.out.println("9.EXIT");
            System.out.println("==============================");

            int pilihan;
            try {
                pilihan = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("INPUT TIDAK VALID");
                System.out.println("==============================");
                input.nextLine();
                continue;
            }
            ;

            if (pilihan == 1) {
                System.out.println();
                System.out.println("==============================");
                System.out.println("MENU");
                System.out.println("==============================");
                driver.printMenu();
            } else if (pilihan == 2) {
                System.out.println();
                System.out.println("==============================");
                System.out.println("PELANGGAN");
                System.out.println("==============================");
                driver.printPelanggan();

                System.out.println("1.TAMBAH PELANGGAN");
                System.out.println("2.TAMBAH PESANAN");
                System.out.println("3.PESANAN PELANGGAN");

                int pil;
                while (true) {
                    try {
                        pil = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("INPUT TIDAK VALID");
                        System.out.println("==============================");
                        input.nextLine();
                        continue;
                    }
                }

                if (pil == 1) {
                    String namaPel;
                    System.out.println("==============================");
                    System.out.print("Nama : ");
                    input.nextLine();
                    namaPel = input.nextLine();

                    Pelanggan plg = new Pelanggan(namaPel);

                    driver.addPelanggan(plg);
                } else if (pil == 2) {
                    driver.printPelanggan();

                    int pelIn;
                    while (true) {
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
                    while (true) {
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

                    try {
                        try {
                            driver.getPelanggan(pelIn).addOrder(driver.getMenu(menIn));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Index Tidak Ditemukan");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Index Tidak Ditemukan");
                    }

                } else if (pil == 3) {
                    int pelIn;
                    while (true) {
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
                    System.out.println("==============================");
                    System.out.println("PESANAN");
                    System.out.println("==============================");

                    ArrayList<Menu> menuTmp = new ArrayList<Menu>();
                    menuTmp = driver.getPelanggan(pelIn).getOrder();
                    for (int i = 0; i < menuTmp.size(); i++) {
                        System.out.println(menuTmp.get(i).getNama());
                    }
                }

            } else if (pilihan == 3) {
                driver.printPelanggan();

                int pelIn;
                while (true) {
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

                Pelanggan pelTmp = driver.getPelanggan(pelIn);

                System.out.println();
                System.out.println("==============================");
                System.out.println("TAGIHAN");
                System.out.println("==============================");
                System.out.println("NAMA PELANGGAN : " + pelTmp.getNama());
                System.out.println("PESANAN");
                System.out.println("==============================");
                for (int i = 0; i < pelTmp.getOrder().size(); i++) {
                    System.out.println(pelTmp.getOrder().get(i).getNama());
                }
                System.out.println("==============================");

                int total = driver.totalBill(pelTmp);
                System.out.println("TOTAL TAGIHAN : Rp." + total);
                System.out.println("==============================");

                System.out.println("1.BAYAR");
                System.out.println("2.KEMBALI KE MENU");

                int hps = 0;
                while (true) {
                    try {
                        System.out.println("==============================");
                        System.out.print("Pilihan : ");
                        hps = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("INPUT TIDAK VALID");
                        System.out.println("==============================");
                        input.nextLine();
                        continue;
                    }
                }

                if(hps == 1){
                    driver.hapusPelanggan(pelIn);
                }
            } else if (pilihan == 9) {
                break;
            } else {
                System.out.println("INPUT TIDAK SESUAI MENU");
                continue;
            }
        }
        ;

        input.close();
    };
}
