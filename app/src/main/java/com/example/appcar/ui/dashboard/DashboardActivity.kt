package com.example.appcar.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcar.R
import com.example.appcar.data.repository.VehiculosRepository
import com.example.appcar.ui.maintenance.AgendarMantenimientoActivity
import kotlinx.coroutines.launch

class DashboardActivity : AppCompatActivity() {

    private val repo = VehiculosRepository()
    private lateinit var rv: RecyclerView
    private lateinit var adapter: VehiculosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("Dashboard", "DashboardActivity OPEN")
        Toast.makeText(this, "Dashboard OPEN", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        rv = findViewById(R.id.rvVehiculos)
        rv.layoutManager = LinearLayoutManager(this)

        cargarVehiculos()
    }

    private fun cargarVehiculos() {
        lifecycleScope.launch {
            try {
                val vehiculos = repo.getVehiculos()

//                logs para vefiricar que se llenan datos
                Log.d("API", "vehiculos.size=${vehiculos.size}")
                if (vehiculos.isNotEmpty()) {
                    Log.d("API", "primero=${vehiculos[0]}")
                }

                // Crea el adapter con los parámetros que exige: items + onItemClick
                adapter = VehiculosAdapter(
                    items = vehiculos.toMutableList(),
                    onItemClick = { vehiculo ->
                        // TODO: aquí luego abres pantalla de agendar mantenimiento
                        Toast.makeText(
                            this@DashboardActivity,
                            "Click: ${vehiculo.marca} ${vehiculo.modelo}",
                            Toast.LENGTH_SHORT
                        ).show()



//                         Ejemplo cuando ya tengas AgendarMantenimientoActivity:
                         val i = Intent(this@DashboardActivity, AgendarMantenimientoActivity::class.java)
                         i.putExtra("vehiculo_id", vehiculo.id ?: -1)
                         startActivity(i)
                    }
                )

                rv.adapter = adapter
                Toast.makeText(this@DashboardActivity, "Vehículos: ${vehiculos.size}", Toast.LENGTH_SHORT).show()

            } catch (e: Exception) {
                Log.e("Dashboard", "Error cargando vehiculos", e)
                Toast.makeText(this@DashboardActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}