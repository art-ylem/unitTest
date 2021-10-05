package com.sidorov.unittest

import android.app.Application
import com.sidorov.unittest.di.AppComponent
import com.sidorov.unittest.di.DaggerAppComponent

class MyApp : Application() {

    val appComponent: AppComponent = DaggerAppComponent
        .builder().build()

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent.inject(this)
    }

    companion object {
        var instance: MyApp? = null
            private set
    }
}
