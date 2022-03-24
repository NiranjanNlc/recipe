package com.example.recipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.databinding.FullRecipeBinding
import com.example.recipe.modal.dataItem.Meal
import com.example.recipe.modal.repo.RecipeRepo
import com.example.recipe.modal.reterofit.RetrofitService
import com.example.recipe.util.InstructionFormatter
import com.example.recipe.viewmodal.ReciepeViewModal
import com.example.recipe.viewmodal.ViewModalFactory


class ReciepeFragment(val reciepeid: String) : Fragment() {
    private lateinit var sampleViewModal: ReciepeViewModal
    private lateinit var binding: FullRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.full_recipe)
        sampleViewModal = initialiseViewModal()
        observeChange()
        return inflater.inflate(R.layout.full_recipe, container, false)
    }

    private fun initialiseViewModal(): ReciepeViewModal {
        val repository = RecipeRepo(RetrofitService.getInstance())
        return ViewModalFactory(repository).create(ReciepeViewModal::class.java)
    }

    private fun observeChange() {

        sampleViewModal.getReciepeParticular(reciepeid)
        sampleViewModal.reciepe.observe(this, {
            println(" this data " + sampleViewModal.reciepe.value.toString())
            val meal = sampleViewModal.reciepe.value
            if (meal != null) {
                setTheUi(meal.meals[0])
                InstructionFormatter.formatInstruction(meal.meals[0])
            }
        }
        )
    }

    private fun setTheUi(meal: Meal) {
        setImage(meal.strMealThumb)
        binding.toolbarLayout.title = meal.strMeal
        binding.toolbarLayout.setCollapsedTitleTextColor(1222222222)
        binding.instructions.text = meal.strInstructions

    }

    private fun setImage(strMealThumb: String) {
        context?.let { Glide.with(it).load(strMealThumb).into(binding.expandedImage) };
    }
}