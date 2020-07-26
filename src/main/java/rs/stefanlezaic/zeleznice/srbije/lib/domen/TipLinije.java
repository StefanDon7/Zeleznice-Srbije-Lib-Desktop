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
public class TipLinije implements GeneralEntity {

    private int tipLinijeID;
    private String naziv;

    public TipLinije() {
    }

    public TipLinije(int tipID) {
        this.tipLinijeID = tipID;
    }

    public TipLinije(int tipID, String naziv) {
        this.tipLinijeID = tipID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTipLinijeID() {
        return tipLinijeID;
    }

    public void setTipLinijeID(int tipLinijeID) {
        this.tipLinijeID = tipLinijeID;
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
        final TipLinije other = (TipLinije) obj;
        if (this.tipLinijeID != other.tipLinijeID) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "TipLinije";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(tipLinijeID).
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
        String[] atributi = {"TipLinijeID", "Naziv"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "tipLinijeID='" + tipLinijeID + "'";
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int id = rs.getInt("TipLinijeID");
        String naziv = rs.getString("Naziv");
        return new TipLinije(id, naziv);
    }

    @Override
    public String getSort() {
        return "Naziv asc";
    }

    @Override
    public String getExtraCondition(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereNoPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
