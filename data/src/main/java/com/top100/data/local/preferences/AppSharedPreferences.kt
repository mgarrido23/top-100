package com.top100.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

interface AppSharedPreferences {
    fun setSessionToken(token: String?)
    fun getSessionToken(): String?
}

class AppSharedPreferencesImpl @Inject constructor(context: Context) : AppSharedPreferences {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_FILE, 0)

    override fun setSessionToken(token: String?) {
        sharedPreferences.edit().putString(KEY_SESSION_TOKEN, token).apply()
    }

    override fun getSessionToken(): String? {
        return sharedPreferences.getString(KEY_SESSION_TOKEN, null)
    }

    companion object {
        private const val PREF_FILE = "pref_top100"

        private const val KEY_SESSION_TOKEN = "SESSION_TOKEN"
    }
}
