package com.goldenpalace.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormMenu extends AppCompatActivity {

    private Button bt_Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_menu);

        IniciarComponentes();

        bt_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormMenu.this, FormMenu2.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        bt_Next = findViewById(R.id.bt_Next);
    }
}