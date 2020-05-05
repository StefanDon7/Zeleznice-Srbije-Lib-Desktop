/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sleza
 */
public class Voz implements GeneralEntity {

    private int vozID;
    private String naziv;
    private int brojSedista;

    public Voz() {
    }

    public Voz(int vozID) {
        this.vozID = vozID;
    }

    public Voz(int vozID, String naziv, int brojSedista) {
        this.vozID = vozID;
        this.naziv = naziv;
        this.brojSedista = brojSedista;
    }

    public int getVozID() {
        return vozID;
    }

    public void setVozID(int vozID) {
        this.vozID = vozID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    public void setBrojSedista(int brojSedista) {
        this.brojSedista = brojSedista;
    }

    @Override
    public String toString() {
        return naziv + "(" + brojSedista + ")";
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
        final Voz other = (Voz) obj;
        if (this.vozID != other.vozID) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Voz";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(vozID).
                append("', '").append(naziv).
                append("', '").append(brojSedista).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        return "";
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"VozID", "Naziv", "BrojMesta"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "vozID='" + vozID + "'";
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int vozID = rs.getInt("VozID");
        String naziv = rs.getString("Naziv");
        int brojSedista = rs.getInt("BrojMesta");
        return new Voz(vozID, naziv, brojSedista);
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
