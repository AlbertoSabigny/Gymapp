package com.mis.gymapp.ui.recipes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mis.gymapp.R
import com.mis.gymapp.databinding.FragmentGymBinding
import com.mis.gymapp.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {



    private val recipesviewModel by viewModels<RecipesViewModel> ()

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }



}