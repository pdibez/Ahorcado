package com.example.pablo.ahorcado

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var juego = Ahorcado()

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
        val cantidadIntentos = juego.getCantidadIntentos().toString()
        intentos.text = "Intentos : $cantidadIntentos"
    }

    private fun adivinarLetra(){
        val letraIngresada = letra.text.toString()
        juego.adivinarLetra(letraIngresada)
    }

    private fun finJuego(){
        val palabra = juego.getPalabra().verPalabra()

        if (juego.finJuego()) {

            adivinar.visibility = View.INVISIBLE
            letra.visibility = View.INVISIBLE

            if (juego.resultadoJuego()) { //gano
                mostrarDialogo("Fin del Juego","Felicitaciones adivinaste la palabra")
                definicion.text = juego.getPalabra().getDefinicion()
                definicion.visibility = View.VISIBLE
            }
            else{ //perdio
                mostrarDialogo("Fin del Juego","Ups...Perdiste. La palabra era $palabra")
            }



        }
    }

    private fun limpiarLetra(){
        letra.text.clear()
    }

    private fun mostrarDialogo(titulo:String,mensaje:String){
        val dialogo = AlertDialog.Builder(this).create()

        dialogo.setTitle(titulo)
        dialogo.setMessage(mensaje)
        dialogo.setButton(AlertDialog.BUTTON_POSITIVE,
                         "SALIR",
                          { _, _ -> dialogo.cancel()})
        dialogo.show()
    }

}
