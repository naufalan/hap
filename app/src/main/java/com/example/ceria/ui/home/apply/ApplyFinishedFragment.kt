package com.example.ceria.ui.home.apply

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyFinishedBinding
import com.example.ceria.util.BaseDialog

class ApplyFinishedFragment : Fragment() {
    private lateinit var binding: FragmentApplyFinishedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentApplyFinishedBinding.inflate(inflater, container, false).apply {
            val title = String.format(getString(R.string.apply_finished), "5.000.000")
            val titleText: String
            val refuseText: String

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                titleText = Html.fromHtml(title, Html.FROM_HTML_MODE_LEGACY).toString()
                refuseText =
                    Html.fromHtml(
                        getString(R.string.tolak_amp_batalkan),
                        Html.FROM_HTML_MODE_LEGACY
                    )
                        .toString()
            } else {
                titleText = Html.fromHtml(title).toString()
                refuseText = Html.fromHtml(getString(R.string.tolak_amp_batalkan)).toString()
            }

            tvApplyFinished.text = titleText
            btnRefuseApplyFinished.text = refuseText.toUpperCase()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            cbApplyFinished.setOnCheckedChangeListener(checkBoxListener)

            toolbarApplyFinished.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            setClickListener { view ->
                when (view.id) {
                    R.id.btn_refuse_apply_finished -> {
                        val rejectDialog = BaseDialog.yesnoDialog(
                            view, null,
                            getString(R.string.tunggu_dulu),
                            "Membatalkan pengajuan berarti kamu harus mengulang kembali mengisi data-data yang diperlukan.",
                            "Batalkan",
                            getString(R.string.tidak)
                        )
                        rejectDialog.show()
                        rejectDialog.findViewById<Button>(R.id.btn_no_yesno_base_dialog)
                            ?.setOnClickListener {
                                rejectDialog.dismiss()
                            }
                        rejectDialog.findViewById<Button>(R.id.btn_yes_yesno_base_dialog)
                            ?.setOnClickListener {
                                view.findNavController()
                                    .navigate(R.id.action_applyFinishedFragment_to_finalizeRejectFragment)
                                rejectDialog.dismiss()
                            }

                    }

                    R.id.btn_accept_apply_finished -> {
                        view.findNavController()
                            .navigate(R.id.action_applyFinishedFragment_to_navigation_finalize)
                    }
                }

            }
        }
    }

    private val checkBoxListener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        binding.btnAcceptApplyFinished.isEnabled = isChecked
    }
}