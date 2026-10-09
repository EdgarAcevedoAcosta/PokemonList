package acevedo.edgar.pokedexlist.utilities

import androidx.compose.ui.graphics.Color
import acevedo.edgar.pokedexlist.ui.theme.Bug
import acevedo.edgar.pokedexlist.ui.theme.DarkGray
import acevedo.edgar.pokedexlist.ui.theme.Electric
import acevedo.edgar.pokedexlist.ui.theme.Fairy
import acevedo.edgar.pokedexlist.ui.theme.Fight
import acevedo.edgar.pokedexlist.ui.theme.Fire
import acevedo.edgar.pokedexlist.ui.theme.Flying
import acevedo.edgar.pokedexlist.ui.theme.Ghost
import acevedo.edgar.pokedexlist.ui.theme.Grass
import acevedo.edgar.pokedexlist.ui.theme.Ground
import acevedo.edgar.pokedexlist.ui.theme.Normal
import acevedo.edgar.pokedexlist.ui.theme.OffWhite
import acevedo.edgar.pokedexlist.ui.theme.Poison
import acevedo.edgar.pokedexlist.ui.theme.Psych
import acevedo.edgar.pokedexlist.ui.theme.Rock
import acevedo.edgar.pokedexlist.ui.theme.Water

fun getColorByType(type: String): Pair<Color,Color>{
    var color: Color
    var dark = true
    when{
        type.lowercase().contains("normal") -> color = Normal;
        type.lowercase().contains("electric") -> {
            color = Electric
            dark= false
        }
        type.lowercase().contains("water") -> {
            color = Water
        }
        type.lowercase().contains("fire") -> color = Fire
        type.lowercase().contains("fairy") -> {
            color = Fairy
            dark= false
        }
        type.lowercase().contains("grass") -> {
            color = Grass
        }
        type.lowercase().contains("psychic") -> {
            color = Psych
        }
        type.lowercase().contains("fighting") -> {
            color = Fight
            dark= false
        }
        type.lowercase().contains("ghost") -> color = Ghost
        type.lowercase().contains("bug") -> color = Bug
        type.lowercase().contains("poison") -> color = Poison
        type.lowercase().contains("ground") -> color = Ground
        type.lowercase().contains("rock") -> color = Rock
        type.lowercase().contains("flying") -> {
            color = Flying
            dark= false
        }
        else -> color=Normal
    }

    return Pair(color, if(dark) OffWhite else DarkGray)
}