package com.xapo.github.screens.main

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.xapo.github.R
import com.xapo.github.utils.base.BaseActivity
import com.xapo.github.views.LoadingLayout

class MainActivity : BaseActivity() {


    @BindView(R.id.ll)
    lateinit var ll:LoadingLayout
    @BindView(R.id.rv_github_repos)
    lateinit var rv:RecyclerView
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
    }
}
