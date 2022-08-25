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

    private val _eventShoeAdded = MutableLiveData<Boolean>()

    val eventShoeAdded : LiveData<Boolean>
        get() = _eventShoeAdded

    private val _eventShoeCancelled = MutableLiveData<Boolean>()

    val eventShoeCancelled : LiveData<Boolean>
        get() = _eventShoeCancelled

    init {
        _eventShoeAdded.value = false
        _eventShoeCancelled.value = false

    }

    fun addNewShoe(newShoe : Shoe)
    {
        Log.i("ShoeViewModel", "AddNewShoe called with name: ${newShoe.getShoeName()}")
        mListOfShoes.add(newShoe)
        _listOfShoes.value = mListOfShoes
        newShoeAdded()
    }

    fun saveNewShoe()
    {
        _eventShoeAdded.value = true
    }

    fun newShoeAdded()
    {
        _eventShoeAdded.value = false
    }

    fun cancelNewShoe()
    {
        _eventShoeCancelled.value = true
    }

    fun newShoeCancelled()
    {
        _eventShoeCancelled.value = false
    }
}