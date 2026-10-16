package acevedo.edgar.pokedexlist.viewmodel

import acevedo.edgar.pokedexlist.model.data.pokemonList
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import acevedo.edgar.pokedexlist.model.domain.Pokemon

class PokemonViewModel: ViewModel(){
    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set
    var capturedPokemon by mutableStateOf(listOf<Pokemon?>(null))
        private set
    var gonePokemon by mutableStateOf(false)
        private set

    var isPokemonCaptured by mutableStateOf(false)
        private set

    fun searchPokemon(){
        wildPokemon= pokemonList.random()
        isPokemonCaptured=false
    }
    fun capturarPokemon(){
        wildPokemon?.let {
            var isCapturated=(1..2).random()
            if(isCapturated==1){
                capturedPokemon=capturedPokemon+it
                gonePokemon=false
                wildPokemon=null
                isPokemonCaptured=true
            }else{
                gonePokemon=true
                wildPokemon=null
                isPokemonCaptured=false
            }
        }
    }
}