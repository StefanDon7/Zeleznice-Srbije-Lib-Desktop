/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author sleza
 */
public class Klijent implements GeneralEntity {

    private int klijentID;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;

    public Klijent() {
    }

    public Klijent(int klijentID) {
        this.klijentID = klijentID;
    }
    
     public Klijent(String email,String lozinka) {
         this.email = email;
         this.lozinka = lozinka;
    }


    public Klijent(int klijentID, String korisnickoIme, String lozinka, String ime, String prezime, String email) {
        this.klijentID = klijentID;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
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
        final Klijent other = (Klijent) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String getClassName() {
        return "Klijent";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(korisnickoIme).
                append("', '").append(email).
                append("', '").append(ime).
                append("', '").append(prezime).
                append("', '").append(lozinka).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("korisnickoime").append("='").append(korisnickoIme).append("',").
                append("email").append("='").append(email).append("',").
                append("ime").append("='").append(ime).append("',").
                append("prezime").append("='").append(prezime).append("',").
                append("lozinka").append("='").append(lozinka).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"KorisnickoIme", "Email", "Ime", "Prezime", "Lozinka"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "klijentid='" + klijentID + "'";
    }

    @Override
    public String getWhereNoPrimaryKey() {
        return "email='" + email + "' and lozinka='" + lozinka + "'";
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        int klijentID = rs.getInt("KlijentID");
        String korisnickoIme = rs.getString("KorisnickoIme");
        String email = rs.getString("Email");
        String ime = rs.getString("Ime");
        String prezime = rs.getString("Prezime");
        String lozinka = rs.getString("Lozinka");
        return new Klijent(klijentID, korisnickoIme, lozinka, ime, prezime, email);

    }

    @Override
    public String getSort() {
        return "Email asc";
    }

    @Override
    public String getExtraCondition(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
