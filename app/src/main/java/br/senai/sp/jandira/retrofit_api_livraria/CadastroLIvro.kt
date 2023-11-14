package br.senai.sp.jandira.retrofit_api_livraria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CadastroLIvro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_livro)

        //Teste de recebimento do JSON
        val bodyJSON = intent.getStringExtra("bodyJSON")
        Log.e("TESTE-JSON", "$bodyJSON")
    }
}