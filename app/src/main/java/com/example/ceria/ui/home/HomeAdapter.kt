package com.example.ceria.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ceria.R
import com.example.ceria.data.local.entity.HomeEntity
import com.example.ceria.databinding.ListPromoHomeBinding

class HomeAdapter : ListAdapter<HomeEntity, HomeAdapter.ViewHolder>(HomeDiffCallback()) {

    private lateinit var viewHolder: ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        viewHolder = ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_promo_home, parent, false), parent.context)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ListPromoHomeBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeEntity) {
//            binding.setClickListener { view ->
//                navigateToUsers(item, view)
//            }
            with(binding) {
//                setItem(item)
                executePendingBindings()
            }
        }

//        private fun navigateToUsers(item: Item, view: View) {
//            val direction =
//                BiddingFragmentDirections.actionBiddingToBiddingDetail(offer)
//            view.findNavController().navigate(direction)
//        }
    }
}

private class HomeDiffCallback : DiffUtil.ItemCallback<HomeEntity>() {
    override fun areItemsTheSame(oldItem: HomeEntity, newItem: HomeEntity): Boolean {
        return oldItem.name == newItem.name

    }

    override fun areContentsTheSame(oldItem: HomeEntity, newItem: HomeEntity): Boolean {
        return oldItem == newItem
    }
}