package com.example.ceria.ui.home.apply.main_form

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyInputKtpBinding

class ApplyInputKtpFragment : Fragment() {

    private lateinit var viewModel: ApplyInputKtpViewModel
    private lateinit var binding: FragmentApplyInputKtpBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyInputKtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarApplyInputKtp.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            setClickListener { view ->

                when (view.id) {
                    R.id.btn_camera_apply_input_ktp -> {
                        btnCameraApplyInputKtp.visibility = View.GONE
                        clApplyInputKtp.visibility = View.VISIBLE
                    }
                    R.id.btn_use_apply_input_ktp -> {
                        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                        with(sharedPref?.edit()) {
                            this?.putBoolean(getString(R.string.isPictureTaken), true)
                            this?.apply()
                        }
                        view.findNavController().navigate(R.id.action_applyInputKtpFragment_to_applyFourthFragment)
                    }
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplyInputKtpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}