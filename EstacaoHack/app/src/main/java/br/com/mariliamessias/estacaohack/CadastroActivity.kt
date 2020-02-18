package br.com.mariliamessias.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //R. acessando o que está dentro da pasta res
        setContentView(R.layout.activity_cadastro)

        //Criando uma lista com valores atribuidos
        val listaSexo = arrayListOf("Selecione o sexo", "Feminino", "Masculino", "Outros")

        //Criando o Adapter do Spinner (tudo que for trabalhar com apresentação de lista
        var sexoAdapter = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
            )

        //Adicionando o adapter ao spinner
        spnSexoCadastro.adapter = sexoAdapter;

        btnCadastrarCadastro.setOnClickListener {
            //Recuperando as informações
            val nome        = edtNomeCadastro.text.toString().trim()
            val sobrenome   = edtSobrenomeCadastro.text.toString().trim()
            val email       = edtEmailCadastro.text.toString().trim().toLowerCase()
            val senha       = edtSenhaCadastro.text.toString().trim()
            val sexo        = spnSexoCadastro.selectedItem.toString()

            if(nome.isEmpty() || sobrenome.isEmpty() ||
                email.isEmpty() || senha.isEmpty() || sexo == "Selecione o sexo"){
                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("Ops algo deu errado")
                    .setMessage("Todos os campos são obrigatórios!")
                    .setPositiveButton("Ok") { _, _ ->
                        //aqui vai a ação que desejar
                    } // null como segundo parâmetro representa o finish que está implícito
                    .setCancelable(false) // não deixa cancelar clicando fora do botão
                    .create()
                    .show()
            }
            else{

                //abre ou cria um sharedpreferences, nunca retorna nulo
                val minhaPreferencia = getSharedPreferences("cadastro", Context.MODE_PRIVATE)
                val meuEditor = minhaPreferencia.edit()

                meuEditor.putString("nome", nome).apply()
                meuEditor.putString("sobrenome", sobrenome).apply()
                meuEditor.putString("email", email).apply()
                meuEditor.putString("senha", senha).apply()
                meuEditor.putString("sexo", sexo).apply()

                //commit -> tem retorno do sucesso da gravação
                // apply -> salva mas não tem retorno

                startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
            }
        }
    }

}
