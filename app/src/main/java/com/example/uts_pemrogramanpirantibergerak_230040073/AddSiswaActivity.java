package com.example.uts_pemrogramanpirantibergerak_230040073;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddSiswaActivity extends AppCompatActivity {

    private TextInputEditText etNim, etNama, etJurusan, etNilai;
    private MaterialButton btnSave;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_siswa);

        dbHelper = new DatabaseHelper(this);

        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etJurusan = findViewById(R.id.etJurusan);
        etNilai = findViewById(R.id.etNilai);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> saveSiswa());
    }

    private void saveSiswa() {
        String nim = etNim.getText().toString().trim();
        String nama = etNama.getText().toString().trim();
        String jurusan = etJurusan.getText().toString().trim();
        String nilaiStr = etNilai.getText().toString().trim();

        if (nim.isEmpty() || nama.isEmpty() || jurusan.isEmpty() || nilaiStr.isEmpty()) {
            Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show();
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(nilaiStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Nilai harus berupa angka", Toast.LENGTH_SHORT).show();
            return;
        }

        Siswa siswa = new Siswa(nim, nama, jurusan, nilai);
        long id = dbHelper.addSiswa(siswa);

        if (id > 0) {
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
        }
    }
}
