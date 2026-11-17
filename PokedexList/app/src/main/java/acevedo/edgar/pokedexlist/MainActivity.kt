package acevedo.edgar.pokedexlist

import acevedo.edgar.pokedexlist.data.CompanionPreferences
import acevedo.edgar.pokedexlist.data.Users
import acevedo.edgar.pokedexlist.data.sqllite.DatabaseHelper
import acevedo.edgar.pokedexlist.data.sqllite.PokemonDAO
import acevedo.edgar.pokedexlist.data.sqllite.PokemonSQLRepository
import acevedo.edgar.pokedexlist.navigation.MyApp
import acevedo.edgar.pokedexlist.view.component.MenuPokedex
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import acevedo.edgar.pokedexlist.ui.theme.PokedexListTheme
import acevedo.edgar.pokedexlist.viewmodel.AddPokemonViewModel
import acevedo.edgar.pokedexlist.viewmodel.PokemonDetailViewModel
import acevedo.edgar.pokedexlist.viewmodel.UserViewModel
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexListTheme {
                val context = LocalContext.current
                val users = remember { Users(context) }
                val companionPreferences = remember { CompanionPreferences(context) }
                val userViewModel = remember { UserViewModel(users, companionPreferences) }
                val pokemonDetailViewModel = remember { PokemonDetailViewModel(companionPreferences) }

                val databaseHelper = remember { DatabaseHelper(context.applicationContext) }
                val pokemonRepository = remember { PokemonSQLRepository(PokemonDAO(databaseHelper)) }
                val addPokemonViewModel = remember { AddPokemonViewModel(pokemonRepository) }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        innerPadding = innerPadding,
                        userViewModel = userViewModel,
                        pokemonDetailViewModel = pokemonDetailViewModel,
                        addPokemonViewModel = addPokemonViewModel
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexListTheme {

    }
}
