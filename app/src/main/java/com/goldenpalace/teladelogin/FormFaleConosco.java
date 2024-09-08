package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class FormFaleConosco extends AppCompatActivity {

    private EditText edit_email_faleconosco,edit_caixa_mensagem;
    private Button bt_Enviar_Msg;
    String[] mensagens = {"Preencha todos os campos"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fale_conosco);

        IniciarComponentes4();

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
    private void IniciarComponentes4(){

        bt_Enviar_Msg = findViewById(R.id.bt_Enviar_Msg);
        edit_email_faleconosco = findViewById(R.id.edit_email_faleconosco);
        edit_caixa_mensagem = findViewById(R.id.edit_caixa_mensagem);
    }
}

