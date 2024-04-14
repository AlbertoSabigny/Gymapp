package com.mis.gymapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.mis.gymapp.R
import com.mis.gymapp.databinding.ActivityGymDetailBinding
import com.mis.gymapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GymDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGymDetailBinding
    private val gymDetailViewModel:GymDetailViewModel by viewModels()

    private val args:GymDetailActivityArgs by navArgs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGymDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Imprimir en el Logcat
        println(args.type)
        initUI()
        gymDetailViewModel.getExcercise(args.type)

    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                gymDetailViewModel.state.collect(){
                    when(it){
                        is GymDetailState.Error -> errorState()

                        GymDetailState.Loading -> loadingState()

                        is GymDetailState.Sucess -> sucessState(it)

                    }
                }

            }
        }
    }

    private fun sucessState(state: GymDetailState.Sucess) {
        binding.pb.isVisible= false
        binding.txtType.text = state.target
        binding.txtName.text = state.name
        binding.txtMuscle.text = state.bodyPart
        binding.txtEquipment.text = state.equipment


        val context = binding.txtName.context

// Utilizar Glide para cargar la imagen
        Glide.with(context)
            .load(state.gifUrl)  // Assuming gifUrl is the property in your GymModel for the GIF
            .into(binding.exoPlayerView)


    }

    private fun errorState() {
        binding.pb.isVisible= true
    }

    private fun loadingState() {
        binding.pb.isVisible= true



    }
}