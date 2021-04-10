package com.example.ceria.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.data.local.entity.HomeEntity
import com.example.ceria.databinding.DialogChangeEmailVerificationBinding
import com.example.ceria.databinding.FragmentHomeBinding
import com.example.ceria.util.BaseDialog
import com.example.ceria.util.UtilFunction
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = getViewModel { parametersOf("hammad") }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fromScoring = arguments?.getBoolean("fromScoring", false)
        val fromFinalizeReject = arguments?.getBoolean("isFromFinalizeReject", false)
        val fromFinalizeFinished = arguments?.getBoolean("isfromFinalizeFinished", false)

        binding.apply {
            if (fromFinalizeFinished != null && fromFinalizeFinished) {
                UtilFunction.stateViewGone(clApplicationHome)
                UtilFunction.stateViewVisible(clAvailableCreditHome)
            }

            if (fromFinalizeReject != null && fromFinalizeReject) {
                UtilFunction.stateViewGone(clApplicationHome)
                UtilFunction.stateViewVisible(clFinalizeRejectHome)
            }

            if (fromScoring != null && fromScoring) {
                UtilFunction.stateViewGone(clApplicationHome)
                UtilFunction.stateViewVisible(clProgressScoringHome)
            }

            val expiredLimitDialog = BaseDialog.simpleDialog(
                view, R.drawable.ic_card_failed_requirements, getString(R.string.ups),
                getString(R.string.desc_expired_limit_dialog), getString(R.string.tutup), true
            )

            setClickListener { view ->
                when (view.id) {
                    R.id.cl_progress_scoring_home -> {
                        UtilFunction.stateViewVisible(clEmailVerificationHome)
                        UtilFunction.stateViewGone(clProgressScoringHome)
                    }

                    R.id.cl_available_credit_home -> {
                        expiredLimitDialog.show()
                        expiredLimitDialog.findViewById<Button>(R.id.btn_base_dialog)
                            ?.setOnClickListener {
                                UtilFunction.stateViewVisible(clApplicationHome)
                                UtilFunction.stateViewGone(clAvailableCreditHome)
                                expiredLimitDialog.dismiss()
                            }

                    }

                    R.id.btn_submit_kredit -> {
                        view.findNavController()
                            .navigate(R.id.action_homeFragment_to_navigation_apply)
                    }
                    R.id.btn_email_verification_home -> {
                        view.findNavController()
                            .navigate(R.id.action_homeFragment_to_applyFinishedFragment)
                    }

                    R.id.tv_change_email_verification_home -> {
                        changeEmailDialog(view)
                    }

                    R.id.btn_finalize_reject_home -> {
                        UtilFunction.stateViewVisible(clApplicationHome)
                        UtilFunction.stateViewGone(clFinalizeRejectHome)
                    }
                }
            }

//            viewModel.getUsers().observe(viewLifecycleOwner, Observer { response ->
//                val adapter = HomeAdapter()
//                when (response.status) {
//                    Status.LOADING -> {
//                        progressHome.visibility = View.VISIBLE
//                    }
//                    Status.SUCCESS -> {
//                        progressHome.visibility = View.GONE
//                        rvHome.adapter = adapter
//                        adapter.submitList(response.data)
//                    }
//                    Status.ERROR -> {
//                        progressHome.visibility = View.GONE
//                        toast("An Error Occured : ${response.message}")
//                    }
//                }
//            })
            var homeList = ArrayList<HomeEntity>()
            homeList.add(HomeEntity("0", "asdklkasd", "alkdaklsk","082299028423","123456"))
            homeList.add(HomeEntity("1", "asdklkasd", "alkdaklsk","082299028423","123456"))
            homeList.add(HomeEntity("2", "asdklkasd", "alkdaklsk","082299028423","123456"))

            val adapter = HomeAdapter()
            rvPromoHome.adapter = adapter
            adapter.submitList(homeList)
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // Handle the back button event
            requireActivity().finish()
        }
    }

    private fun changeEmailDialog(view: View) {
        val dialogView = DialogChangeEmailVerificationBinding.inflate(
            LayoutInflater.from(requireContext()),
            null,
            false
        )
        val changeEmailDialog = AlertDialog.Builder(requireContext()).create()
        dialogView.apply {
            btnChangeEmailVerification.setOnClickListener {
                ivChangeEmailVerification.setImageResource(R.drawable.ic_change_email_success)
                tvChangeEmailVerification.text = resources.getString(R.string.sukses)
                tvDescChangeEmailVerification.text =
                    resources.getString(R.string.desc_change_email_success)
                etChangeEmailVerification.visibility = View.GONE
                btnChangeEmailVerification.visibility = View.GONE
            }
            ivCloseChangeEmailVerification.setOnClickListener {
                binding.tvDescEmailVerificationHome.text =
                    resources.getString(R.string.desc_email_change_success)
                changeEmailDialog.dismiss()
            }
        }
        changeEmailDialog.setView(dialogView.root)
        changeEmailDialog.show()
    }
}