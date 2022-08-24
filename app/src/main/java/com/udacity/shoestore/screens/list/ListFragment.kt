package com.udacity.shoestore.screens.list

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.list_fragment, container, false)

        binding.shoeViewModel = viewModel

        setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)

        binding.listButton.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        }

        viewModel.listOfShoes.observe(viewLifecycleOwner, Observer { shoeList ->
            Log.i("ListFragment", "show list changed")
            Log.i("ListFragment", "Shoe list size: ${shoeList.size}")
            shoeList.forEach {
                Log.i("ListFragment", "Shoe toString: ${it.toString()}")
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater = inflater
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.logout_item -> {
                findNavController().navigate(ListFragmentDirections.actionListFragmentToLoginFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}