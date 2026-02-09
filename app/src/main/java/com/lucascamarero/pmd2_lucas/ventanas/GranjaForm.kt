package com.lucascamarero.pmd2_lucas.ventanas

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucascamarero.pmd2_lucas.components.DefaultColumn
import com.lucascamarero.pmd2_lucas.components.DefaultOutlinedTextField
import com.lucascamarero.pmd2_lucas.MyLog
import com.lucascamarero.pmd2_lucas.logica.GranjaViewModel
import com.lucascamarero.pmd2_lucas.logica.RadioAnimal
import kotlinx.coroutines.launch

@Composable
fun GranjaForm(
    navController: NavController,
    modifier: Modifier,
    viewModel: GranjaViewModel
) {
    val uiScope = rememberCoroutineScope()

    DefaultColumn(modifier = modifier) {
        Text("AnimalForm: ")

        DefaultOutlinedTextField(
            texto = viewModel.nombre,
            onTextoChange = { nuevoTexto -> viewModel.onNombreChanged(nuevoTexto) },
            placeholder = "Nombre"
        )

        DefaultOutlinedTextField(
            texto = viewModel.inversionStr,
            onTextoChange = { nuevoTexto -> viewModel.onInversionChanged(nuevoTexto) },
            placeholder = "Inversion"
        )

        DefaultOutlinedTextField(
            texto = viewModel.retornoStr,
            onTextoChange = { nuevoTexto -> viewModel.onRetornoStrChanged(nuevoTexto) },
            placeholder = "Retorno"
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            val animal by viewModel.radioAnimal

            RadioButton(
                selected = animal == RadioAnimal.VACA,
                onClick = {
                    viewModel.cambiarAnimal(RadioAnimal.VACA)
                    MyLog.d("GranjaForm-animal:${animal}")
                }
            )
            Text("Vaca")

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = animal == RadioAnimal.GALLINA,
                onClick = {
                    viewModel.cambiarAnimal(RadioAnimal.GALLINA)
                    MyLog.d("GranjaForm-animal:${animal}")
                }
            )
            Text("Gallina")

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = animal == RadioAnimal.OVEJA,
                onClick = {
                    viewModel.cambiarAnimal(RadioAnimal.OVEJA)
                    MyLog.d("GranjaForm-animal:${animal}")
                }
            )
            Text("Oveja")
        } // fin row RadioButton

        Row() {

            Button(onClick = {
                uiScope.launch {
                    viewModel.crearAnimal() {navController.popBackStack()}
                }
            }) { Text("Aceptar") }

            Button({
                navController.navigate("VentanaVer")
            }) {
                Text("volver")
            }
        }
        viewModel.errorMensaje?.let { Text(it,color = Color.Red) }
    }
}