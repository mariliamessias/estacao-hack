package com.mariliaMessias.desafios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_par_ou_impar.*
import java.math.BigDecimal

class ParOuImparActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_par_ou_impar)

        btnConsultarParImpar.setOnClickListener({

            var mensagem : String
            var resultado = edtNumeroParImpar.text.toString()

            if (Integer.valueOf(resultado)%2  == 0 ) mensagem = "O número informado é par"
            else mensagem = "O número informado é ímpar"

            txvResultadoParImpar.setText(mensagem)

        })
    }

}
