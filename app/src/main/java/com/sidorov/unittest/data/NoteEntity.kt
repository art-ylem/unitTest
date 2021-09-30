package com.sidorov.unittest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "note title")
    val title: String,
    @ColumnInfo(name = "note description")
    val description: String,
    @ColumnInfo(name = "note fullText")
    val fullText: String
)
