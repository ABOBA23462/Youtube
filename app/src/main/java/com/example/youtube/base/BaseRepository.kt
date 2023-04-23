package com.example.youtube.base

import androidx.lifecycle.liveData

abstract class BaseRepository {

//    fun <T> doRequest(request: suspend () -> T) = liveData {
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success(request()))
//        } catch (exception: Exception) {
//            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
//        }
//    }
}
