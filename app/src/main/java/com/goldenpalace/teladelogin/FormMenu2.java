package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormMenu2 extends AppCompatActivity {

    private Button bt_Voltar_menu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_menu2);

        IniciarComponentes();

        bt_Voltar_menu2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormMenu2.this, FormHome.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        bt_Voltar_menu2 = findViewById(R.id.bt_Voltar_menu2);
    }
}