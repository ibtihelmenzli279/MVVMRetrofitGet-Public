package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.PokemonApplication
import com.example.myapplication.data.PokemonRepository
import com.example.myapplication.model.Pokemon
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface PockUiState {
    data class Success(val pokemons: List<Pokemon>) : PockUiState
    object Error : PockUiState
    object Loading : PockUiState
}
class PokViewModel(private val pokemonRepository: PokemonRepository):ViewModel()  {
    /** The mutable State that stores the status of the most recent request */
    var pockUiState: PockUiState by mutableStateOf(PockUiState.Loading)
        private set

    /**
     */
    init {
        getAllPock()
    }
    fun getAllPock() {
        viewModelScope.launch {

            pockUiState = try {
                val listResult = pokemonRepository.getAllPokemon()
                PockUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                PockUiState.Error
            } catch (e: HttpException) {
                PockUiState.Error
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                PokViewModel(pokemonRepository = pokemonRepository)
            }
        }
    }
}