package com.example.helloandroid
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.helloandroid.domain.CadastroModel
import com.example.helloandroid.domain.CadastroService
import com.example.helloandroid.extension.alert

class CadastroActivity : LogActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadatro)
        findViewById<Button>(R.id.btCadastrar).setOnClickListener {
            onClickCadastrar()
        }
    }
    private fun onClickCadastrar() {
        val termosOk = findViewById<CheckBox>(R.id.checkTermos).isChecked
        if (!termosOk) {
            alert("Aceite os termos para continuar")
        } else {
            // Cria objeto de cadastro
            val model = getCadastroModel()
            val service = CadastroService()
            val ok: Boolean = service.cadastrar(model)
            if (ok) {
                alert("Cadastro realizado com sucesso.\nSua senha foi enviada para o email.") {
                        finish()
            }
        } else {
            alert("Ocorreu um erro ao cadastrar.")
        }
    }
}
// Cria o objeto de modelo copiando os dados do form
private fun getCadastroModel(): CadastroModel {
    val model = CadastroModel()
    model.nome = findViewById<EditText>(R.id.tNome).text.toString()
    model.login = findViewById<EditText>(R.id.tLogin).text.toString()
    model.email = findViewById<EditText>(R.id.tEmail).text.toString()
    model.sexo = if (findViewById<EditText>(R.id.radioSexo) == findViewById<RadioButton>(R.id.radioMasculino)) "M" else "F"

    return model
}
}