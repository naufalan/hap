package com.example.ceria.ui.home.finalize.finished

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentFinalizeFinishedBinding

class FinalizeFinishedFragment : Fragment() {

    private lateinit var binding: FragmentFinalizeFinishedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinalizeFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            setClickListener { view ->
                when (view.id) {
                    R.id.btn_accept_finalize_finished -> {
                        val bundle = bundleOf("isfromFinalizeFinished" to true)
                        view.findNavController()
                            .navigate(R.id.action_finalizeFinishedFragment_to_nav_graph, bundle)
                    }
                    R.id.btn_welcome_finalize_finished -> {
                        view.findNavController()
                            .navigate(R.id.action_finalizeFinishedFragment_to_finalizeWelcomePackageFragment)
                    }
                }
            }
        }
    }
}