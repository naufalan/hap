package com.example.ceria.ui.home.apply.questionnaire

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyFirstBinding
import com.example.ceria.util.BaseDialog

class ApplyFirstFragment : Fragment() {
    private lateinit var viewModel: ApplyFirstViewModel
    private lateinit var binding: FragmentApplyFirstBinding

    private var payrollCounter = 0
    private var isThirdSwitchClicked = false
    private var sharedPref: SharedPreferences? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyFirstBinding.inflate(inflater, container, false)
        sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            switchOneApplyFirst.setOnCheckedChangeListener(switchListener)
            switchTwoApplyFirst.setOnCheckedChangeListener(switchListener)
            switchThreeApplyFirst.setOnCheckedChangeListener(switchListener)

            toolbarApplyFirst.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            btnApplyFirst.setOnClickListener { view ->
                if (payrollCounter == 3) {
                    with(sharedPref?.edit()) {
                        this?.putBoolean(getString(R.string.isPayroll), true)
                        this?.apply()
                    }

                    val direction =
                        ApplyFirstFragmentDirections.actionApplyFirstFragmentToApplySecondFragment(
                            true
                        )
                    view.findNavController().navigate(direction)
                    payrollCounter = 0
                } else if (payrollCounter == 2 && !isThirdSwitchClicked) {
                    val regularAccountDialog = BaseDialog.simpleDialog(view, R.drawable.ic_card_failed_requirements, getString(R.string.ups_ada_masalah), "Kamu belum terdaftar dalam\ndatabase penggajian kami, silakan\nlanjutkan sebagai nasabah reguler.", getString(R.string.lanjutkan), true)
                    regularAccountDialog.show()
                    regularAccountDialog.findViewById<Button>(R.id.btn_base_dialog)
                        ?.setOnClickListener {

                            with(sharedPref?.edit()) {
                                this?.putBoolean(getString(R.string.isPayroll), false)
                                this?.apply()
                            }

                            val direction =
                                ApplyFirstFragmentDirections.actionApplyFirstFragmentToApplySecondFragment(
                                    false
                                )
                            view.findNavController().navigate(direction)
                            regularAccountDialog.dismiss()
                            payrollCounter = 0
                    }
                }
            }
        }

    }

    private val switchListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        when (buttonView.id) {
            R.id.switch_one_apply_first -> {
                payrollCheck(isChecked)
            }
            R.id.switch_two_apply_first -> {
                payrollCheck(isChecked)
            }
            R.id.switch_three_apply_first -> {
                isThirdSwitchClicked = isChecked
                payrollCheck(isChecked)
            }
        }
    }

    private fun payrollCheck(isChecked: Boolean) {
        if (isChecked)
            payrollCounter++
        else if (payrollCounter != 0 && !isChecked)
            payrollCounter--

        binding.apply {
            btnApplyFirst.isEnabled = payrollCounter == 2 && !isThirdSwitchClicked || payrollCounter == 3
        }

    }
}