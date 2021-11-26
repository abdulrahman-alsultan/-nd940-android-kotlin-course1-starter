package com.udacity.shoestore.ViewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MyViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    init{
        _shoeList.value = mutableListOf(
            Shoe("ALTASPORT SHOES", 7.5, "Adidas", "They'll be ready for school or play in these classic court-inspired kids' shoes. Built to last, the sneakers have a flexible synthetic leather upper and a breathable mesh tongue. Hook-and-loop straps let your young adventurer get them on and off in a flash.")
        )
    }

    fun add(name: String, size: Double, company: String, description: String){
        _shoeList.value?.add(Shoe(name, size, company, description))
    }

    fun getShoeList(): LiveData<MutableList<Shoe>>{
        return _shoeList
    }

    fun clear(){
        _shoeList.value = mutableListOf()
    }

}