package com.theresa.practiceapplication_basic

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.theresa.practiceapplication_basic.databinding.FragmentFirstBinding
import com.theresa.practiceapplication_basic.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container,false)

        val sharedInput = arguments?.getString("input")
//        if (sharedInput != null) {
//            d("sharedInput", sharedInput)
//        }
        binding.textView.text = sharedInput

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}