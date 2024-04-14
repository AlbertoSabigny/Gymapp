package com.mis.gymapp.ui.gym

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mis.gymapp.databinding.FragmentGymBinding
import com.mis.gymapp.domain.model.GymInfo
import com.mis.gymapp.domain.model.GymModel
import com.mis.gymapp.ui.gym.adapter.GymAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GymFragment : Fragment() {

    private val gymViewModel by viewModels<GymViewModel> ()

    private lateinit var gymAdapter: GymAdapter
    private var _binding: FragmentGymBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                gymViewModel.exercise.collect {
                    //CAMBIOS EN HOROSCOPE
                    gymAdapter.updteList(it)
                }
            }
        }
    }

    private fun initList() {
        gymAdapter = GymAdapter(onItemSelected = {
            val type = when(it){
                GymInfo.Press->
                    GymModel.Press.apiName
                GymInfo.Curl ->
                    GymModel.Curl.apiName
                GymInfo.Curl3 ->
                    GymModel.Curl3.apiName
                GymInfo.Press2 ->
                    GymModel.Press2.apiName
                GymInfo.Sentadilla ->
                    GymModel.Squats.apiName
            }
            println(type)
            findNavController().navigate(
                GymFragmentDirections.actionGymFragmentToGymDetailActivity(type)
            )
        })
        binding.rvGym.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = gymAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGymBinding.inflate(inflater, container, false)
        return binding.root
    }
}


























