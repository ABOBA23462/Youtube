package com.example.youtube.ui.fragments.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentHomeBinding
import com.example.youtube.ui.adapters.VideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val videoAdapter = VideoAdapter()

    override fun initialize() {
        binding.rvVideo.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = videoAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchVideo().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                videoAdapter.submitData(it)
            }
        }
//        subscribeToVideo()
    }

//    private fun subscribeToVideo() {
//        viewModel.fetchVideo().observe(viewLifecycleOwner){
//            when(it){
//                is Resource.Error -> {
//                    Log.e("anime", it.message.toString  ())
//                }
//                is Resource.Loading -> {
//
//                }
//                is Resource.Success -> {
//                    Log.e("anime", it.message.toString  ())
//                    videoAdapter.submitData(it)
//                }
//            }
//        }
//    }
}