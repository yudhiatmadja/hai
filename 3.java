import java.util.ArrayList;
import java.util.Scanner;

public class BrowserNavigator {
    private ArrayList<String> historyStack;
    private int currentIndex;

    public BrowserNavigator(int capacity) {
        historyStack = new ArrayList<>(capacity);
        currentIndex = -1;
    }

    public void visitURL(Object object) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("masukkan url : ");
        String url = scanner.nextLine();
        if (currentIndex == -1 || !historyStack.get(currentIndex).equals(url)) {
            if (currentIndex == historyStack.size() - 1) {
                historyStack.add(url);
            } else {
                historyStack.subList(currentIndex + 1, historyStack.size()).clear();
                historyStack.add(url);
            }
            currentIndex++;
            System.out.println("Visited URL: " + url);
        } else {
            System.out.println("Already at this URL.");
        }
    }

    public void back() {
        if (currentIndex > 0) {
            currentIndex--;
            System.out.println("Navigating back to: " + historyStack.get(currentIndex));
        } else {
            System.out.println("No previous URLs in history.");
        }
    }

    public void forward() {
        if (currentIndex < historyStack.size() - 1) {
            currentIndex++;
            System.out.println("Navigating forward to: " + historyStack.get(currentIndex));
        } else {
            System.out.println("No forward URLs in history.");
        }
    }

    public String getCurrentURL() {
        return historyStack.get(currentIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrowserNavigator browser = new BrowserNavigator(5);
        while (true) {
            System.out.println("1. masukkan url");
            System.out.println("2. forward");
            System.out.println("3. back");
            System.out.println("4. current url");
            System.out.println("5. keluar");
            System.out.println("masukkan pilihan : ");
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:

                    browser.visitURL(null);
                    break;
                case 2:
                    browser.forward();
                    break;
                case 3:
                    browser.back();
                    break;
                case 4:
                    System.out.println("Current URL: " + browser.getCurrentURL());
                    break;
                case 5:
                    System.exit(0);
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("pilihan tidak tersedia");

            }
        }

    }
}


import java.util.Scanner;

class Node {
    String namaPemesan;
    int jumlahTiket;
    int nomorPemesanan;
    Node next;

    public Node(String namaPemesan, int jumlahTiket, int nomorPemesanan) {
        this.namaPemesan = namaPemesan;
        this.jumlahTiket = jumlahTiket;
        this.nomorPemesanan = nomorPemesanan;
        this.next = null;
    }
}

class TicketQueue {
    private Node front, back;
    private int size;

    public TicketQueue() {
        front = null;
        back = null;
        size = 0;
    }

    public void enqueue(String namaPemesan, int jumlahTiket) {
        Node newNode = new Node(namaPemesan, jumlahTiket, size + 1);
        if (back == null) {
            front = newNode;
            back = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
        size++;
        System.out.println("Pemesanan berhasil ditambahkan dengan nomor: " + newNode.nomorPemesanan);
    }

    // Method untuk menampilkan seluruh pemesanan dalam Queue
    public void display() {
        if (front == null) {
            System.out.println("Queue kosong");
            return;
        }
        Node current = front;
        System.out.println("Daftar Pemesanan:");
        while (current != null) {
            System.out.println("Nomor Pemesanan: " + current.nomorPemesanan + ", Nama Pemesan: " + current.namaPemesan
                    + ", Jumlah Tiket: " + current.jumlahTiket);
            current = current.next;
        }
    }

    // Method untuk menghapus pemesanan dari Queue
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue kosong");
            return;
        }
        Node temp = front;
        front = front.next;
        if (front == null) {
            back = null;
        }
        System.out.println("Pemesanan dengan nomor " + temp.nomorPemesanan + " telah dihapus");
        size--;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketQueue ticketQueue = new TicketQueue();

        while (true) {
            System.out.println("\nPilih operasi yang ingin Anda lakukan:");
            System.out.println("1. Tambah Pemesanan");
            System.out.println("2. Tampilkan Pemesanan");
            System.out.println("3. Hapus Pemesanan");
            System.out.println("4. Keluar");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pemesan: ");
                    String namaPemesan = scanner.nextLine();
                    System.out.print("Masukkan jumlah tiket: ");
                    int jumlahTiket = scanner.nextInt();
                    scanner.nextLine();
                    ticketQueue.enqueue(namaPemesan, jumlahTiket);
                    break;
                case 2:
                    ticketQueue.display();
                    break;
                case 3:
                    ticketQueue.dequeue();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}
