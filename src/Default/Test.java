
///import DAO.DaoBd;

package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamza
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoBd dao = new DaoBd();
        dao.setPilote("com.mysql.jdbc.Driver");
        // dao.setPilote("oracle.jdbc.driver.OracleDriver");
        dao.setUrl("jdbc:mysql://localhost/db19");
        // dao.setUrl("jdbc:oracle://127.0.0.1:8080");
        dao.setLogin("root");
        dao.setPassword("");
        dao.seConnecter();
        // GestionArticle gst = new GestionArticle();
        // gst.All_Articles();
    }

}
