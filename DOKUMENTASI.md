# Dokumentasi Proyek: Aplikasi Manajemen Data Siswa (UTS)

Proyek ini adalah aplikasi Android native yang dikembangkan menggunakan Java untuk memenuhi persyaratan Ujian Tengah Semester (UTS) Pemrograman Piranti Bergerak. Aplikasi ini menyediakan fitur manajemen data siswa dengan penyimpanan lokal menggunakan SQLite.

## Fitur Utama
- **Sistem Login**: Keamanan dasar sebelum masuk ke aplikasi (Admin Access).
- **Manajemen Data (CRUD)**:
    - **Tambah Data**: Menginput NIM, Nama, Jurusan, dan Nilai.
    - **Tampil Data**: Menampilkan daftar siswa dalam bentuk kartu (CardView) menggunakan RecyclerView.
    - **Hapus Data**: Menghapus record siswa dari database lokal.
- **Penyimpanan SQLite**: Data tersimpan secara permanen di perangkat meskipun aplikasi ditutup.
- **Desain Modern (Sage Green)**: Antarmuka pengguna yang bersih, rapi, dan estetis dengan tema warna Hijau Sage.

## Detail Teknis
- **Bahasa**: Java
- **Penyimpanan**: SQLite Database
- **UI Components**: Material Components, RecyclerView, CardView, FloatingActionButton, TextInputLayout.
- **Min SDK**: 24
- **Target SDK**: 35

## Cara Penggunaan

### 1. Login
Saat aplikasi dijalankan, Anda akan diarahkan ke halaman login. Gunakan kredensial berikut:
- **Username**: `admin`
- **Password**: `admin`

### 2. Halaman Utama
Setelah login, Anda akan melihat daftar siswa. Jika data kosong, akan muncul pesan "Belum ada data siswa".

### 3. Menambah Data
Klik tombol **(+)** di pojok kanan bawah untuk membuka form input. Isi semua field (NIM, Nama, Jurusan, Nilai) dan klik **Simpan Data**.

### 4. Menghapus Data
Klik ikon **Sampah (Delete)** pada kartu siswa untuk menghapus data tersebut. Akan muncul konfirmasi sebelum data benar-benar dihapus.

## Struktur Folder Penting
- `app/src/main/java/com/example/uts_pemrogramanpirantibergerak_230040073/`
    - `MainActivity.java`: Logika halaman utama (Daftar Siswa).
    - `LoginActivity.java`: Logika autentikasi.
    - `AddSiswaActivity.java`: Logika form input data.
    - `DatabaseHelper.java`: Pengaturan dan query SQLite.
    - `Siswa.java`: Model data siswa.
    - `SiswaAdapter.java`: Penghubung data ke RecyclerView.
- `app/src/main/res/layout/`
    - `activity_main.xml`: Layout daftar siswa.
    - `activity_login.xml`: Layout halaman login.
    - `activity_add_siswa.xml`: Layout form input.
    - `list_item_siswa.xml`: Layout desain per baris data.

---
**Dikembangkan oleh:** [Nama Anda / NIM Anda]
**Mata Kuliah:** Pemrograman Piranti Bergerak
