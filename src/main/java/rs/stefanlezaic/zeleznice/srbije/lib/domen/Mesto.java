/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sleza
 */
public class Mesto implements GeneralEntity {

    private int mestoID;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int mestoID) {
        this.mestoID = mestoID;
    }

    public Mesto(int mestoID, String naziv) {
        this.mestoID = mestoID;
        this.naziv = naziv;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (this.mestoID != other.mestoID) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Mesto";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(mestoID).
                append("', '").append(naziv).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        return "";
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"MestoID", "Naziv"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "mestoID='" + mestoID + "'";
    }

    @Override
    public String getWhereNoPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int id = rs.getInt("MestoID");
        String naziv = rs.getString("NazivMesta");
        return new Mesto(id, naziv);
    }

    @Override
    public String getSort() {
        return "NazivMesta asc";
    }

    @Override
    public String getExtraCondition(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
