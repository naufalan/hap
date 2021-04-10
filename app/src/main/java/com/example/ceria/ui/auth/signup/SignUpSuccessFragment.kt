package com.example.ceria.ui.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentSignUpSuccessBinding

class SignUpSuccessFragment : Fragment() {
    private lateinit var binding: FragmentSignUpSuccessBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            setClickListener { view ->
                if (view.id == R.id.btn_signup_success) {
                    view.findNavController()
                        .navigate(R.id.action_signUpSuccessFragment_to_nav_graph)
                }
            }
        }
    }

}