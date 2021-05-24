package com.example.ceria.ui.auth.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ceria.BuildConfig
import com.example.ceria.R
import com.example.ceria.databinding.DialogChangePinSuccessBinding
import com.example.ceria.databinding.FragmentCreatePinBinding
import com.example.ceria.network.Service
import com.example.ceria.util.AuthSelector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit


class CreatePinFragment : Fragment() {
    private lateinit var binding: FragmentCreatePinBinding
    private val args: CreatePinFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreatePinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val auth = args.auth
        val phone = args.phone
        Log.d("edPin","${phone}")
        var isConfirmation = false
        binding.apply {
            if (auth == AuthSelector.SIGNUP) {
                tvTitleCreatePin.text = getString(R.string.create_pin)
                tvDescriptionCreatePin.text = getString(R.string.create_secure_pin_message)
            } else if (auth == AuthSelector.FORGET) {
                tvTitleCreatePin.text = getString(R.string.create_pin_forget)
                tvDescriptionCreatePin.text = getString(R.string.create_pin_forget_desc)
            }

            etCreatePin.setOnPinEnteredListener {
                if (it.length == 6) {
                    if (isConfirmation) {
                        if (auth == AuthSelector.SIGNUP) {
                            Log.d("edPin","${phone} ${it}")
                            process_register(phone,it.toString())
//                            findNavController().navigate(R.id.action_createPinFragment_to_signUpSuccessFragment)
                        } else if (auth == AuthSelector.FORGET) {
                            val dialogView = DialogChangePinSuccessBinding.inflate(
                                LayoutInflater.from(requireContext()), null, false
                            )
                            val changePinDialog = AlertDialog.Builder(requireContext()).create()
                            changePinDialog.setView(dialogView.root)
                            dialogView.ivCloseChangePinSuccess.setOnClickListener {
                                changePinDialog.dismiss()
                            }
                            changePinDialog.show()
                        }
                        isConfirmation = !isConfirmation
                    } else {
                        etCreatePin.text?.clear()
                        tvTitleCreatePin.text = getString(R.string.pin_confirmation)
                        tvDescriptionCreatePin.text = getString(R.string.reinput_pin)
                        isConfirmation = !isConfirmation
                    }
                }
            }
        }
    }

    fun process_register(phone:String,pin:String) {
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
            val response = service.userRegister(params)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val jresponse = JSONObject(response.body()?.string())
                    val status = jresponse.getString("success")
                    val message = jresponse.getString("message")

                    Log.d("retrofitReq", "${status} ${message}")

                    if(status.equals("true")){
                        Toast.makeText(activity,"${message}", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_createPinFragment_to_signUpSuccessFragment)
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