/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.transfer;

import java.io.Serializable;
import rs.stefanlezaic.zeleznice.srbije.lib.kons.ResponseStatus;

/**
 *
 * @author sleza
 */
public class ServerskiOdgovor implements Serializable {

    private Object odgovor;
    private Object error;
    private ResponseStatus status;
    private String poruka;

    public ServerskiOdgovor() {
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    

}
