package com.example.pedidocafeteria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Pantalla 2: Selección del pedido.
 * Permite elegir una bebida, un postre (opcional) y si desea azúcar.
 */
class SeleccionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion)

        // 1. Referencias a los componentes
        val rgBebidas = findViewById<RadioGroup>(R.id.rgBebidas)
        val rgPostres = findViewById<RadioGroup>(R.id.rgPostres)
        val cbAzucar = findViewById<CheckBox>(R.id.cbAzucar)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)

        // 2. Recuperar el nombre enviado desde la pantalla 1
        val nombre = intent.getStringExtra("nombre") ?: ""

        // 3. Evento del botón "Confirmar pedido"
        btnConfirmar.setOnClickListener {
            val idBebida = rgBebidas.checkedRadioButtonId

            // 4. Validación: debe haber una bebida seleccionada (-1 = ninguna)
            if (idBebida == -1) {
                Toast.makeText(this, R.string.msg_sin_bebida, Toast.LENGTH_SHORT).show()
            } else {
                // 5. Obtener bebida, postre y azúcar
                val bebida = findViewById<RadioButton>(idBebida).text.toString()
                val postre = findViewById<RadioButton>(rgPostres.checkedRadioButtonId).text.toString()
                val azucar = if (cbAzucar.isChecked) "Sí" else "No"

                // 6. Enviar los datos a la pantalla de resumen
                val intent = Intent(this, ResumenActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("bebida", bebida)
                intent.putExtra("postre", postre)
                intent.putExtra("azucar", azucar)
                startActivity(intent)
            }
        }
    }
}