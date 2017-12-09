package com.example.pablo.ahorcado

class Palabra(var letras: MutableList<Letra>) {

    constructor(palabra: String) : this(mutableListOf()) { //crea una lista de Letra vacio
        val caracteres: CharArray = palabra.toCharArray() // convierte cadena @palabra en un array de caracteres

        for (c in caracteres) {
            letras.add(LetraOculta(c.toString())) //inicialmente todas las letras son ocultas
        }
    }

    /* Verifica si letra ingresada esta en la palabra o no
    * */
    fun esValida(letra: String): Boolean {
        var esValida = false

        for (l in letras){
            if ((l.letra).equals(letra)) {
                letras.set(letras.indexOf(l),LetraAcertada(l.letra))
                esValida = true
            }
        }

        return esValida
    }

    fun mostrarPalabra(): String {
        var palabra = ""

        for (l in letras) {
            palabra += l.mostrarLetra()
        }
        return palabra
    }
}