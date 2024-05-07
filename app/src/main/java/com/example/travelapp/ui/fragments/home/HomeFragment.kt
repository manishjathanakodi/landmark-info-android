package com.example.travelapp.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelapp.databinding.FragmentHomeBinding
import com.example.travelapp.ui.fragments.BaseFragment

class HomeFragment: BaseFragment() {
    private var _binding: FragmentHomeBinding? = null
    private  val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = binding.homeRv
        val homeAdapter = HomeFragmentAdapter { attractionId ->
            val navDirections = HomeFragmentDirections.actionHomeFragmentToAttractionDetailFragments(attractionId)
            navController.navigate(navDirections)

        }
        rv.adapter = homeAdapter
        homeAdapter.setData(attractions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}