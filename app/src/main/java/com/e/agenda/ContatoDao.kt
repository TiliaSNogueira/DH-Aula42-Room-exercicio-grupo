package com.e.agenda

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContatoDao {

    @Insert
    suspend fun addContato(contato: Contato)

    //select
    @Query("SELECT * FROM contatos")
    suspend fun getAllContatos(): List<Contato>

//    //update
//    @Query("UPDATE gastos SET  nomes = 'Comida' WHERE id = :id ")
//    suspend fun alterGasto(id: Int)
//
//    //delete
//    @Query("DELETE FROM  gastos WHERE id = :id ")
//    suspend fun delByID(id: Int)

}