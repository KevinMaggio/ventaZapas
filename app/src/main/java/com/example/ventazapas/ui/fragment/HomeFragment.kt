package com.example.ventazapas.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ventazapas.R
import com.example.ventazapas.data.model.MockShoes
import com.example.ventazapas.databinding.FragmentHomeBinding
import com.example.ventazapas.ui.shoes.ShoesAdapter
import com.example.ventazapas.ui.shoes.ShoesViewModel

class HomeFragment : Fragment() {

    private val shoesViewModel by viewModels<ShoesViewModel>()
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeBinding.inflate(inflater,container,false)

        shoesViewModel.getMockShoes()
        shoesViewModel.listMockShoes.observe(viewLifecycleOwner,{
            initRecyclerView(it)
        })
        return binding.root
    }
    fun initRecyclerView(list : List<MockShoes>){
        val adapter = ShoesAdapter(list)
        binding.rvMoreSeen.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvMoreSeen.adapter= adapter
    }
}