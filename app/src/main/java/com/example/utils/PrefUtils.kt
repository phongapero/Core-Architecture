package com.example.utils

import android.content.SharedPreferences
import java.util.*
import javax.inject.Inject

class PrefUtils @Inject constructor(private val sharedPreferences: SharedPreferences) {
    companion object {
        const val PREF_NAME = "blood_pressure_pref"

        // Ket local
        const val KEY_LANGUAGE_FIRST_OPEN = "KEY_LANGUAGE_FIRST_OPEN"
        const val KEY_ONBOARDING_FIRST_OPEN = "KEY_ONBOARDING_FIRST_OPEN"
        const val KEY_CURRENT_LANGUAGE = "KEY_CURRENT_LANGUAGE"
        const val KEY_PROFILE_ID = "KEY_PROFILE_ID"

        // Key remote
        const val REMOTE_SHOW_AD_NATIVE_LANGUAGE_FIRST_OPEN = "native_language_first_open"
        const val REMOTE_SHOW_AD_OPEN_RESUME = "appopen_resume"
        const val REMOTE_SHOW_NATIVE_LANGUAGE = "REMOTE_SHOW_NATIVE_LANGUAGE"
    }

    var profileId: Long
        get() = sharedPreferences.getLong(KEY_PROFILE_ID, -1L)
        set(value) {
            sharedPreferences.edit().putLong(KEY_PROFILE_ID, value).apply()
        }

    var isShowNativeLanguage: Boolean
        get() = sharedPreferences.getBoolean(REMOTE_SHOW_NATIVE_LANGUAGE, true)
        set(value) {
            sharedPreferences.edit()?.putBoolean(REMOTE_SHOW_NATIVE_LANGUAGE, value)?.apply()
        }

    var isShowAdResume: Boolean
        get() = sharedPreferences.getBoolean(REMOTE_SHOW_AD_OPEN_RESUME, true)
        set(value) {
            sharedPreferences.edit()?.putBoolean(REMOTE_SHOW_AD_OPEN_RESUME, value)?.apply()
        }

    var isShowLanguageFirstOpen: Boolean
        get() = sharedPreferences.getBoolean(KEY_LANGUAGE_FIRST_OPEN, true)
        set(value) {
            sharedPreferences.edit()?.putBoolean(KEY_LANGUAGE_FIRST_OPEN, value)?.apply()
        }

    var isShowOnBoardingFirstOpen: Boolean
        get() = sharedPreferences.getBoolean(KEY_ONBOARDING_FIRST_OPEN, true)
        set(value) {
            sharedPreferences.edit()?.putBoolean(KEY_ONBOARDING_FIRST_OPEN, value)?.apply()
        }

    var isShowNativeLanguageFirstOpen: Boolean
        get() = sharedPreferences.getBoolean(REMOTE_SHOW_AD_NATIVE_LANGUAGE_FIRST_OPEN, true)
            ?: true
        set(value) {
            sharedPreferences.edit()?.putBoolean(REMOTE_SHOW_AD_NATIVE_LANGUAGE_FIRST_OPEN, value)
                ?.apply()
        }

    var currentLanguage: String
        get() = sharedPreferences.getString(KEY_CURRENT_LANGUAGE, Locale.getDefault().language)
            ?: Locale.getDefault().language
        set(value) {
            sharedPreferences.edit()?.putString(KEY_CURRENT_LANGUAGE, value)?.apply()
        }
}