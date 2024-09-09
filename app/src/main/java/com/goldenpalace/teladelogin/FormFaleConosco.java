package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class FormFaleConosco extends AppCompatActivity {

    private EditText edit_email_faleconosco,edit_caixa_mensagem;
    private Button bt_Enviar_Msg,bt_Voltar_faleConosco;
    String[] mensagens = {"Preencha todos os campos"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fale_conosco);

        IniciarComponentes();

        bt_Voltar_faleConosco.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFaleConosco.this, FormHome.class);
                startActivity(intent);
            }
        });


        bt_Enviar_Msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = edit_email_faleconosco.getText().toString();
                String caixaMsg = edit_caixa_mensagem.getText().toString();


                if(email.isEmpty() || caixaMsg.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.RED);
                    snackbar.show();
                }
            }
        });
    }
    private void IniciarComponentes(){

        bt_Enviar_Msg = findViewById(R.id.bt_Enviar_Msg);
        edit_email_faleconosco = findViewById(R.id.edit_email_faleconosco);
        edit_caixa_mensagem = findViewById(R.id.edit_caixa_mensagem);
        bt_Voltar_faleConosco = findViewById(R.id.bt_Voltar_faleConosco);
    }
}

