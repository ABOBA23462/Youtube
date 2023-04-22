package com.example.youtube.models

import com.google.gson.annotations.SerializedName

data class YoutubeResponse<T>(
    @SerializedName("items")
    val items: List<T>
)
