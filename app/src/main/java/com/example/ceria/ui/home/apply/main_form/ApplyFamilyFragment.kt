package com.example.ceria.ui.home.apply.main_form

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ceria.BuildConfig
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyFamilyBinding
import com.example.ceria.network.Service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit

class ApplyFamilyFragment : Fragment() {

    private lateinit var binding: FragmentApplyFamilyBinding
    private lateinit var viewModel: ApplyFamilyViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarApplyFamily.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            val spinnerAdapter10 = ArrayAdapter<String>(
                    requireContext(),
                    R.layout.support_simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.dependents)
            )
            val spinnerAdapter11 = ArrayAdapter<String>(
                    requireContext(),
                    R.layout.support_simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.relation)
            )
            spinnerDependencyApplyFamily.adapter = spinnerAdapter10
            spinnerRelationApplyFamily.adapter = spinnerAdapter11
            btnApplyFamily.setOnClickListener { view ->
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref?.edit()) {
                    this?.putBoolean("isFamilyDataFilled", true)
                    this?.apply()
                }
                process_relative(arguments?.getString("maiden_name").toString(),
                        depend = spinnerAdapter10.toString(),
                        relate = etNameApplyFamily.toString(),
                        relate2 = spinnerAdapter11.toString(),
                        phone_r = etPhoneApplyFamily.toString(),
                        add_r = etAddressApplyFamily.toString(),
                        zip_num = etPostalCodeApplyFamily.toString())
                view.findNavController().navigate(R.id.action_applyFamilyFragment_to_applyFourthFragment)
            }
        }
    }
    fun process_relative(ma_name:String,depend:String,relate:String,relate2:String,phone_r:String,add_r:String,zip_num:String) {
        // Create Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL+"/user/relative/")
                .build()
        // Create Service
        val service = retrofit.create(Service::class.java)
        // Create HashMap with fields
        val params = HashMap<String?, String?>()
        params["maiden_name"] = ma_name
        params["dependents"] = depend
        params["relative"] = relate
        params["relation"] = relate2
        params["phone_relative"] = phone_r
        params["address_relative"] = add_r
        params["zipcode_num"] = zip_num

        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val response = service.userRelative(params)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val jresponse = JSONObject(response.body()?.string())
                    val status = jresponse.getString("success")
                    val message = jresponse.getString("message")

                    Log.d("retrofitReq", "${status} ${message}")

                    if(status.equals("true")){
                        findNavController().navigate(R.id.action_applyFamilyFragment_to_applyFourthFragment)
                    }else{
                        Toast.makeText(activity,"${message}", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Log.e("retrofitReq", "${response.raw().request().url()}")
                }
            }
        }
    }

}