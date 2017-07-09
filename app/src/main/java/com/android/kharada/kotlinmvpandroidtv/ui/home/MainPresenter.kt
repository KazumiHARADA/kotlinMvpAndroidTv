package com.android.kharada.kotlinmvpandroidtv.ui.home

import android.support.v17.leanback.widget.ArrayObjectAdapter
import android.support.v17.leanback.widget.HeaderItem
import android.support.v17.leanback.widget.ListRow
import android.support.v17.leanback.widget.ListRowPresenter
import client.yalantis.com.githubclient.mvp.BaseMvpPresenterImpl
import com.android.kharada.kotlinmvpandroidtv.R
import com.android.kharada.kotlinmvpandroidtv.model.Movie
import com.android.kharada.kotlinmvpandroidtv.model.MovieList
import com.android.kharada.kotlinmvpandroidtv.model.MovieList.list
import com.android.kharada.kotlinmvpandroidtv.ui.view_presenter.CardPresenter
import java.util.*

/**
 * Created by haradakazumi on 2017/07/09.
 */
class MainPresenter :BaseMvpPresenterImpl<MainContract.View>(), MainContract.Presenter {

    override fun loadList() {
        val list: List<Movie> = MovieList.setupMovies()
        mView!!.showList(list)
    }
}