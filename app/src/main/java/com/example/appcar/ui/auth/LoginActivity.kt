package com.example.appcar.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.appcar.R
import com.example.appcar.data.local.TokenStorage
import com.example.appcar.data.models.LoginRequest
import com.example.appcar.data.network.RetrofitClient
//import com.example.appcar.data.network.RetrofitClient
import com.example.appcar.data.repository.AuthRepository
import com.example.appcar.ui.dashboard.DashboardActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        lifecycleScope.launch {
            val token = RetrofitClient.api.login(
                LoginRequest(
                    username = "adminapi",
                    password = "admin2"
                )
            )
        val tokenStorage = TokenStorage(this@LoginActivity)

//            ApiClient.setAccessToken(token.access)
        }
    }



//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        val tokenStorage = TokenStorage(this)
//        val api = ApiClient.api.login(LoginRequest(username = "adminapi", password = "admin2"))
//        val authRepo = AuthRepository(api, tokenStorage)
//
//        val etUser = findViewById<EditText>(R.id.etUser)
//        val etPass = findViewById<EditText>(R.id.etPass)
//        val btnLogin = findViewById<Button>(R.id.btnLogin)
//
//        btnLogin.setOnClickListener {
//            val user = etUser.text.toString().trim()
//            val pass = etPass.text.toString().trim()
//
//            lifecycleScope.launch {
//                try {
//                    authRepo.login(user, pass)
//                    startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
//                    finish()
//                } catch (e: Exception) {
//                    Toast.makeText(this@LoginActivity, "Login falló: ${e.message}", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }
}