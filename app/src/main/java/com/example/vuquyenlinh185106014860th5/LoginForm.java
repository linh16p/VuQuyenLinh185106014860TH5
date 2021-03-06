package com.example.vuquyenlinh185106014860th5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class LoginForm extends AppCompatActivity {


    private static final String STATE = "Trang thai";
    public ArrayList<account> acc = new ArrayList<account>();
    Button nut1,nut2;
    EditText e1,e2;

    int counter = 10;
    TextView tv1,tvtry,tvlabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        Log.e(STATE,"onCreate");

        nut1 = (Button) findViewById(R.id.btnlogin);
        nut2 = (Button) findViewById(R.id.btncancel);
        e1 = (EditText) findViewById(R.id.inputu);
        e2 = (EditText) findViewById(R.id.inputp);
        tv1 =(TextView) findViewById(R.id.tvs);
        tvtry = (TextView) findViewById(R.id.indextry);
        tvlabel = (TextView) findViewById(R.id.labeltry);
        tvlabel.setVisibility(View.GONE);
        tvtry.setVisibility(View.GONE);
        // khoi tao gia tri mac dinh cho tai khoan
        acc.add(new account("demo","1"));
        //link to sign up form
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"sign up form is switching...",Toast.LENGTH_SHORT).show();

                // khoi tao gia tri kieu arraylist de gui du lieu sang form sign up
                Bundle bd = new Bundle();
                bd.putParcelableArrayList("uslist", acc);

                Intent su = new Intent(LoginForm.this,Sign_up_form.class);
                su.putExtras(bd);
                // request code de form sign up xac dinh doi tuong nhan du lieu
                int rq_code = 9;
                // chay activity chua du lieu tra ve gom: intent va request code
                startActivityForResult(su, rq_code);
            }
        });

        // button cancel
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //button login
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // duyet tai khoan
                boolean check=true;
                for(account a : acc){
                    // test 3
                    if(e1.getText().toString().equals(a.getUsername()) && e2.getText().toString().equals(a.getPassword())){
                        check = true; break;
                    }else check = false;
                }
                if(check == false){
                    Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_SHORT).show();
                    tvlabel.setVisibility(View.VISIBLE);
                    tvtry.setVisibility(View.VISIBLE);
                    tvtry.setBackgroundColor(Color.RED);
                    tvtry.setText(Integer.toString(counter));
                    counter--;
                    if(counter ==  0){
                        Toast.makeText(getApplicationContext(),"Wrong too much time",Toast.LENGTH_SHORT).show();
                        nut1.setEnabled(false);
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Login successfull...",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(LoginForm.this,Loginsuccess.class);
                    e1.setText("");
                    e2.setText("");
                    startActivity(i);
                }

            }
        });
    }
    @Override
    protected void onActivityResult(int req_code, int res_code, Intent done_ok){
        if(req_code == 9 && res_code == RESULT_OK){

            String nu = done_ok.getExtras().getString("newUser");

            String np = done_ok.getExtras().getString("newPass");
//            Toast.makeText(getApplicationContext(),nu,Toast.LENGTH_SHORT).show();
//            Toast.makeText(getApplicationContext(),np,Toast.LENGTH_SHORT).show();
            // nhan du lieu hop le va tien hanh tao tai khoan vao database
            acc.add(new account(nu,np));
            // mo nut login neu nhu tao tai khoan hop le :))))
            nut1.setEnabled(true);
            // auto focus vao edittext 1
            e1.requestFocus();
            // gan lai counter
            counter = 10;
            tvtry.setText(Integer.toString(counter));
            tvtry.setVisibility(View.GONE);
            tvlabel.setVisibility(View.GONE);
        }
    }

    // kiem thu vong doi cua cac activity
    @Override
    public void onPause(){
        super.onPause();

        Log.e(STATE, "onPause");
    }

    @Override
    public void onStop(){
        super.onPause();

        Log.e(STATE, "onStop");
    }

    @Override
    public void onResume(){
        super.onResume();

        Log.e(STATE, "onResume");
    }

    @Override
    public void onDestroy(){
        super.onPause();

        Log.e(STATE, "onDestroy");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        Log.e(STATE,"onRestoreInstanceState");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        Log.e(STATE,"onSaveInstanceState");
    }
}