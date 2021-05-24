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
import com.example.ceria.databinding.FragmentApplyPersonalBinding
import com.example.ceria.network.Service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit


class ApplyPersonalFragment : Fragment() {
    private lateinit var binding: FragmentApplyPersonalBinding
    private val list = ArrayList<Int>()
    private lateinit var adapter: ApplyPersonalAdapter


    companion object {
        fun newInstance() = ApplyPersonalFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyPersonalBinding.inflate(inflater, container, false)
        adapter = ApplyPersonalAdapter(list, requireContext())
        list.add(0)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            toolbarApplyPersonal.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }


            rvCardApplyPersonal.adapter = adapter
            val spinnerAdapter = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.credit_card)
                )
            }
            val spinnerAdapter2 = context?.let {
                ArrayAdapter<String>(
                    it,
                    R.layout.support_simple_spinner_dropdown_item,
                    it.resources.getStringArray(R.array.edu_last)
                )
            }
            val spinnerAdapter3 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.marital_stat)
                )
            }
            val spinnerAdapter4 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.prov)
                )
            }
            val spinnerAdapter5 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.city)
                )
            }
            val spinnerAdapter6 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.kec)
                )
            }
            val spinnerAdapter7 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.kel)
                )
            }
            val spinnerAdapter8 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.stat_home)
                )
            }
            val spinnerAdapter9 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.berapa_lama)
                )
            }

            spinnerCityApplyPersonal.adapter = spinnerAdapter5
            spinnerDistrictApplyPersonal.adapter = spinnerAdapter6
            spinnerHowlongApplyPersonal.adapter = spinnerAdapter9
            spinnerProvinceApplyPersonal.adapter = spinnerAdapter4
            spinnerResidencyApplyPersonal.adapter = spinnerAdapter8
            spinnerVillageApplyPersonal.adapter = spinnerAdapter7
            spinnerEduApplyPersonal.adapter = spinnerAdapter2
            spinnerStatusApplyPersonal.adapter = spinnerAdapter3

            btnApplyPersonal.setOnClickListener {
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref?.edit()) {
                    this?.putBoolean("isPersonalDataFilled", true)
                    this?.apply()
                }
                process_profile(arguments?.getString("users_id").toString(),
                        email = etEmailApplyPersonal.toString(),
                        edu = spinnerAdapter2.toString(),
                        marital_stat = spinnerAdapter3.toString(),
                        phone_home = etPhoneApplyPersonal.toString(),
                        cr_card = spinnerAdapter.toString())
                process_place(arguments?.getString("users_id").toString(),
                        address = etStreetApplyPersonal.toString(),
                        province = spinnerAdapter4.toString(),
                        city = spinnerAdapter5.toString(),
                        district = spinnerAdapter6.toString(),
                        village = spinnerAdapter7.toString(),
                        rt = etRtrwApplyPersonal.toString(),
                        residency = spinnerAdapter8.toString(),
                        how_long = spinnerAdapter9.toString())

                view.findNavController().navigate(R.id.action_applyPersonalFragment_to_applyFourthFragment)
            }

        }
    }
    fun process_profile(users_id:String,email:String,edu:String,marital_stat:String,phone_home:String,cr_card:String){
        // Create Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL+"/user/profile/")
                .build()
        // Create Service
        val service = retrofit.create(Service::class.java)
        // Create HashMap with fields
        val params = HashMap<String?, String?>()
        params["users_id"] = users_id
        params["e_mail"] = email
        params["edu"] = edu
        params["marital_status"] = marital_stat
        params["phone_home"] = phone_home
        params["credit_card_bank"] = cr_card
        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val response = service.userProfile(params)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val jresponse = JSONObject(response.body()?.string())
                    val status = jresponse.getString("success")
                    val message = jresponse.getString("message")

                    Log.d("retrofitReq", "${status} ${message}")

                    if(status.equals("true")){
                        Toast.makeText(activity,"${message}", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_applyPersonalFragment_to_applyFourthFragment)
                    }else{
                        Toast.makeText(activity,"${message}", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("retrofitReq", "${response.raw().request().url()}")
                }
            }
        }
    }
    fun process_place(users_id: String,address:String,province:String,city:String,district:String,village:String,rt:String,residency:String,how_long:String){
        // Create Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL+"/user/place/")
                .build()
        // Create Service
        val service = retrofit.create(Service::class.java)
        // Create HashMap with fields
        val params = HashMap<String?, String?>()
        params["users_id"] = users_id
        params["alamat"] = address
        params["provinsi"] = province
        params["kota_kab"] = city
        params["kec"] = district
        params["kel"] = village
        params["rt_rw"] = rt
        params["status_rumah"] = residency
        params["date_tempat"] = how_long
        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val response = service.userPlace(params)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val jresponse = JSONObject(response.body()?.string())
                    val status = jresponse.getString("success")
                    val message = jresponse.getString("message")

                    Log.d("retrofitReq", "${status} ${message}")

                    if(status.equals("true")){
                        Toast.makeText(activity,"${message}", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_applyPersonalFragment_to_applyFourthFragment)
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