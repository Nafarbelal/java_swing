/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hamza
 */
public class MonModel extends AbstractTableModel{
    private int nblig=0;
    private int nbcol;
    private String[] titres;
    private ArrayList<Vector<String>> meslignes=new ArrayList<Vector<String>>();
    public MonModel(ResultSet res){
        try{
            ResultSetMetaData rsmd = res.getMetaData();
            nbcol=rsmd.getColumnCount();
            titres = new String[nbcol];
            for(int i=0;i<nbcol;i++)
                titres[i]=rsmd.getColumnLabel(i+1);
            Vector<String> Ligne;
            while(res.next()){
                Ligne = new Vector<String>();
                for(int i=0;i<nbcol;i++){
                    
                    Ligne.add(res.getObject(i+1).toString());
                }
                meslignes.add(Ligne);
                nblig++;
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int getRowCount() {
        return nblig;
    }

    @Override
    public int getColumnCount() {
        return nbcol;
    }
    @Override
    public String getColumnName(int column) {
        return titres[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return meslignes.get(rowIndex).get(columnIndex);
    }

    
}
