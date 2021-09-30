package com.sidorov.unittest

import android.content.Context

class ResourcesManager(private val context: Context) : ResourcesManagerInterface {
    override fun getString(resId: Int) = context.getString(resId)
}
