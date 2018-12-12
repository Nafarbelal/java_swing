package MODEL;


import DAO.DaoBd;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hamza
 */
public class GestionArticle {

    private Connection con;
    private Statement st;
    private DaoBd dao;

    public GestionArticle() {
        dao = new DaoBd();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost/db19");
        dao.setLogin("root");
        dao.setPassword("");
        dao.seConnecter();
        con = dao.getConnection();
    }

    public void Create(int code, String des, float prix) {
        String req;
        req = "insert into Article values('" + code + "','" + des + "','" + prix + "');";

        try {
            if (con != null) {
                st = con.createStatement();
                st.executeUpdate(req);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Create : " + ex.getMessage());

        }
    }

    public void add(int code, String nom, float prix) {
        try {
            PreparedStatement pst;
            pst = con.prepareStatement("insert into Article values (?,?,?)");
            pst.setInt(1, code);
            pst.setString(1, nom);
            pst.setFloat(1, prix);
            pst.executeUpdate();
            System.err.println("ajout effectue avec succes");
        } catch (SQLException ex) {
            System.err.println("erreur dans la requete add" + ex.getMessage());
        }
    }
    
    public void All_Articles(){
        ResultSet res;
        try {
            st= con.createStatement();
            res=st.executeQuery("select * from Article");
            while(res.next()){
                System.out.println(res.getInt(1)+"  "+res.getString("designation")+" "+res.getFloat(3));
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans la requete select ou st " + ex.getMessage());
        }
    }
    
    
    public ResultSet LesArticles(){
        ResultSet res=null;
        try {
            st= con.createStatement();
            res=st.executeQuery("select * from Article");

        } catch (SQLException ex) {
            System.err.println("erreur dans la requete select ou st " + ex.getMessage());
        }
        return res;
    }
}
