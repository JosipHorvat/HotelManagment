/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Josip
 */
@Entity
public class Dostavnica extends Entitet{
    
    private Date datumPrimitka;
    
    @ManyToOne
    private Rezervacija rezervacija;
         
    @ManyToOne
    private Osoblje osoblje;
    
    @ManyToOne
    private Gost gost;

    public Date getDatumPrimitka() {
        return datumPrimitka;
    }

    public void setDatumPrimitka(Date datumPrimitka) {
        this.datumPrimitka = datumPrimitka;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Osoblje getOsoblje() {
        return osoblje;
    }

    public void setOsoblje(Osoblje osoblje) {
        this.osoblje = osoblje;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }
}
