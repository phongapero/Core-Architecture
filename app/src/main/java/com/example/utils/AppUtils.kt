package com.example.utils

import android.content.Context
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

object AppUtils {

    fun dpToPx(dp: Int, context: Context): Int =
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()

    internal fun Context.getDrawableCompat(@DrawableRes drawable: Int) =
        ContextCompat.getDrawable(this, drawable)

    internal fun Context.getColorCompat(@ColorRes color: Int) = ContextCompat.getColor(this, color)
}