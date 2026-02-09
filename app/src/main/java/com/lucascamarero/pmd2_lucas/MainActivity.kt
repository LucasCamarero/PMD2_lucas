package com.lucascamarero.pmd2_lucas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucascamarero.pmd2_lucas.logica.GranjaViewModel
import com.lucascamarero.pmd2_lucas.ui.theme.PMD2_lucasTheme
import com.lucascamarero.pmd2_lucas.ventanas.GranjaForm
import com.lucascamarero.pmd2_lucas.ventanas.VentanaVer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMD2_lucasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    gestorVentanas(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Gestiona la navegación de la app
@Composable
fun gestorVentanas(modifier: Modifier) {
    val context = LocalContext.current

    val granjaViewModel: GranjaViewModel = viewModel()

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "VentanaVer"
    ) {
        composable("GranjaForm")  { GranjaForm(navController, modifier, granjaViewModel) }
        composable("VentanaVer") { VentanaVer(navController, modifier, granjaViewModel) }
    }
}