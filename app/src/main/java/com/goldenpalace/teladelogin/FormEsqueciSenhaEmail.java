package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormEsqueciSenhaEmail extends AppCompatActivity {

    private Button bt_Enviar_esqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_esqueci_senha_email);

        IniciarComponentes();

        bt_Enviar_esqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormEsqueciSenhaEmail.this, FormEsqueciSenhaCod.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        bt_Enviar_esqueciSenha = findViewById(R.id.bt_Enviar_esqueciSenha);
    }
}