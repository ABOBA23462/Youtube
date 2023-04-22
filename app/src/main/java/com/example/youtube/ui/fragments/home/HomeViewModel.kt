package com.example.youtube.ui.fragments.home

import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.repositories.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: VideoRepository
) : BaseViewModel() {

    fun fetchVideo() = repository.fetchVideo()
}