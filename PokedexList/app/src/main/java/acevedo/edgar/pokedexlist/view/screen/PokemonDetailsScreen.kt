package acevedo.edgar.pokedexlist.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import acevedo.edgar.pokedexlist.model.domain.Pokemon

@Composable
fun PokemonDetailsScreen(innerPadding: PaddingValues, pokemon: Pokemon){
    Column() {
        Text(pokemon.name)
        Image(painterResource(pokemon.image), contentDescription = "${pokemon.name} image")
    }
}