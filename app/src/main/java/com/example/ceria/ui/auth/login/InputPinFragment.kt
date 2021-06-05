package com.example.ceria.ui.auth.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.example.ceria.BuildConfig
import com.example.ceria.R
import com.example.ceria.databinding.FragmentInputPinBinding
import com.example.ceria.network.Service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit


class InputPinFragment : Fragment() {

    private lateinit var binding: FragmentInputPinBinding
    public var pin:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputPinBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("edPin","${arguments?.getString("username")}")
        binding. apply {
            setClickListener { view ->
                when (view.id) {
                    R.id.tv_forgot_input_pin -> {
                        view.findNavController()
                            .navigate(R.id.action_inputPinFragment_to_forgetPinFragment)
                    }
                    R.id.tv_1 -> {
                        pin += 1
                        Log.d("edPin",pin);
                        etInputPin.setText(pin)
                    }
                    R.id.tv_2 -> {
                        pin += 2
                        etInputPin.setText(pin)
                    }
                    R.id.tv_3 -> {
                        pin += 3
                        etInputPin.setText(pin)
                    }
                    R.id.tv_4 -> {
                        pin += 4
                        etInputPin.setText(pin)
                    }
                    R.id.tv_5 -> {
                        pin += 5
                        etInputPin.setText(pin)
                    }
                    R.id.tv_6 -> {
                        pin += 6
                        etInputPin.setText(pin)
                    }
                    R.id.tv_7 -> {
                        pin += 7
                        etInputPin.setText(pin)
                    }
                    R.id.tv_8 -> {
                        pin += 8
                        etInputPin.setText(pin)
                    }
                    R.id.tv_9 -> {
                        pin += 9
                        etInputPin.setText(pin)
                    }
                    R.id.tv_0 -> {
                        pin += 0
                        etInputPin.setText(pin)
                    }
                    R.id.tv_backspace -> {
                        pin = pin.dropLast(1)
                        Log.d("edPin",pin);
                        etInputPin.setText(pin)
                    }
                }
            }

            val pinEntry = etInputPin as PinEntryEditText?
            pinEntry?.setOnPinEnteredListener { str: CharSequence ->
                if(str.length==6){
                    check_auth(arguments?.getString("username").toString(),pin)
//                    if (str.toString() == "111111") {
//                        findNavController().navigate(R.id.action_inputPinFragment_to_homeFragment)
//                    } else {
                        pin = ""
                        pinEntry.setText(null)
//                    }
                }
            }

            /*etInputPin.setOnPinEnteredListener {
                fun onPinEntered(str: CharSequence) {
                    if (str.toString() == "111111"){
                        findNavController().navigate(R.id.action_inputPinFragment_to_homeFragment)
                    }
            }*/

        }

    }

    fun check_auth(phone:String,pin:String) {
        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL+"/auth/login/")
            .build()
        // Create Service
        val service = retrofit.create(Service::class.java)
        // Create HashMap with fields
        val params = HashMap<String?, String?>()
        params["phone_number"] = phone
        params["pin"] = pin
        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val response = service.userLogin(params)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val jresponse = JSONObject(response.body()?.string())
                    val status = jresponse.getString("success")
                    val message = jresponse.getString("message")
                    Log.d("retrofitReq", "${status} ${message}")

                    if(status.equals("true")){
                        findNavController().navigate(R.id.action_inputPinFragment_to_homeFragment)
                    }else{
                        Toast.makeText(activity,"${message}",Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Log.e("retrofitReq", "${response.raw().request().url()}")
                }
            }
        }
    }

}


