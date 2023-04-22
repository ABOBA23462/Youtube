package com.example.youtube.ui.fragments.home


import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentHomeBinding
import com.example.youtube.ui.adapters.VideoAdapter
import com.example.youtube.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val videoAdapter = VideoAdapter()

    override fun initialize() {
        binding.rvVideo.adapter = videoAdapter
    }

    override fun setupSubscribes() {
        subscribeToVideo()
    }

    private fun subscribeToVideo() {
        viewModel.fetchVideo().observe(viewLifecycleOwner){
            when(it){
                is Resource.Error -> {
                    Log.e("anime", it.message.toString())
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    videoAdapter.submitList(it.data?.items)
                }
            }
        }
    }
}