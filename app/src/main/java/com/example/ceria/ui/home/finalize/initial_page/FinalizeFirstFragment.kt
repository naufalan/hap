package com.example.ceria.ui.home.finalize.initial_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentFinalizeFirstBinding

class FinalizeFirstFragment : Fragment() {

    private lateinit var binding: FragmentFinalizeFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinalizeFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnFinalizeFirst.setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.action_finalizeFirstFragment_to_finalizeSecondFragment)
            }
        }
    }


}