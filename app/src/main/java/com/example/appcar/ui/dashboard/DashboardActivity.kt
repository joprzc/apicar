package com.example.appcar.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcar.R
//import com.example.appcar.data.repository.VehiculosRepository
import com.example.appcar.data.repository.VehiculosRepository
import kotlinx.coroutines.launch

class DashboardActivity : AppCompatActivity() {

    private val repo = VehiculosRepository()
    private lateinit var adapter: VehiculosAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        android.util.Log.d("Dashboard", "DashboardActivity OPEN")
        android.widget.Toast.makeText(this, "Dashboard OPEN", android.widget.Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val rv = findViewById<RecyclerView>(R.id.rvVehiculos)
        adapter = VehiculosAdapter()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        cargarVehiculos()
    }

    private fun cargarVehiculos() {
        lifecycleScope.launch {
            try {
                val vehiculos = repo.getVehiculos()
                adapter.submitList(vehiculos)
                Toast.makeText(this@DashboardActivity, "Vehículos: ${vehiculos.size}", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("Dashboard", "Error cargando vehiculos", e)
                Toast.makeText(this@DashboardActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}