package com.example.pablo.ahorcado

import android.widget.Toast

class Ahorcado(private var palabra: Palabra = Palabra("")) {

    init {
        sortearPalabra()
    }

    fun sortearPalabra(){
        /*busca palabras en la DB y elige una aleatoriamente
        * por ahora solo para proba uso INFORMATICA*/
        palabra = Palabra("pablo")
    }

    fun adivinarLetra(letra: String):Boolean{
        return palabra.esValida(letra) //por ahora solo retorna el boolean, luego habria que tmb habilitar a la/s letrass encontradas
    }

    /*getters and setters*/
    fun getPalabra(): Palabra {
        return palabra
    }

}