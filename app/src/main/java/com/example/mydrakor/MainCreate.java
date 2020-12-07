package com.example.mydrakor;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private DatabaseDrakor db;
    private EditText Ejudul, Egenre, Eepisode;
    private String Sjudul, Sgenre, Sepisode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new DatabaseDrakor(this);
        Ejudul = (EditText) findViewById(R.id.create_judul);
        Egenre = (EditText) findViewById(R.id.create_genre);
        Eepisode = (EditText) findViewById(R.id.create_episode);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sgenre = String.valueOf(Egenre.getText());
                Sepisode = String.valueOf(Eepisode.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan judul drama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi genre drama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sepisode.equals("")){
                    Eepisode.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jumlah episode",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Ejudul.setText("");
                    Egenre.setText("");
                    Eepisode.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateDrakor(new Drakor(null, Sjudul, Sgenre, Sepisode));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
