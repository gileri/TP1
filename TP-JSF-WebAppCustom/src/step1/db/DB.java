package step1.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import step1.model.UserModel;

public class DB {
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "TP_JEE";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "root";
    private Connection connection;

    public DB() {
        try {
            // Chargement du Driver, puis etablissement de la connexion
            Class.forName("com.mysql.jdbc.Driver");
            // create connection
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
                    + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER, DB_PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UserModel> getData() { // return value
        ArrayList<UserModel> userList = new ArrayList<UserModel>();
        // Creation de la requete
        java.sql.Statement query;
        String requete;
        try {
            query = connection.createStatement();
            requete = "SELECT * FROM people;";
            ResultSet resultat = query.executeQuery(requete);
            while (resultat.next()) {
                userList.add(new UserModel(resultat.getString(2), resultat
                        .getString(1), resultat.getInt(3), resultat
                        .getString(4), resultat.getString(5)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void addUser(UserModel user) {
        // Creation de la requete
        java.sql.Statement query;
        try {
            // Creation de l'element de requete
            query = connection.createStatement();
            // TODO creez la requete permettant d'ajout un utilisateur avec tous
            // ces parametres
            // (('surname', 'lastname, 'age', 'login', 'pwd')
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
