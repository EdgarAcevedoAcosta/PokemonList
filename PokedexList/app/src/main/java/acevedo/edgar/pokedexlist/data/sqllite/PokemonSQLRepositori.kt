package acevedo.edgar.pokedexlist.data.sqllite

import acevedo.edgar.pokedexlist.data.interfaces.IPokemonDAO
import acevedo.edgar.pokedexlist.data.interfaces.IPokemonRepository
import acevedo.edgar.pokedexlist.domain.Pokemon

class PokemonSQLRepository(private val dao: IPokemonDAO) : IPokemonRepository {
    override suspend fun addPokemon(pokemon: Pokemon){
        dao.insertPokemon(pokemon)
    }

    override suspend fun getPokemons(): List<Pokemon> {
        return dao.getAllPokemons()
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        return dao.getFavoritePokemons()
    }

    override suspend fun getPokemonsByType(type: String): List<Pokemon> {
        return dao.getPokemonsByType(type)
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        dao.updatePokemon(pokemon)
    }

    override suspend fun deletePokemon(id: Integer) {
        dao.deletePokemon(id)
    }
}