/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author sleza
 */
public class Rezervacija implements GeneralEntity {

    private Klijent klijent;
    private Polazak polazak;
    private Date datum;

    public Rezervacija() {
    }

    public Rezervacija(Klijent klijent, Polazak polazak, java.util.Date datum) {
        this.klijent = klijent;
        this.polazak = polazak;
        this.datum = datum;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Polazak getPolazak() {
        return polazak;
    }

    public void setPolazak(Polazak polazak) {
        this.polazak = polazak;
    }

    @Override
    public String toString() {
        return "KLIJENT: " + klijent.getIme() + " " + klijent.getPrezime() + "POLAZAK: " + polazak.getNaziv();
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
        final Rezervacija other = (Rezervacija) obj;
        if (!Objects.equals(this.klijent, other.klijent)) {
            return false;
        }
        if (!Objects.equals(this.polazak, other.polazak)) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Rezervacija";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(klijent.getKlijentID()).
                append("', '").append(polazak.getPolazakID()).
                append("', '").append(new java.sql.Date(datum.getTime())).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("KlijentID").append("='").append(klijent.getKlijentID()).append("',").
                append("PolazakID").append("='").append(polazak.getPolazakID()).append("',").
                append("Date").append("='").append(datum).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"KlijentID", "PolazakID", "Date"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "PolazakID=" + polazak.getPolazakID() + " and KlijentID=" + klijent.getKlijentID();
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int klijentID = rs.getInt("KlijentID");
        int polazakID = rs.getInt("PolazakID");
        java.util.Date datum = new java.util.Date(rs.getDate("Date").getTime());
        return new Rezervacija(new Klijent(klijentID), new Polazak(polazakID), datum);
    }

    @Override
    public String getSort() {
        return "Date desc";
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
