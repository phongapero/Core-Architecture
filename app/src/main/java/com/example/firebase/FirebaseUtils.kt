package com.example.firebase

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics

object FirebaseUtils {
    private var fbAnalytics: FirebaseAnalytics? = null

    fun init(context: Context?) {
        fbAnalytics = FirebaseAnalytics.getInstance(context!!)
    }

    const val KEY_CLICK_AUDIO = "key_click_audio"

    fun eventClickAudio() {
        fbAnalytics?.logEvent(KEY_CLICK_AUDIO, null)
    }
}