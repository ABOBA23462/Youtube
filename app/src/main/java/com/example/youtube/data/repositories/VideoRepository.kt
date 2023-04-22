package com.example.youtube.data.repositories

import com.example.youtube.base.BaseRepository
import com.example.youtube.data.remote.apiservice.VideoApiService
import javax.inject.Inject

class VideoRepository @Inject constructor(private val service: VideoApiService) : BaseRepository() {

    fun fetchVideo() = doRequest {
        service.fetchVideo()
    }
}