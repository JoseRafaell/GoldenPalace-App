package com.goldenpalace.teladelogin;

import static androidx.core.content.ContextCompat.getString;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class conexao {
    public Connection conectar(Context ctx) {

            Connection conn = null;
            try {
                StrictMode.ThreadPolicy politica;
                politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(politica);
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.1.17 " +
                        "databaseName=bd_goldenpalace;user=sa;password=@ITB123456;");
                Toast.makeText(ctx.getApplicationContext(),R.string.sucesso,
                        Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(ctx.getApplicationContext(), e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
            return conn;
        }
        public FormCadastro pesquisarLogin(String edit_email, String edit_senha, String edit_nome,
                                        String edit_telefone, String edit_dataNasc, String edit_cpf, Context ctx){

        try{
            PreparedStatement pst = conectar(ctx).prepareStatement(
                    "Select + from login where nome = ? and email = ? and senha = ? and telefone = ?" +
                            "and dataNasc = ? and cpf = ?");
            pst.setString(1, edit_nome);
            pst.setString(2, edit_email);
            pst.setString(3, edit_senha);
            pst.setString(4, edit_telefone);
            pst.setString(5, edit_dataNasc);
            pst.setString(6, edit_cpf);
            ResultSet res = pst.executeQuery();

            while(res.next()){
                FormCadastro objNome = new FormCadastro();
               // objNome.set(res,getString())
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return null;
        }
    }

