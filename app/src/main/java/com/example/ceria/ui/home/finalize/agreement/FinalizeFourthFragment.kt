package com.example.ceria.ui.home.finalize.agreement

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.webkit.WebViewClient
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentFinalizeFourthBinding

class FinalizeFourthFragment : Fragment() {

    private lateinit var binding: FragmentFinalizeFourthBinding
    private lateinit var viewModel: FinalizeFourthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalizeFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val webSettings = wvFinalizeFourth.settings
            wvFinalizeFourth.webViewClient = WebViewClient()
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
            wvFinalizeFourth.loadData(text, "text/html", "utf-8")


            svFinalizeFourth.setOnScrollChangeListener { v: NestedScrollView, _: Int, _: Int, _: Int, _: Int ->
                val view: View? = v.getChildAt(v.childCount - 1)
                val diff: Int = view?.bottom!! - (v.height + v.scrollY)

                // if diff is zero, then the bottom has been reached
                if (diff == 0) {
                    btnFinalizeFourth.isEnabled = true
                }
            }

            val handler = Handler()
            handler.postDelayed({
                val observer: ViewTreeObserver = svFinalizeFourth.viewTreeObserver
                observer.addOnGlobalLayoutListener {
                    val viewHeight: Int = svFinalizeFourth.measuredHeight
                    val contentHeight: Int = svFinalizeFourth.getChildAt(0).measuredHeight
                    btnFinalizeFourth.isEnabled = viewHeight > contentHeight
                }
            }, 0)

            btnFinalizeFourth.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_finalizeFourthFragment_to_finalizeFifthFragment)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FinalizeFourthViewModel::class.java)
        // TODO: Use the ViewModel
    }

}