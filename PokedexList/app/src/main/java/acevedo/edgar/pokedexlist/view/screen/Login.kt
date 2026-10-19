package acevedo.edgar.pokedexlist.view.screen

import acevedo.edgar.pokedexlist.viewmodel.UserViewModel
import android.view.Menu
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(innerPadding: PaddingValues,onNavigateToMenu: ()->Unit, viewModel: UserViewModel= viewModel()){
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf(value = "") }
    Column() {
        TextField(value = user, label = {
            Text("Correo Electronico")
        }, onValueChange = {it ->user=it}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))
        TextField(value = password, label = {
            Text("Contraseña")
        }, onValueChange = {it ->password=it}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        Button(onClick = {}) {
            Text("Iniciar Sesión")
        }
    }
}