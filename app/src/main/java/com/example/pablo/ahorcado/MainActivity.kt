package com.example.pablo.ahorcado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog

import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.palabra
import kotlinx.android.synthetic.main.activity_main.letra
import kotlinx.android.synthetic.main.activity_main.adivinar
import kotlinx.android.synthetic.main.activity_main.intentos

class MainActivity : AppCompatActivity() {

    private val juego = Ahorcado()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        visualizarPalabra()
        visualizarIntentos()

        adivinar.setOnClickListener{
            adivinarLetra()
            visualizarPalabra()
            visualizarIntentos()
            limpiarLetra()
            mensajeFinJuego()
        }
    }

    private fun visualizarPalabra(){
        palabra.text = juego.getPalabra().mostrarPalabra()
    }

    private fun visualizarIntentos(){
        intentos.text = "Intentos : "+juego.getCantidadIntentos().toString()
    }

    private fun adivinarLetra(){
        val letraIngresada = letra.text.toString()
        juego.adivinarLetra(letraIngresada)
    }

    private fun mensajeFinJuego(){
        val mensaje = if (juego.resultadoJuego()) "Felicitaciones GANASTE!!!" else "Ups...PERDISTE"
        val dialogo = AlertDialog.Builder(this).create()

        if (juego.finJuego()) {
            adivinar.setEnabled(false)
            letra.setEnabled(false)
            dialogo.setMessage(mensaje)
            dialogo.show()
        }
    }

    private fun limpiarLetra(){
        letra.text.clear()
    }

}
