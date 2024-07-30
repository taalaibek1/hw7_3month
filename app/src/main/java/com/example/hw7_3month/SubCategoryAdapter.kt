package com.example.hw7_3month

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw7_3month.databinding.ItemSubCategoryBinding

class SubCategoryAdapter(private val subCategories: List<String>) :
    RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    inner class SubCategoryViewHolder(private val binding: ItemSubCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(subCategory: String) {
            binding.apply {
                subCategoryName.text = subCategory
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val binding = ItemSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.bind(subCategories[position])
    }

    override fun getItemCount(): Int = subCategories.size
}
