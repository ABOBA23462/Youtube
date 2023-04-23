package com.example.youtube.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.youtube.base.BaseRepository
import com.example.youtube.data.remote.apiservice.VideoApiService
import com.example.youtube.data.repositories.pagingsource.VideoPagingSource
import javax.inject.Inject

class VideoRepository @Inject constructor(private val service: VideoApiService) {

    fun fetchVideo() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        VideoPagingSource(service)
    }.liveData
}