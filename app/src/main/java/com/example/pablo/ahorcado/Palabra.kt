package com.example.pablo.ahorcado

class Palabra(var letras: MutableList<Letra>,private var definicion : String) {

    constructor(palabra: String,definicion: String) : this(mutableListOf(),"") {
        val caracteres: CharArray = palabra.toCharArray() // convierte cadena @palabra en un array de caracteres

        for (c in caracteres) {
            letras.add(LetraOculta(c.toString())) //inicialmente todas las letras estan ocultas
        }
        this.definicion = definicion
    }

    /*
    * Verifica si letra ingresada esta en la palabra o no
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

    /*
     *   Retorna true si la palabra fue adivinida
     */
    fun adivinada():Boolean{
        var adivinada = true

        for(l in letras){
            if (!l.acertada){
                adivinada = false
            }
        }

        return adivinada
    }

    fun mostrarPalabra(): String {
        var palabra = ""

        for (l in letras) {
            palabra += l.mostrarLetra()
        }
        return palabra
    }

    /*A diferencia de mostrarPalabra(), este metodo retorna la palabra con sus caracteres en letras*/
    fun verPalabra(): String {
        var palabra = ""

        for (l in letras) {
            palabra += l.verLetra()
        }
        return palabra
    }

    fun getDefinicion() : String {return definicion}
}