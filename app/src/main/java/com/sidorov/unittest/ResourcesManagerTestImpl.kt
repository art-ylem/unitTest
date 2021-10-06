package com.sidorov.unittest

import android.content.Context
import javax.inject.Inject

class ResourcesManagerTestImpl @Inject constructor(val context: Context) :
    ResourcesManager {
    override fun getString(resId: Int) = context.getString(resId)
    fun getStubString(resId: Int) = "stub"
}
