/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;

/**
 *
 * @author sleza
 */
public class Stanica implements GeneralEntity {

    private int stanicaID;
    private String naziv;
    private Mesto mesto;

    public Stanica() {
    }

    public Stanica(int stanicaID) {
        this.stanicaID = stanicaID;
    }

    public Stanica(int StanicaID, String naziv, Mesto mesto) {
        this.stanicaID = StanicaID;
        this.naziv = naziv;
        this.mesto = mesto;
    }

    public int getStanicaID() {
        return stanicaID;
    }

    public void setStanicaID(int stanicaID) {
        this.stanicaID = stanicaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) throws ParametarsException {
        if (naziv.equals("") || naziv.isEmpty()) {
            throw new ParametarsException("Popunite naziv stanice.");
        } else if (naziv.length() < 3) {
            throw new ParametarsException("Naziv stanice se sastoji od najmanje 3 slova.");
        }
        this.naziv = naziv;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) throws ParametarsException {
        if (mesto.equals(null)) {
            throw new ParametarsException("Odaberite mesto!");
        } else if (!(mesto instanceof Mesto)) {
            throw new ParametarsException("Greska!");
        }
        this.mesto = mesto;
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
        final Stanica other = (Stanica) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.mesto, other.mesto)) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Stanica";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(naziv).
                append("', '").append(mesto.getMestoID()).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        return "";
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"NazivStanice", "MestoID"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "stanicaID=" + stanicaID + "";
    }

    @Override
    public String getWhereNoPrimaryKey() {
        return "mestoID='" + mesto.getMestoID() + "' and NazivStanice='" + naziv + "'";
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int stanicaID = rs.getInt("StanicaID");
        String nazivStanice = rs.getString("NazivStanice");
        int mestoID = rs.getInt("MestoID");
        return new Stanica(stanicaID, nazivStanice, new Mesto(mestoID));
    }

    @Override
    public String getSort() {
        return "NazivStanice asc";
    }

    @Override
    public String getExtraCondition(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
