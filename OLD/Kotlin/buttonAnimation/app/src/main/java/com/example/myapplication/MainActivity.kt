package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu, menu)
            return true
        }

        fun onOptionsItemSelected(item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.sobre -> {
                    Log.i("Teste", "Sobre clicado")
                }
            }
            return super.onOptionsItemSelected(item)
        }


        val lists = arrayOf("Sim", "Talvez", "Não conte com isso!", "teste")
        btn.setOnClickListener {
            val random = Random()
            val index = random.nextInt(4)
            txt_response.text = lists[index]
            Log.i("Teste", "O index é ${index}")
        }

        btn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.button_anim)
            btn.startAnimation(animation)
            val random = Random()
            val index = random.nextInt(3)
            Log.i("Teste", "O index é ${index}")
            txt_response.text = lists[index]
        }





    }
}