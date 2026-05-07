package com.example.uts_pemrogramanpirantibergerak_230040073;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SiswaAdapter.OnItemClickListener {

    private RecyclerView rvSiswa;
    private SiswaAdapter adapter;
    private DatabaseHelper dbHelper;
    private List<Siswa> siswaList = new ArrayList<>();
    private TextView tvEmpty;
    private static final int REQUEST_CODE_ADD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        
        rvSiswa = findViewById(R.id.rvSiswa);
        tvEmpty = findViewById(R.id.tvEmpty);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        rvSiswa.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SiswaAdapter(siswaList, this);
        rvSiswa.setAdapter(adapter);

        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddSiswaActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD);
        });

        loadData();
    }

    private void loadData() {
        siswaList = dbHelper.getAllSiswa();
        if (siswaList.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            rvSiswa.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            rvSiswa.setVisibility(View.VISIBLE);
        }
        adapter.updateList(siswaList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {
            loadData();
        }
    }

    @Override
    public void onDeleteClick(Siswa siswa) {
        new AlertDialog.Builder(this)
                .setTitle("Hapus Data")
                .setMessage("Apakah Anda yakin ingin menghapus data " + siswa.getNama() + "?")
                .setPositiveButton("Ya", (dialog, which) -> {
                    dbHelper.deleteSiswa(siswa.getId());
                    Toast.makeText(this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                    loadData();
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

    @Override
    public void onItemClick(Siswa siswa) {
        // Option to edit could be added here
        Toast.makeText(this, "Siswa: " + siswa.getNama(), Toast.LENGTH_SHORT).show();
    }
}