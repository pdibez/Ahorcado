package com.example.pablo.ahorcado

class LetraOculta(override var letra: String, override var acertada: Boolean = false) : Letra {

    override fun mostrarLetra(): String {
        return " _ ";
    }

    override fun verLetra(): String {
        return letra
    }

}