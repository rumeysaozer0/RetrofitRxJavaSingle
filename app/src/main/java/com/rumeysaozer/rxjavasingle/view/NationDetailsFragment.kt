package com.rumeysaozer.rxjavasingle.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.rumeysaozer.rxjavasingle.databinding.FragmentNationDetailsBinding


class NationDetailsFragment : Fragment() {
    private var _binding: FragmentNationDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<NationDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNationDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nation.text = args.nation.nationality
        binding.capital.text = args.nation.capital
        binding.flag.text = args.nation.flag
        binding.language.text = args.nation.language

    }


}