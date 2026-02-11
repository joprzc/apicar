package com.example.appcar.ui.maintenance

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appcar.R

class AgendarMantenimientoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar_mantenimiento)

        // Recibir el id enviado desde Dashboard
        val tvInfo = findViewById<TextView?>(R.id.tvInfoVehiculo)
        if (tvInfo == null) {
            // Esto te confirma que el layout no tiene ese id
            android.util.Log.e("AGENDAR", "No existe tvInfoVehiculo en activity_agendar_mantenimiento.xml")
            return
        }
        tvInfo.text = "Agendar mantenimiento para vehículo ID: ${intent.getIntExtra("vehiculo_id", -1)}"
    }
}