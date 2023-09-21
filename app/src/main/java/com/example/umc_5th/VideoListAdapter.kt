package com.example.umc_5th

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class VideoListAdapter(val list: Array<Pair<String,String>>): RecyclerView.Adapter<VideoListAdapter.VideoListViewHolder>() {
    override fun getItemCount(): Int {
        return list.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.video_list_item, parent, false)
        return VideoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoListViewHolder, position: Int) {
        holder.musicItemTile.text = list[position].first
        holder.musicItemSinger.text = list[position].second
    }
    inner class VideoListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var musicItemTile: TextView = view.findViewById(R.id.music_name)
        var musicItemSinger: TextView = view.findViewById(R.id.music_singer_name)
    }
}