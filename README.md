# Petunjuk Penggunaan Program

## Deskripsi
Program ini adalah aplikasi GUI yang dibuat menggunakan Java. Aplikasi ini terhubung dengan database untuk mengelola data.

## Langkah-langkah Menjalankan Program

1. **Persyaratan Sistem**
   - Pastikan Anda memiliki Java Development Kit (JDK) terinstal di sistem Anda.
   - Pastikan Anda memiliki MySQL Connector/J untuk koneksi database.

2. **Mengunduh dan Menyiapkan Proyek**
   - Unduh atau kloning repositori proyek ini ke dalam folder lokal Anda.
   - Pastikan struktur folder sesuai dengan yang ada di repositori.

3. **Menyiapkan Database**
   - Buka MySQL dan buat database baru.
   - Impor file `datamenupudding.sql` ke dalam database yang telah Anda buat.

4. **Menjalankan Program**
   - Buka terminal dan navigasikan ke direktori proyek.
   - Jalankan perintah berikut untuk membangun proyek:
     ```bash
     javac -d bin -cp "lib/mysql-connector-j-9.5.0.jar" src/PTPudding/*.java
     ```
   - Setelah berhasil dibangun, jalankan program dengan perintah:
     ```bash
     java -cp "bin;lib/mysql-connector-j-9.5.0.jar" PTPudding.GUI
     ```

5. **Menggunakan Aplikasi**
   - Setelah aplikasi berjalan, Anda dapat mulai menggunakan antarmuka untuk mengelola data.
