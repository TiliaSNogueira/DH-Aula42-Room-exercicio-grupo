package com.e.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contato.view.*

class MainAdapter(val listContato: List<Contato>) :
    RecyclerView.Adapter<MainAdapter.ContatoViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ContatoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)
        return ContatoViewHolder(view)
    }


    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = listContato.get(position)

        holder.tvNome.text = contato.nome
        holder.tvTelefone.text = "Telefone: " + contato.telefone

    }

    override fun getItemCount() = listContato.size


    class ContatoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNome: TextView = view.tv_nome
        val tvTelefone: TextView = view.tv_telefone


    }
}
