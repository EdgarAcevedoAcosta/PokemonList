package acevedo.edgar.pokedexlist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import acevedo.edgar.pokedexlist.model.domain.Pokemon

class PokemonViewModel: ViewModel(){
    var wildPokemon by mutableStateOf<Pokemon?>(null)
    fun capturarPokemon(){

    }
}