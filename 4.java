package demo;

import java.util.HashMap;
import java.util.Scanner;

class dataPemilih {
    private HashMap<String, Integer> candidates = new HashMap<>();
    private HashMap<String, String> users = new HashMap<>();
    private HashMap<String, String[]> userDetails = new HashMap<>();
    private HashMap<String, String> userVotes = new HashMap<>();

    private Scanner scanner = new Scanner(System.in);

    public void addCandidate(String name) {
        candidates.put(name, 0);
    }

    public void vote() {
        do {
            System.out.print("Masukkan email Anda: ");
            String email = scanner.nextLine();

            if (userVotes.containsKey(email)) {
                System.out
                        .println(
                                "Anda sudah memberikan suara sebelumnya. Satu pengguna hanya bisa memilih satu kandidat.");
                return;
            }

            System.out.println("Pilih kandidat yang ingin Anda dukung:");
            for (String candidate : candidates.keySet()) {
                System.out.println(candidate);
            }

            System.out.print("Masukkan nama kandidat atau ketik 'selesai' untuk keluar: ");
            String kandidatName = scanner.nextLine();

            if (candidates.containsKey(kandidatName)) {
                int currentVotes = candidates.get(kandidatName);
                candidates.put(kandidatName, currentVotes + 1);
                System.out.println("Terima kasih, suara Anda telah direkam.");

                userVotes.put(email, kandidatName);
            } else if (kandidatName.equalsIgnoreCase("selesai")) {
                showResult();
            } else {
                System.out.println("Kandidat tidak valid.");
            }
        } while (true);

    }

    public void showResult() {
        System.out.println("Hasil voting : ");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate + " : " + candidates.get(candidate) + " suara");
        }
    }

    public void register() {
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIK: ");
        String nik = scanner.nextLine();

        if (email.endsWith("@gmail.com") && !users.containsKey(email) && !userDetails.containsValue(nik)) {
            users.put(email, password);
            userDetails.put(email, new String[] { name, nik });
            System.out.println("Berhasil Mendaftar");
            showOptions();
        } else {
            System.out.println("Gagal Login");
            showOptions();
        }
    }

    public void login() {
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (users.containsKey(email) && users.get(email).equals(password) && email.endsWith("@gmail.com")) {
            System.out.println("Login Berhasil");
            String[] userDetails = this.userDetails.get(email);
            System.out.println("Nama: " + userDetails[0]);
            System.out.println("NIK: " + userDetails[1]);
            vote();
        } else {
            System.out.println("Gagal Login");
            showOptions();
        }
    }

    public void showOptions() {
        System.out.println("pilihan");
        System.out.println("1. login");
        System.out.println("2. daftar");
        System.out.println("pilih menu : ");
        int pilih = scanner.nextInt();
        scanner.nextLine();

        switch (pilih) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            default:
                System.out.println("pilihan tidak tersedia");
                break;
        }

    }

}

public class Main {
    public static void main(String[] args) {

        dataPemilih pilih = new dataPemilih();

        pilih.addCandidate("Kandidat A");
        pilih.addCandidate("Kandidat B");
        pilih.addCandidate("Kandidat C");

        System.out.println("Selamat datang di sistem voting online");
        pilih.showOptions();
    }
}
