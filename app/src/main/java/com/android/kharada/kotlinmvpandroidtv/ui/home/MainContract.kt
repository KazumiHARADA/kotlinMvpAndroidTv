package com.android.kharada.kotlinmvpandroidtv.ui.home

import com.android.kharada.kotlinmvpandroidtv.model.Movie
import com.android.kharada.kotlinmvpandroidtv.ui.base.BaseMvpPresenter
import com.android.kharada.kotlinmvpandroidtv.ui.base.BaseMvpView

/**
 * Created by haradakazumi on 2017/07/09.
 */

object MainContract {

    interface View : BaseMvpView {
        fun showList(list:List<Movie>)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadList()
    }
}