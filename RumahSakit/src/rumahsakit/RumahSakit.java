/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rumahsakit;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String nama;
    private int umur;

    public Person(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }
}

class Dokter extends Person {
    private String spesialisasi;

    public Dokter(String nama, int umur, String spesialisasi) {
        super(nama, umur);
        this.spesialisasi = spesialisasi;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void meresepkanObat() {
        System.out.println("Meresepkan Obat...");
    }
}

class Perawat extends Person {
    private int tahunPengalamanKerja;

    public Perawat(String nama, int umur, int tahunPengalamanKerja) {
        super(nama, umur);
        this.tahunPengalamanKerja = tahunPengalamanKerja;
    }

    public int getTahunPengalamanKerja() {
        return tahunPengalamanKerja;
    }

    public void asistDokter() {
        System.out.println("Asisten dokter...");
    }
}

class Pasien extends Person {
    private String kondisi;

    public Pasien(String nama, int umur, String kondisi) {
        super(nama, umur);
        this.kondisi = kondisi;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void menerimaPerawatan() {
        System.out.println("Menerima Perawatan...");
    }
}

public class RumahSakit {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String choice ="";

        do {
            System.out.println("Masukkan tipe person (dokter/perawat/pasien):");
            String personType = scanner.nextLine();

            System.out.println("Masukkan nama:");
            String nama = scanner.nextLine();

            System.out.println("Masukkan umur:");
            int umur = scanner.nextInt();
            scanner.nextLine(); 

            if (personType.equalsIgnoreCase("dokter")) {
                System.out.println("Masukkan Spesialisasi dari Dokter:");
                String spesialisasi = scanner.nextLine();
                persons.add(new Dokter(nama, umur, spesialisasi));
            } else if (personType.equalsIgnoreCase("perawat")) {
                System.out.println("Masukkan Berapa Tahun Pengalaman dari Perawat:");
                int tahunPengalamanKerja = scanner.nextInt();
                scanner.nextLine(); 
                persons.add(new Perawat(nama, umur, tahunPengalamanKerja));
            } else if (personType.equalsIgnoreCase("pasien")) {
                System.out.println("Masukkan Kondisi Pasien:");
                String kondisi = scanner.nextLine();
                persons.add(new Pasien(nama, umur, kondisi));
            } else {
                System.out.println("Terjadi Kesalahan. Silakan Coba Lagi");
                continue;
            }

            System.out.println("Apakah kamu ingin menambahkan data baru? (yes/no)");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        scanner.close();

        for (Person person : persons) {
            System.out.println("Nama: " + person.getNama());
            System.out.println("Umur: " + person.getUmur());

            if (person instanceof Dokter) {
                Dokter dokter = (Dokter) person;
                System.out.println("Spesialisasi: " + dokter.getSpesialisasi());
                dokter.meresepkanObat();
            } else if (person instanceof Perawat) {
                Perawat perawat = (Perawat) person;
                System.out.println("Tahun Pengalaman: " + perawat.getTahunPengalamanKerja());
                perawat.asistDokter();
            } else if (person instanceof Pasien) {
                Pasien pasien = (Pasien) person;
                System.out.println("Kondisi: " + pasien.getKondisi());
                pasien.menerimaPerawatan();
            }

            System.out.println();
        }
    }
}
