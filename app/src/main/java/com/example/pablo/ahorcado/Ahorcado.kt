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
        listaPalabras = listOf(
                Palabra("CONJUNTO","Grupo o colección de objetos.  Pueden expresarse por lo menos de tres maneras: mediante (1) la descripción verbal, (2) la enumeración o listado y (3) la notación de construcción de conjuntos."),
                Palabra("INTERSECCION","Conjunto de elementos comunes a ambos conjuntos A y B."),
                Palabra("PROPOSICION","Aseveración que puede ser verdadera o falsa, pero no ambas."),
                Palabra("CUANTIFICADOR","Indica cuántos casos existen de una situación determinada."),
                Palabra("CODIGOS","Se utilizan para comunicar de manera segura información clasificada de tal suerte que debe decodificarse antes para que pueda ser comprendida.  Uno de los más ampliamente utilizados en la industria fue desarrollado por Ronald L. Rivest, Adi Shamir y Leonard M.Adleman,denominado RSA."),
                Palabra("PRIMO","Número natural que tiene exactamente dos factores diferentes.	"),
                Palabra("COMBINATORIA","Estudia los diferentes modos en que se pueden llevar a cabo una cierta tarea de ordenación o agrupación de unos cuantos objetos siguiendo unas reglas prefijadas."),
                Palabra("VARIACIONES","Subconjuntos de p elementos que se pueden formar con los n dados, considerando que son distintas cuando difieren en algún elemento o cuando difieren en el orden en que se presentan.")
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
        inicializarPalabras()
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