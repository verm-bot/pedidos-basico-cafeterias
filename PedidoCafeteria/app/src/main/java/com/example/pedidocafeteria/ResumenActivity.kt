package com.example.pedidocafeteria

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Pantalla 3: Resumen del pedido.
 * Recupera los datos enviados y los muestra en pantalla.
 */
class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        // 1. Referencias a los TextView
        val tvCliente = findViewById<TextView>(R.id.tvCliente)
        val tvBebida = findViewById<TextView>(R.id.tvBebida)
        val tvAzucar = findViewById<TextView>(R.id.tvAzucar)
        val tvPostre = findViewById<TextView>(R.id.tvPostre)

        // 2. Recuperar la información enviada desde la pantalla 2
        val nombre = intent.getStringExtra("nombre") ?: ""
        val bebida = intent.getStringExtra("bebida") ?: ""
        val azucar = intent.getStringExtra("azucar") ?: ""
        val postre = intent.getStringExtra("postre") ?: ""

        // 3. Mostrar el resumen
        tvCliente.text = nombre
        tvBebida.text = bebida
        tvAzucar.text = azucar
        tvPostre.text = postre

        // 4. Mensaje de confirmación
        Toast.makeText(this, R.string.msg_pedido_registrado, Toast.LENGTH_LONG).show()
    }
}