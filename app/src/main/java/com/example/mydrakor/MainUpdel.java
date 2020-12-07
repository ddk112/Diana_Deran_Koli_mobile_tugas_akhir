package com.example.mydrakor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private DatabaseDrakor db;
    private String Sid,Sjudul, Sgenre, Sepisode;
    private EditText Ejudul, Egenre, Eepisode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new DatabaseDrakor(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Sgenre = i.getStringExtra("Igenre");
        Sepisode = i.getStringExtra("Iepisode");
        Ejudul = (EditText) findViewById(R.id.updel_judul);
        Egenre = (EditText) findViewById(R.id.updel_genre);
        Eepisode = (EditText) findViewById(R.id.updel_episode);
        Ejudul.setText(Sjudul);
        Egenre.setText(Sgenre);
        Eepisode.setText(Sepisode);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sgenre = String.valueOf(Egenre.getText());
                Sepisode = String.valueOf(Eepisode.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi judul drama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi genre drma",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Eepisode.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jumlah episode",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateDrakor(new Drakor(Sid, Sjudul, Sgenre, Sepisode));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteDrakor(new Drakor(Sid, Sjudul, Sgenre, Sepisode));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}