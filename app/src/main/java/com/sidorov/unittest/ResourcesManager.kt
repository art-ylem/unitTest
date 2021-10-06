package com.sidorov.unittest

import androidx.annotation.StringRes

interface ResourcesManager {
    fun getString(@StringRes resId: Int): String
}
