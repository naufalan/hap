package com.example.ceria.ui.auth.signup

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ceria.R
import com.example.ceria.databinding.DialogCancelingOtpVerificationBinding
import com.example.ceria.databinding.DialogFailOtpBinding
import com.example.ceria.databinding.DialogNotRegisteredBinding
import com.example.ceria.databinding.FragmentOtpVerificationBinding
import com.example.ceria.util.AuthSelector
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class OtpVerificationFragment : Fragment() {

    private lateinit var binding: FragmentOtpVerificationBinding
    private var timerUtil: CountDownTimer? = null
    private val args: OtpVerificationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOtpVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val auth = args.auth
        binding.apply {

            setClickListener { view ->
                when (view.id) {
                    R.id.tv_change_number_otp_verif -> {
                        createChangeNumberDialog(view)
                    }
                }
            }

            toolbarBiddingDetail.setNavigationOnClickListener { view ->
                createDialog(view)
            }
            val onBackPressedCallback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Handle the back button event
                    createDialog(view)
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                onBackPressedCallback
            )

            setAuth(auth)
            if (timerUtil != null) {
                timerUtil!!.cancel()
                timerUtil = null
            }

            timerStart()

            etOtpVerif.setOnPinEnteredListener {
                if (it.length == 6) {
                    timerUtil?.cancel()
                    timerUtil = null
                    when (auth) {
                        AuthSelector.SIGNUP -> {
                            val direction =
                                OtpVerificationFragmentDirections.actionOtpVerificationFragmentToCreatePinFragment(
                                    AuthSelector.SIGNUP
                                )
                            findNavController().navigate(direction)
                        }
                        AuthSelector.LOGIN -> {
                            findNavController().navigate(R.id.action_otpVerificationFragment_to_inputPinFragment)
                        }
                        AuthSelector.FORGET -> {
                            val direction =
                                OtpVerificationFragmentDirections.actionOtpVerificationFragmentToCreatePinFragment(
                                    AuthSelector.FORGET
                                )
                            findNavController().navigate(direction)
                        }
                    }
                }
            }
        }
    }

    private fun timerStart() {
        binding.apply {
            timerUtil = object : CountDownTimer((15 * 1000).toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    tvResendCountOtpVerif.visibility = View.VISIBLE
                    if (isAdded)
                        tvResendOtpVerif.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.otp_resend
                            )
                        )
                    tvResendCountOtpVerif.text =
                        "(${TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60})"
                }

                override fun onFinish() {
                    tvResendCountOtpVerif.visibility = View.GONE
                    tvResendOtpVerif.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimary
                        )
                    )
                    timerUtil = null
                }
            }.start()
        }
    }

    private fun createChangeNumberDialog(view: View) {
        timerUtil?.cancel()
        timerUtil = null
        val dialogView =
            DialogNotRegisteredBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        val changeNumberDialog = AlertDialog.Builder(requireContext()).create()
        changeNumberDialog.setView(dialogView.root)
        changeNumberDialog.setCancelable(false)
        dialogView.btnNotRegistered.setOnClickListener {
            changeNumberDialog.dismiss()
            timerStart()
        }
        changeNumberDialog.show()
    }


    private fun createDialog(view: View) {
        timerUtil?.cancel()
        timerUtil = null
        val dialogView = DialogCancelingOtpVerificationBinding.inflate(
            LayoutInflater.from(requireContext()),
            null,
            false
        )
        val cancelDialog = AlertDialog.Builder(requireContext()).create()
        cancelDialog.setView(dialogView.root)
        cancelDialog.setCancelable(false)
        dialogView.btnNoCancelingOtpVerification.setOnClickListener {
            cancelDialog.dismiss()
            timerStart()
        }
        dialogView.btnYesCancelingOtpVerification.setOnClickListener {
            view.findNavController().navigateUp()
            cancelDialog.dismiss()
        }
        cancelDialog.show()
    }

}


