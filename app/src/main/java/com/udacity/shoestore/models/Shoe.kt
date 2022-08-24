package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String = "",
                var size: Double = 0.0,
                var company: String = "",
                var description: String = "")
    : Parcelable, BaseObservable() {

    @Bindable
    fun getShoeName() : String{
        return name;
    }

    fun setShoeName(shoeName : String) {
        name = shoeName;
        notifyPropertyChanged(BR.shoeName)
    }
    @Bindable
    fun getShoeSize() : Double{
        return size;
    }

    fun setShoeSize(shoeSize : Double) {
        size = shoeSize;
        notifyPropertyChanged(BR.shoeSize)
    }
    @Bindable
    fun getShoeCompany() : String{
        return company;
    }

    fun setShoeCompany(shoeCompany : String) {
        company = shoeCompany;
        notifyPropertyChanged(BR.shoeCompany)
    }

    @Bindable
    fun getShoeDescription() : String{
        return description;
    }

    fun setShoeDescription(shoeDescription : String) {
        description = shoeDescription;
        notifyPropertyChanged(BR.shoeDescription)
    }

    override fun toString(): String {
        var toStringShoeInfo = ""
        toStringShoeInfo = "Name: $name, Size: ${size.toString()}, Company: $company, description: $description"
        return toStringShoeInfo
    }
}