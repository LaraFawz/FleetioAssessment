package com.android.example.fleetioassessment.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.example.fleetioassessment.databinding.FleetItemViewBinding
import com.android.example.fleetioassessment.data.Vehicle
import com.android.example.fleetioassessment.util.FleetListener

class FleetAdapter (private val clickListener: FleetListener,
                    diffCallback: DiffUtil.ItemCallback<Vehicle>) :
    PagingDataAdapter<Vehicle, FleetAdapter.FleetViewHolder>(diffCallback) {

    object FleetComparator : DiffUtil.ItemCallback<Vehicle>() {
        override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
            // Id is unique.
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = FleetViewHolder( FleetItemViewBinding.inflate( LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: FleetViewHolder, position: Int) {
        val item = getItem(position)
        // Note that item may be null. ViewHolder must support binding a
        // null item as a placeholder.
        holder.also {
            it.itemView.setOnClickListener{
                clickListener.onClick(item)
            }
            it.bind(item!!)
        }
    }

    inner class FleetViewHolder(private val binding: FleetItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Vehicle) {
            with(binding) {
                fleetItem = item
            }
        }
    }

}