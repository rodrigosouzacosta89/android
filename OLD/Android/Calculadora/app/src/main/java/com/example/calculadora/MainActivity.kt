package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener{
            val calculator = Calculator() //instanciar um objeto
            val resultOfCalculator = calculator.sum(2,9) // função
            txt_response.text = "resultado é ${resultOfCalculator}" // retorno da função
        }
    }
}


class Calculator {


    var result = 0

    fun sum(x: Int, y: Int): Int{
        result = x * y
         return result
    }


}