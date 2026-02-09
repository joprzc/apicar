package com.example.appcar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appcar.ui.dashboard.DashboardActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // MainActivity solo actúa como launcher.
        // Evita setContentView(R.layout.item_vehiculo) (eso es un layout de fila, no una pantalla).
        // Abre directamente el dashboard donde está el RecyclerView.
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }
}