package com.example.parcial1v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ListadoAlumnos : AppCompatActivity() {
    
    private lateinit var nombreDeAlumnos: TextView
    private lateinit var listViewAlumnos: ListView
    private lateinit var buttonDetalleAlumno: Button

    private var nombre: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_alumnos)

        val bundle = intent.extras
        nombreDeAlumnos = findViewById(R.id.textViewNombreAlumno)
        listViewAlumnos = findViewById(R.id.listView)
        buttonDetalleAlumno = findViewById(R.id.buttonDetalle)


        val ListaAlumnos = mutableListOf("Alejandro Rocha", "Samuel Gimenez", "Luciano Villarino", "Tomas Herrera", "Carolina Sepulveda")
        val adapterListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListaAlumnos)
        listViewAlumnos.adapter = adapterListView


        val name = bundle?.getString("name", "")
        nombreDeAlumnos.text = "$name"
        Toast.makeText(this, "Se ha agregado a $name correctamente", Toast.LENGTH_SHORT).show()
        ListaAlumnos.add(nombreDeAlumnos.text.toString())

        listViewAlumnos.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, nacionalidad[position], Toast.LENGTH_LONG).show()
            nombre = ListaAlumnos[position]
        }

        buttonDetalleAlumno.setOnClickListener {
            if (nombre != null) {
                val intent = Intent(this,DetalleAlumnos::class.java)
                intent.putExtra("nameSeleccionado", nombre)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Debe seleccionar un alumno", Toast.LENGTH_SHORT).show()
            }
        }
        
    }
}