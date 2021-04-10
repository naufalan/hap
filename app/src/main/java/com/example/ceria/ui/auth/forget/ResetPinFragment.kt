package com.example.ceria.ui.auth.forget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentResetPinBinding
import com.example.ceria.util.AuthSelector


class ResetPinFragment : Fragment() {
    private lateinit var binding: FragmentResetPinBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetPinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var isPhone = false
        val property = ArrayList<ResetProperty>()
        property.add(
            ResetProperty(
                R.drawable.ic_reset_pin,
                R.string.reset_pin_desc,
                R.string.registered_number,
                R.string.dont_have_access_number
            )
        )
        property.add(
            ResetProperty(
                R.drawable.ic_email_otp,
                R.string.reset_email_desc,
                R.string.registered_email,
                R.string.dont_have_access_email
            )
        )
        binding.apply {
            setClickListener { view ->
                when (view.id) {
                    R.id.btn_reset_pin -> {
                        if (!isPhone) {
                            ivResetPin.setImageResource(property[1].image)
                            tvDescForgetPin.text = getString(property[1].desc)
                            tvRegisteredNumberResetPin.text = getString(property[1].registered)
                            tvDontHaveAccessResetPin.text = getString(property[1].access)
                            isPhone = !isPhone
                        } else {
                            val direction =
                                ResetPinFragmentDirections.actionResetPinFragmentToOtpVerificationFragment(
                                    AuthSelector.FORGET
                                )
                            view.findNavController().navigate(direction)
                            isPhone = !isPhone
                        }
                    }
                    R.id.tv_dont_have_access_reset_pin -> {
                        view.findNavController()
                                .navigate(R.id.action_resetPinFragment_to_dontHaveAccessFragment)
                    }
                }
            }
        }
    }
}