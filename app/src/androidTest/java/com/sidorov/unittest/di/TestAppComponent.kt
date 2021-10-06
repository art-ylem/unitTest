package com.sidorov.unittest.di

import android.content.Context
import com.sidorov.unittest.room.DatabaseRule
import com.sidorov.unittest.room.DatabaseRuleWithDI
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, AppModule::class])
interface TestAppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): TestAppComponent
    }
    fun inject(into: TestDI)
    fun inject(into: DatabaseRule)
}
