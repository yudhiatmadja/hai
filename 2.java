Array List
import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    String nama;
    String kontak;

    public Contact(String nama, String kontak){
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }
    public String getKontak() {
        return kontak;
    }
 }

 class ContactManager {
    ArrayList<Contact> contactList = new ArrayList<>();

    public void addContact(String nama, String kontak) {
        Contact newContact = new Contact(nama, kontak);
        contactList.add(newContact);
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        System.out.println("Daftar Kontak:");
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            System.out.println((i + 1) + ". " + contact.getNama() + " " + contact.getKontak());
            System.out.println("\n");
        }
    }

public void searchContact(String nama){
    for(Contact contact : contactList){
        if(contact.getNama().equalsIgnoreCase(nama)){
            System.out.println("Kontak ditemukan!");
            System.out.println("Nama: " + contact.getNama());
            System.out.println("Nomor Telepon: " + contact.getKontak());
            return;  
        }
    }
    System.out.println("Kontak tidak ditemukan.");
}
}



public class ContactManagement{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("Selamat datang di Manajemen Kontak!");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");

            int pilih = input.nextInt();
            input.nextLine();

    switch (pilih) {
        case 1:
        System.out.print("Masukkan nama kontak: ");
        String nama = input.nextLine();
        System.out.print("Masukkan nomor telepon: ");
        String kontak = input.nextLine();
        contactManager.addContact(nama, kontak);
        break;
        case 2:
        contactManager.displayContacts();
            break;
        case 3:
        System.out.print("Masukkan nama kontak yang ingin dicari: ");
        String searchName = input.nextLine();
        contactManager.searchContact(searchName);
            break;
        case 4:
        System.out.println("Terima kasih! Program selesai.");
        System.exit(0);
            break;
        default:
        System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, 3, atau 4.");
    }
}
}
}

Linkedlist
import java.util.Scanner;

class Contact {
    String nama;
    String kontak;
    Contact next;

    public Contact(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
        this.next = null;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }
}

class ContactManager {
    Contact head;

    public void addContact(String nama, String kontak) {
        Contact newContact = new Contact(nama, kontak);
        if (head == null) {
            head = newContact;
        } else {
            Contact current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newContact;
        }
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        System.out.println("Daftar Kontak:");
        Contact current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.getNama() + " " + current.getKontak());
            current = current.next;
            index++;
        }
        System.out.println();
    }

    public void searchContact(String nama) {
        Contact current = head;
        while (current != null) {
            if (current.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan!");
                System.out.println("Nama: " + current.getNama());
                System.out.println("Nomor Telepon: " + current.getKontak());
                return;
            }
            current = current.next;
        }
        System.out.println("Kontak tidak ditemukan.");
    }
}

public class ContactManagement2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("Selamat datang di Manajemen Kontak!");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");

            int pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan nama kontak: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    String kontak = input.nextLine();
                    contactManager.addContact(nama, kontak);
                    break;
                case 2:
                    contactManager.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukkan nama kontak yang ingin dicari: ");
                    String searchName = input.nextLine();
                    contactManager.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, 3, atau 4.");
            }
        }
    }
}



   



