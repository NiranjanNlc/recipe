package com.example.recipe.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.R
import com.example.recipe.databinding.ReciepeListBinding
import com.example.recipe.modal.repo.RecipeRepo
import com.example.recipe.modal.reterofit.RetrofitService
import com.example.recipe.viewmodal.ReciepeViewModal
import com.example.recipe.viewmodal.ViewModalFactory

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ReciepeListBinding
    private lateinit var sampleViewModal: ReciepeViewModal
    private var adapter:ReciepeListAdapter = ReciepeListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.reciepe_list)
       sampleViewModal = initialiseViewModal()
        bindData()
        observeChange()
        initRecyclerView()
    }

    private fun observeChange() {
       // sampleViewModal.getReciepeList()
        sampleViewModal.reciepList.observe(this, {
            println(" this data " + sampleViewModal.reciepList.value.toString())
            adapter.submitList(it.meals)
        })
//        sampleViewModal.getReciepeParticular("52807")
//        sampleViewModal.reciepe.observe(this, {
//            println(" this data " + sampleViewModal.reciepe.value.toString())
//        }
//        )
    }

    private fun initialiseViewModal(): ReciepeViewModal {
        val repository = RecipeRepo(RetrofitService.getInstance())
        val sampleViewModal = ViewModalFactory(repository).create(ReciepeViewModal::class.java)
        return sampleViewModal
    }
    private fun bindData()
    {  
        binding.lifecycleOwner=this
    }
 
    private fun initRecyclerView()
    {
        print(" recycler view initiated")
        binding.browserRecycler.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        binding.browserRecycler.setHasFixedSize(true)
        binding.browserRecycler.adapter=   adapter
        adapter.submitList(sampleViewModal.reciepList.value?.meals)
    }
}