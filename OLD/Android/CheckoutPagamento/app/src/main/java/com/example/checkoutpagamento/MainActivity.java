package com.example.checkoutpagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText edtValorCompra;
    private EditText edtValorPago;
    private TextView txtValorTroco;
    private TextView txtValorBrinde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtValorCompra = findViewById(R.id.edtValorTotal);
        edtValorPago = findViewById(R.id.edtValorPago);

        txtValorTroco = findViewById(R.id.valueTroco);
        txtValorBrinde = findViewById(R.id.valueBrinde);
    }

    public void finalizarCompra (View view){

        double valorCompra = Double.parseDouble(edtValorCompra.getText().toString());
        double valorPago = Double.parseDouble(edtValorPago.getText().toString());

        double valorTroco = valorPago - valorCompra;

        txtValorTroco.setText("R$:" + valorTroco);

        if(valorCompra >= 100){
            txtValorBrinde.setText("SIM");

         }else {
            txtValorBrinde.setText("NAO");

        }



    }

}