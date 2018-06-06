package com.talento.codetest.utils

import android.content.Context
import android.content.res.Configuration

object Utils {
    fun isTablet(context: Context) = context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
}