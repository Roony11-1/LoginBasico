package com.patitofeliz.loginbasico

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PanelUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_panel_usuario)

        var botonFormulario:Button = findViewById(R.id.botonIrFormulario);

        var botonCalculadora:Button = findViewById(R.id.botonIrCalculadora);

        var txtUserName:TextView = findViewById(R.id.txtUserName);

        txtUserName.text = intent.getStringExtra("pUsuario");

        botonFormulario.setOnClickListener {

            val irPanelFormulario = Intent(this, PanelFormulario::class.java);

            startActivity(irPanelFormulario);
        }

        botonCalculadora.setOnClickListener {

            val irPanelCalculadora = Intent(this, PanelCalculadora::class.java);

            startActivity(irPanelCalculadora);
        }

        var btnAtras:Button = findViewById(R.id.btnAtras);

        btnAtras.setOnClickListener {
            var activityAtras = Intent(this, MainActivity::class.java)

            startActivity(activityAtras);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}