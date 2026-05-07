package com.example.uts_pemrogramanpirantibergerak_230040073;

public class Siswa {
    private int id;
    private String nim;
    private String nama;
    private String jurusan;
    private int nilai;

    public Siswa() {}

    public Siswa(int id, String nim, String nama, String jurusan, int nilai) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.nilai = nilai;
    }

    public Siswa(String nim, String nama, String jurusan, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.nilai = nilai;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }

    public int getNilai() { return nilai; }
    public void setNilai(int nilai) { this.nilai = nilai; }
}
