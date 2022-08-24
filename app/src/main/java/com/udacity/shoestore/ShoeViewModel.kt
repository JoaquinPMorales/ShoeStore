package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.*

class ShoeViewModel : ViewModel() {
    private val _listOfShoes = MutableLiveData<Vector<Shoe>>()

    val listOfShoes : LiveData<Vector<Shoe>>
        get() = _listOfShoes

    fun addNewShoe(newShoe : Shoe)
    {
        _listOfShoes.value?.add(newShoe)
    }
}