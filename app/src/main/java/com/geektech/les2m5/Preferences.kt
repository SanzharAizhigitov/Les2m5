package com.geektech.les2m5

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {


    private var preferences: SharedPreferences =
        context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun userSeenOnBoard() {
        preferences.edit().putBoolean("userSeen", true).apply()
    }

    fun isUserSeen(): Boolean {
        return preferences.getBoolean("userSeen", false)
    }
}