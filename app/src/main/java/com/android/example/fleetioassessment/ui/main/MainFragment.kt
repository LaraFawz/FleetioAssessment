package com.android.example.fleetioassessment.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.example.fleetioassessment.FleetioApplication
import com.android.example.fleetioassessment.ViewModelFactory
import com.android.example.fleetioassessment.databinding.FragmentMainBinding
import com.android.example.fleetioassessment.util.FleetListener
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment: Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MainViewModel>

    private val viewModel: MainViewModel by lazy {
        viewModelFactory.get<MainViewModel>(
            requireActivity()
        )
    }

    lateinit var binding: FragmentMainBinding

    private val pagingAdapter = FleetAdapter(FleetListener { fleet ->
        viewModel.onFleetClicked(fleet)}, FleetAdapter.FleetComparator)

    override fun onCreate(savedInstanceState: Bundle?) {
        FleetioApplication.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        binding.swipeContainer.isEnabled = false

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.fleetRecyclerView.adapter = pagingAdapter
        initObservers()

    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getFleetList().observe(viewLifecycleOwner, {
                pagingAdapter.submitData(lifecycle, it)
                Log.e("MainFragment: ", "ViewModelResult: $it")
            })
        }


        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(MainFragmentDirections.actionShowDetail(it))
                viewModel.displayFleetDetailsComplete()
            }
        })
//        viewModel.performSearch()
//        when(val state =  viewModel.uiState){
//            is MainUiState.Error ->
//            MainUiState.Loading ->
//            is MainUiState.Success -> {
///                submitList()
//            }
//        }
    }

}