package com.example.simplegetrequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplegetrequest.databinding.PokemonCardBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val pokemon: JSONArray ): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = PokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(pokemon[position] as JSONObject)
    }

    override fun getItemCount(): Int = pokemon.length()

    class MainHolder (val binding: PokemonCardBinding): RecyclerView.ViewHolder(binding.root){
        fun render (pokemon: JSONObject){
            binding.TextPokemon.setText(pokemon.getString("name"))
        }
    }

}