/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Josip
 */
@Entity
public class Hotel extends Entitet{
    
    private String naziv;
    private String adresa1;
    private String adresa2;
    private String adresa3;
    private String webStranica;
    private String brojTelefona;
    private Integer brojZvjezdica;

    public List<Osoblje> getOsoblje() {
        return osoblje;
    }

    public void setOsoblje(List<Osoblje> osoblje) {
        this.osoblje = osoblje;
    }
    
    @OneToMany(mappedBy = "hotel")
    private List<Osoblje> osoblje = new ArrayList<>();
    
     @OneToMany(mappedBy = "hotel")
    private List<Soba> sobe = new ArrayList<>();

    public List<Soba> getSobe() {
        return sobe;
    }

    public void setSobe(List<Soba> sobe) {
        this.sobe = sobe;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa1() {
        return adresa1;
    }

    public void setAdresa1(String adresa1) {
        this.adresa1 = adresa1;
    }

    public String getAdresa2() {
        return adresa2;
    }

    public void setAdresa2(String adresa2) {
        this.adresa2 = adresa2;
    }

    public String getAdresa3() {
        return adresa3;
    }

    public void setAdresa3(String adresa3) {
        this.adresa3 = adresa3;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Integer getBrojZvjezdica() {
        return brojZvjezdica;
    }

    public void setBrojZvjezdica(Integer brojZvjezdica) {
        this.brojZvjezdica = brojZvjezdica;
    }

    @Override
    public String toString() {
        return getNaziv() + " "+ getBrojZvjezdica();
    }
    
    
    
}
