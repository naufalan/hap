package com.example.ceria.ui.auth.signup

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentSignUpBinding
import com.example.ceria.util.AuthSelector
import timber.log.Timber



class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var isChecked = false
        binding.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                tvTncSignup.text = Html.fromHtml(
                    resources.getString(R.string.agree_checked),
                    Html.FROM_HTML_MODE_LEGACY
                )
            } else {
                tvTncSignup.text = Html.fromHtml(resources.getString(R.string.agree_checked))
            }

//            val adapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_simple_layout, resources.getStringArray(R.array.credit_card))
//            spinner.adapter = adapter
//            spinner.onFocusChangeListener(object : AdapterView.)
            etPhoneNumberSignup.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable)
                {
                    btnLogin.setOnClickListener{
                        findNavController().navigate(R.id.action_signUpFragment_to_otpVerificationFragment)}
                }

                override fun beforeTextChanged(s: CharSequence, start: Int,
                                               count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int){}

            })
            cbTncSignup.isEnabled = true
            cbTncSignup.setOnCheckedChangeListener { _, isCheckedHere ->
                Timber.e("isChecked : $isChecked isCheckedHere : $isCheckedHere")
                btnSignup.isEnabled = isCheckedHere
                isChecked = isCheckedHere
            }
            setClickListener {
                when (it.id) {
                    R.id.cb_tnc_signup -> {
                        Timber.e("isChecked : $isChecked")
                        if (isChecked) {
                            it.findNavController()
                                .navigate(R.id.action_signUpFragment_to_tncFragment)
                        }
                    }

                    R.id.btn_login -> {
                        it.findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                    }
                }
            }
        }
    }
}