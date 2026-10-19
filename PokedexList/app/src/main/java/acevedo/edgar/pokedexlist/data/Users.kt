package acevedo.edgar.pokedexlist.data

import acevedo.edgar.pokedexlist.domain.User

val validUsers=listOf<User>(
    User("alma@mail.com","12345","Alma Chavez"),
    User("cazo@mail.com","48565","Alma Ruiz"),
    User("maryblog@mail.com","12513","Maty Blogs")
)

fun getUserByMail(mail: String): User?{
    val users=validUsers.filter { it.email.equals(mail, ignoreCase = true) }
    return if (users.isEmpty()) null else users.first()
}

fun login(user: String, password: String): User?{
    val u=getUserByMail(user)
    u?.let {
        if(u.password.equals(password)){
            return u
        }
    }
    return null
}