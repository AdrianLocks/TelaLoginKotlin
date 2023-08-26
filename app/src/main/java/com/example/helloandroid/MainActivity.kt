package com.example.helloandroid
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.helloandroid.R.id.btCadastrar
import com.example.helloandroid.R.id.btEsqueciSenha
import com.example.helloandroid.R.id.btFaleConosco
import com.example.helloandroid.R.id.btLocalizacao
import com.example.helloandroid.R.id.btLogin
import com.example.helloandroid.R.id.tLogin
import com.example.helloandroid.R.id.tSenha
import com.example.helloandroid.R.layout.activity_main
import com.example.helloandroid.domain.LoginService
import com.example.helloandroid.extension.alert




class MainActivity : LogActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        if(savedInstanceState != null) {
            // recupera o count
            Log.d("android","Recuperando estado")
            count = savedInstanceState.getInt("count")
        }
        Log.d("android","Count: $count")

        findViewById<Button>(btLogin).setOnClickListener {
            onClickLogin()
        }

        findViewById<TextView>(btEsqueciSenha).setOnClickListener {
            onClickEsqueciSenha()
        }
        findViewById<TextView>(btCadastrar).setOnClickListener {
            onClickCadastrar()
        }
        findViewById<TextView>(btLocalizacao).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://google.com"))
            startActivity(intent)
        }
        findViewById<TextView>(btFaleConosco).setOnClickListener {
            onClickContato()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("android","Salvando estado")
        count++
        outState.putInt("count",count)
    }
    private fun onClickLogin() {
        // Encontra as views
        val tLogin = findViewById<TextView>(tLogin)
        val tSenha = findViewById<TextView>(tSenha)
        // Lê os textos
        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()
        Log.d("[Projeto_Android]","Login: $login, Senha: $senha")
        // Valida o login
        val service = LoginService()
        val user = service.login(login,senha)
        if(user != null) {
            // login OK vai para a Home
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
            val intent = Intent(this,HomeActivity::class.java)
            val args = Bundle()
            args.putSerializable("usuario", user)
            intent.putExtras(args)
            startActivity(intent)
        } else {
            // Erro de Login
            alert("Login incorreto, digite os dados novamente")
        }
    }

    // Um método para cada evento aqui

    private fun onClickEsqueciSenha() {
        startActivity(Intent(this,EsqueciSenhaActivity::class.java))
    }
    private fun onClickCadastrar() {
        startActivity(Intent(this,CadastroActivity::class.java))
    }
    private fun onClickContato() {
        startActivity(Intent(this,CadastroActivity::class.java))
    }
}