package com.sidorov.unittest.room

import com.sidorov.unittest.data.NoteDTO
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import javax.inject.Inject

class DatabaseRuleWithDI @Inject constructor(private val database: NotesDB) : TestWatcher() {

    lateinit var notesDAO: NotesDAO
    lateinit var noteDTO: NoteDTO

    override fun starting(description: Description?) {

        notesDAO = database.notesDAO()
        noteDTO = NoteDTO(title = "title", description = "description")
        super.starting(description)
    }

    override fun finished(description: Description?) {
        database.close()
        super.finished(description)
    }
}
