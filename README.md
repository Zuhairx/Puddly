# Pudding Data Management System V 1.0 - Tutorial Penggunaan

<div align="center">
<img width="256" height="256" alt="iconAplikasi" src="image/iconLogo.png" />
</div>

## Persiapan Awal

### 1. Persyaratan Sistem
- Java Development Kit (JDK) terinstall
- MySQL Server terinstall

### 2. Setup Database
1. Buat database baru di MySQL
2. Import file `Database/Pudding_database.sql` ke dalam database tersebut
3. Pastikan koneksi database sudah dikonfigurasi dengan benar (lihat `KoneksiDatabase.java`)

### 3. Menjalankan Aplikasi
- **Via Batch File**: Jalankan `run.bat` (untuk Windows) - ini akan mengkompilasi dan menjalankan aplikasi secara otomatis.
- **Via Terminal**:
  - Jalankan perintah berikut untuk membangun proyek:
    ```bash
    javac -d bin -cp "lib/mysql-connector-j-9.5.0.jar" src/PTPudding/*.java
    ```
  - Setelah berhasil dibangun, jalankan program dengan perintah:
    ```bash
    java -cp "bin;lib/mysql-connector-j-9.5.0.jar" PTPudding.launch
    ```

## Panduan Penggunaan

### Main Menu
1. Jalankan aplikasi
2. Anda akan melihat menu utama dengan opsi: Insert, Update, Delete, View Data

### Insert Data
1. Klik "Insert" di menu utama
2. Isi data pudding (nama, harga, dll.)
3. Klik "Insert" untuk menyimpan

### Update Data
1. Klik "Update" di menu utama
2. Pilih data pudding dari tabel
3. Ubah data yang diperlukan
4. Klik "Update"

### Delete Data
1. Klik "Delete" di menu utama
2. Pilih data pudding dari tabel
3. Klik "Delete"

### View Data
1. Klik "View Data" di menu utama
2. Lihat semua data pudding dalam tabel

## Struktur Database

### Tabel `menu`
- `id` (INT): ID unik pudding
- `nama` (VARCHAR): Nama pudding
- `harga` (INT): Harga pudding
- `stok` (INT): Jumlah stok
- dll. (sesuai model Pudding.java)

## Troubleshooting

### Tidak Bisa Koneksi Database
- Pastikan MySQL server sedang berjalan
- Periksa konfigurasi di `KoneksiDatabase.java`

### Aplikasi Tidak Bisa Dijalankan
- Pastikan JDK terinstall
- Pastikan semua file .class sudah dikompilasi

## Dukungan
Untuk pertanyaan atau masalah, hubungi developer.
