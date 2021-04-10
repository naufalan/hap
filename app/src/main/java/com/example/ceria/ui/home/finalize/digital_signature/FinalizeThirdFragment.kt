package com.example.ceria.ui.home.finalize.digital_signature

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.DialogTncDigitalSignatureBinding
import com.example.ceria.databinding.FragmentFinalizeThirdBinding
import com.example.ceria.ui.home.finalize.digital_signature.FinalizeThirdViewModel
import com.example.ceria.util.BaseDialog
import com.example.ceria.util.UtilFunction

class FinalizeThirdFragment : Fragment() {

    private lateinit var viewModel: FinalizeThirdViewModel
    private lateinit var binding: FragmentFinalizeThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalizeThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uploadFailedDialog = BaseDialog.simpleDialog(
            view,
            R.drawable.ic_person_cross,
            getString(
                R.string.ups
            ),
            getString(R.string.desc_upload_failed_dialog),
            getString(R.string.foto_selfie_ulang),
            false
        )

        val privyDialog = privyDialog()

        val tncDigitalSignatureDialog = tncDigitalSignatureDialog()

        binding.apply {
            setClickListener { view ->
                cbFinalizeThird.setOnCheckedChangeListener(checkBoxListener)
                when (view.id) {
                    R.id.iv_information_finalize_third -> {
                        val informationDialog = BaseDialog.simpleDialog(
                            view, R.drawable.ic_id, getString(R.string.digital_signature),
                            getString(R.string.information_digital_signature), "", true
                        )
                        informationDialog.show()
                        informationDialog.findViewById<Button>(R.id.btn_base_dialog)
                            ?.let { UtilFunction.stateViewGone(it) }
                        informationDialog.findViewById<ImageView>(R.id.iv_base_dialog)
                            ?.let { UtilFunction.stateViewGone(it) }
                    }
                    R.id.btn_finalize_third -> {
                        uploadFailedDialog.show()
                        uploadFailedDialog.findViewById<Button>(R.id.btn_base_dialog)
                            ?.setOnClickListener {
                                tncDigitalSignatureDialog.show()
                                tncDigitalSignatureDialog.findViewById<Button>(R.id.btn_tnc_digital_signature)
                                    ?.setOnClickListener {
                                        privyDialog.show()
                                        privyDialog.findViewById<Button>(R.id.btn_privy)
                                            ?.setOnClickListener {
                                                view.findNavController()
                                                    .navigate(R.id.action_finalizeThirdFragment_to_finalizeFourthFragment)
                                                privyDialog.dismiss()
                                            }
                                        tncDigitalSignatureDialog.dismiss()
                                    }
                                uploadFailedDialog.dismiss()
                            }
                    }

                    R.id.cl_finalize_third -> {
                        view.findNavController()
                            .navigate(R.id.action_finalizeThirdFragment_to_finalizeSelfieFragment)
                    }
                }
            }
        }
    }

    private fun tncDigitalSignatureDialog(): AlertDialog {
        val dialogView = DialogTncDigitalSignatureBinding.inflate(
            LayoutInflater.from(requireContext()),
            null,
            false
        )
        val tncDigitalSignatureDialog = AlertDialog.Builder(requireContext()).create()
        dialogView.apply {
            ivCloseTncDigitalSignature.setOnClickListener {
                tncDigitalSignatureDialog.dismiss()
            }
            val webSettings = wvTncDigitalSignature.settings
            wvTncDigitalSignature.webViewClient = WebViewClient()
            webSettings.javaScriptEnabled = true
            webSettings.domStorageEnabled = true
            webSettings.defaultFontSize = 12

            val text =
                " <div ng-if=\"UserInfo.approvedTermsAndConditions || !UserInfo.isAuthenticated\">\n" +
                        "\t<ncy-breadcrumb></ncy-breadcrumb>\n" +
                        "</div>\n" +
                        "<div class=\"container\">\n" +
                        "\t<div class=\"row\">\n" +
                        "\t\t<div class=\"col-md-8 col-md-offset-2\">\n" +
                        "\t\t\t<form name=\"tandc\" ng-submit=\"approveTandC()\">\n" +
                        "\t\t\t\t<div class=\"panel panel-default\" style=\"margin-top:20px;\">\n" +
                        "\t\t\t\t\t<div class=\"panel-body\" style=\"max-height:600px; overflow-y:scroll; background-color:white;\">\n" +
                        "\t\t\t\t\t\t<div style=\"text-align:center;\">\n" +
                        "\t\t\t\t\t\t\t<h1>Terms and Conditions</h1>\n" +
                        "\t\t\t\t\t\t\t<p>\n" +
                        "\t\t\t\t\t\t\t\tThis is where your terms and conditions content will go.\n" +
                        "\t\t\t\t\t\t\t</p>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t\t<div style=\"text-align:center;\" ng-if=\"settings.Authentication.RequireTermsAndConditions && !UserInfo.approvedTermsAndConditions && UserInfo.isAuthenticated\">\n" +
                        "\t\t\t\t\t<button style=\"margin:20px;\" class=\"btn btn-primary\" type=\"submit\">Agree to Terms and Conditions</button>\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</form>\n" +
                        "\t\t</div>\n" +
                        "\t</div>\n" +
                        "</div>\n" +
                        " <div ng-if=\"UserInfo.approvedTermsAndConditions || !UserInfo.isAuthenticated\">\n" +
                        "\t<ncy-breadcrumb></ncy-breadcrumb>\n" +
                        "</div>\n" +
                        "<div class=\"container\">\n" +
                        "\t<div class=\"row\">\n" +
                        "\t\t<div class=\"col-md-8 col-md-offset-2\">\n" +
                        "\t\t\t<form name=\"tandc\" ng-submit=\"approveTandC()\">\n" +
                        "\t\t\t\t<div class=\"panel panel-default\" style=\"margin-top:20px;\">\n" +
                        "\t\t\t\t\t<div class=\"panel-body\" style=\"max-height:600px; overflow-y:scroll; background-color:white;\">\n" +
                        "\t\t\t\t\t\t<div style=\"text-align:center;\">\n" +
                        "\t\t\t\t\t\t\t<h1>Terms and Conditions</h1>\n" +
                        "\t\t\t\t\t\t\t<p>\n" +
                        "\t\t\t\t\t\t\t\tThis is where your terms and conditions content will go.\n" +
                        "\t\t\t\t\t\t\t</p>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t\t<div style=\"text-align:center;\" ng-if=\"settings.Authentication.RequireTermsAndConditions && !UserInfo.approvedTermsAndConditions && UserInfo.isAuthenticated\">\n" +
                        "\t\t\t\t\t<button style=\"margin:20px;\" class=\"btn btn-primary\" type=\"submit\">Agree to Terms and Conditions</button>\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</form>\n" +
                        "\t\t</div>\n" +
                        "\t</div>\n" +
                        "</div>\n" +
                        " <div ng-if=\"UserInfo.approvedTermsAndConditions || !UserInfo.isAuthenticated\">\n" +
                        "\t<ncy-breadcrumb></ncy-breadcrumb>\n" +
                        "</div>\n" +
                        "<div class=\"container\">\n" +
                        "\t<div class=\"row\">\n" +
                        "\t\t<div class=\"col-md-8 col-md-offset-2\">\n" +
                        "\t\t\t<form name=\"tandc\" ng-submit=\"approveTandC()\">\n" +
                        "\t\t\t\t<div class=\"panel panel-default\" style=\"margin-top:20px;\">\n" +
                        "\t\t\t\t\t<div class=\"panel-body\" style=\"max-height:600px; overflow-y:scroll; background-color:white;\">\n" +
                        "\t\t\t\t\t\t<div style=\"text-align:center;\">\n" +
                        "\t\t\t\t\t\t\t<h1>Terms and Conditions</h1>\n" +
                        "\t\t\t\t\t\t\t<p>\n" +
                        "\t\t\t\t\t\t\t\tThis is where your terms and conditions content will go.\n" +
                        "\t\t\t\t\t\t\t</p>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t\t<div style=\"text-align:center;\" ng-if=\"settings.Authentication.RequireTermsAndConditions && !UserInfo.approvedTermsAndConditions && UserInfo.isAuthenticated\">\n" +
                        "\t\t\t\t\t<button style=\"margin:20px;\" class=\"btn btn-primary\" type=\"submit\">Agree to Terms and Conditions</button>\n" +
                        "\t\t\t\t</div>\n" +
                        "\t\t\t</form>\n" +
                        "\t\t</div>\n" +
                        "\t</div>\n" +
                        "</div>\n"
            wvTncDigitalSignature.loadData(text, "text/html", "utf-8")

            svTncDigitalSignature.setOnScrollChangeListener { v: NestedScrollView, _: Int, _: Int, _: Int, _: Int ->
                val view: View? = v.getChildAt(v.childCount - 1)
                val diff: Int = view?.bottom!! - (v.height + v.scrollY)

                // if diff is zero, then the bottom has been reached
                if (diff == 0) {
                    btnTncDigitalSignature.isEnabled = true
                }
            }

            val handler = Handler()
            handler.postDelayed({
                val observer: ViewTreeObserver = svTncDigitalSignature.viewTreeObserver
                observer.addOnGlobalLayoutListener {
                    val viewHeight: Int = svTncDigitalSignature.measuredHeight
                    val contentHeight: Int = svTncDigitalSignature.getChildAt(0).measuredHeight
                    btnTncDigitalSignature.isEnabled = viewHeight > contentHeight
                }
            }, 0)
        }

        tncDigitalSignatureDialog.setView(dialogView.root)
        tncDigitalSignatureDialog.setCancelable(false)

        return tncDigitalSignatureDialog
    }

    private fun privyDialog(): AlertDialog {
        val factory = LayoutInflater.from(requireContext())
        val dialogView = factory.inflate(R.layout.dialog_privy, null)
        val privyDialog = AlertDialog.Builder(requireContext()).create()

        privyDialog.setView(dialogView)
        privyDialog.setCancelable(false)

        return privyDialog
    }

    private val checkBoxListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        binding.btnFinalizeThird.isEnabled = isChecked
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FinalizeThirdViewModel::class.java)
        // TODO: Use the ViewModel
    }
}