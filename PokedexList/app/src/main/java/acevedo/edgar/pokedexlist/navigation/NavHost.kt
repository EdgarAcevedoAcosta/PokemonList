package acevedo.edgar.pokedexlist.navigation

import acevedo.edgar.pokedexlist.view.screen.AddPokemonScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import acevedo.edgar.pokedexlist.view.screen.LoginScreen
import acevedo.edgar.pokedexlist.view.screen.MenuPokedexScreen
import acevedo.edgar.pokedexlist.view.screen.PokemonDetailScreen
import acevedo.edgar.pokedexlist.view.screen.PokemonHuntScreen
import acevedo.edgar.pokedexlist.view.screen.ProfileScreen
import acevedo.edgar.pokedexlist.viewmodel.AddPokemonViewModel
import acevedo.edgar.pokedexlist.viewmodel.PokemonDetailViewModel
import acevedo.edgar.pokedexlist.viewmodel.UserViewModel

@Composable
fun MyApp(innerPadding: PaddingValues,
          userViewModel: UserViewModel,
          pokemonDetailViewModel: PokemonDetailViewModel,
          addPokemonViewModel: AddPokemonViewModel
){
    val navControl= rememberNavController()
    NavHost(navController = navControl, startDestination = Login){
        composable<Login> {
            LoginScreen(
                viewModel = userViewModel,
                onLoginSuccess = {
                    navControl.navigate(PokemonList) {
                        popUpTo<Login> { inclusive = true }
                    }
                }
            )
        }
        composable<PokemonList>{
            MenuPokedexScreen(
                innerPadding = innerPadding,
                onNavigateToDetail = { id ->
                    navControl.navigate(route = PokemonDetail(id))
                },
                onNavigateToHunt = {
                    navControl.navigate(route = PokemonHunt)
                },
                onNavigateToProfile = {
                    navControl.navigate(route = Profile)
                },
                onNavigateToAddPokemon = {
                    navControl.navigate(route = AddPokemon)
                },
                addPokemonViewModel = addPokemonViewModel
            )
        }

        composable<PokemonDetail>{
            //val id= backSt
            val detail: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(
                innerPadding = innerPadding,
                pokemonNumber = detail.pokemon,
                pokemonDetailViewModel = pokemonDetailViewModel
            )
        }

        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding)
        }
        composable<Profile> {
            ProfileScreen(
                innerPadding = innerPadding,
                userViewModel = userViewModel
            )
        }

        composable<AddPokemon> {
            AddPokemonScreen(
                innerPadding = innerPadding,
                addPokemonViewModel = addPokemonViewModel
            )
        }
    }
}