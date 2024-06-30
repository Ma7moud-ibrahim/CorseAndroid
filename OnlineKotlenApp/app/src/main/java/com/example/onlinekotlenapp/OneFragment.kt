package com.example.onlinekotlenapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlinekotlenapp.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonSendData.setOnClickListener {
            val data = binding.textName.text.toString()
            (activity as MainActivity).sendDataToFragmentTwo(data)
        }

        return view
    }
}
