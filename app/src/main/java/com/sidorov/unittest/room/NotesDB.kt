package com.sidorov.unittest.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sidorov.unittest.data.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesDB : RoomDatabase() {
    abstract fun notesDAO(): NotesDAO
}
