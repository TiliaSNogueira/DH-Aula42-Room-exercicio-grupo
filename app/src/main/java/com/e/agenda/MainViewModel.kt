package com.e.agenda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {

    val listContatos = MutableLiveData<List<Contato>>()

    //vai acessar as suspend fun do repository

    //adicionar um novo contato
    fun addNewContato(contato: Contato) {
        viewModelScope.launch {
            repository.addContatoTask(contato)
        }
    }


    //exibir a lista de contatos
    fun getAllContatos() {
        viewModelScope.launch {
            listContatos.value = repository.getAllContatosTask()
        }
    }

//    fun alterContatoDb(id : Int){
//        viewModelScope.launch {
//            listContatos.value = repository.alterContatoTask(id)
//        }
//    }
//
//    fun delByID(id: Int){
//        viewModelScope.launch {
//            listContatos.value = repository.delByIDTask(id)
//        }
//    }

}