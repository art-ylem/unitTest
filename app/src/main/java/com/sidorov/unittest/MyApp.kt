package com.sidorov.unittest

import android.app.Application
import android.content.Context
import com.sidorov.unittest.di.AppComponent
import com.sidorov.unittest.di.DaggerAppComponent

class MyApp : Application() {

    var name: String? = null
        get() = resources.getString(R.string.app_name)
        private set

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder().context(this).build()
        instance = this
        appComponent.inject(this)
    }

    companion object {
        var instance: MyApp? = null
            private set
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MyApp -> appComponent
        else -> this.applicationContext.appComponent
    }
