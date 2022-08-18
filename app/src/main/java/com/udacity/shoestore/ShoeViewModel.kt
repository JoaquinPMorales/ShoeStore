package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ShoeViewModel : ViewModel() {
    private val _listOfShoes = MutableLiveData<Vector<String>>()

    val listOfShoes : LiveData<Vector<String>>
        get() = _listOfShoes

    fun addNewShoe(newShoe : String)
    {
        _listOfShoes.value?.add(newShoe)
    }
}