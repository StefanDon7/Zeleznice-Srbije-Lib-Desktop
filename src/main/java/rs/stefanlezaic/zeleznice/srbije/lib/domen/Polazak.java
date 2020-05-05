/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sleza
 */
public class Polazak implements GeneralEntity {

    private int polazakID;
    private String naziv;
    private Date datumPolaska;
    private Date datumDolaska;
    private Linija linija;
    private Voz voz;
    private String napomena = "/";

    public Polazak() {
    }

    public Polazak(int polazakID) {
        this.polazakID = polazakID;
    }

    public Polazak(int polazakID, String naziv, Date datumPolaska, Date datumDolaska, Linija linija, Voz voz) {
        this.polazakID = polazakID;
        this.naziv = naziv;
        this.datumPolaska = datumPolaska;
        this.datumDolaska = datumDolaska;
        this.linija = linija;
        this.voz = voz;
    }

    public Polazak(int polazakID, String naziv, Date datumPolaska, Date datumDolaska, Linija linija, Voz voz, String napomena) {
        this.polazakID = polazakID;
        this.naziv = naziv;
        this.datumPolaska = datumPolaska;
        this.datumDolaska = datumDolaska;
        this.linija = linija;
        this.voz = voz;
        this.napomena = napomena;
    }

    public int getPolazakID() {
        return polazakID;
    }

    public void setPolazakID(int polazakID) {
        this.polazakID = polazakID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Linija getLinija() {
        return linija;
    }

    public void setLinija(Linija linija) {
        this.linija = linija;
    }

    public Voz getVoz() {
        return voz;
    }

    public void setVoz(Voz voz) {
        this.voz = voz;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
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
        final Polazak other = (Polazak) obj;
        if (this.polazakID != other.polazakID) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Polazak";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(naziv).
                append("', '").append(new java.sql.Timestamp(datumPolaska.getTime())).
                append("', '").append(linija.getLinijaID()).
                append("', '").append(voz.getVozID()).
                append("', '").append(new java.sql.Timestamp(datumDolaska.getTime())).
                append("', '").append(napomena).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("Napomena").append("='").append(napomena).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"Naziv", "DatumPolaska", "LinijaID", "VozID", "DatumDolaska", "Napomena"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "polazakid='" + polazakID + "'";
    }

    @Override
    public String getWhereNoPrimaryKey() {
        return "linijaid='" + linija.getLinijaID() + "'";
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int polazakID = rs.getInt("PolazakID");
        String naziv = rs.getString("Naziv");
        java.util.Date dateP = null;
        Timestamp datumP = rs.getTimestamp("DatumPolaska");
        if (datumP != null) {
            dateP = new java.util.Date(datumP.getTime());
        }
        int linijaID = rs.getInt("LinijaID");
        int vozID = rs.getInt("VozID");
        java.util.Date dateD = null;
        Timestamp datumD = rs.getTimestamp("DatumDolaska");
        if (datumD != null) {
            dateD = new java.util.Date(datumD.getTime());
        }
        String napomena = rs.getString("Napomena");
        return new Polazak(polazakID, naziv, dateP, dateD, new Linija(linijaID), new Voz(vozID), napomena);
    }

    @Override
    public String getSort() {
        return "DatumPolaska desc";
    }

    @Override
    public String getExtraCondition(Object o) {
        Date d = (Date) o;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(d);
        return "DatumPolaska LIKE '" + datum + "%'";
    }

}
