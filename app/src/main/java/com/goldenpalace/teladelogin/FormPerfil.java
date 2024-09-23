package com.goldenpalace.teladelogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class FormPerfil extends AppCompatActivity {

    private Button bt_deslogar,bt_Voltar_perfil;
    private TextView nomeUsuario,emailUsuario,cpfUsuario,telefoneUsuario,dataNascUsuario;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_perfil);

        IniciarComponentes();

        bt_Voltar_perfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormPerfil.this, FormHome.class);
                startActivity(intent);
            }
        });

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormPerfil.this, FormLogin.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

       String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
    usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
            if (documentSnapshot != null){
                nomeUsuario.setText(documentSnapshot.getString("nome"));
                emailUsuario.setText(email);
                cpfUsuario.setText(documentSnapshot.getString("cpf"));
                dataNascUsuario.setText(documentSnapshot.getString("dataNasc"));
                telefoneUsuario.setText(documentSnapshot.getString("telefone"));
            }
            }
        });
    }

    private void IniciarComponentes() {
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_Voltar_perfil = findViewById(R.id.bt_Voltar_perfil);
        nomeUsuario = findViewById(R.id.textNomeUsuario);
        emailUsuario = findViewById(R.id.textEmailUsuario);
        cpfUsuario = findViewById(R.id.textCPFUsuario);
        telefoneUsuario = findViewById(R.id.textTelefoneUsuario);
        dataNascUsuario = findViewById(R.id.textdataNascUsuario);
    }
}