package com.example.novo_app;

package com.example.myapplication

import android.os.Bundle
import android.support.7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.text = "Text"
        }
        }
