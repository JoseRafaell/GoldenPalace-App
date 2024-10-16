package com.goldenpalace.teladelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FormCadastro extends AppCompatActivity {

    private EditText edit_nome,edit_email,edit_senha,edit_telefone,edit_dataNasc,edit_cpf;
    private Button bt_cadastrar;
    String[] mensagens = {"Preencha todos os campos", "Cadastro realizado com sucesso!"};
    String usuarioID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);


        IniciarComponentes();

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                String telefone = edit_telefone.toString();
                String dataNasc = edit_dataNasc.toString();
                String cpf = edit_cpf.toString();

                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty() || dataNasc.isEmpty() || cpf.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.RED);
                    snackbar.show();

                }else{
                    CadastrarUsuario(v);
                }

            }
        });

    }

    private void CadastrarUsuario(View v){

        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            new FormLogin();

                            SalvarDadosUsuario();

                            Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                            snackbar.setBackgroundTint(Color.BLACK);
                            snackbar.setTextColor(Color.GREEN);
                            snackbar.show();
                        }
                    },5000);
                           Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                            startActivity(intent);

                } else {
                    String erro;
                    try {
                        throw task.getException();

                    } catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Defina uma senha com no minino 6 caracteres";

                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "Esta conta ja foi cadastrada";

                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "E-mail invalido";
                    } catch (Exception e) {
                        erro = "Erro ao cadastrar usuario";
                    }

                    Snackbar snackbar = Snackbar.make(v,erro,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.RED);
                    snackbar.show();

                }

            }
        });

    }

    private void SalvarDadosUsuario(){
        String nome = edit_nome.getText().toString();
        String telefone = edit_telefone.getText().toString();
        String dataNasc = edit_dataNasc.getText().toString();
        String cpf = edit_cpf.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> usuarios = new HashMap<>();
        usuarios.put("nome",nome);
        usuarios.put("telefone",telefone);
        usuarios.put("dataNasc",dataNasc);
        usuarios.put("cpf",cpf);

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            Log.d("db", "Sucesso ao salvar os dados");
            }
       })
               .addOnFailureListener(new OnFailureListener() {
                  @Override
                    public void onFailure(@NonNull Exception e) {
                   Log.d("db_error", "Erro ao salvar os dados" + e.toString());
                   }
            });
    }

        private void IniciarComponentes(){
        edit_nome = findViewById(R.id.edit_nome);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        edit_telefone = findViewById(R.id.edit_telefone);
        edit_dataNasc = findViewById(R.id.edit_dataNasc);
        edit_cpf = findViewById(R.id.edit_cpf);
        bt_cadastrar = findViewById(R.id.bt_cadastrar);

}

}