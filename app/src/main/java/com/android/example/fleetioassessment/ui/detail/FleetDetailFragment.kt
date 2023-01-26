package com.android.example.fleetioassessment.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android.example.fleetioassessment.databinding.FragmentDetailBinding

class FleetDetailFragment: Fragment() {

    private val args by navArgs<FleetDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.vehicle = args.selectedFleet

        return binding.root
    }
}