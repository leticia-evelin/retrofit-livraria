package br.senai.sp.jandira.retrofit_api_livraria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.create

class Cadastro_Categoria : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_categoria)

        //conecta apiService com a api rest atraves da classe RetrofitHelper e seu método
        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        //recupera o componente gráfico de EditText
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)

        //trata a ação de clique do botão cadastrar
        findViewById<Button>(R.id.btnCadastrarCategoria).setOnClickListener{

            //recuperar o dado digitado pelo usuário
            val nomeCategoria = txtCategoria.text

            //enviar a requisição de cadastro para a API
            createCategory(nomeCategoria.toString())
        }
    }

    //implementação do método createCategory
    private fun createCategory(nome_categoria: String){
        lifecycleScope.launch {

            //montagem do corpo de dados em json
            val body = JsonObject().apply {
                addProperty("nome_categoria", nome_categoria)
            }

            //envio da requisição de cadastro de categoria
            val result = apiService.createCategory(body)

            //verificando a resposta da requisição
            if (result.isSuccessful){
                val msg = result.body()?.get("mensagemStatus")
                Log.e("CREATE-CATEGORY", "STATUS: ${msg}")
            } else {
                Log.e("CREATE-CATEGORY", "ERROR: ${result.message()}")
            }
        }

    }


}