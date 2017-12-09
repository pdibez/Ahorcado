package com.example.pablo.ahorcado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.palabra
import kotlinx.android.synthetic.main.activity_main.letra
import kotlinx.android.synthetic.main.activity_main.adivinar

class MainActivity : AppCompatActivity() {

    private val juego = Ahorcado()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actualizarPalabra()

        adivinar.setOnClickListener{
            adivinarLetra()
            actualizarPalabra()
        }
    }

    private fun actualizarPalabra(){
        palabra.text = juego.getPalabra().mostrarPalabra()
    }

    private fun adivinarLetra(){
        val letraIngresada = letra.text.toString()
        val mensaje : String

        if (juego.adivinarLetra(letraIngresada)) {
            mensaje = "La letra es correcta"
        }
        else {
            mensaje = "La letra es incorrecta"
        }

        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
    }

}
