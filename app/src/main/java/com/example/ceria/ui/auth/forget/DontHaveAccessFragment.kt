package com.example.ceria.ui.auth.forget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceria.databinding.FragmentDontHaveAccessBinding


class DontHaveAccessFragment : Fragment() {
    private lateinit var binding: FragmentDontHaveAccessBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDontHaveAccessBinding.inflate(inflater, container, false)
        return binding.root
    }

}