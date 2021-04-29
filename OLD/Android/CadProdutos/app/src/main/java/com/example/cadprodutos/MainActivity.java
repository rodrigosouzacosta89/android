package com.example.cadprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.cadprodutos.dao.ProdutosDAO;
import com.example.cadprodutos.model.Produtos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ProdutosDAO dao;
    ArrayList<Produtos> listView_Produtos;
    Produtos produto;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listView_Produtos);


        Button btnCadastrar = (Button) findViewById(R.id.btn_Cadastrar);
        btnCadastrar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormularioProdutos.class);
                startActivity(intent);

            }
        });
    }

    protected  void onResume(){
        super.onResume();
        carregarProduto();
    }

    public void carregarProduto(){

        dao = new ProdutosDAO(MainActivity.this);
        listView_Produtos = dao.getLista();
        dao.close();

        if(listView_Produtos !=null){
            adapter = new ArrayAdapter<Produtos>(MainActivity.this,android.R.layout.simple_list_item_1,listView_Produtos);
            lista.setAdapter(adapter);
        }



    }
}