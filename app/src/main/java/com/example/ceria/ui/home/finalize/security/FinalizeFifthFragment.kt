package com.example.ceria.ui.home.finalize.security

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentFinalizeFifthBinding

class FinalizeFifthFragment : Fragment() {

    private lateinit var binding: FragmentFinalizeFifthBinding
    private lateinit var viewModel: FinalizeFifthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalizeFifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            etFinalizeFifth.setOnPinEnteredListener {
                if (it.length == 6) {
                    findNavController().navigate(R.id.action_finalizeFifthFragment_to_finalizeSixthFragment)
                }
            }

        }
    }

}