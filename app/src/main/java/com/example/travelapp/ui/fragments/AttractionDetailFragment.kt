package com.example.travelapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.travelapp.data.Attraction
import com.example.travelapp.databinding.FragmentAttractionDetailBinding
import com.squareup.picasso.Picasso

class AttractionDetailFragment: BaseFragment() {

    private var _binding: FragmentAttractionDetailBinding? = null
    private val binding get() = _binding!!

    private val safeArgs: AttractionDetailFragmentArgs by navArgs()

    private val attraction: Attraction by lazy {
        attractions.find { it.id == safeArgs.attractionId }!!
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttractionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleTv.text = attraction.title
        Picasso.get().load(attraction.image_urls[0]).into(binding.headerIv);
        binding.descriptionTv.text = attraction.description
        binding.monthsToVisitTv.text = attraction.months_to_visit
        binding.numOfFacts.text = "${attraction.facts.size} facts"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}