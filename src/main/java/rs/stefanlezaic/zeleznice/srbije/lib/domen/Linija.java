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
 * Klasa Linija predstavlja Liniju jednog putnickog voza. Odredjuje je tip
 * linije, pocetna stanica i krajnja stanica.
 *
 * @author sleza
 */
public class Linija implements GeneralEntity {

    /**
     *
     */
    private int linijaID;
    /**
     *
     */
    private String nazivLinije;
    /**
     *
     */
    private int minutaza;
    /**
     *
     */
    private double kilometraza;
    /**
     *
     */
    private Stanica stanicaPocetna;
    /**
     *
     */
    private Stanica stanicaKrajnja;
    /**
     *
     */
    private TipLinije tipLinije;

    /**
     *
     */
    public Linija() {
    }

    /**
     *
     */
    public Linija(int linijaID) {
        this.linijaID = linijaID;
    }

    /**
     *
     */
    public Linija(int LinijaID, String naziv, int minutaza, double kilometraza, Stanica stanicaPocetna, Stanica stanicaKrajnja, TipLinije tipLinije) {
        this.linijaID = LinijaID;
        this.nazivLinije = naziv;
        this.minutaza = minutaza;
        this.kilometraza = kilometraza;
        this.stanicaPocetna = stanicaPocetna;
        this.stanicaKrajnja = stanicaKrajnja;
        this.tipLinije = tipLinije;
    }

    /**
     *
     */
    public int getLinijaID() {
        return linijaID;
    }

    /**
     *
     */
    public void setLinijaID(int LinijaID) {
        this.linijaID = LinijaID;
    }

    /**
     *
     */
    public String getNazivLinije() {
        return nazivLinije;
    }

    /**
     *
     */
    public void setNazivLinije(String nazivLinije) throws ParametarsException {
        if (nazivLinije == null || nazivLinije.isEmpty()) {
            throw new ParametarsException("Naziv linije nema vrednost!");
        }
        this.nazivLinije = nazivLinije;
    }

    /**
     *
     */
    public int getMinutaza() {
        return minutaza;
    }

    /**
     *
     */
    public void setMinutaza(int minutaza) throws ParametarsException {
        if (minutaza < 0) {
            throw new ParametarsException("Minutaza ne sme biti manja od 0.");
        }
        this.minutaza = minutaza;
    }

    /**
     *
     */
    public double getKilometraza() {
        return kilometraza;
    }

    /**
     *
     */
    public void setKilometraza(double kilometraza) throws ParametarsException {
        if (kilometraza < 0) {
            throw new ParametarsException("Minutaza ne sme biti manja od 0.");
        }
        this.kilometraza = kilometraza;
    }

    /**
     *
     */
    public Stanica getStanicaPocetna() {
        return stanicaPocetna;
    }

    /**
     *
     */
    public void setStanicaPocetna(Stanica stanicaPocetna) throws ParametarsException {
        if (stanicaPocetna.equals(null) || !(stanicaPocetna instanceof Stanica)) {
            throw new ParametarsException("Pogresan parametar pocetna stanica.");
        }
        this.stanicaPocetna = stanicaPocetna;
    }

    /**
     *
     */
    public Stanica getStanicaKrajnja() {
        return stanicaKrajnja;
    }

    /**
     *
     */
    public void setStanicaKrajnja(Stanica stanicaKrajnja) throws ParametarsException {
        if (stanicaKrajnja.equals(null) || !(stanicaKrajnja instanceof Stanica)) {
            throw new ParametarsException("Pogresan parametar krajnja stanica.");
        } else if (stanicaKrajnja.equals(stanicaPocetna)) {
             throw new ParametarsException("Krajnja stanica ne sme biti ista kao pocetna.");
        }

        this.stanicaKrajnja = stanicaKrajnja;
    }

    /**
     *
     */
    public TipLinije getTipLinije() {
        return tipLinije;
    }

    /**
     *
     */
    public void setTipLinije(TipLinije tipLinije) throws ParametarsException {
        if (tipLinije.equals(null) || !(tipLinije instanceof TipLinije)) {
            throw new ParametarsException("Pogresan parametar tip linije.");
        }
        this.tipLinije = tipLinije;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return nazivLinije;
    }

    /**
     *
     */
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
        final Linija other = (Linija) obj;
        if (!Objects.equals(this.stanicaPocetna, other.stanicaPocetna)) {
            return false;
        }
        if (!Objects.equals(this.stanicaKrajnja, other.stanicaKrajnja)) {
            return false;
        }
        if (!Objects.equals(this.tipLinije, other.tipLinije)) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Linija";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(nazivLinije).
                append("', '").append(stanicaPocetna.getStanicaID()).
                append("', '").append(stanicaKrajnja.getStanicaID()).
                append("', '").append(minutaza).
                append("', '").append(kilometraza).
                append("', '").append(tipLinije.getTipLinijeID()).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("naziv").append("='").append(nazivLinije).append("',").
                append("stanicaPocetna").append("='").append(stanicaPocetna).append("',").
                append("stanicaKrajnja").append("='").append(stanicaKrajnja).append("',").
                append("minutaza").append("='").append(minutaza).append("',").
                append("kilometraza").append("='").append(kilometraza).append("',").
                append("tipLinije").append("='").append(tipLinije).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"NazivLinije", "StanicaIDPolazna", "StanicaIDKrajnja", "Minutaza", "Kilometraza", "TiPlinijeID"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "linijaid='" + linijaID + "'";
    }

    @Override
    public String getWhereNoPrimaryKey() {
        return "stanicaIDPolazna='" + stanicaPocetna.getStanicaID() + "' and stanicaIDKrajnja='" + stanicaKrajnja.getStanicaID() + "' and tipLinijeID='" + tipLinije.getTipLinijeID() + "'";
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int linijaID = rs.getInt("LinijaID");
        String naziv = rs.getString("NazivLinije");
        int stanicaPolaskaID = rs.getInt("StanicaIDPolazna");
        int stanicaKrajnjaID = rs.getInt("StanicaIDKrajnja");
        int minutaza = rs.getInt("Minutaza");
        double kilometraza = rs.getDouble("Kilometraza");
        int tipLinijeID = rs.getInt("TipLinijeID");
        return new Linija(linijaID, naziv, minutaza, kilometraza, new Stanica(stanicaPolaskaID), new Stanica(stanicaKrajnjaID), new TipLinije(tipLinijeID));
    }

    @Override
    public String getSort() {
        return "nazivLinije asc";
    }

    @Override
    public String getExtraCondition(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
