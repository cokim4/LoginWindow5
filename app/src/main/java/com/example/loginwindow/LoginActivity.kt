package com.example.loginwindow

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.idEdt

private val JOIN_REQUEST_CODE = 100

class LoginActivity : AppCompatActivity() {

    val adminId = "admin"
    val adminPw = "1234admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener {
            var id = idEdt.text.toString()
            val pw = pwEdt.text.toString()

            if (id.equals("") || pw.equals("")) {
                Toast.makeText(this, "id 또는 pw 공백", Toast.LENGTH_SHORT).show()
            } else {

                //DB 접속하여 id와 pw맞는지 확인 필요
                //맞으면 return 값은 ok로, 틀리면 return 값을 no로

                if (id.equals(adminId) && pw.equals(adminPw)) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "id 또는 pw 오류", Toast.LENGTH_SHORT).show()
                }
            }
        }

        joinBtn.setOnClickListener {
            val intent = Intent(this@LoginActivity, JoinActivity::class.java)
            startActivityForResult(intent, JOIN_REQUEST_CODE)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == JOIN_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val id = data!!.getStringExtra("ID")
                val pw = data!!.getStringExtra("PW")
                idEdt.setText(id)
                pwEdt.setText(pw)
            }
        }
    }

}