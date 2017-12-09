package com.example.pablo.ahorcado

import java.util.*

class Ahorcado() {

    private var listaPalabras : List<Palabra> = listOf()
    private var palabra: Palabra = Palabra("")

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

    fun adivinarLetra(letra: String): Boolean {
        return palabra.esValida(letra)
    }

    fun getPalabra(): Palabra {
        return palabra
    }

}