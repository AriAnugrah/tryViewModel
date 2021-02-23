package com.enigma.tryviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.enigma.tryviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnNavigationListener {
    lateinit var binding: ActivityMainBinding
    lateinit var helloFragment: HelloFragment
    lateinit var registrationFragment: RegistrationFragment
    lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registrationFragment = RegistrationFragment.newInstance()
        helloFragment = HelloFragment.newInstance()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.helloWord?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag, helloFragment).commit()
        } ?: let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag, registrationFragment).commit()
        }
    }

    override fun onHello() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_tag, helloFragment)
            .commit()
    }
}



