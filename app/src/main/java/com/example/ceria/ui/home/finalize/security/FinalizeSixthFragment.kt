package com.example.ceria.ui.home.finalize.security

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
import com.example.ceria.databinding.FragmentFinalizeSixthBinding
import com.example.ceria.util.BaseDialog
import com.example.ceria.util.UtilFunction

class FinalizeSixthFragment : Fragment() {

    private lateinit var binding: FragmentFinalizeSixthBinding
    private lateinit var viewModel: FinalizeSixthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalizeSixthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val verificationFailedDialog = BaseDialog.simpleDialog(
            view,
            R.drawable.ic_person_cross,
            getString(R.string.verifikasi_identitas_gagal),
            getString(R.string.desc_verification_failed_dialog),
            getString(R.string.foto_selfie_ulang),
            false
        )

        val cancelingVerificationDialog = BaseDialog.yesnoDialog(
            view, null, getString(R.string.tunggu_dulu), getString(
                R.string.desc_canceling_verification_dialog
            ), getString(R.string.ya_batalkan), getString(R.string.tidak_kembali)
        )

        val secondVerificationFailedDialog = BaseDialog.simpleDialog(
            view,
            null,
            getString(R.string.sorry),
            getString(R.string.desc_second_verification_failed_dialog),
            getString(R.string.hubungi_contact_centre),
            false
        )

        val thirdVerificationFailedDialog = BaseDialog.simpleDialog(
            view,
            null,
            getString(R.string.ups_gagal_lagi),
            getString(R.string.desc_third_verification_failed_dialog),
            getString(R.string.kembali_ke_home),
            false
        )

        val verificationSuccessDialog = BaseDialog.simpleDialog(
            view,
            R.drawable.ic_check,
            getString(R.string.verifikasi_identitas_berhasil),
            getString(R.string.desc_third_verification_failed_dialog),
            getString(R.string.kembali_ke_home),
            false
        )



        binding.apply {
            btnCameraFinalizeSixth.setOnClickListener {
                verificationFailedDialog.show()
                verificationFailedDialog.findViewById<ImageView>(R.id.iv_base_dialog)
                    ?.setOnClickListener {
                        secondVerificationFailedDialog.show()
                        secondVerificationFailedDialog.findViewById<Button>(R.id.btn_base_dialog)
                            ?.setOnClickListener {
                                findNavController().navigate(R.id.action_finalizeSixthFragment_to_finalizeHelpFragment)
                                secondVerificationFailedDialog.dismiss()
                            }
                        verificationFailedDialog.dismiss()
                    }
                verificationFailedDialog.findViewById<Button>(R.id.btn_base_dialog)
                    ?.setOnClickListener {
                        thirdVerificationFailedDialog.show()
                        thirdVerificationFailedDialog.findViewById<Button>(R.id.btn_base_dialog)
                            ?.setOnClickListener {
                                verificationSuccessDialog.show()
                                verificationSuccessDialog.findViewById<Button>(R.id.btn_base_dialog)
                                    ?.let { it1 -> UtilFunction.stateViewGone(it1) }
                                verificationSuccessDialog.findViewById<TextView>(R.id.tv_desc_base_dialog)
                                    ?.let { it1 -> UtilFunction.stateViewGone(it1) }
                                verificationSuccessDialog.findViewById<ImageView>(R.id.iv_base_dialog)
                                    ?.setOnClickListener {
                                        findNavController().navigate(R.id.action_finalizeSixthFragment_to_finalizeFinishedFragment)
                                        verificationSuccessDialog.dismiss()
                                    }
                                thirdVerificationFailedDialog.dismiss()
                            }
                    verificationFailedDialog.dismiss()
                }
            }


        }
    }
}


