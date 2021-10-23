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
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;

/**
 *
 * @author sleza
 */
public class Rezervacija implements GeneralEntity {

    private int rezervacijaID;
    private Klijent klijent;
    private Polazak polazak;
    private Date date;

    public Rezervacija() {
    }

    public Rezervacija(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public Rezervacija(Polazak polazak) {
        this.polazak = polazak;
    }

    public Rezervacija(Klijent klijent, Polazak polazak) {
        this.klijent = klijent;
        this.polazak = polazak;
    }

    public Rezervacija(Klijent klijent, Polazak polazak, Date datum) {
        this.klijent = klijent;
        this.polazak = polazak;
        this.date = datum;
    }

    public Rezervacija(int rezervacijaID, Klijent klijent, Polazak polazak, Date datum) {
        this.rezervacijaID = rezervacijaID;
        this.klijent = klijent;
        this.polazak = polazak;
        this.date = datum;
    }

    public int getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) throws ParametarsException {
        if (date.after(new Date())) {
            throw new ParametarsException("Datum rezervacije nije dobar!");
        }
        this.date = date;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) throws ParametarsException {
        if (klijent.getKlijentID() < 1) {
            throw new ParametarsException("Sifra korisnika mora biti veca od nule!");
        }
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
        return "Rezervacija{" + "rezervacijaID=" + rezervacijaID + ", klijent=" + klijent + ", polazak=" + polazak + ", datum=" + date + '}';
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
                append("', '").append(new java.sql.Date(date.getTime())).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("KlijentID").append("='").append(klijent.getKlijentID()).append("',").
                append("PolazakID").append("='").append(polazak.getPolazakID()).append("',").
                append("Date").append("='").append(date).append("'");
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
        int rezervacijaID = rs.getInt("rezervacijaID");
        int klijentID = rs.getInt("KlijentID");
        int polazakID = rs.getInt("PolazakID");
        java.util.Date datum = new java.util.Date(rs.getDate("Date").getTime());
        return new Rezervacija(rezervacijaID, new Klijent(klijentID), new Polazak(polazakID), datum);
    }

    @Override
    public String getSort() {
        return "Date desc";
    }

    @Override
    public String getExtraCondition(Object o) {
        return "";
    }

    @Override
    public String getWhereNoPrimaryKey() {
        return "";
    }

}
