package com.example.helloandroid.domain
class LoginService {
    fun login(login:String, senha: String): Usuario? {
        if(login == "adrian" && senha == "123") {
            return Usuario("adrian","a@a.com")
        } else if(login == "teste" && senha == "123") {
            return Usuario("Teste","b@b.com")
        }
        return null
    }
}