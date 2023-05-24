package com.example.parcial1v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetalleAlumnos : AppCompatActivity() {

    private lateinit var textViewDetalleAlumnos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_alumnos)

        val bundle = intent.extras
        val nombre = bundle?.getString("nameSeleccionado","")

        textViewDetalleAlumnos = findViewById(R.id.textViewDetalleNombreAlumno)

        textViewDetalleAlumnos.text = "$nombre ha aprobado :)"
    }
}