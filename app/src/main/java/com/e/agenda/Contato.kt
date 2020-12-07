package com.e.agenda

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contatos")
data class Contato (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var nome: String,
    var telefone: String) {
}