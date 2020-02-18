package br.com.mariliamessias.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrarLogin.setOnClickListener {

            val usuario = edtUsuarioLogin.text.toString().trim()
            val senha = edtSenhaLogin.text.toString().trim()

            if(usuario.isEmpty()){
                Toast.makeText(this@LoginActivity, "Preencha o usuário", Toast.LENGTH_SHORT).show()
            }else if (senha.isEmpty()){
                Toast.makeText(this@LoginActivity, "Preencha a senha", Toast.LENGTH_SHORT).show()
            }else if(usuario !=  "admin" || senha != "123"){
                Toast.makeText(this@LoginActivity, "Usuário ou senha inválido", Toast.LENGTH_SHORT).show()
            }else {

                //Toast.makeText(this@LoginActivity, "Usuário e senha corretos! :)", Toast.LENGTH_SHORT).show()
            }
        }

        btnCadastrarLogin.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }
    }
}
