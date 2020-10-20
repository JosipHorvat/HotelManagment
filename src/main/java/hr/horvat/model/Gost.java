/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Josip
 */
@Entity
public class Gost extends Osoba{
    
    @Enumerated(EnumType.STRING)
    private VrstaPlacanja vrstaPlacanja;
    
    public static enum VrstaPlacanja{
        gotovina,
        kartica
    }
    
    private String drzava;
    private String brojTelefona;
    private String brojKreditneKartice;
    

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public VrstaPlacanja getVrstaPlacanja() {
        return vrstaPlacanja;
    }

    public void setVrstaPlacanja(VrstaPlacanja vrstaPlacanja) {
        this.vrstaPlacanja = vrstaPlacanja;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getBrojKreditneKartice() {
        return brojKreditneKartice;
    }

    public void setBrojKreditneKartice(String brojKreditneKartice) {
        this.brojKreditneKartice = brojKreditneKartice;
    }  
    
}
