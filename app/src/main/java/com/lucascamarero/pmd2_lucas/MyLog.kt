package com.lucascamarero.pmd2_lucas

import android.util.Log
import kotlin.collections.firstOrNull
import kotlin.text.contains
import kotlin.text.startsWith
import kotlin.text.substringAfterLast
import kotlin.text.substringBefore

/**
 * Es una form global de llamar a un log, asi podemos estandarizar el menseje
 * Aseguramos que todos los logs tengan un [MyApp]
 * También informa desde que funcion se esta realizando el log
 */
object MyLog {

    private const val PREFIX = "[MyApp] "



    private fun caller(): String {
        val trace = Throwable().stackTrace

        val frame = trace.firstOrNull { element ->
            element.className.startsWith("com.example.granja") &&
                    !element.className.contains("MyLog")
        }

        val className = frame?.className?.substringAfterLast('.')?.substringBefore('$')
            ?: "UnknownClass"

        val file = frame?.fileName ?: "Unknown.kt"
        val line = frame?.lineNumber ?: -1

        return "($file:$line)"
    }



    fun d(message: String) {
        Log.d(caller(), PREFIX + message)
    }

    fun e(message: String, throwable: Throwable? = null) {
        if (throwable != null) {
            // Log.e acepta un Throwable como tercer parámetro
            Log.e(caller(), PREFIX + message, throwable)
        } else {
            Log.e(caller(), PREFIX + message)
        }
    }
}