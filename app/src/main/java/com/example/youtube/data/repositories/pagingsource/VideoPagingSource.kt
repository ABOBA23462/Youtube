package com.example.youtube.data.repositories.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.youtube.data.remote.apiservice.VideoApiService
import com.example.youtube.models.VideoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val PAGE_TOKEN = ""

class VideoPagingSource(private val service: VideoApiService) : PagingSource<String, VideoModel>() {

    override fun getRefreshKey(state: PagingState<String, VideoModel>): String? {
        var current: String? = ""

        val anchorPosition = state.anchorPosition

        CoroutineScope(Dispatchers.IO).launch {
            if (anchorPosition != null) {
                current = state.closestPageToPosition(anchorPosition)?.prevKey?.let {
                    service.fetchVideo(
                        pageToken = it
                    ).nextPageToken
                }
            }
        }
        return current
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, VideoModel> {
        return try {
            val startPage = params.key ?: PAGE_TOKEN
            val response = service.fetchVideo(
                pageToken = startPage
            )
            val nextPage = if (response.items.isEmpty()) null else response.nextPageToken
            val prevPage = if (startPage == PAGE_TOKEN) null else response.prevPageToken

            LoadResult.Page(
                data = response.items,
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}