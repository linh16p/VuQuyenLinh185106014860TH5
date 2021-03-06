package com.example.vuquyenlinh185106014860th5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sign_up_form extends AppCompatActivity {

    Button nut3,nut4;

    EditText u,p,pc;

    String u1,p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        nut3 = (Button) findViewById(R.id.btncre);
        nut4 = (Button) findViewById(R.id.btncancel);
        u = (EditText) findViewById(R.id.inputu1);
        p = (EditText) findViewById(R.id.inputp1);
        pc = (EditText) findViewById(R.id.inputc1);

        // khoi tao 1 doi tuong cua lop bundle de lay du lieu cua intent truoc
        Bundle bd = getIntent().getExtras();
        ArrayList<account> data = bd.getParcelableArrayList("uslist");

        // button cancel
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // button create
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check empty username edittext
                if(TextUtils.isEmpty(u.getText().toString())) {
                    u.setError("The item name cannot be empty");
                    return;
                }
                // check empty password edittext
                if(TextUtils.isEmpty(p.getText().toString())) {
                    p.setError("The item password cannot be empty");
                    return;
                }
                // check empty confirm password edittext
                if(TextUtils.isEmpty(pc.getText().toString())) {
                    pc.setError("The item confirm password cannot be empty");
                    return;
                }
                // check empty password ?== confirm password edittext
                if(!pc.getText().toString().equals(p.getText().toString())) {
                    pc.setError("The confirm password not match!");
                    return;
                }
                // duyet du lieu cua database gui sang
                boolean check=true;
                for(account a : data){
                    if(u.getText().toString().equals(a.getUsername())) {
                        check = false; break;
                    }
                }
                if(!check){
                    u.setError("username is trumcate!");
                }else{
                    // neu da match het cac thong tin thi tien hanh luu du lieu vao 2 bien u1 p1
                u1 = u.getText().toString();
                p1 = p.getText().toString();
                Toast.makeText(getApplicationContext(),"create successfull..",Toast.LENGTH_SHORT).show();
                finish();}

            }
        });

    }

    @Override
    public void finish(){
        if(!TextUtils.isEmpty(u1) && !TextUtils.isEmpty(p1)) {
            // khoi tao gia tri intent de tra du lieu ve
            Intent done_ok = new Intent();
            // dung phuong thuc putExtras de nap du lieu
            done_ok.putExtra("newUser",u1);
            done_ok.putExtra("newPass",p1);
            // gui cho ben nhan 1 request moi de xac nhan thong tin : REQUEST_OK
            // gia tri tra ve gom co : request label and data
            setResult(RESULT_OK,done_ok);
        }
        // goi lai ham cua lop base
        super.finish();
    }
}