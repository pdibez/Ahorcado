package com.example.pablo.ahorcado

class LetraAcertada(override var letra: String, override var acertada: Boolean = true) : Letra {

    override fun mostrarLetra() : String{
        return letra;
    }

}