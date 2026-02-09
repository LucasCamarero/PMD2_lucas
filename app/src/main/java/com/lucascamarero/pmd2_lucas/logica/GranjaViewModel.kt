package com.lucascamarero.pmd2_lucas.logica

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lucascamarero.pmd2_lucas.MyLog

enum class RadioAnimal {
    VACA,
    GALLINA,
    OVEJA
}

//TODO datas class de ejempplo
data class Animal(
    val inversion: Int,
    var nombre: String
)

class GranjaViewModel : ViewModel() {
    fun String.obtenerValor():Int {
        MyLog.d("String.obtenerValor: ${this}")
        try {
            return this.toInt()
        } catch (e: Exception) {
            MyLog.d("String.obtenerValor error de conversion ")
        }
        return -1
    }
    fun limpiar() {
        //TODO reseteo de funciones
    }
    val listaAnimales = mutableStateListOf<Animal>()

    var errorMensaje by mutableStateOf<String?>(null)
        private set

    var nombre by mutableStateOf("")
        private set
    fun onNombreChanged(nuevoTexto: String) {
        nombre = nuevoTexto
        if (errorMensaje != null) errorMensaje = null // Limpiar error al escribir
    }

    var inversionStr by mutableStateOf("")
        private set
    fun onInversionChanged(nuevoTexto: String) {
        inversionStr = nuevoTexto
        if (errorMensaje != null) errorMensaje = null // Limpiar error al escribir
    }

    var retornoStr by mutableStateOf("")
        private set
    fun onRetornoStrChanged(nuevoTexto: String) {
        retornoStr = nuevoTexto
        if (errorMensaje != null) errorMensaje = null // Limpiar error al escribir
    }



    private val _radioAnimal = mutableStateOf(RadioAnimal.VACA)
    val radioAnimal: State<RadioAnimal> = _radioAnimal

    fun cambiarAnimal(nuevo: RadioAnimal) {
        _radioAnimal.value = nuevo
        MyLog.d("Radio update: ${nuevo.toString()}")
    }

    fun pruebas() {
        //TODO Datos de pruebas
    }

    fun crearAnimal(onSuccess: () -> Unit) {
        MyLog.d("El animal seleccionado ha sido ${radioAnimal.value}")
        //TODO
    }
}

// Función de extensión de Boolean
// Devuelve "SI" si el valor es true y "NO" si es false
fun Boolean.aTexto():String {
    if(this) return "SI"
    else return "NO"
}

// Función de extensión de String
// Devuelve un mensaje de confirmación
fun String.Confirmación():String {
    String resultado = "¿Estás seguro de esto?: "
    return resultado += this
}