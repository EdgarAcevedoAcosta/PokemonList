package acevedo.edgar.pokedexlist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import acevedo.edgar.pokedexlist.model.data.getPokemonByNumber
import acevedo.edgar.pokedexlist.view.screen.LoginScreen
import acevedo.edgar.pokedexlist.view.screen.MenuPokedexScreen
import acevedo.edgar.pokedexlist.view.screen.PokemonDetailsScreen
import acevedo.edgar.pokedexlist.view.screen.PokemonHuntScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navigateToMenu={
        navControl.navigate
    }
    val navControl= rememberNavController()
    NavHost(navControl, startDestination= PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateToDetail =
                {id -> navControl.navigate(route= PokemonDetail(id))},
                onNavigateToHunt= {navControl.navigate(route= PokemonHunt)})
        }

        composable<PokemonDetail>{
            //val id= backSt
            val pokemon= it.arguments?.getInt("pokemon")?:-1
            PokemonDetailsScreen(innerPadding, getPokemonByNumber(pokemon))
        }

        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding)
        }
        composable<Login>{
            LoginScreen(innerPadding, navigateToMenu)
        }
    }
}