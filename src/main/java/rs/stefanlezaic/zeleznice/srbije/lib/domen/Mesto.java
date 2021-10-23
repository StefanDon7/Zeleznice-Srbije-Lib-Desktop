/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;

/**
 *
 * @author sleza
 */
public class Mesto implements GeneralEntity {

    private int mestoID;
    private String nazivMesta;

    public Mesto() {
    }

    public Mesto(int mestoID) {
        this.mestoID = mestoID;
    }

    public Mesto(int mestoID, String nazivMesta) {
        this.mestoID = mestoID;
        this.nazivMesta = nazivMesta;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) throws ParametarsException {
        if (nazivMesta == null || nazivMesta.isEmpty()) {
            throw new ParametarsException("Naziv stanice ne sme biti prazno polje.");
        }
        this.nazivMesta = nazivMesta;
    }

    @Override
    public String toString() {
        return nazivMesta;
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
                append("', '").append(nazivMesta).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        return "";
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"MestoID", "NazivMesta"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "mestoID='" + mestoID + "'";
    }

    @Override
    public String getWhereNoPrimaryKey() {
        return "";
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int id = rs.getInt("MestoID");
        String nazivMesta = rs.getString("NazivMesta");
        return new Mesto(id, nazivMesta);
    }

    @Override
    public String getSort() {
        return "NazivMesta asc";
    }

    @Override
    public String getExtraCondition(Object o) {
        return "";
    }

}
