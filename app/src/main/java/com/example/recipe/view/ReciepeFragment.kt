package com.example.recipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipe.R
import com.example.recipe.modal.repo.RecipeRepo
import com.example.recipe.modal.reterofit.RetrofitService
import com.example.recipe.util.InstructionFormatter
import com.example.recipe.viewmodal.ReciepeViewModal
import com.example.recipe.viewmodal.ViewModalFactory


class ReciepeFragment : Fragment()
{
    private lateinit var sampleViewModal:ReciepeViewModal
    private lateinit var binding:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
           sampleViewModal= initialiseViewModal()
          observeChange()
        return inflater.inflate(R.layout.full_recipe, container, false)
    }
    private fun initialiseViewModal(): ReciepeViewModal {
        val repository = RecipeRepo(RetrofitService.getInstance())
        val sampleViewModal = ViewModalFactory(repository).create(ReciepeViewModal::class.java)
        return sampleViewModal
    }
    private fun observeChange() {

        sampleViewModal.getReciepeParticular("52807")
        sampleViewModal.reciepe.observe(this, {
            println(" this data " + sampleViewModal.reciepe.value.toString())
            val meal  = sampleViewModal.reciepe.value
            if (meal != null) {
                setTheUi()
                InstructionFormatter.formatInstruction(meal.meals[0])
            }
        }
        )
    }

    private fun setTheUi() {


    }
}