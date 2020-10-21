/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Josip
 */
@Entity
public class Rezervacija extends Entitet{
    
    private Date datumRezervacije;
    private Date datumDolaskaGosta;
    private Date datumOdlaskaGosta;
    private Integer brojGostiju;
    private Integer brojSoba;
    
    @ManyToMany(mappedBy = "rezervacije")
    private List<Soba> sobe = new ArrayList<>();
    
    @ManyToOne
    private Gost gost;
    
    @OneToMany(mappedBy = "gost")
    private List<Dostavnica> dostavnice = new ArrayList<>();

    public List<Dostavnica> getDostavnice() {
        return dostavnice;
    }

    public void setDostavnice(List<Dostavnica> dostavnice) {
        this.dostavnice = dostavnice;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public Date getDatumDolaskaGosta() {
        return datumDolaskaGosta;
    }

    public void setDatumDolaskaGosta(Date datumDolaskaGosta) {
        this.datumDolaskaGosta = datumDolaskaGosta;
    }

    public Date getDatumOdlaskaGosta() {
        return datumOdlaskaGosta;
    }

    public void setDatumOdlaskaGosta(Date datumOdlaskaGosta) {
        this.datumOdlaskaGosta = datumOdlaskaGosta;
    }

    public Integer getBrojGostiju() {
        return brojGostiju;
    }

    public void setBrojGostiju(Integer brojGostiju) {
        this.brojGostiju = brojGostiju;
    }

    public Integer getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(Integer brojSoba) {
        this.brojSoba = brojSoba;
    }
    
     public List<Soba> getSobe() {
        return sobe;
    }

    public void setSobe(List<Soba> sobe) {
        this.sobe = sobe;
    }
    
}
