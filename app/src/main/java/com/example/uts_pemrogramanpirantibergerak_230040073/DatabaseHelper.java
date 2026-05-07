package com.example.uts_pemrogramanpirantibergerak_230040073;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SiswaDB";
    private static final int DATABASE_VERSION = 2; // Incremented version to force upgrade

    private static final String TABLE_SISWA = "siswa";
    private static final String KEY_ID = "id";
    private static final String KEY_NIM = "nim";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_JURUSAN = "jurusan";
    private static final String KEY_NILAI = "nilai";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SISWA_TABLE = "CREATE TABLE " + TABLE_SISWA + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NIM + " TEXT,"
                + KEY_NAMA + " TEXT,"
                + KEY_JURUSAN + " TEXT,"
                + KEY_NILAI + " INTEGER" + ")";
        db.execSQL(CREATE_SISWA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SISWA);
        onCreate(db);
    }

    public long addSiswa(Siswa siswa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NIM, siswa.getNim());
        values.put(KEY_NAMA, siswa.getNama());
        values.put(KEY_JURUSAN, siswa.getJurusan());
        values.put(KEY_NILAI, siswa.getNilai());
        long id = db.insert(TABLE_SISWA, null, values);
        db.close();
        return id;
    }

    public List<Siswa> getAllSiswa() {
        List<Siswa> siswaList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_SISWA + " ORDER BY " + KEY_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Siswa siswa = new Siswa();
                siswa.setId(cursor.getInt(0));
                siswa.setNim(cursor.getString(1));
                siswa.setNama(cursor.getString(2));
                siswa.setJurusan(cursor.getString(3));
                siswa.setNilai(cursor.getInt(4));
                siswaList.add(siswa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return siswaList;
    }

    public int updateSiswa(Siswa siswa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NIM, siswa.getNim());
        values.put(KEY_NAMA, siswa.getNama());
        values.put(KEY_JURUSAN, siswa.getJurusan());
        values.put(KEY_NILAI, siswa.getNilai());
        return db.update(TABLE_SISWA, values, KEY_ID + " = ?",
                new String[]{String.valueOf(siswa.getId())});
    }

    public void deleteSiswa(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SISWA, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}
