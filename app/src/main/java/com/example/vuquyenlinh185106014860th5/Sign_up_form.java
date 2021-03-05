package com.example.vuquyenlinh185106014860th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_up_form extends AppCompatActivity {

    Button nut3,nut4;

    EditText u,p,pc;

    TextView lol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        nut3 = (Button) findViewById(R.id.btncre);
        nut4 = (Button) findViewById(R.id.btncancel);
        u = (EditText) findViewById(R.id.inputu1);
        p = (EditText) findViewById(R.id.inputp1);
        pc = (EditText) findViewById(R.id.inputc1);
        lol = (TextView) findViewById(R.id.lol);

        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(u.getText().toString())) {
                    u.setError("The item name cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(p.getText().toString())) {
                    p.setError("The item password cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(pc.getText().toString())) {
                    pc.setError("The item confirm password cannot be empty");
                    return;
                }
                if(!pc.getText().toString().equals(p.getText().toString())) {
                    pc.setError("The confirm password not match!");
                    return;
                }
                Toast.makeText(getApplicationContext(),"create successfull..",Toast.LENGTH_SHORT).show();
                finish();

//                if(!TextUtils.isEmpty(u.getText().toString()) && !TextUtils.isEmpty(p.getText().toString())  && !TextUtils.isEmpty(pc.getText().toString())){
//                    Toast.makeText(getApplicationContext(),"create successfull..",Toast.LENGTH_SHORT).show();
//
//                    lol.setText("right" + u.getText().toString() + p.getText().toString() + pc.getText().toString());
//                }else {
//                    Toast.makeText(getApplicationContext(),"create failed..",Toast.LENGTH_SHORT).show();
//                    lol.setText("wrong" + u.getText().toString() + p.getText().toString() + pc.getText().toString());
//                }
            }
        });

    }
}