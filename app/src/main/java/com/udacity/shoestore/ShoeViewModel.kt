package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.*
import kotlin.collections.ArrayList

class ShoeViewModel : ViewModel() {
    private val _listOfShoes = MutableLiveData<ArrayList<Shoe>>()

    val listOfShoes : LiveData<ArrayList<Shoe>>
        get() = _listOfShoes

    private var mListOfShoes = ArrayList<Shoe>()

    fun addNewShoe(newShoe : Shoe)
    {
        Log.i("ShoeViewModel", "AddNewShoe called with name: ${newShoe.getShoeName()}")
        mListOfShoes.add(newShoe)
        _listOfShoes.value = mListOfShoes
    }
}