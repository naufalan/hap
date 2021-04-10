package com.example.ceria.ui.home.finalize.finished

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.ceria.databinding.FragmentFinalizeWelcomePackageBinding


class FinalizeWelcomePackageFragment : Fragment() {

    private lateinit var binding: FragmentFinalizeWelcomePackageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinalizeWelcomePackageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val webSettings = wvFinalizeWelcomePackage.settings
            wvFinalizeWelcomePackage.webViewClient = WebViewClient()
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
                        "</div>\n"
            wvFinalizeWelcomePackage.loadData(text, "text/html", "utf-8")
        }
    }
}