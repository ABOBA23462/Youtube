package com.example.youtube.data.repositories.pagingsource

import android.net.Uri
import com.example.youtube.base.BasePagingSource
import com.example.youtube.data.remote.apiservice.VideoApiService
import com.example.youtube.models.VideoModel

private const val VIDEO_PAGE = 1

class VideoPagingSource(private val service: VideoApiService) : BasePagingSource<VideoModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoModel> {
        return try {
            val nextPage = params.key ?: VIDEO_PAGE
            val response = service.fetchVideo()
            val nextPages =
                Uri.parse(response.items.toString()).getQueryParameter("page[offset]")!!.toInt()

            LoadResult.Page(
                data = response.items,
                prevKey = if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}