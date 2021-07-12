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
public class MedjuStanica implements GeneralEntity {

    private Stanica stanica;
    private Linija linija;
    private int redniBroj;

    public MedjuStanica() {
    }

    public MedjuStanica(Stanica stanica, Linija linija, int redniBroj) {
        this.stanica = stanica;
        this.linija = linija;
        this.redniBroj = redniBroj;
    }

    public Stanica getStanica() {
        return stanica;
    }

    public void setStanica(Stanica stanica) throws ParametarsException {
        if (stanica == null) {
            throw new ParametarsException("Odaberite liniju!");
        } else if (!(stanica instanceof Stanica)) {
            throw new ParametarsException("Greska!");
        }
        this.stanica = stanica;
    }

    public Linija getLinija() {
        return linija;
    }

    public void setLinija(Linija linija) throws ParametarsException {
        if (linija == null) {
            throw new ParametarsException("Odaberite liniju!");
        } else if (!(linija instanceof Linija)) {
            throw new ParametarsException("Greska!");
        }
        this.linija = linija;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) throws ParametarsException {
        if (redniBroj < 1) {
            throw new ParametarsException("Redni broj ne sme biti manji od 1.");
        }
        this.redniBroj = redniBroj;
    }

    @Override
    public String toString() {
        return stanica.getNaziv() + " " + redniBroj;
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
        final MedjuStanica other = (MedjuStanica) obj;
        if (!Objects.equals(this.stanica, other.stanica)) {
            return false;
        }
        if (!Objects.equals(this.linija, other.linija)) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Medjustanica";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(redniBroj).
                append("', '").append(stanica.getStanicaID()).
                append("', '").append(linija.getLinijaID()).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("rednibroj").append("='").append(redniBroj).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"RedniBroj", "StanicaID", "LinijaID"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "stanicaID=" + stanica.getStanicaID() + " and linijaid=" + linija.getLinijaID();
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int redniBroj = rs.getInt("RedniBroj");
        int stanicaid = rs.getInt("StanicaID");
        int linijaid = rs.getInt("LinijaID");
        return new MedjuStanica(new Stanica(stanicaid), new Linija(linijaid), redniBroj);
    }

    @Override
    public String getSort() {
        return "RedniBroj asc";
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
