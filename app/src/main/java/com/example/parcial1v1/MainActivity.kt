package com.example.parcial1v1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nombreAlumno: EditText
    private lateinit var buttonIngresarAlumno: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombreAlumno = findViewById(R.id.editTextNombreAlumno)
        buttonIngresarAlumno = findViewById(R.id.buttonIngresar)

        buttonIngresarAlumno.setOnClickListener {

            if (nombreAlumno.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Debe escribir el nombre del alumno", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ListadoAlumnos::class.java)
                intent.putExtra("name", nombreAlumno.text.toString())
                startActivity(intent)
            }

        }
    }
}