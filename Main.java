package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String[]> festivalList = new ArrayList<>();
        festivalList.add(new String[]{"Festival Danau Toba", "Sumatera Utara", "25 November 2025"});
        festivalList.add(new String[]{"Festival Tabuik Pariaman", "Sumatera Barat", "15 Agustus 2025"});
        festivalList.add(new String[]{"Festival Karapan Sapi", "Madura", "10 Oktober 2025"});
        festivalList.add(new String[]{"Festival Bali Arts", "Bali", "20 Juni 2025"});

        int pilihan;

        do {
            System.out.println("\n=== Manajemen Daftar Festival Budaya ===");
            System.out.println("1. Tambah Festival");
            System.out.println("2. Lihat Daftar Festival");
            System.out.println("3. Ubah Festival");
            System.out.println("4. Hapus Festival");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama festival: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan asal festival: ");
                    String asal = input.nextLine();
                    System.out.print("Masukkan tanggal festival: ");
                    String tanggal = input.nextLine();
                    festivalList.add(new String[]{nama, asal, tanggal});
                    System.out.println("Festival berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n------------------------------ Daftar Festival Budaya ------------------------------");
                    if (festivalList.isEmpty()) {
                        System.out.println("Belum ada festival yang terdaftar.");
                    } else {
                        System.out.printf("%-5s | %-30s | %-20s | %-20s%n", "No", "Nama Festival", "Asal", "Tanggal Pelaksanaan");
                        System.out.println("------------------------------------------------------------------------------------");
                        for (int i = 0; i < festivalList.size(); i++) {
                            String[] fest = festivalList.get(i);
                            System.out.printf("%-5d | %-30s | %-20s | %-20s%n", (i + 1), fest[0], fest[1], fest[2]);
                        }
                    }
                    break;

                case 3:
                    if (festivalList.isEmpty()) {
                        System.out.println("Daftar masih kosong!");
                    } else {
                        System.out.println("Pilih nomor festival yang ingin diubah:");
                        for (int i = 0; i < festivalList.size(); i++) {
                            String[] fest = festivalList.get(i);
                            System.out.printf("%-5d | %-30s | %-20s | %-20s%n", (i + 1), fest[0], fest[1], fest[2]);
                        }
                        System.out.print("Nomor festival yang ingin diubah: ");
                        int indexUbah = input.nextInt();
                        input.nextLine();

                        if (indexUbah > 0 && indexUbah <= festivalList.size()) {
                            System.out.print("Masukkan nama festival baru: ");
                            String namaBaru = input.nextLine();
                            System.out.print("Masukkan asal festival baru: ");
                            String asalBaru = input.nextLine();
                            System.out.print("Masukkan tanggal festival baru: ");
                            String tanggalBaru = input.nextLine();
                            festivalList.set(indexUbah - 1, new String[]{namaBaru, asalBaru, tanggalBaru});
                            System.out.println("Festival berhasil diubah!");
                        } else {
                            System.out.println("Nomor tidak valid!");
                        }
                    }
                    break;

                case 4:
                    if (festivalList.isEmpty()) {
                        System.out.println("Daftar masih kosong!");
                    } else {
                        System.out.println("\n------------------------------ Daftar Festival Budaya ------------------------------");
                        System.out.printf("%-5s | %-30s | %-20s | %-20s%n", "No", "Nama Festival", "Asal", "Tanggal Pelaksanaan");
                        System.out.println("------------------------------------------------------------------------------------");
                        for (int i = 0; i < festivalList.size(); i++) {
                            String[] fest = festivalList.get(i);
                            System.out.printf("%-5d | %-30s | %-20s | %-20s%n", (i + 1), fest[0], fest[1], fest[2]);
                        }

                        System.out.print("Nomor festival yang ingin dihapus: ");
                        int indexHapus = input.nextInt();
                        input.nextLine();

                        if (indexHapus > 0 && indexHapus <= festivalList.size()) {
                            String[] festHapus = festivalList.get(indexHapus - 1);
                            System.out.println("Festival \"" + festHapus[0] + "\" berhasil dihapus!");
                            festivalList.remove(indexHapus - 1);

                            // 🔄 tampilkan ulang daftar setelah dihapus
                            System.out.println("\n------------------------------ Daftar Festival Budaya ------------------------------");
                            if (festivalList.isEmpty()) {
                                System.out.println("Tidak ada festival yang tersisa.");
                            } else {
                                System.out.printf("%-5s | %-30s | %-20s | %-20s%n", "No", "Nama Festival", "Asal", "Tanggal Pelaksanaan");
                                System.out.println("------------------------------------------------------------------------------------");
                                for (int i = 0; i < festivalList.size(); i++) {
                                    String[] fest = festivalList.get(i);
                                    System.out.printf("%-5d | %-30s | %-20s | %-20s%n", (i + 1), fest[0], fest[1], fest[2]);
                                }
                            }
                        } else {
                            System.out.println("Nomor tidak valid!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih! Program telah selesai ^-^");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);

        input.close();
    }
}
