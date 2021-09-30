package com.sidorov.unittest

import androidx.annotation.StringRes

interface ResourcesManagerInterface {
    fun getString(@StringRes resId: Int): String
}
