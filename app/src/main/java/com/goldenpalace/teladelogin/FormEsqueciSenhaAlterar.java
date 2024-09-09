package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormEsqueciSenhaAlterar extends AppCompatActivity {

    private Button bt_Confirmar_esqueciSenhaAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_esqueci_senha_alterar);
        IniciarComponentes();

        bt_Confirmar_esqueciSenhaAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormEsqueciSenhaAlterar.this, FormLogin.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        bt_Confirmar_esqueciSenhaAlterar = findViewById(R.id.bt_Confirmar_esqueciSenhaAlterar);
    }
}