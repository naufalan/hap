package com.example.ceria.ui.change_number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentChangeNumberBinding

class ChangeNumberFragment : Fragment() {
    private lateinit var binding: FragmentChangeNumberBinding
    private lateinit var viewModel: ChangeNumberViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnProfileChangeNumber.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_ChangeNumberFragment)
            }
        }
    }
}