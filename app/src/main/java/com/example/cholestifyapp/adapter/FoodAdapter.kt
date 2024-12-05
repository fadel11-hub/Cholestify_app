package com.example.cholestifyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cholestifyapp.data.response.DataItem
import com.example.cholestifyapp.databinding.ItemAddFoodBinding

class FoodAdapter(private val foodList: List<DataItem>, private val onItemClick: (DataItem) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    // Menyimpan daftar makanan yang diterima dari ViewModel
    private var foods = foodList

    // Mengupdate data makanan pada adapter
    fun updateData(newFoods: List<DataItem>) {
        foods = newFoods
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemAddFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int = foods.size

    inner class FoodViewHolder(private val binding: ItemAddFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: DataItem) {
            binding.tvItemName.text = food.food // Mengambil nama makanan dari data dan mengikat ke TextView
            binding.checkboxItem.setOnCheckedChangeListener { _, isChecked ->
                // Bisa tambahkan aksi ketika checkbox dicentang (misalnya menyimpan status)
            }
            binding.root.setOnClickListener {
                onItemClick(food) // Menangani klik pada item
            }
        }
    }
}