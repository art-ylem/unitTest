package com.sidorov.unittest.di

import android.content.Context
import androidx.room.Room
import com.sidorov.unittest.Note
import com.sidorov.unittest.room.NotesDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DataModule {

    @Singleton
    @Provides
    fun provideNote() = Note()

    @Singleton
    @Provides
    fun provideRoom(context: Context) =
        Room.inMemoryDatabaseBuilder(context, NotesDB::class.java).build()

}
