package acevedo.edgar.pokedexlist.components

import acevedo.edgar.pokedexlist.domain.Pokemon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun pokemonRow(pokemon: Pokemon){
    Row(Modifier.fillMaxWidth(),horizontalArrangement= Arrangement.SpaceBetween){
        Image(painterResource(pokemon.image), contentDescription = "${pokemon.nama} image",
            Modifier.width(50.dp).padding(10.dp))

        Column(){
            Text(pokemon.nama)
            Text(pokemon.description,
                fontSize=10.sp)
            Row(Modifier.fillMaxWidth(0.60f),horizontalArrangement= Arrangement.SpaceBetween) {
                Text("Height: ${pokemon.height}")
                Text("Weight: ${pokemon.weight}")
            }
        }
        Text("${pokemon.number}", Modifier.background(Green, CircleShape))
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRow(bulbasaur: Pokemon){
    
}