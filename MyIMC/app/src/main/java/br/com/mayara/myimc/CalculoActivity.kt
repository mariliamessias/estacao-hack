package br.com.mayara.myimc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_calculo.*
import java.text.DecimalFormat

class CalculoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)

        val listaSexo = arrayListOf("Sexo", "Feminino", "Masculino", "Outros")

        val sexoAdapter = ArrayAdapter(
            this@CalculoActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        spnSexo.adapter = sexoAdapter

        btnTabela.setOnClickListener {
            startActivity(Intent(this@CalculoActivity, TabelaActivity::class.java))
        }

        btnCalcular.setOnClickListener {

            val altura = (txvAlturaValor.text.toString().replace("m", "")).toDouble()
            val peso = (txvPesoValor.text.toString().replace("kg", "")).toDouble()
            val df = DecimalFormat("#.##")
            val imc = df.format(peso / (altura * altura))
            val resultado = imc.toString()
            val sexo = spnSexo.selectedItem.toString()

            val mensagem = "\nSeu IMC é: ${resultado}.\n\nConsulte a tabela para saber o resultado."

            if (txvAlturaValor.text == "0 m" || txvPesoValor.text == "0 kg" || spnSexo.selectedItem == "Sexo") {
                AlertDialog.Builder(this@CalculoActivity)
                    .setTitle("Existem campos em branco!")
                    .setMessage("\nPreencha todos os campos para calcular o IMC.")
                    .setIcon(R.drawable.imglogo)
                    .setPositiveButton("Ok") { _, _ ->

                    }
                    .setCancelable(true)
                    .create()
                    .show()
            } else {

                val minhaPreferencia = getSharedPreferences("imc", Context.MODE_PRIVATE)
                val meuEditor = minhaPreferencia.edit()

                meuEditor.putString("imc", resultado).apply()

                AlertDialog.Builder(this@CalculoActivity)
                    .setTitle("Valor calculado")
                    .setMessage(mensagem)
                    .setIcon(R.drawable.imglogo)
                    .setPositiveButton("Ok") { _, _ ->

                    }
                    .setCancelable(true)
                    .create()
                    .show()
            }

        }


        skbAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                val newValue = progress / 100.0
                val df = DecimalFormat("#.##")
                txvAlturaValor.text = "${df.format(newValue)} m"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        skbPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                val newValue = progress / 1000.0
                val df = DecimalFormat("#.##")
                txvPesoValor.text = "${df.format(newValue)} kg"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


    }
}
