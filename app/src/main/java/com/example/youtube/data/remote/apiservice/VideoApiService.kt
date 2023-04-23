package com.example.youtube.data.remote.apiservice

import com.example.youtube.models.VideoModel
import com.example.youtube.models.YoutubeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApiService {

    @GET("videos")
    suspend fun fetchVideo(
        @Query("part") part: String = "snippet",
        @Query("id") id: String = "id"
    ): YoutubeResponse<VideoModel>
}