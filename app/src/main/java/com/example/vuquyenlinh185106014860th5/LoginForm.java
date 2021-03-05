package com.example.vuquyenlinh185106014860th5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginForm extends AppCompatActivity {

    private static final String STATE = "Trang thai";
    Button nut1,nut2;
    EditText e1,e2;

    int counter = 3;
    TextView tv1;
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

        //link to sign up form
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"sign up form is switching...",Toast.LENGTH_SHORT).show();
                Intent su = new Intent(LoginForm.this,Sign_up_form.class);

                startActivity(su);
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
                if(e1.getText().toString().equals("admin") && e2.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"Login successfull...",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(LoginForm.this,Loginsuccess.class);
                    e1.setText("");
                    e2.setText("");
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_SHORT).show();
                    counter--;
                    if(counter ==  0){
                        Toast.makeText(getApplicationContext(),"Wrong too much time",Toast.LENGTH_SHORT).show();
                        nut1.setEnabled(false);
                    }
                }
            }
        });
    }
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