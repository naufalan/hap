package com.example.ceria.ui.home.finalize.digital_signature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentFinalizeSelfieBinding
import com.example.ceria.util.BaseDialog
import com.example.ceria.util.UtilFunction

class FinalizeSelfieFragment : Fragment() {

    private lateinit var binding: FragmentFinalizeSelfieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinalizeSelfieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val leavingSelfieDialog = BaseDialog.yesnoDialog(
            view, null, getString(R.string.tunggu_dulu), getString(
                R.string.desc_selfie_dialog
            ), getString(R.string.ya_lanjut), getString(R.string.tidak_ulang)
        )

        val thirdTimeTakeDialog = BaseDialog.simpleDialog(
            view,
            R.drawable.ic_person_cross,
            getString(
                R.string.ups_gagal_lagi
            ),
            getString(R.string.desc_third_time_take_dialog),
            getString(R.string.kembali_ke_home),
            false
        )

        val selfieFailedDialog = BaseDialog.yesnoDialog(
            view, R.drawable.ic_person_cross, getString(
                R.string.foto_selfie_kamu_gagal
            ), getString(R.string.desc_selfie_failed_dialog), getString(
                R.string.ya_foto_ulang
            ), getString(R.string.tidak_batal)
        )


        binding.apply {
            setClickListener { view ->
                when (view.id) {
                    R.id.btn_camera_finalize_selfie -> {
                        UtilFunction.stateViewGone(btnCameraFinalizeSelfie)
                        UtilFunction.stateViewGone(tvDescFinalizeSelfie)
                        UtilFunction.stateViewGone(borderFinalizeSelfie)
                        UtilFunction.stateViewGone(cameraFinalizeSelfie)
                        UtilFunction.stateViewGone(tvDescFinalizeSelfie)
                        UtilFunction.stateViewVisible(ivFinalizeSelfie)
                        UtilFunction.stateViewVisible(clFinalizeSelfie)

                    }
                    R.id.btn_use_finalize_selfie -> {
                        view.findNavController()
                            .navigate(R.id.action_finalizeSelfieFragment_to_finalizeThirdFragment)
                    }
                }
            }
        }


        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Handle the back button event
                    leavingSelfieDialog.show()
                    leavingSelfieDialog.findViewById<Button>(R.id.btn_no_yesno_base_dialog)
                        ?.setOnClickListener {
                            leavingSelfieDialog.dismiss()
                        }
                }
            }
        )
    }


}