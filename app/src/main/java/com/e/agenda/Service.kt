package com.e.agenda


interface Repository {

    suspend fun addContatoTask(contato: Contato): List<Contato>

    suspend fun getAllContatosTask(): List<Contato>

//    // updates
//    suspend fun alterContatoTask(id: Int): List<Contato>
//
//    //delete
//    suspend fun delByIDTask(id: Int): List<Contato>

}

class RepositoryImpl(val contatoDAO: ContatoDao) : Repository {
    override suspend fun addContatoTask(contato: Contato): List<Contato> {
        contatoDAO.addContato(contato)
        return contatoDAO.getAllContatos()
    }

    override suspend fun getAllContatosTask() = contatoDAO.getAllContatos()

//
//    override suspend fun alterContatoTask(id: Int): List<Contato> {
//        contatoDAO.alterContato(id)
//        return contatoDAO.getAllContatos()
//    }
//
//
//    override suspend fun delByIDTask(id: Int): List<Contato> {
//        contatoDAO.delByID(id)
//        return contatoDAO.getAllContatos()
//    }


}