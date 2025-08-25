package com.patitofeliz.loginbasico

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PanelFormulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var btnFormulario:Button = findViewById(R.id.btnFormulario);

        btnFormulario.setOnClickListener {
            val text = "Chupalo"
            val duration = Toast.LENGTH_SHORT;

            val toast = Toast.makeText(this, text, duration);

            toast.show();
        }

        setContentView(R.layout.activity_panel_formulario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}