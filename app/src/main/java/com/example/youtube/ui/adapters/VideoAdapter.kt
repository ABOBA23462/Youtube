package com.example.youtube.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.databinding.ItemHomeBinding
import com.example.youtube.models.VideoModel
import com.example.youtube.utils.imageviewextension.setImage

class VideoAdapter :PagingDataAdapter<VideoModel, VideoAdapter.ViewHolder>(
    VideoDiffCallback()
) {

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: VideoModel?) = with(binding) {
            tvAuthorName.text = item?.snippet?.channelTitle
            ivCover.setImage(item!!.snippet.thumbnails.url)
            tvName.text = item.snippet.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    private class VideoDiffCallback : DiffUtil.ItemCallback<VideoModel>(){
    override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
        return oldItem == newItem
    }
    }
}