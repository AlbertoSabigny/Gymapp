package com.mis.gymapp.ui.gym.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mis.gymapp.R
import com.mis.gymapp.domain.model.GymInfo

class GymAdapter(private var exercise_list: List<GymInfo> = emptyList(),
    private val onItemSelected: (GymInfo)-> Unit
    ):RecyclerView.Adapter<GymViewHolder>(){
    fun updteList(list: List<GymInfo>){
        exercise_list=list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymViewHolder {
        return GymViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        )
    }

    override fun getItemCount() = exercise_list.size
    override fun onBindViewHolder(holder: GymViewHolder, position: Int) {
        holder.render(exercise_list[position], onItemSelected)
    }
}