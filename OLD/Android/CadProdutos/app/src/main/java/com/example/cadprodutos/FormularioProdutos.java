package com.example.cadprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadprodutos.dao.ProdutosDAO;
import com.example.cadprodutos.model.Produtos;

public class FormularioProdutos extends AppCompatActivity {

    EditText editText_NomeProduto;
    EditText editText_Descricao_Produto;
    EditText editText_Quantidade;
    Button btn_Modificar;
    Produtos editarProduto, produto;
    ProdutosDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produtos);

        produto = new Produtos();
        dao = new ProdutosDAO(FormularioProdutos.this);


        Intent intent = getIntent();
        editarProduto = (Produtos) intent.getSerializableExtra("produto-escolhido");

        editText_NomeProduto = (EditText) findViewById(R.id.editText_NomeProduto);
        editText_Descricao_Produto = (EditText) findViewById(R.id.editText_Descricao_Produto);
        editText_Quantidade = (EditText) findViewById(R.id.editText_Quantidade);

        btn_Modificar = (Button) findViewById(R.id.btn_Modificar);

        if (editarProduto != null) {
            btn_Modificar.setText("Modificar");

        } else
            btn_Modificar.setText("Cadastrar");

        btn_Modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produto.setNomeProduto(editText_NomeProduto.getText().toString());
                produto.setDescricaoProduto(editText_Descricao_Produto.getText().toString());
                produto.setQuantidade(Integer.parseInt(editText_Quantidade.getText().toString()));

                if (btn_Modificar.getText().toString().equals("Cadastrar")) {
                    dao.salvarProduto(produto);
                    dao.close();

                } else {
                    dao.alterarProduto(produto);
                    dao.close();
                }

            }

        });
    }

}