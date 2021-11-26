package com.udacity.shoestore.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ShoeDetail : Fragment() {

    private val myViewModel by lazy { ViewModelProvider(requireActivity()).get(MyViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        val act = activity as MainActivity

        act.toolbar.title = "Add new Shoe"
        act.toolbar.menu.clear()
        act.toolbar.inflateMenu(R.menu.menu)
        act.toolbar.setOnMenuItemClickListener {
            myViewModel.clear()
            findNavController().navigate(ShoeDetailDirections.actionShoeDetailToLogin())
            true
        }
        act.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        act.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        setHasOptionsMenu(true)

        binding.btnShoeDetailAdd.setOnClickListener {
            if(binding.edShoeDetailName.text.isNotEmpty() && binding.edShoeDetailCompany.text.isNotEmpty() && binding.edShoeDetailSize.text.isNotEmpty() && binding.edShoeDetailDescription.text.isNotEmpty()){
                myViewModel.add(binding.edShoeDetailName.text.toString(), binding.edShoeDetailSize.text.toString().toDouble(), binding.edShoeDetailCompany.text.toString(), binding.edShoeDetailDescription.text.toString())
                Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_LONG).show()
                findNavController().popBackStack()
            }
            else{
                Toast.makeText(requireContext(), "All fields are requirements", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnShoeDetailCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}