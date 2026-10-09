package acevedo.edgar.pokedexlist.model.domain

data class PokedexState(
    val team:List<Pokemon> = emptyList<Pokemon>(),
    val lastCaptured: Pokemon ?=null
)
