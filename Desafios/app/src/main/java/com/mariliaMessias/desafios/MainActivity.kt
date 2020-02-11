package com.mariliaMessias.desafios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cstParImpar.setOnClickListener {
            val intent = Intent(this, ParOuImparActivity::class.java)
            startActivity(intent);
        }

        cstBissexto.setOnClickListener {
            val intent = Intent(this, BissextoActivity::class.java)
            startActivity(intent);
        }

        cstChopp.setOnClickListener {
            val intent = Intent(this, ChoppActivity::class.java)
            startActivity(intent);
        }

        cstDistancia.setOnClickListener {
            val intent = Intent(this, DistanciaActivity::class.java)
            startActivity(intent);
        }

        cstIpva.setOnClickListener {
            val intent = Intent(this, IpvaActivity::class.java)
            startActivity(intent);
        }

        cstTemperatura.setOnClickListener {
            val intent = Intent(this, ConversorTemperaturaActivity::class.java)
            startActivity(intent);
        }
    }




}
