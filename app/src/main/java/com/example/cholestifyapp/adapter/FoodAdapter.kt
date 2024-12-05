package com.example.cholestifyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cholestifyapp.R
import com.example.cholestifyapp.data.response.DataItem

class FoodAdapter(private var foodList: List<DataItem?>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkbox_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_add_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodList[position]
        holder.tvItemName.text = foodItem?.food ?: "Unknown Food"
        holder.checkBox.isChecked = false // Sesuaikan jika ada logika tambahan
    }

    override fun getItemCount(): Int = foodList.size

    fun updateData(newFoodList: List<DataItem?>) {
        this.foodList = newFoodList
        notifyDataSetChanged()
    }
}