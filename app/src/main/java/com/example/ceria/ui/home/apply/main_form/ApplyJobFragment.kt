package com.example.ceria.ui.home.apply.main_form

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ceria.BuildConfig
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyJobBinding
import com.example.ceria.network.Service
import com.example.ceria.util.UtilFunction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit
import java.util.*

class ApplyJobFragment : Fragment() {

    private lateinit var viewModel: ApplyJobViewModel
    private lateinit var binding: FragmentApplyJobBinding

    private var calendarPicker = Calendar.getInstance()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyJobBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarApplyJob.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            val spinnerAdapter12 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.sumber_peng)
                )
            }
            val spinnerAdapter13 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.jenis_work)
                )
            }
            val spinnerAdapter14 = context?.let {
                ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        it.resources.getStringArray(R.array.stat_work)
                )
            }

            spinnerIncomeApplyJob.adapter = spinnerAdapter12
            spinnerTypeApplyJob.adapter = spinnerAdapter13
            spinnerStatusApplyJob.adapter = spinnerAdapter14

            setClickListener { view ->
                when (view.id) {
                    R.id.tv_start_apply_job -> {
                        DatePickerDialog(
                                requireContext(),
                                UtilFunction.datePickerListener(calendarPicker, tvStartApplyJob),
                                calendarPicker.get(Calendar.YEAR),
                                calendarPicker.get(Calendar.MONTH),
                                calendarPicker.get(Calendar.DAY_OF_MONTH)
                        ).show()
                    }
                    R.id.tv_end_apply_job -> {
                        DatePickerDialog(
                                requireContext(),
                                UtilFunction.datePickerListener(calendarPicker, tvEndApplyJob),
                                calendarPicker.get(Calendar.YEAR),
                                calendarPicker.get(Calendar.MONTH),
                                calendarPicker.get(Calendar.DAY_OF_MONTH)
                        ).show()
                    }
                    R.id.btn_apply_job -> {
                        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                        with(sharedPref?.edit()) {
                            this?.putBoolean("isJobDataFilled", true)
                            this?.apply()
                        }
                        process_work(arguments?.getString("users_id").toString(),
                                npwp = etNpwpApplyJob.toString(),
                                inc = spinnerAdapter12.toString(),
                                inc_net = etNetApplyJob.toString(),
                                work = spinnerAdapter13.toString(),
                                work_pl = etCompanyApplyJob.toString(),
                                work_stat = spinnerAdapter14.toString(),
                                work_start = tvStartApplyJob.toString(),
                                work_end = tvEndApplyJob.toString())
                        view.findNavController()
                                .navigate(R.id.action_applyJobFragment_to_applyFourthFragment)
                    }
                }

            }
        }

    }
    fun process_work(users_id:String,npwp:String,inc:String,inc_net:String,work:String,work_pl:String,work_stat:String,work_start:String,work_end:String) {
        // Create Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL+"/user/work/")
                .build()
        // Create Service
        val service = retrofit.create(Service::class.java)
        // Create HashMap with fields
        val params = HashMap<String?, String?>()
        params["users_id"] = users_id
        params["npwp_num"] = npwp
        params["income"] = inc
        params["income_net"] = inc_net
        params["work"] = work
        params["work_place"] = work_pl
        params["work_status"] = work_stat
        params["work_start"] = work_start
        params["work_end"] = work_end

        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val response = service.userWork(params)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val jresponse = JSONObject(response.body()?.string())
                    val status = jresponse.getString("success")
                    val message = jresponse.getString("message")

                    Log.d("retrofitReq", "${status} ${message}")

                    if(status.equals("true")){
                        findNavController().navigate(R.id.action_applyJobFragment_to_applyFourthFragment)
                    }else{
                        Toast.makeText(activity,"${message}", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Log.e("retrofitReq", "${response.raw().request().url()}")
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplyJobViewModel::class.java)
        // TODO: Use the ViewModel
    }

}