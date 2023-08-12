package com.example.a10120196akb_UAS;

/*
 *NIM : 10120196
 *Nama : Gilang Diva Prayoga
 *Kelas : IF-5
 *Email : gilang.10120196@mahasiswa.unikom.ac.id
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    Button profile_btn, note_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        profile_btn = findViewById(R.id.profile_btn);
        note_btn = findViewById(R.id.note_btn);

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        note_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}