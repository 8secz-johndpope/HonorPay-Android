package com.freeworldone.honorpay.ui.base.extensions

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
import android.view.View
import com.freeworldone.honorpay.appContext

fun array(@ArrayRes array: Int): Array<String> = appContext.resources.getStringArray(array)
fun color(@ColorRes resId: Int) = ContextCompat.getColor(appContext, resId)
fun drawable(@DrawableRes resId: Int, @ColorInt color: Int = 0, isMutate: Boolean = false): Drawable? = if (resId == 0) null else
    AppCompatResources.getDrawable(appContext, resId)
            ?.let { if (isMutate) it.mutate() else it }
            ?.apply { if (color != 0) setColorFilter(color, PorterDuff.Mode.SRC_IN) }

fun string(@StringRes resId: Int, vararg args: Any): String = if (resId == 0) "" else appContext.getString(resId, *args)
fun dimen(@DimenRes resId: Int) = appContext.resources.getDimensionPixelSize(resId)

fun dp(dp: Int) = dpF(dp).toInt()
fun dpF(dp: Int) = dp * appContext.resources.displayMetrics.density
fun plural(@PluralsRes resId: Int, quantity: Int, arg1: Any? = null, arg2: Any? = null): String =
        when {
            resId == 0 -> ""
            arg1 != null && arg2 != null -> appContext.resources.getQuantityString(resId, quantity, arg1, arg2)
            arg1 != null -> appContext.resources.getQuantityString(resId, quantity, arg1)
            else -> appContext.resources.getQuantityString(resId, quantity)
        }

fun sp(sp: Int) = spF(sp).toInt()
fun spF(sp: Int) = sp * appContext.resources.displayMetrics.scaledDensity


fun View.array(@ArrayRes array: Int): Array<String> = resources.getStringArray(array)
fun View.color(@ColorRes resId: Int) = ContextCompat.getColor(context, resId)
fun View.drawable(@DrawableRes resId: Int, @ColorInt color: Int = 0, isMutate: Boolean = false): Drawable? = if (resId == 0) null else
    AppCompatResources.getDrawable(context, resId)
            ?.let { if (isMutate) it.mutate() else it }
            ?.apply { if (color != 0) setColorFilter(color, PorterDuff.Mode.SRC_IN) }

fun View.string(@StringRes resId: Int, vararg args: Any): String = if (resId == 0) "" else resources.getString(resId, *args)
fun View.dimen(@DimenRes resId: Int) = resources.getDimensionPixelSize(resId)

fun View.dp(dp: Int) = dpF(dp).toInt()
fun View.dpF(dp: Int) = dp * resources.displayMetrics.density
fun View.plural(@PluralsRes resId: Int, quantity: Int, arg1: Any? = null, arg2: Any? = null): String =
        when {
            resId == 0 -> ""
            arg1 != null && arg2 != null -> resources.getQuantityString(resId, quantity, arg1, arg2)
            arg1 != null -> resources.getQuantityString(resId, quantity, arg1)
            else -> resources.getQuantityString(resId, quantity)
        }

fun View.sp(sp: Int) = spF(sp).toInt()
fun View.spF(sp: Int) = sp * resources.displayMetrics.scaledDensity