package com.sidorov.unittest.room

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.sidorov.unittest.data.NoteDTO
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class DatabaseRule : TestWatcher() {

    lateinit var database: NotesDB
    lateinit var notesDAO: NotesDAO
    lateinit var noteDTO: NoteDTO

    override fun starting(description: Description?) {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(appContext, NotesDB::class.java).build()
        notesDAO = database.notesDAO()
        noteDTO = NoteDTO(title = "title", description = "description")
        super.starting(description)
    }

    override fun finished(description: Description?) {
        database.close()
        super.finished(description)
    }
}
