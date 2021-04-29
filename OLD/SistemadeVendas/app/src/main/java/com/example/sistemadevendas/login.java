package com.example.sistemadevendas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1,btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edt1 = findViewById(R.id.user);
        edt2 = findViewById(R.id.pass);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2) ;


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Login();
            }
        });
    }

    public void Login(){
        String  username = edt1.getText().toString();
        String password  = edt2.getText().toString();

        if (username.equals("")||password.equals("")) {
            Toast.makeText(this, "Favor digitar as informações corretas", Toast.LENGTH_LONG).show();
        }else if (username.equals("Arthur")&& password.equals("2019")){
            Intent i = new Intent(login.this, Main.class);
            startActivity(i);
        }else{
            Toast.makeText(this,"Usuario ou Senha Incorreto",Toast.LENGTH_LONG).show();
        }

    }

}