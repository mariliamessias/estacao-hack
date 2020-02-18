package br.com.mariliamessias.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minhaPreferencia = getSharedPreferences("cadastro", Context.MODE_PRIVATE)

        txvEmailMain.text = minhaPreferencia.getString("email", "Erro String Shared")
        txvNomeMain.text = minhaPreferencia.getString("nome", "Erro String Shared")
        txvSexoMain.text = minhaPreferencia.getString("sexo", "Erro String Shared")

        btnSairMain.setOnClickListener {
            //botão voltar do celular, se sobrescrever essa função é possível alterar a função do botão voltar
            onBackPressed()
        }

        btnSiteMain.setOnClickListener {
            startActivity(Intent(this@MainActivity, WebActivity::class.java))
        }
    }
}
