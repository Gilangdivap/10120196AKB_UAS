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
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText title_input, category_input, note_input;
    Button add_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        category_input = findViewById(R.id.category_input);
        note_input = findViewById(R.id.note_input);
        add_btn = findViewById(R.id.add_btn);


        Intent intent = new Intent(this, MainActivity.class);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDataBaseHelper myDb = new MyDataBaseHelper(AddActivity.this);
                myDb.addNote(title_input.getText().toString().trim(),
                        category_input.getText().toString().trim(),
                        note_input.getText().toString().trim());
                startActivity(intent);


            }
        });



    }
}