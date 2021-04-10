package com.example.ceria.ui.change_number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentChangeNumberOtpBinding
import com.example.ceria.util.BaseDialog
import com.example.ceria.util.UtilFunction

class OtpFragment : Fragment() {
    private lateinit var binding: FragmentChangeNumberOtpBinding
    private lateinit var viewModel: ChangeNumberOtpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeNumberOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val numberChangedDialog = BaseDialog.simpleDialog(
            view,
            R.drawable.ic_check,
            "Nomor berhasil diubah",
            "",
            "",
            true
        )

        binding.apply {
            etProfileOtp.setOnPinEnteredListener {
                if (it.length == 6) {
                    numberChangedDialog.show()
                    numberChangedDialog.findViewById<TextView>(R.id.tv_desc_base_dialog)
                        ?.let { it1 -> UtilFunction.stateViewGone(it1) }
                    numberChangedDialog.findViewById<Button>(R.id.btn_base_dialog)
                        ?.let { it1 -> UtilFunction.stateViewGone(it1) }
                    numberChangedDialog.findViewById<ImageView>(R.id.iv_close_base_dialog)
                        ?.setOnClickListener {
                            findNavController().navigate(R.id.action_ChangeNumberFragment_to_OtpVerificationFragment)
                            numberChangedDialog.dismiss()
                        }
                }
            }

        }
    }
}