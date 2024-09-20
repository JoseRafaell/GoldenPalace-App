package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormHome extends AppCompatActivity {

    private Button bt_reserva_home;
    private Button bt_menu_home;
    private Button bt_faleConosco_home;
    private Button bt_perfil_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_home);

        IniciarComponentes();

        bt_reserva_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormHome.this, FormReserva.class);
                startActivity(intent);
            }
        });

        bt_menu_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormHome.this, FormMenu.class);
                startActivity(intent);
            }
        });

        bt_faleConosco_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormHome.this, FormFaleConosco.class);
                startActivity(intent);
            }
        });

        bt_perfil_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormHome.this, FormPerfil.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        bt_reserva_home = findViewById(R.id.bt_reserva_home);
        bt_menu_home = findViewById(R.id.bt_menu_home);
        bt_faleConosco_home = findViewById(R.id.bt_faleConosco_home);
        bt_perfil_home = findViewById(R.id.bt_perfil_home);

    }
}