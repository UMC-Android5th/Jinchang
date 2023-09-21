package com.example.umc_5th

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PotCastListAdapter(val list: Array<Pair<String,String>>): RecyclerView.Adapter<PotCastListAdapter.PotCastListViewHolder>() {
    override fun getItemCount(): Int {
        return list.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotCastListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.potcast_list_item, parent, false)
        return PotCastListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PotCastListViewHolder, position: Int) {
        holder.musicItemTile.text = list[position].first
        holder.musicItemSinger.text = list[position].second
    }
    inner class PotCastListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var musicItemTile: TextView = view.findViewById(R.id.music_name)
        var musicItemSinger: TextView = view.findViewById(R.id.music_singer_name)
    }
}