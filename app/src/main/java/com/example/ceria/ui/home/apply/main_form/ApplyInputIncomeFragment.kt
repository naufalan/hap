package com.example.ceria.ui.home.apply.main_form

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyInputIncomeBinding

class ApplyInputIncomeFragment : Fragment() {

    private lateinit var binding: FragmentApplyInputIncomeBinding
    private lateinit var viewModel: ApplyInputIncomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyInputIncomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            setClickListener { view ->
                when (view.id) {
                    R.id.btn_camera_apply_input_income -> {
                        ivApplyInputIncome.visibility = View.VISIBLE
                        clApplyInputIncome.visibility = View.VISIBLE
                        cameraApplyInputIncome.visibility = View.GONE
                        tvDescApplyInputIncome.visibility = View.GONE
                        btnCameraApplyInputIncome.visibility = View.GONE
                    }
                    R.id.btn_retake_apply_input_income -> {

                    }
                    R.id.btn_use_apply_input_income -> {
                        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                        with(sharedPref?.edit()) {
                            this?.putBoolean(getString(R.string.isIncomeUploaded), true)
                            this?.apply()
                        }
                        view.findNavController().navigate(R.id.action_applyInputIncomeFragment_to_applyIncomeUploadFragment)
                    }
                }
            }
        }
    }

}