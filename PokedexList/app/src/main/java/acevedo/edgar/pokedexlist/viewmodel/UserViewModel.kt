package acevedo.edgar.pokedexlist.viewmodel

import acevedo.edgar.pokedexlist.data.validUsers
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescriptor by mutableStateOf<String>("")
    fun login(user:String, password: String){
        val user=login(user,password)
        if (user==null){
            loginError=true
            errorDescriptor="Usuario o comtraseña incorrecta"
        }else{
            loginError=false
            errorDescriptor=""

        }

    }
}