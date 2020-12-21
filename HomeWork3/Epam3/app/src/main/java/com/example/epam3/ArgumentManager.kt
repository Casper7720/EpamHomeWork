package com.example.epam3

import android.os.Bundle
import androidx.core.os.bundleOf

class ArgumentManager {
    private val KEY_ARG = "KEY_ARG"

    fun getCounter(args: Bundle?): Int = args?.getInt(KEY_ARG) ?: 0

    fun createArguments(counter: Int) = bundleOf(KEY_ARG to counter)
}