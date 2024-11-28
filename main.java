
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class revPjakhir {

    public static long hitungGaji(long jamKerja, long tarifPerJam) {
        long gaji;

        if (jamKerja <= 40) {
            gaji = jamKerja * tarifPerJam;
        } else {
            long jamLembur = jamKerja - 40;
            gaji = (40 * tarifPerJam) + (long) (jamLembur * tarifPerJam * 1.5);
        }
        return gaji;
    }

    public static long hitungPajak(long gaji) {
        double pajak = 0;

        if (gaji <= 60000000) {
            pajak = gaji * 0.05;
        } else if (gaji <= 250000000) {
            pajak = gaji * 0.15;
        } else if (gaji <= 500000000) {
            pajak = gaji * 0.25;
        } else if (gaji <= 5000000000L) {
            pajak = gaji * 0.30;
        } else {
            pajak = gaji * 0.35;
        }
        return gaji - (long) pajak;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        String tanggalwaktu = now.format(formatter);

        System.out.print("Masukkan jumlah karyawan: ");
        int jumlahKaryawan = input.nextInt();
        input.nextLine();

        String[] namaKaryawan = new String[jumlahKaryawan];
        long[] jamKerjaKaryawan = new long[jumlahKaryawan];
        long[] tarifPerJamKaryawan = new long[jumlahKaryawan];
        long[] gajiKaryawan = new long[jumlahKaryawan];
        String[] jabatan = new String[jumlahKaryawan];
        long[] gajiBersih = new long[jumlahKaryawan];

        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.println("\nData Karyawan " + (i + 1) + ":");
            System.out.print("Nama: ");
            namaKaryawan[i] = input.nextLine();
            System.out.print("Jabatan: ");
            jabatan[i] = input.nextLine();
            System.out.print("Jam kerja: ");
            jamKerjaKaryawan[i] = input.nextLong();
            System.out.print("Tarif per jam: ");
            tarifPerJamKaryawan[i] = input.nextLong();
            input.nextLine();

            gajiKaryawan[i] = hitungGaji(jamKerjaKaryawan[i], tarifPerJamKaryawan[i]);
            gajiBersih[i] = hitungPajak(gajiKaryawan[i]);
        }

        System.out.println("\n=== Laporan Gaji Karyawan ===");
        System.out.println(tanggalwaktu);
        System.out.println("----------------------------");
        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.printf("Nama: %s\n", namaKaryawan[i]);
            System.out.printf("Jabatan: %s\n", jabatan[i]);
            System.out.printf("Jam Kerja: %d jam\n", jamKerjaKaryawan[i]);
            System.out.printf("Tarif per Jam: Rp %,d\n", tarifPerJamKaryawan[i]);
            System.out.printf("Gaji Sebelum Pajak: Rp %,d\n", gajiKaryawan[i]);
            System.out.printf("Gaji Bersih: Rp %,d\n", gajiBersih[i]);
            System.out.println("----------------------------");
        }
        System.out.println("Apakah ada data yang salah? (y/n)");
        String valid = input.nextLine();
        if(valid.equalsIgnoreCase("y")){
            System.out.println("Data karyawan berapa yang ingin anda ubah?");
            int dataUbah = input.nextInt();
            int i = dataUbah - 1;
            System.out.printf("Nama: %s\n", namaKaryawan[i]);
            System.out.printf("Jabatan: %s\n", jabatan[i]);
            System.out.printf("Jam Kerja: %d jam\n", jamKerjaKaryawan[i]);
            System.out.printf("Tarif per Jam: Rp %,d\n", tarifPerJamKaryawan[i]);
            System.out.printf("Gaji Sebelum Pajak: Rp %,d\n", gajiKaryawan[i]);
            System.out.printf("Gaji Bersih: Rp %,d\n", gajiBersih[i]);
            System.out.println("Apakah anda ingin mengubah data karyawan ini? (y/n)");
            String val2 = input.next();
            if(val2.equalsIgnoreCase("y")){
                System.out.println("Masukan data yang baru: ");
                input.nextLine();
                System.out.print("Nama: ");
                namaKaryawan[i] = input.nextLine();
                System.out.print("Jabatan: ");
                jabatan[i] = input.nextLine();
                System.out.print("Jam kerja: ");
                jamKerjaKaryawan[i] = input.nextLong();
                System.out.print("Tarif per jam: ");
                tarifPerJamKaryawan[i] = input.nextLong();


                System.out.println("Data yang sudah diperbarui: ");
                System.out.println("");
                System.out.println("");


                System.out.println("\n=== Laporan Gaji Karyawan ===");
                System.out.println(tanggalwaktu);
                System.out.println("----------------------------");
                for (int j = 0; j < jumlahKaryawan; j++) {
                    System.out.printf("Nama: %s\n", namaKaryawan[j]);
                    System.out.printf("Jabatan: %s\n", jabatan[j]);
                    System.out.printf("Jam Kerja: %d jam\n", jamKerjaKaryawan[j]);
                    System.out.printf("Tarif per Jam: Rp %,d\n", tarifPerJamKaryawan[j]);
                    System.out.printf("Gaji Sebelum Pajak: Rp %,d\n", gajiKaryawan[j]);
                    System.out.printf("Gaji Bersih: Rp %,d\n", gajiBersih[j]);
                    System.out.println("----------------------------");
            }
        } else{
            System.out.println("Terima kasih, Semoga harimu menyenangkan");
        }
    } else{ System.out.println("Terima kasih, Semoga harimu menyenangkan");}
    input.close();
}
}
