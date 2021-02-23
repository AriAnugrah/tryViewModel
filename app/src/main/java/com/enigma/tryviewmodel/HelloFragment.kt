package com.enigma.tryviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.enigma.tryviewmodel.databinding.FragmentHelloBinding
import com.enigma.tryviewmodel.databinding.FragmentRegistrationBinding


class HelloFragment : Fragment() {

    lateinit var binding: FragmentHelloBinding
    lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHelloBinding.inflate(layoutInflater)
        binding.apply {
            helloTextView.setText(viewModel.helloWord)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HelloFragment()
    }
}