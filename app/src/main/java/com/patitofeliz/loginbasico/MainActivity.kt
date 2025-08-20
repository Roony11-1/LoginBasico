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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val campoUsuario:EditText = findViewById(R.id.usuario);
        val campoPassword:EditText = findViewById(R.id.password);
        val textoAviso:TextView = findViewById(R.id.textoAviso);
        val botonLogin:Button = findViewById(R.id.botonLogin);

        var usuarioDefecto = "patito";
        var passwordDefecto = "123456";

        botonLogin.setOnClickListener {
            val usuarioLogin = campoUsuario.getText().toString()
            val passwordLogin = campoPassword.getText().toString()

            if (usuarioLogin.equals(usuarioDefecto) && passwordLogin.equals(passwordDefecto))
            {
                val panelUsuario = Intent(this, PanelUsuario::class.java)

                startActivity(panelUsuario)
            }
            else
                textoAviso.setText("Usuario o Contraseña Incorrectos");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}