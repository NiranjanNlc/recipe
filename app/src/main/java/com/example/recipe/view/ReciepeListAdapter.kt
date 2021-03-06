package com.example.recipe.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe.databinding.ItemRecipeBinding
import com.example.recipe.modal.dataItem.MealItem

class ReciepeListAdapter constructor(
    val context: Context,
    val itemClickListener: ItemClickListener
) :
    ListAdapter<MealItem, ReciepeListAdapter.RecipeListViewHolder>(MEAL_COMPARATOR) {

    interface ItemClickListener {
        fun onItemClick(position: String)
    }

    inner class RecipeListViewHolder(var items: ItemRecipeBinding) :
        RecyclerView.ViewHolder(items.root) {
        init {
            items.root.setOnClickListener {
                items.items?.idMeal?.let { it1 -> itemClickListener.onItemClick(it1) }
            }
        }

        fun bind(mealItem: MealItem) {
            items.items = mealItem

        }

    }

    companion object {
        val MEAL_COMPARATOR = object : DiffUtil.ItemCallback<MealItem>() {
            override fun areItemsTheSame(oldItem: MealItem, newItem: MealItem): Boolean {
                println(" item same ")
                return oldItem == newItem;
            }

            override fun areContentsTheSame(oldItem: MealItem, newItem: MealItem): Boolean {
                print(" Content same ")
                return oldItem.idMeal.equals(newItem.idMeal)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        println("On view create ")
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecipeBinding.inflate(inflater)
        return RecipeListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        val mealItem = getItem(position)
        println(" see thid " + mealItem.strMeal)
        holder.bind(mealItem)
        Glide.with(context).load(mealItem.strMealThumb).into(holder.items.browserCellImage)
        holder.items.executePendingBindings()
    }

}