package com.sidorov.unittest

import android.content.Context
import javax.inject.Inject

class ResourcesManagerImpl @Inject constructor(private val context: Context) : ResourcesManager {
    override fun getString(resId: Int) = context.getString(resId)
}
