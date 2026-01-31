# Puddly - Tutorial Penggunaan

<div align="center">
<img width="256" height="256" alt="Application Icon" src="image/icon.png" />
</div>

## Persiapan Awal

### 1. Persyaratan Sistem
- Java Development Kit (JDK) terinstal
- MySQL Server terinstal

### 2. Setup Database 
1. Import file `database/stockwise2_db.sql` ke dalam database
3. Pastikan koneksi database sudah dikonfigurasi dengan benar (lihat `koneksiDatabase.java`)

### 3. Menjalankan Aplikasi
- **Via Batch File**: Jalankan `run.bat` (untuk Windows)
- **Via Terminal**: `javac -d bin -cp "lib/mysql-connector-j-9.5.0.jar" src/Puddly/*.java`
- Setelah proses build berhasil, jalankan aplikasi dengan perintah:
  `java -cp "bin;lib/mysql-connector-j-9.5.0.jar" Puddly.launch` 

## Panduan Penggunaan

### Menu Utama
1. Jalankan aplikasi
2. Akan muncul menu utama dengan pilihan:
   - **Insert**
   - **Update**
   - **Delete**
   - **View Data**

### Menambahkan Data (Insert)
1. Klik tombol **Insert** pada menu utama
2. Isi data pudding (nama, harga, dan data lainnya)
3. Klik **Insert** untuk menyimpan data ke database

### Mengubah Data (Update)
1. Klik tombol **Update** pada menu utama
2. Cari atau pilih data pudding dari tabel di sebelah kanan
3. Ubah data yang diperlukan pada form di sebelah kiri
4. Klik **Update** untuk menyimpan perubahan data

### Menghapus Data (Delete)
1. Klik tombol **Delete** pada menu utama
2. Pilih data pudding dari tabel
3. Klik **Delete** untuk menghapus data dari database

### Melihat Data (View Data)
1. Klik tombol **View Data** pada menu utama
2. Seluruh data pudding akan ditampilkan dalam tabel

## Database Structure

### Table `menu`
- `id` (INT): Unique pudding ID
- `nama` (VARCHAR): Pudding name
- `harga` (INT): Pudding price
- `stok` (INT): Stock quantity
- etc. (according to Pudding.java model)

## Troubleshooting

### Tidak Dapat Terhubung ke Database
- Pastikan MySQL Server sedang berjalan
- Periksa konfigurasi koneksi pada file `KoneksiDatabase.java`

### Aplikasi Tidak Dapat Dijalankan
- Pastikan Java Development Kit (JDK) sudah terinstal
- Pastikan seluruh file `.class` berhasil dikompilasi

## Dukungan
Jika terdapat pertanyaan atau kendala, silakan hubungi pengembang.

