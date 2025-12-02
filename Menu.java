import java.util.Scanner;

public class Menu {
    static int cariIndex(Patient[] data, int jumlah, String nama) {
        for (int i = 0; i < jumlah; i++) {
            if (data[i].nama.equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        Patient[] data = new Patient[100];
        int jumlahPasien = 0;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Screening COVID-19");
            System.out.println("=======================");
            System.out.println("1.Daftar Seluruh Pasien");
            System.out.println("2.Input Gejala");
            System.out.println("3.Edit Data");
            System.out.println("4.Hapus Data");
            System.out.println("5.Cari Berdasarkan Hasil");
            System.out.println("6.Keluar");
            System.out.print("Pilih : ");

            int pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan >= 1 && pilihan <= 7) {
                if (pilihan == 1) {
                    System.out.println();
                    System.out.println("+------+----------------------+----------------------+----------------------+----------------------+");
                    System.out.printf("| %-4s | %-20s | %-20s | %-20s | %-20s |\n", 
                    "No", "Nama", "Nomor Telp", "Alamat", "Email");
                    System.out.println("+------+----------------------+----------------------+----------------------+----------------------+");
                    if (jumlahPasien > 0) {
                        for (int i = 0; i < jumlahPasien; i++) {
                            System.out.printf("| %-4d | %-20s | %-20s | %-20s | %-20s |\n",
                            (i + 1),
                            data[i].nama,
                            data[i].notelp,
                            data[i].alamat,
                            data[i].email
                            );
                        }
                    } else {
                        String teks = "Data Kosong!";
                        int totalLebar = 6 + 22 + 22 + 22 + 22 + 5; 
                        System.out.printf("| %-96s |\n", 
                            String.format("%" + ((94 + teks.length()) / 2) + "s", teks)
                        );
                    }
                    System.out.println("+------+----------------------+----------------------+----------------------+----------------------+");
                } else if (pilihan == 2) {
                    Patient p = new Patient();
                    System.out.println();
                    System.out.println("Pendaftaran Pasien Baru");
                    System.out.println("=======================");
                    System.out.print("Nama: ");
                    p.nama = sc.nextLine();
                    System.out.print("Nomor Telp: ");
                    p.notelp = sc.nextLine();
                    System.out.print("Alamat: ");
                    p.alamat = sc.nextLine();
                    System.out.print("Email: ");
                    p.email = sc.nextLine();
                    data[jumlahPasien] = p;
                    jumlahPasien++;
                } else if (pilihan == 3) {
                    System.out.println();
                    System.out.println("Edit Data Pasien");
                    System.out.println("=======================");
                    System.out.print("Nama lengkap pasien: ");
                    String cariNama = sc.nextLine();
                    int idx = cariIndex(data, jumlahPasien, cariNama);
                    if (idx == -1) {
                        System.out.println("Pasien tidak ditemukan");
                    } else {
                        System.out.println("=======================");
                        System.out.println("Mau Edit Apa?");
                        System.out.println("1. Data Pasien");
                        System.out.println("2. Gejala");
                        System.out.println("3. Back");
                        System.out.println("=======================");
                        System.out.print("Pilih: ");
                        int editPilih = sc.nextInt();
                        if (editPilih == 1) {
                            
                        } else if (editPilih == 2) {
                            
                        } else if (editPilih == 3) {
                            continue;
                        } else {
                            System.out.println("Pilihan tidak sesuai!");
                        }
                    }
                } else if (pilihan == 4) {
                    System.out.println("\nHapus Data Pasien");
                    System.out.println("=======================");
                    System.out.print("Masukkan nama lengkap pasien: ");
                    String cariNama = sc.nextLine();

                    int idx = cariIndex(data, jumlahPasien, cariNama);

                    if (idx == -1) {
                        System.out.println("Pasien tidak ditemukan");
                    } else {

                        for (int i = idx; i < jumlahPasien - 1; i++) {
                            data[i] = data[i + 1];
                        }
                        jumlahPasien--;

                        System.out.println("Data berhasil dihapus");
                    }
                } else if (pilihan == 5) {
                    
                } else if (pilihan == 6) {
                    System.out.println("=======================");
                    System.out.println("Terimakasih!");
                    System.out.println("=======================");
                    System.exit(0);
                }
            } else {
                System.out.println();
                System.out.println("=======================");
                System.out.println("Pilih yang sesuai!");
                System.out.println("=======================");
            }
        } while (true);
    }
}
