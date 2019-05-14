package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsertNote, btnShowList;
    EditText edtNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertNote = findViewById(R.id.buttonInsertNote);
        edtNote = findViewById(R.id.editTextNote);
        btnShowList = findViewById(R.id.buttonShowList);

        btnInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = findViewById(R.id.radioGroupStars);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);

                DBHelper db = new DBHelper(MainActivity.this);

                db.insertNote(edtNote.getText().toString(), Integer.parseInt(rb.getText().toString()));
                db.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
