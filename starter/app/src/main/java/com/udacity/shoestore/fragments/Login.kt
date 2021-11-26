package com.udacity.shoestore.fragments

import android.os.Bundle
import android.text.LoginFilter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.activity_main.*

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentLoginBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
                container,
                false
        )

        val act = activity as MainActivity

        act.toolbar.title = "Login/Create account"

        act.toolbar.title = "Instruction"

        val backButton = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backButton)


        binding.btnLoginCreateAccount.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_welcome)
        }

        binding.btnLoginLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_welcome)
        }


        return binding.root
    }
}