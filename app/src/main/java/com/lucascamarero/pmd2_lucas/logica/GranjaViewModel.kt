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
        nombre = ""
        inversionStr = ""
        retornoStr = ""
        errorMensaje = null
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
        val animalesPrueba = listOf<Animal>(
            Vaca("Pepa",15000, 20000, true),
            Gallina("Marisa",80, 40, true),
            Oveja("Juliana",400, 700, true)
        )

        animalesPrueba.forEach {
            listaAnimales.add(it)
        }
    }

    fun crearAnimal(onSuccess: () -> Unit) {
        // Variables auxiliares para convertir los valores numéricos
        var inInversion = 0
        var inRetorno = 0

        // Validación de la inversión
        try {
            inInversion = inversionStr.toInt()
        } catch (e : Exception) {
            errorMensaje = "La inversión no es un número cómo se espera"
            return
        }

        // Validación del retorno
        try {
            inRetorno = retornoStr.toInt()
        } catch (e : Exception) {
            errorMensaje = "El retorno no es un número cómo se espera"
            return
        }

        if(_radioAnimal.value == RadioAnimal.VACA) {
            // Se crea una instancia de Libro con los datos introducidos
            var animal:Animal = Vaca(nombre, inInversion, inRetorno, true)

            // Se añade el libro a la lista observable
            listaAnimales.add(animal)
        }

        if(_radioAnimal.value == RadioAnimal.GALLINA) {
            // Se crea una instancia de Libro con los datos introducidos
            var animal:Animal = Gallina(nombre, inInversion, inRetorno, true)

            // Se añade el libro a la lista observable
            listaAnimales.add(animal)
        }

        if(_radioAnimal.value == RadioAnimal.OVEJA) {
            // Se crea una instancia de Libro con los datos introducidos
            var animal:Animal = Oveja(nombre, inInversion, inRetorno, true)

            // Se añade el libro a la lista observable
            listaAnimales.add(animal)
        }

        // Callback para notificar éxito (por ejemplo, cerrar pantalla)
        onSuccess()
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
    return this + ": ¿Estás seguro de esto?"
}