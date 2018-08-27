package com.xapo.github.screens.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.xapo.github.R
import com.xapo.github.remote.models.Trend

class Adapter(private val context: Context, private val trends: MutableList<Trend>) : RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.trend_row, parent, false))
    }

    override fun getItemCount(): Int = trends.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val trend = trends[position]
        holder.author.text = trend.author
        holder.description.text = trend.description
        holder.startCount.text = trend.currentPeriodStars.toString()
        Glide.with(context).
    }


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.avatar)
        lateinit var avatar: ImageView

        @BindView(R.id.author)
        lateinit var author: TextView
        @BindView(R.id.description)
        lateinit var description: TextView
        @BindView(R.id.star_count)
        lateinit var startCount: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

    }

}