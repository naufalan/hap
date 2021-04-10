package com.example.ceria.ui.home.apply

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyScoringBinding

class ApplyScoringFragment : Fragment() {

    private lateinit var binding: FragmentApplyScoringBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyScoringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val time = String.format(resources.getString(R.string.counter_apply_scoring), 50, 22)
            tvCounterApplyScoring.text = time

            btnHomeApplyScoring.setOnClickListener {
                val bundle = bundleOf("fromScoring" to true)
                view.findNavController()
                    .navigate(R.id.action_applyScoringFragment_to_nav_graph, bundle)
            }
        }
    }
}