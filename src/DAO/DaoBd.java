/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoBd{
    private static String Pilote;
    private static String Url;
    private static String Login;
    private static String Password;
    private static Connection Connection;

    public void seConnecter(){
        try{
            System.out.println("Chargement de Pilote ....");
            Class.forName(Pilote);
            System.out.println("Chargement de Pilote reussi....");
            Connection = DriverManager.getConnection(Url,Login,Password);
            System.out.println("Connexion etabli ....");
        }catch(ClassNotFoundException ex){
            System.err.println("Pb de Pilote !!! ");
            
        }catch(SQLException ex){
            System.err.println("Pb de Connexion"+ex.getMessage());

        }
    }

    public static String getPilote() {
        return Pilote;
    }

    public static void setPilote(String Pilote) {
        DaoBd.Pilote = Pilote;
    }

    public static String getUrl() {
        return Url;
    }

    public static void setUrl(String Url) {
        DaoBd.Url = Url;
    }

    public static String getLogin() {
        return Login;
    }

    public static void setLogin(String Login) {
        DaoBd.Login = Login;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        DaoBd.Password = Password;
    }

    public static Connection getConnection() {
        return Connection;
    }

    public static void setConnection(Connection Connection) {
        DaoBd.Connection = Connection;
    }
    
    
            
    

}