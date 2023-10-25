package com.theresa.practiceapplication_basic

import android.os.Bundle
import android.text.Editable
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.theresa.practiceapplication_basic.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.shareBtn.setOnClickListener{
            // send textInput
            var inputToShare: String? = binding.editText.text.toString()
            val bundle = Bundle()
            val fragment2 = SecondFragment()

//            if (inputToShare != null) {
//                d("inputToShare", inputToShare)
//            }
            bundle.putString("input", inputToShare)
            fragment2.arguments = bundle

            // replace with fragment2 in activity container
            replaceFragment(fragment2)

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun replaceFragment(fragment: Fragment) {
//        parentFragmentManager.beginTransaction().apply {
//            replace(R.id.fragmentContainerView, fragment)
//            addToBackStack(null)
//            commit()
//        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .addToBackStack(null)
            .commit()

        Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()
    }
}