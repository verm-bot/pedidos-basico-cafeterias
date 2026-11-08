package com.example.pedidocafeteria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Pantalla 1: Datos del cliente.
 * Valida que el nombre no esté vacío y que tenga al menos 6 caracteres.
 */
class MainActivity : AppCompatActivity() {

    // Longitud mínima permitida para el nombre
    private val MIN_CARACTERES = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)

        btnSiguiente.setOnClickListener {
            val nombre = etNombre.text.toString().trim()

            if (nombre.isEmpty()) {
                // Validación 1: campo vacío
                etNombre.error = getString(R.string.msg_nombre_vacio)
                Toast.makeText(this, R.string.msg_nombre_vacio, Toast.LENGTH_SHORT).show()
            } else if (nombre.length < MIN_CARACTERES) {
                // Validación 2: menos de 6 caracteres
                etNombre.error = getString(R.string.msg_nombre_corto)
                Toast.makeText(this, R.string.msg_nombre_corto, Toast.LENGTH_SHORT).show()
            } else {
                // Todo correcto: navegar y enviar el nombre
                val intent = Intent(this, SeleccionActivity::class.java)
                intent.putExtra("nombre", nombre)
                startActivity(intent)
            }
        }
    }
}