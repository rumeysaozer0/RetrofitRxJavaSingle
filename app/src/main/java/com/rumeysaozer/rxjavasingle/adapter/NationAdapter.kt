package com.rumeysaozer.rxjavasingle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.rxjavasingle.databinding.ItemRowBinding
import com.rumeysaozer.rxjavasingle.model.NationItem
import com.rumeysaozer.rxjavasingle.view.NationFragmentDirections

class NationAdapter(val nationList : ArrayList<NationItem>): RecyclerView.Adapter<NationAdapter.NationHolder>() {
    class NationHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NationHolder {
     val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NationHolder(binding)
    }

    override fun onBindViewHolder(holder: NationHolder, position: Int) {
        holder.binding.textView.text = nationList[position].nationality
        holder.itemView.setOnClickListener {
            val action = NationFragmentDirections.actionNationFragmentToNationDetailsFragment(nationList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
     return nationList.size
    }
}