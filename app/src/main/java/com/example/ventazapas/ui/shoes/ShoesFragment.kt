package com.example.ventazapas.ui.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ventazapas.databinding.FragmentShoesBinding

class ShoesFragment : Fragment() {

    lateinit var binding: FragmentShoesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentShoesBinding.inflate(inflater,container, false)

        return binding.root
    }
}