package com.example.youtube.ui.fragments.home

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.repositories.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: VideoRepository
) : BaseViewModel() {

    fun fetchVideo() = repository.fetchVideo().cachedIn(viewModelScope)
}