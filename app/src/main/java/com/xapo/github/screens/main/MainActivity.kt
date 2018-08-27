package com.xapo.github.screens.main

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import com.xapo.github.R
import com.xapo.github.remote.models.Trend
import com.xapo.github.utils.GeneralApiException
import com.xapo.github.utils.base.BaseActivity
import com.xapo.github.views.LoadingLayout
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    private val trendList: MutableList<Trend> = ArrayList()

    override fun onShow(toList: List<Trend>) {
        trendList.addAll(toList)

        ll.state = LoadingLayout.STATE_SHOW_DATA
    }

    override fun onError(generalApiException: GeneralApiException?) {
        ll.setError(generalApiException?.message() ?: "an error has occurred")
        ll.setListener(View.OnClickListener {
            presenter.getRepositories()
        })
    }


    @BindView(R.id.ll)
    lateinit var ll: LoadingLayout
    @BindView(R.id.rv_github_repos)
    lateinit var rv: RecyclerView
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv.itemAnimator = DefaultItemAnimator()

    }
}
