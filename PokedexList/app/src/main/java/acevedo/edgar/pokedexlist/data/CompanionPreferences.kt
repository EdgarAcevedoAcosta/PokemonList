package acevedo.edgar.pokedexlist.data

import acevedo.edgar.pokedexlist.domain.Pokemon
import acevedo.edgar.pokedexlist.preferencias.PokemonSerializer
import android.content.Context
import androidx.datastore.core.DataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

val Context.dataStore: DataStore<Pokemon> by dataStore(
    fileName = "pokemon.json",
    serializer = PokemonSerializer,
    scope = CoroutineScope(
        Dispatchers.IO
    )
)


class CompanionPreferences(private val context: Context) {

    suspend fun saveCompanion(companion: Pokemon) {
        context.dataStore.updateData { pokemon ->
            companion.copy(companionSinceEpochDay = LocalDate.now().toEpochDay())
        }
    }

    fun pokemonCompanion(): Flow<Pokemon> =
        context.dataStore.data.map { pokemon ->
            pokemon
        }


}