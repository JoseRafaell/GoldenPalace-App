package com.goldenpalace.teladelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_cadastro,text_esqueciSenhaLogin;
    private EditText edit_email,edit_senha;
    private Button bt_entrar;
   String[] mensagens = {"Preencha todos os campos", "Login efetuado com sucesso!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);


        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {

              Intent intent = new Intent(FormLogin.this,FormCadastro.class);
               startActivity(intent);
           }
       });

        text_esqueciSenhaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this,FormEsqueciSenhaEmail.class);
                startActivity(intent);
            }
        });

        bt_entrar.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {

               String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                if (email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                   snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.RED);
                   snackbar.show();
                }else {
                    AutenticarUsuario();
                }

           }
        });

    }

    private void AutenticarUsuario(){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            if (task.isSuccessful()) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    FormHome();
                }
            },1100);
            }
            }
        });
    }

    private void FormHome(){
        Intent intent = new Intent(FormLogin.this,FormHome.class);
    startActivity(intent);
    finish();
   }

    private void IniciarComponentes(){
       text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
        text_esqueciSenhaLogin = findViewById(R.id.text_esqueciSenhaLogin);
        edit_email = findViewById(R.id.edit_email);
       edit_senha = findViewById(R.id.edit_senha);
        bt_entrar = findViewById(R.id.bt_entrar);
    }
}