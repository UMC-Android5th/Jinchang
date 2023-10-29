package com.example.umc_5th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_5th.databinding.FragmentBannerBinding

class BannerFragment(val imgRes :Int) : Fragment() {
    private var _binding: FragmentBannerBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBannerBinding.inflate(inflater,container,false)
        binding.bannerImageIv.setImageResource(imgRes)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}