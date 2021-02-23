package com.enigma.tryviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.enigma.tryviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        binding.apply {
            helloTextView.text = viewmodel.helloWord
            helloButton.setOnClickListener {
                viewmodel.sayHello("hello")
                helloTextView.text = viewmodel.helloWord
            }
        }
    }

    private fun initViewModel() {
        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
}

