package com.example.pablo.ahorcado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

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
            finJuego()
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

    private fun finJuego(){
        val mensaje = if (juego.resultadoJuego()) "Felicitaciones GANASTE!!!" else "Ups...PERDISTE"
        val dialogo = AlertDialog.Builder(this).create()

        if (juego.finJuego()) {

            adivinar.visibility = View.INVISIBLE
            letra.visibility = View.INVISIBLE

            dialogo.setTitle("Fin del Juego")
            dialogo.setMessage(mensaje)
            dialogo.show()

            if (juego.resultadoJuego()) {
                definicion.visibility = View.VISIBLE
                definicion.text = juego.getPalabra().getDefinicion()
            }
        }
    }

    private fun limpiarLetra(){
        letra.text.clear()
    }

}
