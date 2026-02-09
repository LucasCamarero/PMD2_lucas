package com.lucascamarero.pmd2_lucas.ventanas

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

@Composable
fun GranjaForm(
    navController: NavController,
    modifier: Modifier,
    viewModel: GranjaViewModel
) {
    DefaultColumn(modifier = modifier) {
        DefaultOutlinedTextField(
            texto = viewModel.nombre,
            onTextoChange = { nuevoTexto -> viewModel.onNombreChanged(nuevoTexto) },
            placeholder = "Nombre"
        )
        //TODO crea el resto de textFields

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
            Button({
                viewModel.crearAnimal() {
                    //TODO ve atras o ventanaVer
                }

            }) {
                Text("Aceptar")
            }
            Button({
                //TODO navega a ventana Ver
            }) {
                Text("volver")
            }
        }
        //TODO Muestra el error en pantalla o Toast, como quieras
    } // fin collumn
}