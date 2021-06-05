package com.example.ceria.ui.home.apply.main_form

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyFourthBinding
import com.example.ceria.util.UtilFunction
import org.jetbrains.anko.textColor
import timber.log.Timber

class ApplyFourthFragment : Fragment() {

    private lateinit var viewModel: ApplyFourthViewModel
    private lateinit var binding: FragmentApplyFourthBinding
    private var sharedPref: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyFourthBinding.inflate(inflater, container, false).apply {
            val saveText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(
                    resources.getString(R.string.berhenti_and_simpan),
                    Html.FROM_HTML_MODE_LEGACY
                )
            } else {
                Html.fromHtml(resources.getString(R.string.berhenti_and_simpan))
            }

            btnSaveApplyFourth.text = saveText.toString().toUpperCase()
        }
        sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val isPictureTaken = sharedPref?.getBoolean(getString(R.string.isPictureTaken), false)
            val isPersonalDataFilled =
                sharedPref?.getBoolean(getString(R.string.isPersonalDataFilled), false)
            val isFamilyDataFilled =
                sharedPref?.getBoolean(getString(R.string.isFamilyDataFilled), false)
            val isJobDataFilled = sharedPref?.getBoolean(getString(R.string.isJobDataFilled), false)

            Timber.e("state : $isPictureTaken $isPersonalDataFilled")

            if (isPictureTaken!!) {
                ivKtpApplyFourth.setImageResource(R.drawable.ic_check_solid)
                UtilFunction.stateViewVisible(ivKtpTakenApplyFourth)
                UtilFunction.stateViewVisible(tvKtpTakenApplyFourth)
                UtilFunction.stateViewVisible(tvChangeApplyFourth1)
                UtilFunction.stateViewGone(tvKtpApplyFourth)
                UtilFunction.stateViewGone(tvDescKtpApplyFourth)
                UtilFunction.stateViewGone(ivRightApplyFourth1)
                clPersonalClickApplyFourth.isClickable = true
                ivPersonalApplyFourth.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.colorPrimary
                    )
                )
                ivRightApplyFourth2.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.colorPrimary
                    )
                )
                tvPersonalApplyFourth.textColor =
                    ContextCompat.getColor(requireContext(), R.color.colorPrimary)
            } else {
                ivKtpApplyFourth.setImageResource(R.drawable.ic_camera)
                UtilFunction.stateViewGone(ivKtpTakenApplyFourth)
                UtilFunction.stateViewGone(tvKtpTakenApplyFourth)
                UtilFunction.stateViewGone(tvChangeApplyFourth1)
                UtilFunction.stateViewVisible(tvKtpApplyFourth)
                UtilFunction.stateViewVisible(tvDescKtpApplyFourth)
                UtilFunction.stateViewVisible(ivRightApplyFourth1)
                ivPersonalApplyFourth.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black30
                    )
                )
                ivRightApplyFourth2.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black30
                    )
                )
                tvPersonalApplyFourth.textColor =
                    ContextCompat.getColor(requireContext(), R.color.black30)
            }

            if (isPersonalDataFilled!!) {
                ivPersonalApplyFourth.setImageResource(R.drawable.ic_check_solid)
                UtilFunction.stateViewVisible(clPersonalDataApplyFourth)
                UtilFunction.stateViewVisible(tvChangeApplyFourth2)
                UtilFunction.stateViewGone(ivRightApplyFourth2)
                clFamilyClickApplyFourth.isClickable = true
                ivFamilyApplyFourth.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.colorPrimary
                    )
                )
                ivRightApplyFourth3.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.colorPrimary
                    )
                )
                tvFamilyApplyFourth.textColor =
                    ContextCompat.getColor(requireContext(), R.color.colorPrimary)
            } else {
                ivPersonalApplyFourth.setImageResource(R.drawable.ic_profile)
                UtilFunction.stateViewGone(clPersonalDataApplyFourth)
                UtilFunction.stateViewGone(tvChangeApplyFourth2)
                UtilFunction.stateViewVisible(ivRightApplyFourth2)
                ivFamilyApplyFourth.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black30
                    )
                )
                ivRightApplyFourth3.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black30
                    )
                )
                tvFamilyApplyFourth.textColor =
                    ContextCompat.getColor(requireContext(), R.color.black30)
            }

            if (isFamilyDataFilled!!) {
                ivFamilyApplyFourth.setImageResource(R.drawable.ic_check_solid)
                UtilFunction.stateViewVisible(clFamilyDataApplyFourth)
                UtilFunction.stateViewVisible(tvChangeApplyFourth3)
                UtilFunction.stateViewGone(ivRightApplyFourth3)
                clJobClickApplyFourth.isClickable = true
                ivJobApplyFourth.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.colorPrimary
                    )
                )
                ivRightApplyFourth4.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.colorPrimary
                    )
                )
                tvJobApplyFourth.textColor =
                    ContextCompat.getColor(requireContext(), R.color.colorPrimary)
            } else {
                ivFamilyApplyFourth.setImageResource(R.drawable.ic_group)
                UtilFunction.stateViewGone(clFamilyDataApplyFourth)
                UtilFunction.stateViewGone(tvChangeApplyFourth3)
                UtilFunction.stateViewVisible(ivRightApplyFourth3)
                ivJobApplyFourth.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black30
                    )
                )
                ivRightApplyFourth4.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black30
                    )
                )
                tvJobApplyFourth.textColor =
                    ContextCompat.getColor(requireContext(), R.color.black30)
            }

            if (isJobDataFilled!!) {
                ivJobApplyFourth.setImageResource(R.drawable.ic_check_solid)
                UtilFunction.stateViewVisible(clJobDataApplyFourth)
                UtilFunction.stateViewVisible(tvChangeApplyFourth4)
                UtilFunction.stateViewGone(ivRightApplyFourth4)
                cbApplyFourth.isEnabled = true
            } else {
                ivJobApplyFourth.setImageResource(R.drawable.ic_job)
                UtilFunction.stateViewGone(clJobDataApplyFourth)
                UtilFunction.stateViewGone(tvChangeApplyFourth4)
                UtilFunction.stateViewVisible(ivRightApplyFourth4)
            }

            toolbarApplyFourth.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            setClickListener { view ->
                when (view.id) {
                    R.id.cl_ktp_apply_fourth -> {
                        view.findNavController()
                            .navigate(R.id.action_applyFourthFragment_to_applyInputKtpFragment)
                    }
                    R.id.cl_personal_click_apply_fourth -> {
                        view.findNavController()
                            .navigate(R.id.action_applyFourthFragment_to_applyPersonalFragment)
                    }
                    R.id.cl_family_click_apply_fourth -> {
                        view.findNavController()
                            .navigate(R.id.action_applyFourthFragment_to_applyFamilyFragment)
                    }
                    R.id.cl_job_click_apply_fourth -> {
                        view.findNavController()
                            .navigate(R.id.action_applyFourthFragment_to_applyJobFragment)
                    }
                    R.id.btn_send_apply_fourth -> {
                        with(sharedPref?.edit()) {
                            this?.putBoolean(getString(R.string.isPictureTaken), false)
                            this?.putBoolean(getString(R.string.isPersonalDataFilled), false)
                            this?.putBoolean(getString(R.string.isFamilyDataFilled), false)
                            this?.putBoolean(getString(R.string.isJobDataFilled), false)
                            this?.apply()
                        }
                        applicationSubmittedDialog(view)
                    }
                }
            }
        }
    }

    private fun applicationSubmittedDialog(view: View) {
        val factory = LayoutInflater.from(requireContext())
        val dialogView = factory.inflate(R.layout.dialog_application_submitted, null)
        val applicationSubmittedDialog = AlertDialog.Builder(requireContext()).create()
        val isPayroll = sharedPref?.getBoolean(getString(R.string.isPayroll), false)

        dialogView.findViewById<ConstraintLayout>(R.id.cl_application_submitted)
            .setOnClickListener {
                if (isPayroll!!) {
                    view.findNavController()
                        .navigate(R.id.action_applyFourthFragment_to_applyScoringFragment)
                } else {
                    view.findNavController()
                        .navigate(R.id.action_applyFourthFragment_to_applyIncomeUploadFragment)
                }

                applicationSubmittedDialog.dismiss()
            }
        applicationSubmittedDialog.setView(dialogView)
        applicationSubmittedDialog.show()
    }

}