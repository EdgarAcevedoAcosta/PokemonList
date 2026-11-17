package acevedo.edgar.pokedexlist.viewmodel


import acevedo.edgar.pokedexlist.data.CompanionPreferences
import acevedo.edgar.pokedexlist.data.Users
import acevedo.edgar.pokedexlist.domain.Pokemon
import acevedo.edgar.pokedexlist.domain.User
import acevedo.edgar.pokedexlist.preferencias.PokemonSerializer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class UserViewModel(
    val users: Users,
    private val companionPreferences: CompanionPreferences
) : ViewModel() {

    var currentUser by mutableStateOf<User?>(null)
        private set

    var loginError by mutableStateOf(false)
        private set

    var errorDescription by mutableStateOf("")
        private set

    val companion: StateFlow<Pokemon> = companionPreferences.pokemonCompanion()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = PokemonSerializer.defaultValue
        )

    init {
        currentUser = users.getCurrentUser()
    }

    fun login(email: String, pass: String): Boolean {
        val user = users.loginService(email, pass)
        return if (user != null) {
            users.saveUser(user.email, user.name)
            currentUser = user
            loginError = false
            errorDescription = ""
            true
        } else {
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos"
            false
        }
    }

    fun isLoggedIn(): Boolean {
        return users.isLoggedIn()
    }

    fun logout() {
        users.logout()
        currentUser = null
    }
}