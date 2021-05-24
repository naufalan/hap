package com.example.ceria.ui.auth.forget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentForgetPinBinding


class ForgetPinFragment : Fragment() {

    private lateinit var binding: FragmentForgetPinBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgetPinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setClickListener { view ->
            when (view.id) {
                R.id.btn_forget_pin -> {
                    view.findNavController()
                        .navigate(R.id.action_forgetPinFragment_to_resetPinFragment)
                }
            }
        }
    }
}