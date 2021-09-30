package com.sidorov.unittest.room

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.sidorov.unittest.data.NoteDTO
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DBTest {
    private lateinit var database: NotesDB
    private lateinit var notesDAO: NotesDAO
    private lateinit var noteDTO: NoteDTO

    @Before
    fun createDB() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(appContext, NotesDB::class.java).build()
        notesDAO = database.notesDAO()
        noteDTO = NoteDTO(title = "title", description = "description")
    }

    @After
    fun closeDB() {
        database.close()
    }

    @Test
    fun `dto to vo mapper`() {
        Assert.assertEquals(noteDTO.toVO().fullText, "${noteDTO.title} - ${noteDTO.description}")
        Assert.assertEquals(noteDTO.toVO().title, noteDTO.title)
        Assert.assertEquals(noteDTO.toVO().description, noteDTO.description)
    }

    @Test
    fun `check is insert method correct`() {
        database.notesDAO().insert(noteDTO.toVO().toEntity())
        val singleValue = database.notesDAO().getById("testId").test()
        singleValue.assertNoErrors().assertValue { it.description == noteDTO.toVO().description }
    }
}
