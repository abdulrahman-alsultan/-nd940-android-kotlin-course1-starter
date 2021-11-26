package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.transaction
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.activity_main.*

class Welcome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        val act = activity as MainActivity

        act.toolbar.title = "Welcome"


        binding.btnWelcomeNavigate.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_instruction)
        }

        val backButton = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backButton)



        return binding.root
    }



}