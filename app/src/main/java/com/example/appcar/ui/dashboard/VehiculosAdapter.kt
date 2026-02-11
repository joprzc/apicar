package com.example.appcar.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcar.R
import com.example.appcar.data.models.VehiculoDto

class VehiculosAdapter(
    private val items: List<VehiculoDto>,
    private val onItemClick: (VehiculoDto) -> Unit
) : RecyclerView.Adapter<VehiculosAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_vehiculo, parent, false)
        return VH(v, onItemClick)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class VH(
        itemView: View,
        private val onItemClick: (VehiculoDto) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val tvPlaca: TextView = itemView.findViewById(R.id.tvPlaca)
        private val tvDetalle: TextView = itemView.findViewById(R.id.tvDetalle)

        fun bind(v: VehiculoDto) {
            tvPlaca.text = "${v.marca ?: ""} ${v.modelo ?: ""}".trim().ifBlank { "(sin marca/modelo)" }
            tvDetalle.text = "Año: ${v.anio ?: "-"} • Combustible: ${v.tipo_combustible ?: "-"}"

            itemView.setOnClickListener {
                onItemClick(v)
            }
        }
    }
}