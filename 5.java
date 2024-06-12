package demo.tugas2;

import java.util.Scanner;

public class InventarisTokoBuku {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(new Book("123", "java", "taufiqurrahman"));
        bst.add(new Book("456", "Struktur Data", "yudhi"));
        bst.add(new Book("789", "Strukdat", "atmadja"));
        bst.add(new Book("321", "python", "taufiq"));
        bst.add(new Book("654", "sistem operasi", "alex"));
        bst.add(new Book("987", "RPL", "yudhii"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambahkan Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Tampilkan Semua Buku PreOrder | InOrder | PostOrder");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ISBN: ");
                    String isbn = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String title = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String author = scanner.nextLine();
                    bst.add(new Book(isbn, title, author));
                    break;
                case 2:
                    System.out.print("Masukkan ISBN yang dicari: ");
                    String searchIsbn = scanner.nextLine();
                    Book foundBook = bst.search(searchIsbn);
                    if (foundBook != null) {
                        System.out.println("Buku yang ditemukan: " + foundBook);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("PreOrder: ");
                    bst.traversePreOrder();

                    System.out.println("InOrder: ");
                    bst.traverseInOrder();

                    System.out.println("PostOrder: ");
                    bst.traversePostOrder();
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Opsi tidak valid");
                    break;
            }
        }
    }
}
