package com.example.appcar.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcar.R
import com.example.appcar.data.models.VehiculoDto

class VehiculosAdapter(
    private val items: MutableList<VehiculoDto> = mutableListOf()
) : RecyclerView.Adapter<VehiculosAdapter.VH>() {

    fun submitList(newItems: List<VehiculoDto>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_vehiculo, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvPlaca: TextView = itemView.findViewById(R.id.tvPlaca)
        private val tvDetalle: TextView = itemView.findViewById(R.id.tvDetalle)

        fun bind(v: VehiculoDto) {
            tvPlaca.text = v.placa ?: "(sin placa)"
            tvDetalle.text = listOfNotNull(v.marca, v.modelo).joinToString(" / ").ifBlank { "(sin detalle)" }
        }
    }
}