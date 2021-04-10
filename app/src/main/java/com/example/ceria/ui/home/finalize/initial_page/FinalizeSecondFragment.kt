package com.example.ceria.ui.home.finalize.initial_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentFinalizeSecondBinding

class FinalizeSecondFragment : Fragment() {

    private lateinit var viewModel: FinalizeSecondViewModel
    private lateinit var binding: FragmentFinalizeSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalizeSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnFinalizeSecond.setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.action_finalizeSecondFragment_to_finalizeThirdFragment)
            }
        }
    }


}