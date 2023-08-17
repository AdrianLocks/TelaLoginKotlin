package com.example.helloandroid
// versao 1.0
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloandroid.R.id.btCadastrar
import com.example.helloandroid.R.id.btEsqueciSenha
import com.example.helloandroid.R.id.btLogin


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(btLogin).setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        findViewById<TextView>(btEsqueciSenha).setOnClickListener {
            startActivity(Intent(this,EsqueciSenhaActivity::class.java))



        }
        findViewById<TextView>(btCadastrar).setOnClickListener {
            startActivity(Intent(this,CadatroActivity::class.java))
        }
    }
}

