package com.example.sistemadevendas;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class fabricante extends AppCompatActivity {

    EditText edtfab,edtfabdesc;
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabricante);


        edtfab = findViewById(R.id.edtfab);
        edtfabdesc = findViewById(R.id.edtdescfab);

        btn1 = findViewById(R.id.btncadastrar);
        btn2 = findViewById(R.id.btncancelar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fabricante.this, Main.class);
                startActivity(i);
            }
        });

    }

        public void insert(){
            try {
                String fabricante = edtfab.getText().toString();
                String descfab = edtfabdesc.getText().toString();
                SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS fabricante(id INTEGER PRIMARY KEY AUTOINCREMENT,fabricante VARCHAR,descfab VARCHAR)");

                String sql = "insert into categoria1 (categoria,catdesc)values (?,?)";
                SQLiteStatement statement = db.compileStatement(sql);
                statement.bindString(1, fabricante);
                statement.bindString(2, descfab);
                statement.execute();
                Toast.makeText(this, "Fabricante adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                edtfab.setText("");
                edtfabdesc.setText("");
                edtfab.requestFocus();
            }catch (Exception ex){
                Toast.makeText(this, "Fabricante com erro!", Toast.LENGTH_SHORT).show();
            }
        }
    }