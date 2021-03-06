package com.sidorov.unittest.di

import android.content.Context
import com.sidorov.unittest.MainActivity
import com.sidorov.unittest.MyApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(into: MainActivity)
    fun inject(into: MyApp)
}
