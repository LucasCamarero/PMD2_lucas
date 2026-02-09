package com.lucascamarero.pmd2_lucas.ventanas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucascamarero.pmd2_lucas.logica.GranjaViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.navigation.NavController
import com.lucascamarero.pmd2_lucas.components.DefaultColumn

@Composable
fun VentanaVer(
    navController: NavController,
    modifier: Modifier,
    viewModel: GranjaViewModel
) {
    val animales = viewModel.listaAnimales

    DefaultColumn(modifier = modifier) {
        //TODO Crea los botones

        // COLUMNA DE VISUALICACIÓN DE DATOS
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(animales) { animal ->
                //TODO Asegurate que se visualizan los animales
                Text(text = animal.toString(), modifier = Modifier.padding(4.dp))
                Divider()
            }
        }
    }
}