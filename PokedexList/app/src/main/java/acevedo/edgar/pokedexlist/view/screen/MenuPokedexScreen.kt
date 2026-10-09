package acevedo.edgar.pokedexlist.view.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import acevedo.edgar.pokedexlist.R
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import acevedo.edgar.pokedexlist.view.component.FavoritesRow
import acevedo.edgar.pokedexlist.view.component.PokedexGrid
import acevedo.edgar.pokedexlist.model.data.getFavoritePokemons
import acevedo.edgar.pokedexlist.model.data.pokemonList
import acevedo.edgar.pokedexlist.ui.theme.Blue
import acevedo.edgar.pokedexlist.ui.theme.Green
import acevedo.edgar.pokedexlist.ui.theme.LightBlue
import acevedo.edgar.pokedexlist.ui.theme.LightGreen

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail:(id:Int) -> Unit){
    var grid by remember { mutableStateOf(false) }
    Switch(checked = grid, onCheckedChange = {grid = it},
    colors = SwitchDefaults.colors(
        checkedThumbColor = Green,
        checkedTrackColor = LightGreen,
        uncheckedThumbColor = Blue,
        uncheckedTrackColor = LightBlue,
        uncheckedIconColor = Color.Transparent
        
    ),
        thumbContent = {
            if(grid)
                Icon(painterResource(R.drawable.grid), contentDescription = "Grid", modifier = Modifier.size(
                    SwitchDefaults.IconSize))
            else
                Icon(painterResource(R.drawable.list), contentDescription = "Grid", modifier = Modifier.size(
                    SwitchDefaults.IconSize))
        })
    Column(modifier = Modifier.padding(innerPadding)) {
        Text("Favorite Pokemon")
        FavoritesRow(getFavoritePokemons(), onNavigateToDetail)
        Spacer(Modifier.size(15.dp))
        Text("All Pokemons")
        PokedexGrid(pokemonList)
    }
}

@Preview(showBackground = true)
@Composable
fun previewScreen(){
    MenuPokedexScreen(PaddingValues(15.dp,15.dp),{})
}
