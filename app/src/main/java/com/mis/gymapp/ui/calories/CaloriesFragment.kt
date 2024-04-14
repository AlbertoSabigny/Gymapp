package com.mis.gymapp.ui.calories

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.mis.gymapp.R
import com.mis.gymapp.databinding.FragmentCaloriesBinding


class CaloriesFragment : Fragment() {
    private var _binding: FragmentCaloriesBinding? = null
    private val binding get() = _binding!!

    // TODO: Puedes agregar parámetros si es necesario
    private var currentProgress = 0
    private val maxProgress = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCaloriesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()



    }

    private fun initUI() {

        binding.pBcalories.max = 3200
        val currentProgress = 2500





        // Configurar el color del tinte para la parte cargada de la barra de progreso
        val tintedColor = ContextCompat.getColor(requireContext(), R.color.gold)
        binding.pBcalories.progressDrawable.setColorFilter(tintedColor, android.graphics.PorterDuff.Mode.SRC_IN)



        ObjectAnimator.ofInt(binding.pBcalories, "progress", currentProgress)
            .setDuration(1000)
            .start()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
