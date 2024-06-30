package com.example.onlinekotlenapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlinekotlenapp.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {
    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        val view = binding.root

        val data = arguments?.getString("key")
        binding.txtUsername.text = data

        return view
    }
}
