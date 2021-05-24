package com.example.ceria.ui.auth.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentTncBinding
import com.example.ceria.util.AuthSelector

class TncFragment : Fragment(), NestedScrollView.OnScrollChangeListener {
    private lateinit var binding: FragmentTncBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTncBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.svTnc.setOnScrollChangeListener(this)
        Log.d("edPin","${arguments?.getString("phone")}")
        binding.apply {
            val webSettings = wvTnc.settings
            wvTnc.webViewClient = WebViewClient()
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
            wvTnc.loadData(text, "text/html", "utf-8")
            btnTnc.setOnClickListener {
//                findNavController().navigate(R.id.action_tncFragment_to_CreatePinFragment)
                val direction =
                    TncFragmentDirections.actionTncFragmentToCreatePinFragment(
                        AuthSelector.SIGNUP,
                        "${arguments?.getString("phone")}"
                    )
                findNavController().navigate(direction)
            }
            /*btnTnc.setOnClickListener{
                findNavController().navigate(R.id.action_tncFragment_to_OtpVerificationFragment)
            }*/

            val onBackPressedCallback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Handle the back button event
                    findNavController().navigate(R.id.action_tncFragment_to_signUpFragment)
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                onBackPressedCallback
            )

            toolbarTnc.setNavigationOnClickListener {
                findNavController().navigate(R.id.action_tncFragment_to_signUpFragment)
            }
        }
    }

    override fun onScrollChange(v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
        if (v != null) {
            if (v.getChildAt(0).bottom <= (v.height + scrollY)) {
                binding.btnTnc.isEnabled = true
            }
        }
    }
}