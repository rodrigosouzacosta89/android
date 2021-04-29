package com.example.kchatmessenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.act_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)


        btn_enter.setOnClickListener {
             signIn()
        }
      txt_account.setOnClickListener{
          val i = Intent(this, RegisterActivity::class.java)
          startActivity(i)
      }
    }
    private fun signIn() {
        val email = edit_email.text.toString()
        val password = edit_password.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this,
                "email e senha devem ser informados",
                Toast.LENGTH_LONG).show()
            return
        }
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful)
                    Log.i("Teste", it.result?.user?.uid)
            }
            .addOnFailureListener {
                Log.e("Teste", it.message, it)
            }
    }
}
