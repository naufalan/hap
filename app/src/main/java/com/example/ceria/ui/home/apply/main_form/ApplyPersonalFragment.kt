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
import com.example.ceria.databinding.FragmentApplyPersonalBinding


class ApplyPersonalFragment : Fragment() {
    private lateinit var binding: FragmentApplyPersonalBinding
    private val list = ArrayList<Int>()
    private lateinit var adapter: ApplyPersonalAdapter


    companion object {
        fun newInstance() = ApplyPersonalFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyPersonalBinding.inflate(inflater, container, false)
        adapter = ApplyPersonalAdapter(list, requireContext())
        list.add(0)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            toolbarApplyPersonal.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            rvCardApplyPersonal.adapter = adapter
            val spinnerAdapter = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.credit_card)
                )
            }

            spinnerCityApplyPersonal.adapter = spinnerAdapter
            spinnerDistrictApplyPersonal.adapter = spinnerAdapter
            spinnerHowlongApplyPersonal.adapter = spinnerAdapter
            spinnerProvinceApplyPersonal.adapter = spinnerAdapter
            spinnerResidencyApplyPersonal.adapter = spinnerAdapter
            spinnerVillageApplyPersonal.adapter = spinnerAdapter
            spinnerEduApplyPersonal.adapter = spinnerAdapter
            spinnerStatusApplyPersonal.adapter = spinnerAdapter

            btnApplyPersonal.setOnClickListener {
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref?.edit()) {
                    this?.putBoolean("isPersonalDataFilled", true)
                    this?.apply()
                }
                view.findNavController().navigate(R.id.action_applyPersonalFragment_to_applyFourthFragment)
            }

        }
    }


}