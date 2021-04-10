package com.example.ceria.ui.home.apply.questionnaire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplySecondBinding

class ApplySecondFragment : Fragment() {

    private lateinit var viewModel: ApplySecondViewModel
    private lateinit var binding: FragmentApplySecondBinding
    private val args: ApplySecondFragmentArgs by navArgs()

    private var isPayroll = false
    private var isAllCheckedCounter = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplySecondBinding.inflate(inflater, container, false).apply {
            isPayroll = args.isPayroll

            toolbarApplySecond.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            cbOneApplySecond.setOnCheckedChangeListener(checkBoxListener)
            cbTwoApplySecond.setOnCheckedChangeListener(checkBoxListener)


            btnApplySecond.setOnClickListener {
                view.findNavController().navigate(R.id.action_applySecondFragment_to_applyThirdFragment)
                isAllCheckedCounter = 0
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplySecondViewModel::class.java)
        // TODO: Use the ViewModel
    }


    private val checkBoxListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        when (buttonView.id) {
            R.id.cb_one_apply_second -> {
                checkboxState(isChecked)
            }
            R.id.cb_two_apply_second -> {
                checkboxState(isChecked)
            }

        }
    }

    private fun checkboxState(isChecked: Boolean) {
        if (isChecked)
            isAllCheckedCounter++
        else if (isAllCheckedCounter != 0 && !isChecked)
            isAllCheckedCounter--

        binding.apply {
            if (isPayroll && isAllCheckedCounter == 2) {
                btnApplySecond.isEnabled = true
            } else
                btnApplySecond.isEnabled = !isPayroll && isAllCheckedCounter == 3
        }
    }
}