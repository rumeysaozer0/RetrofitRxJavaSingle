package com.rumeysaozer.rxjavasingle.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.rxjavasingle.adapter.NationAdapter
import com.rumeysaozer.rxjavasingle.databinding.FragmentNationBinding
import com.rumeysaozer.rxjavasingle.viewmodel.NationViewModel


class NationFragment : Fragment() {
    private var _binding: FragmentNationBinding? = null
    private val binding get() = _binding!!
    private var viewModel = NationViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NationViewModel::class.java)
        viewModel.getData()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getData()
    }
    fun getData(){
        viewModel.nation.observe(viewLifecycleOwner, Observer { nation->
            nation?.let {
                val adapter = NationAdapter(it)
                binding.recyclerView.adapter = adapter
            }

        })
    }

}