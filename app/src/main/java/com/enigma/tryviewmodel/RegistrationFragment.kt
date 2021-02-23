package com.enigma.tryviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.lifecycle.ViewModelProvider
import com.enigma.tryviewmodel.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {
    lateinit var viewModel: RegistrationFragmentViewModel
    lateinit var binding: FragmentRegistrationBinding
    lateinit var sharedViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel =
            ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        viewModel = ViewModelProvider(this).get(RegistrationFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        binding.apply {
            registrationButton.setOnClickListener {
                val personName = nameEditText.text
                if (viewModel.inputNameValidation(personName.toString())) {
                    sharedViewModel.sayHello("hii...${personName}")
                    (requireActivity() as OnNavigationListener).onHello()
                } else {
                    makeText(
                        requireContext(),
                        "please input a name",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RegistrationFragment()
    }
}