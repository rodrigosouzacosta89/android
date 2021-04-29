package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Categoria extends AppCompatActivity {

    EditText edt1,edt2;
    Button  btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);


        edt1 = findViewById(R.id.edtcat);
        edt2 = findViewById(R.id.edtdesc);

        btn1 = findViewById(R.id.btncadastrar);
        btn2 = findViewById(R.id.btncancelar);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Categoria.this, Main.class);
                startActivity(i);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             insert();
            }
        });
    }



    public void insert () {
        try {
            String categoria = edt1.getText().toString();
            String descricao = edt2.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS categoria1(id INTEGER PRIMARY KEY AUTOINCREMENT,categoria VARCHAR,catdesc VARCHAR)");

            String sql = "insert into categoria1 (categoria,catdesc)values (?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, categoria);
            statement.bindString(2, descricao);
            statement.execute();
            Toast.makeText(this, "Categoria adicionada com sucesso!", Toast.LENGTH_SHORT).show();
            edt1.setText("");
            edt2.setText("");
            edt1.requestFocus();
        }catch (Exception ex){
            Toast.makeText(this, "Categoria com erro!", Toast.LENGTH_SHORT).show();
        }
    }
}