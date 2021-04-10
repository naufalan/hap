package com.example.ceria.ui.home.finalize.reject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentFinalizeRejectBinding

class FinalizeRejectFragment : Fragment() {
    private lateinit var binding: FragmentFinalizeRejectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinalizeRejectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarFinalizeReject.setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }

            btnFinalizeReject.setOnClickListener { view ->
                val bundle = bundleOf("isFromFinalizeReject" to true)
                view.findNavController()
                    .navigate(R.id.action_finalizeRejectFragment_to_homeFragment, bundle)
            }
        }
    }

}