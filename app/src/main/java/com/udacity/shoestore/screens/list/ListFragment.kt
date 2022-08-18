package com.udacity.shoestore.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.list_fragment, container, false)

        binding.listButton.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        }
        return binding.root
    }
}