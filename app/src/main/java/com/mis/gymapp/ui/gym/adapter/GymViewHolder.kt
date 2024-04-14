package com.mis.gymapp.ui.gym.adapter

import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mis.gymapp.databinding.ItemExerciseBinding
import com.mis.gymapp.domain.model.GymInfo

class GymViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding = ItemExerciseBinding.bind(view)
    fun render (gymInfo: GymInfo, onItemSelected:(GymInfo)->Unit){
        val context = binding.tvTitle.context

        // Utilizar Glide para cargar la imagen
        Glide.with(context)
            .load(gymInfo.img)
            .into(binding.ivExercise)
        binding.tvTitle.text = context.getString(gymInfo.name)


        binding.parent.setOnClickListener{
            startScaleAnimation(
                binding.ivExercise,
                newLambda = {onItemSelected(gymInfo)}

            )
        }
    }

    private fun startScaleAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
            scaleXBy(0.2f)
            scaleYBy(0.2f)
            withEndAction {
                scaleXBy(-0.2f)
                scaleYBy(-0.2f)
                newLambda()
            }
            start()
        }
    }

}