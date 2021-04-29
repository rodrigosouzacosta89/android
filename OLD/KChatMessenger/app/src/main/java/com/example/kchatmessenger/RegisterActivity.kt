package com.example.kchatmessenger

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.act_register.*
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private var mSelectedUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_register)


        btn_register.setOnClickListener {
            createUser()
        }

        btn_select_photo.setOnClickListener {
            selectPhoto()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            mSelectedUri = data?.data

            val bitmap = MediaStore.Images.Media.getBitmap(
                contentResolver,
                mSelectedUri
            )
            img_photo.setImageBitmap(bitmap)
            btn_select_photo.alpha = 0f


        }
    }


    private fun selectPhoto() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 0)
    }

    private fun createUser() {
        val email = edit_email.text.toString()
        val password = edit_password.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this,
                "email e senha devem ser informados",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.i("Teste", "UserID é ${it.result?.user?.uid}")

                    saveUserInFirebase()
                }
            }.addOnFailureListener {
                Log.e("Teste", it.message, it)
            }
    }

    private fun saveUserInFirebase() {
        val filename = UUID.randomUUID().toString() // 2
        val ref= FirebaseStorage.getInstance().getReference("/images/${filename}")

        mSelectedUri?.let { // 4
            ref.putFile(it) // 5
                .addOnSuccessListener { // 6
                    ref.downloadUrl.addOnSuccessListener {// 7
                        Log.i("Teste", it.toString())

           val url = it.toString()
           val name = edit_name.text.toString()
           val uid = FirebaseAuth.getInstance().uid!!

           val user = User(uid, name, url)

          FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                  Log.i("Teste", it.id)
             }
             .addOnFailureListener {
                 Log.e("Teste", it.message, it)
             }
       }
     }
  }
}