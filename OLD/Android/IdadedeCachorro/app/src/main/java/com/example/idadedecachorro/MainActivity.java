package com.example.idadedecachorro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editIdade;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editIdade = findViewById(R.id.editIdade);
        textResultado = findViewById(R.id.textResultado);

    }


    public void calcularIdade (View view){

        int idade = Integer.parseInt(editIdade.getText().toString());

        int resultado = idade*7;

        textResultado.setText("Idade igual a: "+resultado);

    }
}