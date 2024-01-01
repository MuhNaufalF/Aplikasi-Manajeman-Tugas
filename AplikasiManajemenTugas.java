import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplikasiManajemenTugas {
    private List<Tugas> tugasList;
    private List<Pengingat> pengingatList;

    public AplikasiManajemenTugas() {
        tugasList = new ArrayList<>();
        pengingatList = new ArrayList<>();
    }

    public void tambahTugas(Tugas tugas) {
        tugasList.add(tugas);
    }

    public void hapusTugas(String id) {
        tugasList.removeIf(tugas -> tugas.getId().equals(id));
    }

    public void updateStatusTugas(String id, boolean status) {
        for (Tugas tugas : tugasList) {
            if (tugas.getId().equals(id)) {
                tugas.setStatus(status);
                break;
            }
        }
    }

    public void tambahPengingat(Pengingat pengingat) {
        pengingatList.add(pengingat);
    }

    public void hapusPengingat(String id) {
        pengingatList.removeIf(pengingat -> pengingat.getId().equals(id));
    }

    public void tampilkanDaftarTugas() {
        System.out.println("Daftar Tugas:");
        System.out.println(String.format("%-15s %-20s %-15s", "|ID|", "|Nama|", "|Status|"));

        StringBuilder tabel = new StringBuilder();
        for (Tugas tugas : tugasList) {
            tabel.append(String.format("%-15s %-20s %-15s", tugas.getId(), tugas.getNama(), (tugas.isStatus() ? "Selesai" : "Belum Selesai")) + "\n");
        }
        System.out.println(tabel.toString());
    }

    public void tampilkanDaftarPengingat() {
        System.out.println("Daftar Pengingat:");
        for (Pengingat pengingat : pengingatList) {
            System.out.println("ID: " + pengingat.getId() + ", Pesan: " + pengingat.getPesan());
        }
    }

    public static void main(String[] args) {
        AplikasiManajemenTugas app = new AplikasiManajemenTugas();
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        do {
            System.out.println("+================================+");
            System.out.println("|      Aplikasi Teman Tugas      |");
            System.out.println("+================================+");
            System.out.println("|           Pilih opsi:          |");
            System.out.println("+================================+");
            System.out.println("| 1. Tambah Tugas                |");
            System.out.println("| 2. Hapus Tugas                 |");
            System.out.println("| 3. Update Status Tugas         |");
            System.out.println("| 4. Tambah Pengingat            |");
            System.out.println("| 5. Hapus Pengingat             |");
            System.out.println("| 6. Tampilkan Daftar Tugas      |");
            System.out.println("| 7. Tampilkan Daftar Pengingat  |");
            System.out.println("| 8. Keluar                      |");
            System.out.println("+================================+");

            System.out.println("Masukan nomor pilihan : ");
            input = scanner.nextInt();
            scanner.nextLine(); // clear the buffer

            switch (input) {
                case 1:
                    System.out.print("Masukkan ID Tugas: ");
                    String idTugas = scanner.nextLine();
                    System.out.print("Masukkan Nama Tugas: ");
                    String namaTugas = scanner.nextLine();
                    app.tambahTugas(new Tugas(idTugas, namaTugas, false));
                    System.out.println("Tugas berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan ID Tugas yang akan dihapus: ");
                    String idHapusTugas = scanner.nextLine();
                    app.hapusTugas(idHapusTugas);
                    System.out.println("Tugas berhasil dihapus!");
                    break;
                case 3:
                    System.out.print("Masukkan ID Tugas yang akan diupdate statusnya: ");
                    String idUpdateStatus = scanner.nextLine();
                    System.out.print("Masukkan Status Baru (true/false): ");
                    boolean statusBaru = scanner.nextBoolean();
                    app.updateStatusTugas(idUpdateStatus, statusBaru);
                    System.out.println("Status tugas berhasil diupdate!");
                    break;
                case 4:
                    System.out.print("Masukkan ID Pengingat: ");
                    String idPengingat = scanner.nextLine();
                    System.out.print("Masukkan Pesan Pengingat: ");
                    String pesanPengingat = scanner.nextLine();
                    app.tambahPengingat(new Pengingat(idPengingat, pesanPengingat));
                    System.out.println("Pengingat berhasil ditambahkan!");
                    break;
                case 5:
                    System.out.print("Masukkan ID Pengingat yang akan dihapus: ");
                    String idHapusPengingat = scanner.nextLine();
                    app.hapusPengingat(idHapusPengingat);
                    System.out.println("Pengingat berhasil dihapus!");
                    break;
                case 6:
                    app.tampilkanDaftarTugas();
                    break;
                case 7:
                    app.tampilkanDaftarPengingat();
                    break;
                case 8:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Opsi tidak valid");
            }
        } while (input != 8);
        scanner.close();
    }
}