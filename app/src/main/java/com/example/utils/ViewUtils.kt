package com.example.utils

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.SystemClock
import android.text.TextPaint
import android.view.View
import android.widget.TextView

object ViewUtils {
    fun TextView.setGradiantText(start: String, end: String) {
        val paint: TextPaint = this.paint
        val width: Float = paint.measureText(this.text.toString())

        val textShader: Shader = LinearGradient(
            0f, 0f, width, this.textSize, intArrayOf(
                Color.parseColor(start), Color.parseColor(end)
            ), null, Shader.TileMode.CLAMP
        )
        this.paint.shader = textShader
    }

    fun View.isVisible(): Boolean {
        return this.visibility == View.VISIBLE
    }

    fun View.makeVisible() {
        this.visibility = View.VISIBLE
    }

    fun View.isGone(): Boolean {
        return this.visibility == View.GONE
    }

    fun View.makeGone() {
        this.visibility = View.GONE
    }

    fun View.isInvisible(): Boolean {
        return this.visibility == View.INVISIBLE
    }

    fun View.makeInvisible() {
        this.visibility = View.INVISIBLE
    }

    fun View.clickWithDebounce(debounceTime: Long = 500L, action: () -> Unit) {
        this.setOnClickListener(object : View.OnClickListener {
            private var lastClickTime: Long = 0
            override fun onClick(v: View) {
                if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
                else action()
                lastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }
}