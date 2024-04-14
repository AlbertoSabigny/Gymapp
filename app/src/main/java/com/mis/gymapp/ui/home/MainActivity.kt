package com.mis.gymapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mis.gymapp.R
import com.mis.gymapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar el diseño de la actividad usando View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la interfaz de usuario
        initUI()
    }

    // Inicializar la interfaz de usuario
    private fun initUI() {
        // Inicializar la navegación
        initNavigation()
    }

    // Inicializar la configuración de navegación
    private fun initNavigation() {
        // Obtener el fragmento contenedor de la navegación desde el layout
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // Inicializar el controlador de navegación con el controlador asociado al NavHostFragment
        navController = navHost.navController

        // Configurar la barra de navegación inferior para que sea controlada por el navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}