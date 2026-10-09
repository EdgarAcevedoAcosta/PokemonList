package acevedo.edgar.pokedexlist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import acevedo.edgar.pokedexlist.model.data.getPokemonByNumber
import acevedo.edgar.pokedexlist.view.screen.MenuPokedexScreen
import acevedo.edgar.pokedexlist.view.screen.PokemonDetailsScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navControl= rememberNavController()
    NavHost(navControl, startDestination= PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateToDetail =
                {id -> navControl.navigate(route= PokemonDetail(id))})
        }

        composable<PokemonDetail>{
            //val id= backSt
            val pokemon= it.arguments?.getInt("pokemon")?:-1
            PokemonDetailsScreen(innerPadding, getPokemonByNumber(pokemon))
        }
    }

}