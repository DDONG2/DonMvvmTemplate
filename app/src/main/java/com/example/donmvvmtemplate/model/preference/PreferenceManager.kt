package com.example.donmvvmtemplate.model.preference

interface PreferenceManager {

    fun getString(key: String): String?

    fun putString(key: String, value: String)

    fun getLong(key: String): Long?

    fun putLong(key: String, value: Long)
}
