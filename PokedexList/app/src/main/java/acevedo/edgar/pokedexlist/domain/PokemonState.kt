package acevedo.edgar.pokedexlist.domain

data class PokemonState (
    val team: List<Pokemon> = emptyList(),
    val lastCapture: Pokemon? = null
)