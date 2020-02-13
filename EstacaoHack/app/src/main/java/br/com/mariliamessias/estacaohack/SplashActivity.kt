package br.com.mariliamessias.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //para a thread principal e executa uma outra tread
        //parametros do metodo postDelayed do o que vai executar e quanto tempo
        //Intent a intencao de fazer alguma coisa
        //          intent explicita -> falamos o que ela vai executar (sua acao)
        //          intent implicita -> camera do celular (exemplo)
        Handler().postDelayed({

            //o valor de parametro da intent é onde esta // o segundo parametro é para qual activity irá
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, 3000)
    }
}
