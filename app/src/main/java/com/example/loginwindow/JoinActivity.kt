package com.example.loginwindow

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_join.idEdt
import kotlinx.android.synthetic.main.activity_login.*

private val JOIN_REQUEST_CODE = 100

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val idedt : EditText = findViewById(R.id.idEdt)
        val nameedt : EditText = findViewById(R.id.nameEdt)
        val psedt : EditText = findViewById(R.id.passEdt)
        val psckedt : EditText = findViewById(R.id.passChkEdt)
        val okbtn : Button = findViewById(R.id.okBtn)
        val cancelbtn : Button = findViewById(R.id.cancelBtn)

        val intent = Intent (this@JoinActivity, LoginActivity::class.java)

        okbtn.setOnClickListener {
            if (idedt.length() == 0) {
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (nameedt.length() == 0) {
                Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (psedt.length() == 0) {
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (psckedt.length() == 0) {
                Toast.makeText(this, "비밀번호확인을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (!psedt.text.toString().equals(psckedt.text.toString())) {
                Toast.makeText(this, "패스워드를 똑같이 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("ID", idEdt.text.toString())
                intent.putExtra("PW", pwEdt.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        cancelbtn.setOnClickListener {
            startActivity(intent)
        }
    }

}