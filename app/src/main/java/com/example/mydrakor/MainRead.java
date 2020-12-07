package com.example.mydrakor;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseDrakor db;
    private List<Drakor> ListDrakor = new ArrayList<Drakor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new DatabaseDrakor(this);
        adapter_off = new CustomListAdapter(this, ListDrakor );
        mListView = (ListView) findViewById(R.id.list_drakor);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListDrakor.clear();
        List<Drakor> contacts = db.ReadDrakor();
        for (Drakor cn : contacts) {
            Drakor dataDrakor = new Drakor();
            dataDrakor.setmId(cn.getmId());
            dataDrakor.setmJudul(cn.getmJudul());
            dataDrakor.setmGenre(cn.getmGenre());
            dataDrakor.setmEpisode(cn.getmEpisode());
            ListDrakor.add(dataDrakor);
            if ((ListDrakor.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Drakor obj_itemDetails = (Drakor)o;
        String Sid = obj_itemDetails.getmId();
        String Sjudul = obj_itemDetails.getmJudul();
        String Sgenre = obj_itemDetails.getmGenre();
        String Sepisode = obj_itemDetails.getmEpisode();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijudul", Sjudul);
        goUpdel.putExtra("Igenre", Sgenre);
        goUpdel.putExtra("Iepisode", Sepisode);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListDrakor.clear();
        mListView.setAdapter(adapter_off);
        List<Drakor> contacts = db.ReadDrakor();
        for (Drakor cn : contacts) {
            Drakor dataDrama = new Drakor();
            dataDrama.setmId(cn.getmId());
            dataDrama.setmJudul(cn.getmJudul());
            dataDrama.setmGenre(cn.getmGenre());
            dataDrama.setmEpisode(cn.getmEpisode());
            ListDrakor.add(dataDrama);
            if ((ListDrakor.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
