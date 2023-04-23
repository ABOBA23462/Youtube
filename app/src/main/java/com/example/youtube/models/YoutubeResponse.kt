package com.example.youtube.models

import com.google.gson.annotations.SerializedName

data class YoutubeResponse<T>(
    @SerializedName("items")
    val items: List<T>,
    @SerializedName("nextPageToken")
    val nextPageToken: String,
    @SerializedName("prevPageToken")
    val prevPageToken: String,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo
)

data class PageInfo(
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int,
)