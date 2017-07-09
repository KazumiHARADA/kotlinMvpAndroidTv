package com.android.kharada.kotlinmvpandroidtv.ui.base

interface BaseMvpPresenter<in V : BaseMvpView> {
    fun attachView(view: V)

    fun detachView()
}