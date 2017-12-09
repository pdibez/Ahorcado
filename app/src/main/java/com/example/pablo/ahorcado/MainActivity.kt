package com.example.pablo.ahorcado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

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
        val mensaje = if (juego.adivinarLetra(letraIngresada)) "La letra es correcta" else "La letra es incorrecta"

        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
    }

    private fun mensajeFinJuego(){
        val mensaje = if (juego.resultadoJuego()) "Felicitaciones GANASTE!!!" else "Ups.. PERDISTE"
        if (juego.finJuego()) Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
    }

    private fun limpiarLetra(){
        letra.text.clear()
    }

}
