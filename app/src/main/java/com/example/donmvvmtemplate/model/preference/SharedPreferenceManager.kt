package com.example.donmvvmtemplate.model.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import okhttp3.internal.Internal.instance

class SharedPreferenceManager(context: Context) : PreferenceManager {

    private var preferences: SharedPreferences
    private var preEditor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences("TEMP", Context.MODE_PRIVATE)
        preEditor = preferences.edit()
    }


    override fun getString(key: String): String? {
        val value = preferences.getString(key, DEAFULT_String)

        return if (value == DEAFULT_String) {
            null
        } else {
            value
        }
    }

    override fun putString(key: String, value: String) =
        preferences.edit { putString(key, value) }



    override fun getLong(key: String): Long? {
        val value = preferences.getLong(key, DEAFULT_LONG)

        return if (value == DEAFULT_LONG) {
            null
        } else {
            value
        }
    }

    override fun putLong(key: String, value: Long) =
        preferences.edit { putLong(key, value) }




    companion object {
        private val DEAFULT_LONG = Long.MIN_VALUE
        private val DEAFULT_String = ""


        private var instance: SharedPreferenceManager? = null

        fun getInstance(context: Context) = instance
            ?: SharedPreferenceManager(context).also { instance = it }
    }

}
