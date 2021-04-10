package com.example.ceria.ui.home.apply.main_form

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyFamilyBinding

class ApplyFamilyFragment : Fragment() {

    private lateinit var binding: FragmentApplyFamilyBinding
    private lateinit var viewModel: ApplyFamilyViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarApplyFamily.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            val spinnerAdapter = ArrayAdapter<String>(
                    requireContext(),
                    R.layout.support_simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.credit_card)
            )
            spinnerRelationApplyFamily.adapter = spinnerAdapter
            spinnerDependencyApplyFamily.adapter = spinnerAdapter

            btnApplyFamily.setOnClickListener { view ->
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref?.edit()) {
                    this?.putBoolean("isFamilyDataFilled", true)
                    this?.apply()
                }
                view.findNavController().navigate(R.id.action_applyFamilyFragment_to_applyFourthFragment)
            }
        }
    }
}