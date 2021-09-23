package com.example.recipe.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.modal.dataItem.MealItem

class ReciepeListAdapter:
    ListAdapter<MealItem,ReciepeListAdapter.RecciepeListViewHolder> (MEAL_COMPARATOR)
{

    class RecciepeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecciepeListViewHolder
    {
        TODO("Not yet implemented")
    }
  override fun onBindViewHolder(holder: RecciepeListViewHolder, position: Int)
  {
        TODO("Not yet implemented")
  }

}