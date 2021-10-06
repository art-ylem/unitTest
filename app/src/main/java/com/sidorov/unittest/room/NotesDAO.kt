package com.sidorov.unittest.room

import androidx.room.*
import com.sidorov.unittest.data.NoteEntity
import io.reactivex.Single

@Dao
interface NotesDAO {
    @Query("SELECT * FROM notes")
    fun getAll(): Single<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id=:id ")
    fun getById(id: String): Single<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: NoteEntity)

    @Update
    fun update(data: NoteEntity)

    @Delete
    fun delete(vararg data: NoteEntity)
}
