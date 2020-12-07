package com.example.mydrakor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDrakor extends SQLiteOpenHelper{
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_drakor";
    private static final String tb_drakor = "tb_drakor";
    private static final String tb_drakor_id = "id";
    private static final String tb_drakor_judul = "judul";
    private static final String tb_drakor_genre = "genre";
    private static final String tb_drakor_episode = "episode";
    private static final String CREATE_TABLE_DRAMA = "CREATE TABLE " +
            tb_drakor + "("
            + tb_drakor_id + " INTEGER PRIMARY KEY ,"
            + tb_drakor_judul + " TEXT,"
            + tb_drakor_genre + " TEXT,"
            + tb_drakor_episode + " TEXT " + ")";

    public DatabaseDrakor(Context context){
        super(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DRAMA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateDrakor (Drakor mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_drakor_id, mdNotif.getmId());
        values.put(tb_drakor_judul, mdNotif.getmJudul());
        values.put(tb_drakor_genre, mdNotif.getmGenre());
        values.put(tb_drakor_episode, mdNotif.getmEpisode());
        db.insert(tb_drakor, null, values);
        db.close();
    }

    public List<Drakor> ReadDrakor() {
        List<Drakor> judulModelList = new ArrayList<Drakor>();
        String selectQuery = "SELECT * FROM " + tb_drakor;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Drakor dataDrakor = new Drakor();
                dataDrakor.setmId(cursor.getString(0));
                dataDrakor.setmJudul(cursor.getString(1));
                dataDrakor.setmGenre(cursor.getString(2));
                dataDrakor.setmEpisode(cursor.getString(3));
                judulModelList.add(dataDrakor);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateDrakor (Drakor mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_drakor_judul, mdNotif.getmJudul());
        values.put(tb_drakor_genre, mdNotif.getmGenre());
        values.put(tb_drakor_episode, mdNotif.getmEpisode());
        return db.update(tb_drakor, values, tb_drakor_id + " = ?",
                new String[] { String.valueOf(mdNotif.getmId())});
    }
    public void DeleteDrakor (Drakor mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_drakor, tb_drakor_id+ " = ?",
                new String[]{String.valueOf(mdNotif.getmId())});
        db.close();
    }

}
