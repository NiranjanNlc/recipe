package com.example.recipe.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.databinding.ItemRecipeBinding
import com.example.recipe.modal.dataItem.MealItem

class ReciepeListAdapter:
    ListAdapter<MealItem,ReciepeListAdapter.RecipeListViewHolder> (MEAL_COMPARATOR)
{

    class RecipeListViewHolder(var items: ItemRecipeBinding) : RecyclerView.ViewHolder(items.root)
    {
        fun bind(mealItem: MealItem)
        {
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder
    {
        println("On view create ")
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecipeBinding.inflate(inflater)
        return RecipeListViewHolder(binding)

    }
  override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int)
  {
      val mealItem = getItem(position)
      println( " see thid " + mealItem.strMeal)
      holder.bind(mealItem)
     //  holder.bind(getItem(position))
      //holder.items.items = getItem(position)
    //  holder.items.items = getItem(position)
      holder.items.executePendingBindings()
  }

}