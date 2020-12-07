package com.e.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.agenda.database.AppDataBase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDataBase
    private lateinit var repo: Repository

    private lateinit var ll : LinearLayoutManager
    private lateinit var adapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDB()

        //passa o dao pro banco de dados
        repo = RepositoryImpl(db.contatoDao())


        //instanciando viewModel com parametros
        val viewModel by viewModels<MainViewModel> {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(repo) as T
                }
            }
        }


        viewModel.addNewContato(Contato(nome = "João", telefone = "12345"))

        viewModel.getAllContatos()



        rv_main.layoutManager = LinearLayoutManager(this)

        viewModel.listContatos.observe(this, {
            it.forEach {
                Log.i("MAINACTIVITY", it.toString())

            }
            adapter = MainAdapter(it)


        })

    }

    //inicia o nosso banco de dados
    fun initDB() {
        db = AppDataBase.invoke(this)
    }


}