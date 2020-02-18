package br.com.mariliamessias.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //habilitando javascript
        wbvWeb.settings.javaScriptEnabled = true
        wbvWeb.loadUrl("https://br.cellep.com/estacaohack")
    }
}
