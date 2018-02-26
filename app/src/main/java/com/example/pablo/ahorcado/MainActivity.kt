package com.example.pablo.ahorcado

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.view.View
import android.view.inputmethod.InputMethodManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var juego = Ahorcado()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        visualizarPalabra()
        visualizarDefinicion()
        visualizarIntentos()

        adivinar.setOnClickListener{
            adivinarLetra()

            visualizarPalabra()
            visualizarIntentos()

            limpiarLetra()
            ocultarTeclado()
            finJuego()
        }

        nuevo.setOnClickListener(){
            nuevoJuego()
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
                mostrarDialogo("Fin del Juego","¡¡¡Felicitaciones adivinaste la palabra!!!")
            }
            else{ //perdio
                mostrarDialogo("Fin del Juego","Ups...Perdiste. La palabra era $palabra")
            }
        }
    }

    private fun visualizarDefinicion() {
        definicion.text = juego.getPalabra().getDefinicion()
        definicion.visibility = View.VISIBLE
    }

    private fun limpiarLetra(){
        letra.text.clear()
    }

    private fun mostrarDialogo(titulo:String,mensaje:String){

        val dialogo = AlertDialog.Builder(this).create()

        dialogo.setTitle(titulo)
        dialogo.setMessage(mensaje)
        dialogo.setButton(AlertDialog.BUTTON_NEGATIVE,
                         "VOLVER",
                          { _, _ -> dialogo.cancel()})
        dialogo.setButton(AlertDialog.BUTTON_POSITIVE,
                         "NUEVO",
                         {_,_->nuevoJuego()})
        dialogo.show()
    }

    private fun ocultarTeclado(){
        val teclado = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        teclado.hideSoftInputFromWindow(letra.getWindowToken(), 0)
    }

    private fun nuevoJuego(){
        juego.nuevoJuego()

        visualizarPalabra()
        visualizarIntentos()
        visualizarDefinicion()

        adivinar.visibility = View.VISIBLE
        letra.visibility = View.VISIBLE

    }

}
