package com.boydhogerheijde.android.weather.ui

/**
 * @author Boyd Hogerheijde.
 */
interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)
}