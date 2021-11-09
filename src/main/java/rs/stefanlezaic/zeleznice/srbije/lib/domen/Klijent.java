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
import rs.stefanlezaic.zeleznice.srbije.lib.validator.EmailValidator;

/**
 * Klasa predstavlja Klijenta koji se registruje i prijavljuje radi rezervisanja
 * karata. Klasa implementira interfejs GeneralEntity.
 *
 * @author sleza
 */
public class Klijent implements GeneralEntity {

    /**
     * ID klijenta
     */
    private int klijentID;
    /**
     * Email klijenta
     */
    private String email;
    /**
     * Korisnicko ime klijenta
     */
    private String korisnickoIme;
    /**
     * Ime klijenta
     */
    private String ime;
    /**
     * Prezime klijenta
     */
    private String prezime;
    /**
     * lozinka klijenta
     */
    private String lozinka;

    /**
     * Prazan konstruktor klijenta
     */
    public Klijent() {
    }

    /**
     * Konstruktor Klijenta
     *
     * @param klijentID
     *
     */
    public Klijent(int klijentID) {
        this.klijentID = klijentID;
    }

    /**
     * Konstruktor Klijenta
     *
     * @param email
     * @param lozinka
     *
     */
    public Klijent(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }

    /**
     * Konstruktor Klijenta
     *
     * @param klijentID
     * @param korisnickoIme
     * @param ime
     * @param prezime
     * @param email
     * @param lozinka
     *
     */
    public Klijent(int klijentID, String email, String korisnickoIme, String ime, String prezime, String lozinka) {
        this.klijentID = klijentID;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
    }

    /**
     * Vraca id klijenta
     *
     * @return klijentID
     */
    public int getKlijentID() {
        return klijentID;
    }

    /**
     * Postavlja id klijentu
     *
     * @param klijentID
     */
    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) throws ParametarsException {
        if (email == null || email.isEmpty()) {
            throw new ParametarsException("Email adresa je null ili prazan string!");
        } else if (!(EmailValidator.validate(email))) {
            throw new ParametarsException("Email adresa nije u dobrom formatu!");
        }
        this.email = email;
    }

    /**
     * Vraca string korisnicko ime
     *
     * @return korisnickoIme
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Postavlja korisnicko ime
     *
     * @param korisnickoIme
     */
    public void setKorisnickoIme(String korisnickoIme) throws ParametarsException {
        if (korisnickoIme == null || korisnickoIme.isEmpty()) {
            throw new ParametarsException("Korisnicko ime adresa je null ili prazan string!");
        }
        this.korisnickoIme = korisnickoIme;
    }

    /**
     *
     * @return
     */
    public String getIme() {
        return ime;
    }

    /**
     *
     * @param ime
     */
    public void setIme(String ime) throws ParametarsException {
        if (ime == null || ime.isEmpty()) {
            throw new ParametarsException("Ime adresa je null ili prazan string!");
        }
        this.ime = ime;
    }

    /**
     *
     * @return
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     *
     * @param prezime
     */
    public void setPrezime(String prezime) throws ParametarsException {
        if (prezime == null || prezime.isEmpty()) {
            throw new ParametarsException("Prezime adresa je null ili prazan string!");
        }
        this.prezime = prezime;
    }

    /**
     *
     * @return
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     *
     * @param lozinka
     */
    public void setLozinka(String lozinka) throws ParametarsException {
        if (lozinka == null || lozinka.isEmpty()) {
            throw new ParametarsException("Lozinka adresa je null ili prazan string!");
        }
        this.lozinka = lozinka;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    /**
     * Provera da li su dva objekta ista ako jesu uzima
     *
     *
     * @param obj
     * @return True ako su objekti isti i false ako nisu.
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
        return new Klijent(klijentID, email, korisnickoIme, ime, prezime, lozinka);

    }

    @Override
    public String getSort() {
        return "Email asc";
    }

    @Override
    public String getExtraCondition(Object o) {
        return "";
    }

    public String getFullQuery(Polazak p) {
        return "SELECT * FROM klijent WHERE klijentid IN(SELECT klijentID FROM rezervacija WHERE polazakID=" + p.getPolazakID() + ")";
    }

}
