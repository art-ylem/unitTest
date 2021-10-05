package com.sidorov.unittest.di

import com.sidorov.unittest.Note
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideNote() = Note()
}