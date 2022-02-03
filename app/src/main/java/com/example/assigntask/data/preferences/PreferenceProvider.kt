package com.example.assigntask.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferenceProvider
@Inject
constructor(
    @ApplicationContext private val context: Context
){
    companion object {

        const val USER_NAME = "userId"
        const val IS_LOGGED_IN = "isLoggedIn"
        const val USER_KEY = "userKey"
        const val USER_TYPE = "userType"

        // default value
        const val DFT_IS_LOGGED_IN: Boolean = false
        val DFT_USER_NAME: String? = null
        val DFT_USER_KEY: String? = null
        val DFT_USER_TYPE: String? = null

    }
    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(context)


    fun saveUserName(user_name: String?) {
        preference.edit().putString(
            USER_NAME,
            user_name
        ).apply()
    }

    fun getUserName(): String? {
        return preference.getString(USER_NAME, DFT_USER_NAME)
    }

    fun saveUserKey(user_key: String?) {
        preference.edit().putString(
            USER_KEY,
            user_key
        ).apply()
    }

    fun getUserKey(): String? {
        return preference.getString(USER_KEY, DFT_USER_KEY)
    }
    //
    fun saveUserType(user_type: String?) {
        preference.edit().putString(
            USER_TYPE,
            user_type
        ).apply()
    }

    fun getUserType(): String? {
        return preference.getString(USER_TYPE, DFT_USER_TYPE)
    }



    fun saveIsLoggedIn(is_logged_in: Boolean) {
        preference.edit().putBoolean(
            IS_LOGGED_IN,
            is_logged_in
        ).apply()
    }

    fun getIsLoggedIn(): Boolean {
        return preference.getBoolean(IS_LOGGED_IN, DFT_IS_LOGGED_IN)
    }

}