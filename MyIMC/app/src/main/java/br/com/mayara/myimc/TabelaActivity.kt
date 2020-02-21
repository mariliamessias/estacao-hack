package br.com.mayara.myimc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tabela.*

class TabelaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela)


        val minhaPreferencia = getSharedPreferences("imc", Context.MODE_PRIVATE)
        txvImc.text = minhaPreferencia.getString("imc", "Erro String Shared")
    }
}
