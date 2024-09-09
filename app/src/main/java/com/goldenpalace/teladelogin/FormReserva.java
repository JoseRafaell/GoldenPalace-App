package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class FormReserva extends AppCompatActivity {

    private EditText edit_data,edit_ambiente,edit_pessoas,edit_horario,edit_observacoes;
    private Button bt_enviar_reserva,bt_Voltar_reserva;
    String[] mensagens = {"Preencha todos os campos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_reserva);

        IniciarComponentes();

        bt_Voltar_reserva.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormReserva.this, FormHome.class);
                startActivity(intent);
            }
        });


        bt_enviar_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = edit_data.toString();
                String ambiente = edit_ambiente.getText().toString();
                String pessoas = edit_pessoas.getText().toString();
                String horario = edit_horario.toString();
                String observacoes = edit_observacoes.getText().toString();

                if(data.isEmpty() || ambiente.isEmpty() || pessoas.isEmpty() || horario.isEmpty() || observacoes.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.RED);
                    snackbar.show();
                }
            }
        });
    }
                private void IniciarComponentes(){
        edit_data = findViewById(R.id.edit_data);
        edit_ambiente = findViewById(R.id.edit_ambiente);
        edit_pessoas = findViewById(R.id.edit_pessoas);
        edit_horario = findViewById(R.id.edit_horario);
        edit_observacoes = findViewById(R.id.edit_observacoes);
        bt_enviar_reserva = findViewById(R.id.bt_enviar_reserva);
        bt_Voltar_reserva = findViewById(R.id.bt_Voltar_reserva);
            }
        }


