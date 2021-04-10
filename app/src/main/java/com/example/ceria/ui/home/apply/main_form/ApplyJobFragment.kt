package com.example.ceria.ui.home.apply.main_form

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyJobBinding
import com.example.ceria.util.UtilFunction
import java.util.*

class ApplyJobFragment : Fragment() {

    private lateinit var viewModel: ApplyJobViewModel
    private lateinit var binding: FragmentApplyJobBinding

    private var calendarPicker = Calendar.getInstance()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyJobBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarApplyJob.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            val spinnerAdapter = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.credit_card)
                )
            }

            spinnerIncomeApplyJob.adapter = spinnerAdapter
            spinnerStatusApplyJob.adapter = spinnerAdapter
            spinnerTypeApplyJob.adapter = spinnerAdapter

            setClickListener { view ->
                when (view.id) {
                    R.id.tv_start_apply_job -> {
                        DatePickerDialog(
                                requireContext(),
                                UtilFunction.datePickerListener(calendarPicker, tvStartApplyJob),
                                calendarPicker.get(Calendar.YEAR),
                                calendarPicker.get(Calendar.MONTH),
                                calendarPicker.get(Calendar.DAY_OF_MONTH)
                        ).show()
                    }
                    R.id.tv_end_apply_job -> {
                        DatePickerDialog(
                                requireContext(),
                                UtilFunction.datePickerListener(calendarPicker, tvEndApplyJob),
                                calendarPicker.get(Calendar.YEAR),
                                calendarPicker.get(Calendar.MONTH),
                                calendarPicker.get(Calendar.DAY_OF_MONTH)
                        ).show()
                    }
                    R.id.btn_apply_job -> {
                        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                        with(sharedPref?.edit()) {
                            this?.putBoolean("isJobDataFilled", true)
                            this?.apply()
                        }
                        view.findNavController()
                                .navigate(R.id.action_applyJobFragment_to_applyFourthFragment)
                    }
                }

            }
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplyJobViewModel::class.java)
        // TODO: Use the ViewModel
    }

}