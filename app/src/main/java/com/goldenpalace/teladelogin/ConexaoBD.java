package com.goldenpalace.teladelogin;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public static Connection conectar (){
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.15.19" +
                    "databaseName = bd_goldenpalace; user = sa; password = @ITB123456;");
        } catch (SQLException e){
            e.getMessage();

        } catch (ClassNotFoundException e ){
            e.printStackTrace();
        }
        return conn;

    }

}
