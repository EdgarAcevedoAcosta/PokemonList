package acevedo.edgar.pokedexlist.view.screen

import acevedo.edgar.pokedexlist.ui.theme.Green
import acevedo.edgar.pokedexlist.ui.theme.Pink80
import acevedo.edgar.pokedexlist.ui.theme.Purple40
import acevedo.edgar.pokedexlist.ui.theme.Typography
import acevedo.edgar.pokedexlist.view.component.PokemonRow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import acevedo.edgar.pokedexlist.viewmodel.PokemonViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun PokemonHuntScreen(innerPadding: PaddingValues, viewModel: PokemonViewModel= viewModel()) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { viewModel.searchPokemon() }) {
            Text("Buscar Pokemon en la Hierva")
        }
        Spacer(Modifier.size(18.dp))
        viewModel.wildPokemon?.let { pokemon ->
            Text(
                "Aparecio un ${pokemon.name} salvaje",
                style = Typography.labelLarge,
                color = Purple40
            )
            Spacer(Modifier.size(15.dp))
            Image(painterResource(pokemon.image), "${pokemon.name}")
            Button(onClick = { viewModel.capturarPokemon() }) {
                Text("Capturar a ${pokemon.name}")
            }
        }
        if (viewModel.isPokemonCaptured) {
            Text("Has atrapado al Pokemon :v", style = Typography.labelLarge, color = Green)
        }

        if (viewModel.gonePokemon) {
            Text("El pokemon se ha escapado", style = Typography.labelLarge, color = Color.Magenta)
        }

        Spacer(Modifier.size(18.dp))
        Text("Pokemon Capturados", style = Typography.titleLarge, color = Pink80)
        LazyColumn() {
            items(viewModel.capturedPokemon) { pokemon ->
                PokemonRow(pokemon, {})
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview(){
    PokemonHuntScreen(PaddingValues(15.dp))
}