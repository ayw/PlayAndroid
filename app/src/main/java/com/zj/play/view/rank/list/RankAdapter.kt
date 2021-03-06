package com.zj.play.view.rank.list

import android.content.Context
import android.widget.TextView
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import com.zj.play.R
import com.zj.play.model.DataX
import java.util.*

class RankAdapter(context: Context, layoutId: Int, rankList: ArrayList<DataX>) :
    CommonAdapter<DataX>(context, layoutId, rankList) {
    override fun convert(holder: ViewHolder, t: DataX, position: Int) {
        val rankAdTvUsername = holder.getView<TextView>(R.id.rankAdTvUsername)
        val rankAdTvRank = holder.getView<TextView>(R.id.rankAdTvRank)
        val rankAdTvCoinCount = holder.getView<TextView>(R.id.rankAdTvCoinCount)
        val rankAdTvLevel = holder.getView<TextView>(R.id.rankAdTvLevel)
        rankAdTvUsername.text = t.username
        rankAdTvRank.text = "第${t.rank}名"
        rankAdTvCoinCount.text = "${t.coinCount}积分"
        rankAdTvLevel.text = "${t.level}级"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}
