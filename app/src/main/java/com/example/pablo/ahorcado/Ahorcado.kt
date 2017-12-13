package com.example.pablo.ahorcado

import java.util.*

class Ahorcado() {

    private var listaPalabras : List<Palabra> = listOf()
    private var palabra: Palabra = Palabra("","")
    private var cantidadIntentos = 5

    init {
        inicializarPalabras()
        sortearPalabra()
    }

    fun inicializarPalabras(){
        /*TO DO LIST traer datos de la DB*/
        listaPalabras = listOf( Palabra("Informatica","Ciencia que estudia métodos, técnicas, procesos, con el fin de almacenar, procesar y transmitir información y datos en formato digital."),
                                Palabra("PC","Registro del procesador de un computador que indica la posición donde está el procesador en su secuencia de instrucciones. "),
                                Palabra("CPU","Dispositivo dentro de un ordenador u otros dispositivos programables, que interpreta las instrucciones de un programa informático mediante la realización de las operaciones básicas aritméticas, lógicas y de entrada/salida del sistema."),
                                Palabra("Memoria","Dispositivo que retiene, memoriza o almacena datos informáticos durante algún período de tiempo."),
                                Palabra("Perifericos","Conjunto de dispositivos que sin pertenecer al núcleo fundamental de la computadora, formado por la unidad central de procesamiento (CPU) y la memoria central, permitan realizar operaciones de entrada/salida (E/S) complementarias al proceso de datos que realiza la CPU. ")
                              )
    }

    fun sortearPalabra() {
        val aleatorio = Random()
        val i = aleatorio.nextInt(listaPalabras.size)

        palabra = listaPalabras.get(i)
    }

    fun adivinarLetra(letra: String) {
        val esValida = palabra.esValida(letra)
        descontarCantidadIntentos(esValida)
    }

    fun descontarCantidadIntentos(esValida : Boolean){
        if (!esValida && cantidadIntentos > 0 && !finJuego()) --cantidadIntentos
    }

    fun finJuego():Boolean{
        if (cantidadIntentos == 0 || palabra.adivinada())
            return true
        else
            return false
    }

    fun nuevoJuego(){
        cantidadIntentos = 5
        sortearPalabra()
    }

    /*
    Si retorna TRUE es gano
    sino retorna FALSE y significa que perdio
    * */
    fun resultadoJuego() = palabra.adivinada()

    fun getPalabra(): Palabra { return palabra }
    fun getCantidadIntentos(): Int { return cantidadIntentos }

}