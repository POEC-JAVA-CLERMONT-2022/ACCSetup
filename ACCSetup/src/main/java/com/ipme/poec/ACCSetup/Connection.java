package com.ipme.poec.ACCSetup;

import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Connection {

    String url = "jdbc:mysql://localhost:3306/accsetup";
    String user = "root";
    String pwd = ""; //mot de passe vide, je ne sais plus si le pwd doit être vide ou nul

    java.sql.Connection connexion = null;

        /*
    try {
            connexion = getConnection(url, user, pwd);
        } catch (java.sql.SQLException e) {
            //problème de connexion à la base
        }

        if (connexion != null){
            try {
                connexion.close();
            }
            catch (java.sql.SQLException e){
                //problème de déconnexion
            }
    }

         */
}
