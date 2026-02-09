package com.lucascamarero.pmd2_lucas.logica

// Interfaz Activo
interface Activo {

    val inversion: Int
    val retorno: Int
    val diario: Boolean

    // devuelve true si el valor de la entrada es menor.
    fun masRentable(entrada: Activo): Boolean {
        return (entrada.retorno - entrada.inversion) < (this.retorno - this.inversion)
    }
}

// Clase abstracta Animal
abstract class Animal(
    val nombre: String,
    override var inversion: Int,
    override var retorno: Int,
    override var diario: Boolean
): Activo {

    // devuelve un String con el sonido del animal
    abstract fun sonido(): String

    // devuelve un string informativo de la clase
    fun imprimir(): String {
        var rentabilidad: Int = retorno - inversion
        return "${this::class.simpleName} - rentabilidad: $rentabilidad, nombre: $nombre"
    }

}

// Clase hija Vaca
class Vaca(
    nombre: String,
    inversion: Int,
    retorno: Int,
    diario: Boolean
) : Animal(nombre, inversion, retorno, diario) {

    // sobreescribe la función sonido
    override fun sonido(): String = "Muuu"
}

// Clase hija Gallina
class Gallina(
    nombre: String,
    inversion: Int,
    retorno: Int,
    diario: Boolean
) : Animal(nombre, inversion, retorno, diario) {

    // sobreescribe la función sonido
    override fun sonido(): String = "Cocoroco"
}


// Clase hija Oveja
class Oveja(
    nombre: String,
    inversion: Int,
    retorno: Int,
    diario: Boolean
) : Animal(nombre, inversion, retorno, diario) {

    // sobreescribe la función sonido
    override fun sonido(): String = "Beee"
}



