package com.example.ceria.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentInputPinBinding


class InputPinFragment : Fragment() {

    private lateinit var binding: FragmentInputPinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputPinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setClickListener { view ->
            when (view.id) {
                R.id.tv_forgot_input_pin -> {
                    view.findNavController()
                            .navigate(R.id.action_inputPinFragment_to_forgetPinFragment)
                }
            }
        }
    }
}