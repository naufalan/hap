package com.example.ceria.ui.home.apply.main_form

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyIncomeUploadBinding
import com.example.ceria.util.UtilFunction
import com.google.android.material.bottomsheet.BottomSheetDialog


class ApplyIncomeUploadFragment : Fragment() {

    private lateinit var binding: FragmentApplyIncomeUploadBinding
    private lateinit var viewModel: ApplyIncomeUploadViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyIncomeUploadBinding.inflate(inflater, container, false).apply {
            val saveText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(
                    resources.getString(R.string.berhenti_and_simpan),
                    Html.FROM_HTML_MODE_LEGACY
                )
            } else {
                Html.fromHtml(resources.getString(R.string.berhenti_and_simpan))
            }
            btnSaveApplyIncomeUpload.text = saveText.toString().toUpperCase()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_upload, null)
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(dialogView)

        binding.apply {
            setClickListener { view ->
                when (view.id) {
                    R.id.cl_main_apply_income_upload -> {
                        bottomSheetDialog.show()
                        bottomSheetDialog.findViewById<ConstraintLayout>(R.id.cl_camera_bottom_sheet_upload)
                            ?.setOnClickListener {
                                view.findNavController()
                                    .navigate(R.id.action_applyIncomeUploadFragment_to_applyInputIncomeFragment)
                                bottomSheetDialog.dismiss()
                            }
                    }
                    R.id.cl_optional_apply_income_upload -> {
                        bottomSheetDialog.show()
                        bottomSheetDialog.findViewById<ConstraintLayout>(R.id.cl_camera_bottom_sheet_upload)
                            ?.setOnClickListener {
                                view.findNavController()
                                    .navigate(R.id.action_applyIncomeUploadFragment_to_applyInputIncomeFragment)
                                bottomSheetDialog.dismiss()
                            }
                    }
                    R.id.btn_send_apply_income_upload -> {
                        view.findNavController()
                            .navigate(R.id.action_applyIncomeUploadFragment_to_applyScoringFragment)
                    }
                }
            }
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
            val isIncomeUploaded =
                sharedPref?.getBoolean(getString(R.string.isIncomeUploaded), false)

            if (isIncomeUploaded!!) {
                ivMainApplyIncomeUpload.setImageResource(R.drawable.ic_check_solid)
                UtilFunction.stateViewVisible(ivMainUploadedApplyIncomeUpload)
                UtilFunction.stateViewVisible(tvMainUplaodedApplyIncomeUpload)
                UtilFunction.stateViewVisible(tvChangeApplyIncomeUpload1)
                UtilFunction.stateViewGone(tvTitleMainApplyIncomeUpload)
                UtilFunction.stateViewGone(tvDescMainApplyIncomeUpload)
            } else {
                ivMainApplyIncomeUpload.setImageResource(R.drawable.ic_camera)
                UtilFunction.stateViewVisible(tvTitleMainApplyIncomeUpload)
                UtilFunction.stateViewVisible(tvDescMainApplyIncomeUpload)
                UtilFunction.stateViewGone(ivMainUploadedApplyIncomeUpload)
                UtilFunction.stateViewGone(tvMainUplaodedApplyIncomeUpload)
                UtilFunction.stateViewGone(tvChangeApplyIncomeUpload1)
            }
        }
    }
}