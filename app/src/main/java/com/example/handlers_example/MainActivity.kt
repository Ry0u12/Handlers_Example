package com.example.handlers_example

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tv_cuadro1: TextView
    private lateinit var tv_cuadro2: TextView
    private lateinit var tv_cuadro3: TextView
    private lateinit var tv_cuadro4: TextView
    private lateinit var btn_accion: Button
    private lateinit var handlersito: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Inicializamos el Handler
        handlersito = Handler(Looper.getMainLooper())
        //Inicializamos los textviews y el boton
        tv_cuadro1 = findViewById(R.id.tv_cuadro1)
        tv_cuadro2 = findViewById(R.id.tv_cuadro2)
        tv_cuadro3 = findViewById(R.id.tv_cuadro3)
        tv_cuadro4 = findViewById(R.id.tv_cuadro4)
        btn_accion = findViewById(R.id.btn_accion)
        //Iniciamos las funciones con el boton
        btn_accion.setOnClickListener{
            contar1()
            contar2()
        }
    }
    private fun contar1()
    {
        val hilo1 = Thread{
            for (i in 1 .. 1000){
                runOnUiThread{
                    tv_cuadro1.text = i.toString()
                }
            }
        }
        hilo1.start()
        val hilo2 = Thread{
            for (i in 1 .. 1000){
                runOnUiThread{
                    tv_cuadro2.text = i.toString()
                }
            }
        }
        hilo2.start()
    }
    private fun contar2()
    {
        val hilo3 = Thread{
            for (i in 1 .. 1000){
                runOnUiThread{
                    tv_cuadro3.text = i.toString()
                }
            }
        }
        hilo3.start()
        val hilo4 = Thread{
            for (i in 1 .. 1000){
                runOnUiThread{
                    tv_cuadro4.text = i.toString()
                }
            }
        }
        hilo4.start()
    }
}