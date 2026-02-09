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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.lucascamarero.pmd2_lucas.components.DefaultColumn
import com.lucascamarero.pmd2_lucas.logica.InversionTotal

@Composable
fun VentanaVer(
    navController: NavController,
    modifier: Modifier,
    viewModel: GranjaViewModel
) {
    val animales = viewModel.listaAnimales

    var inversionTotal by remember { mutableStateOf(0) }

    DefaultColumn(modifier = modifier) {
        Text("VentanaVer")

        Button({
            viewModel.pruebas()
        }) { Text("Insertar datos de prueba") }

        Button(onClick = {
            navController.navigate("GranjaForm")
        }) {
            Text("Añadir animal")
        }

        // COLUMNA DE VISUALIZACIÓN DE DATOS
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(animales) { animal ->
                //TODO Asegurate que se visualizan los animales
                Text(text = animal.imprimir(), modifier = Modifier.padding(4.dp))
                Divider()
            }

            item {
                inversionTotal = animales.InversionTotal()
                Text("Inversión Total = $inversionTotal")
            }
        }
    }
}