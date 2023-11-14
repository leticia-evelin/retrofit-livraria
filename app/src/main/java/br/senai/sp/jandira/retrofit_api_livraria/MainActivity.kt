package br.senai.sp.jandira.retrofit_api_livraria

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.JsonObject

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Declarando e recuperando os objetos de view
        val txtTitulo = findViewById<EditText>(R.id.txtTitulo)
        val txtPreco = findViewById<EditText>(R.id.txtPreco)
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)
        val txtDescricao = findViewById<EditText>(R.id.txtLivroDescricao)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrarLivro)


        //Tratamento da ação de clique do BOTAO CADASTRAR
        btnCadastrar.setOnClickListener{

            //entrada dos dados do livro
            val titulo = txtTitulo.text.toString()
            val preco = txtPreco.text.toString()
            val categoria = txtCategoria.text.toString()
            val descricao = txtDescricao.text.toString()

            //Montagem do corpo JSON dos dados de livro
            val body = JsonObject().apply {
                addProperty("titulo", titulo)
                addProperty("preco", preco)
                addProperty("categoria", categoria)
                addProperty("descricao", descricao)
            }

            //Teste do corpo de dados JSON
            Log.e("BODY-JSON", body.toString())

            //Navegaçao para a tela de imagens de livro
            val intent = Intent(
                this,
                CadastroLivroImagem::class.java).apply {
                    putExtra("bodyJSON", body.toString())

                startActivity(intent)
            }
        }
    }

}