package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class DetailFragment : Fragment() {

    var shoeObject = Shoe();

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: DetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.detail_fragment, container, false)
        //viewModel = (requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel = viewModel
        binding.shoeData = shoeObject
        binding.setLifecycleOwner(this)

        /*binding.saveButton.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
            viewModel.addNewShoe(shoeObject)
            Log.i("DetailFragment", shoeObject.toString())
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
        }*/

        viewModel.eventShoeAdded.observe(this, Observer { shoeAdded ->
            if(shoeAdded)
            {
                Log.i("DetailFragment", "Shoe added observed flag")
                viewModel.addNewShoe(shoeObject)
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
            }
        })

        viewModel.eventShoeCancelled.observe(this, Observer { shoeCancelled ->
            if(shoeCancelled) {
                Log.i("DetailFragment", "Shoe cancelled observed flag")
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
                viewModel.newShoeCancelled()
            }
        })

        return binding.root
    }
}