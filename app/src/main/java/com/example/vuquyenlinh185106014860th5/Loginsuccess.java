package com.example.vuquyenlinh185106014860th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Loginsuccess extends AppCompatActivity {

    Button btd;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsuccess);

        btd = (Button)findViewById(R.id.btndone);
//        ed1 = (EditText) findViewById(R.id.inputu);
//        ed2 = (EditText) findViewById(R.id.inputp);
//        ed1.setText("");
//        ed2.setText("");

        btd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}