package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.ViewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*


class ShoeList : Fragment() {

    private val myViewModel by lazy { ViewModelProvider(requireActivity()).get(MyViewModel::class.java) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        val act = activity as MainActivity
        act.toolbar.title = "Shoes display"

        setHasOptionsMenu(true)
        act.toolbar.menu.clear()
        act.toolbar.inflateMenu(R.menu.menu)
        act.toolbar.setOnMenuItemClickListener {
            myViewModel.clear()
            findNavController().navigate(ShoeListDirections.actionShoeListToLogin())
            true
        }

        act.toolbar.navigationIcon = null

        val backButton = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backButton)

        myViewModel.getShoeList().observe(viewLifecycleOwner, Observer { shoes ->
            for (s in shoes) {
                val ll = LayoutInflater.from(requireContext()).inflate(R.layout.shoe_item, binding.llShoeListDisplayList, false)

                val name = ll.findViewById<TextView>(R.id.tv_item_name)
                val size = ll.findViewById<TextView>(R.id.tv_item_size)
                val company = ll.findViewById<TextView>(R.id.tv_item_company)
                val description = ll.findViewById<TextView>(R.id.tv_item_description)

                name.text = s.name
                size.text = "Size: ${s.size}"
                company.text = "Company: ${s.company}"
                description.text = "Description: ${s.description}"
                binding.llShoeListDisplayList.addView(ll)
            }
        })

        binding.fabShoeListOpenDetailsFragment.setOnClickListener {
            findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
        }

        return binding.root
    }

}