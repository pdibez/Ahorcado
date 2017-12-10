package com.example.pablo.ahorcado

import java.util.*

class Ahorcado() {

    private var listaPalabras : List<Palabra> = listOf()
    private var palabra: Palabra = Palabra("")
    private var cantidadIntentos = 5

    init {
        inicializarPalabras()
        sortearPalabra()
    }

    fun inicializarPalabras(){
        /*TO DO LIST traer datos de la DB*/
        listaPalabras = listOf( Palabra("informatica"),
                                Palabra("pc"),
                                Palabra("CPU"))
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

    /*
    Si retorna TRUE es gano
    sino retorna FALSE y significa que perdio
    * */
    fun resultadoJuego() = palabra.adivinada()

    fun getPalabra(): Palabra { return palabra }
    fun getCantidadIntentos(): Int { return cantidadIntentos }

}