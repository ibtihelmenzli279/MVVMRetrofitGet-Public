package com.example.myapplication.data

import com.example.myapplication.model.Pokemon
import com.example.myapplication.network.ApiService

interface PokemonRepository {
    suspend fun  getAllPokemon():List<Pokemon>

}
class NetworkPokemonRepository(private val pokemonApiService: ApiService
):PokemonRepository{
    override suspend fun getAllPokemon(): List<Pokemon> {
        return pokemonApiService.getAllPokemon()
    }

}