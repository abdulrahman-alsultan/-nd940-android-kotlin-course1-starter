package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import kotlinx.android.synthetic.main.activity_main.*

class Instruction : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Instructions"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )
        val act = activity as MainActivity

        act.toolbar.title = "Instruction"

        val backButton = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backButton)

        binding.btnInstructionOpenApp.setOnClickListener {
            findNavController().navigate(R.id.action_instruction_to_shoeList)
        }


        return binding.root
    }
}