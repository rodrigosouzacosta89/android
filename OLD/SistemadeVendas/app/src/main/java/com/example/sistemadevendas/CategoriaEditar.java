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

public class CategoriaEditar extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn1, btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoriaeditar);

        edt1 = findViewById(R.id.catid);
        edt2 = findViewById(R.id.edtcat);
        edt3 = findViewById(R.id.edtdesc);


        btn1 = findViewById(R.id.btneditar);
        btn2 = findViewById(R.id.btndelete) ;
        btn3 = findViewById(R.id.btncancelar);


        Intent i = getIntent();

        String id = i.getStringExtra("id").toString();
        String categoria = i.getStringExtra("categoria").toString();
        String descricao = i.getStringExtra("catdesc").toString();


        edt1.setText(id);
        edt2.setText(categoria);
        edt3.setText(descricao);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editar();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Deletar();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent((getApplicationContext()), Main.class);
                startActivity(i);

            }
        });

    }

     public void Editar() {
      try
      {
        String catid = edt1.getText().toString();
        String categorianome = edt2.getText().toString();
        String catdescricao = edt3.getText().toString();

        SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
        String sql = "update categoria1 set categoria  = ?, catdesc =? where id=?;" ;

        SQLiteStatement statement = db.compileStatement(sql);
        statement.bindString(1, catid);
        statement.bindString(2, categorianome);
        statement.bindString(3, catdescricao);
        statement.execute();
        Toast.makeText(this, "Categoria atualizada com sucesso!", Toast.LENGTH_SHORT).show();

        Intent i = new Intent((getApplicationContext()), Main.class);
        startActivity(i);

    }catch (Exception ex){
        Toast.makeText(this, "Categoria com erro!", Toast.LENGTH_SHORT).show();
    }
    }

    public void Deletar() {
        try
        {
            String catid = edt1.getText().toString();


            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
            String sql = "delete from categoria1 where id=?;" ;

            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, catid);
            statement.execute();
            Toast.makeText(this, "Categoria deletada com sucesso!", Toast.LENGTH_SHORT).show();

            Intent i = new Intent((getApplicationContext()), Main.class);
            startActivity(i);

        }catch (Exception ex){
            Toast.makeText(this, "Categoria com erro!", Toast.LENGTH_SHORT).show();
        }
    }

}