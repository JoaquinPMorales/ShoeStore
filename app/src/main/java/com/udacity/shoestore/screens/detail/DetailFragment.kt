package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: DetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.detail_fragment, container, false)

        binding.saveButton.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
        }

        return binding.root
    }
}