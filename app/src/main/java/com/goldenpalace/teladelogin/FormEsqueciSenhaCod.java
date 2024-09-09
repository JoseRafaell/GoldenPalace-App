package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormEsqueciSenhaCod extends AppCompatActivity {

    private Button bt_Confirmar_esqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_esqueci_senha_cod);

        IniciarComponentes();

        bt_Confirmar_esqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormEsqueciSenhaCod.this, FormEsqueciSenhaAlterar.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        bt_Confirmar_esqueciSenha = findViewById(R.id.bt_Confirmar_esqueciSenha);
    }
}