package com.sidorov.unittest.di

import com.sidorov.unittest.MainActivity
import com.sidorov.unittest.MyApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(app: MyApp)
}