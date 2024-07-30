package com.example.hw7_3month


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw7_3month.databinding.FragmentDescriptionBinding

class Description : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val description = arguments?.getString("description")
        binding.descriptionText.text = description
    }

    companion object {
        fun newInstance(description: String): Description{
            val fragment = Description()
            val args = Bundle().apply {
                putString("description", description)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
