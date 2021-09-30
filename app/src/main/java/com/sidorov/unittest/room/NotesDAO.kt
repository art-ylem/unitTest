package com.sidorov.unittest.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sidorov.unittest.data.NoteEntity
import io.reactivex.Single

@Dao
interface NotesDAO {
    @Query("SELECT * FROM notes")
    fun getAll(): Single<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id=:id ")
    fun getById(id: String): Single<NoteEntity>

    @Insert
    fun insert(data: NoteEntity)

    @Update
    fun update(data: NoteEntity)

    @Delete
    fun delete(vararg data: NoteEntity)
}
