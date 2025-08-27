package com.patitofeliz.loginbasico

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.patitofeliz.loginbasico.util.OpMatematicas
import org.w3c.dom.Text

class PanelCalculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_panel_calculadora)

        var etUno:EditText = findViewById(R.id.etUno);
        var etDos:EditText = findViewById(R.id.etDos);
        var etOperacion:EditText = findViewById(R.id.etOperacion);

        var msgCalculadora:TextView = findViewById(R.id.msgCalculadora);
        var msgResultado:TextView = findViewById(R.id.msgResultado);

        var btnCalcular:Button = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener {
            if (etUno.getText().trim().isBlank() || etDos.getText().trim().isBlank())
            {
                msgCalculadora.setText("Ingresa ambos valores para operar")
            }
            else if (etOperacion.getText().trim().isBlank())
            {
                msgCalculadora.setText("No has ingresado la operación")
            }
            else
            {
                var num1:Double = etUno.getText().trim().toString().toDoubleOrNull() ?: 0.0;
                var num2:Double = etDos.getText().trim().toString().toDoubleOrNull() ?: 0.0;
                var resultado:Double = 0.0;

                if (etOperacion.getText().toString().trim().equals("+"))
                    resultado = OpMatematicas.suma(num1, num2);
                else if (etOperacion.getText().toString().trim().equals("-"))
                    resultado = OpMatematicas.resta(num1, num2);
                else if (etOperacion.getText().toString().trim().equals("/"))
                    resultado = OpMatematicas.division(num1, num2);
                else if (etOperacion.getText().toString().trim().equals("*"))
                    resultado = OpMatematicas.multiplicacion(num1, num2);

                msgResultado.setText(resultado.toString());
            }
        }


        var btnAtras: Button = findViewById(R.id.btnAtras);

        btnAtras.setOnClickListener {
            var activityAtras = Intent(this, PanelUsuario::class.java)

            startActivity(activityAtras);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}