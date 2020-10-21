/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Josip
 */
@Entity
public class Osoblje extends Osoba{
    
    private String odjel;   
    private BigDecimal placa;
    private String zaposlenUDjelatnosti;
    
    @ManyToOne
    private Hotel hotel;
    
    @OneToMany(mappedBy = "gost")
    private List<Dostavnica> dostavnice = new ArrayList<>();

    public List<Dostavnica> getDostavnice() {
        return dostavnice;
    }

    public void setDostavnice(List<Dostavnica> dostavnice) {
        this.dostavnice = dostavnice;
    }

    public String getOdjel() {
        return odjel;
    }

    public void setOdjel(String odjel) {
        this.odjel = odjel;
    }

    public BigDecimal getPlaca() {
        return placa;
    }

    public void setPlaca(BigDecimal placa) {
        this.placa = placa;
    }

    public String getZaposlenUDjelatnosti() {
        return zaposlenUDjelatnosti;
    }

    public void setZaposlenUDjelatnosti(String zaposlenUDjelatnosti) {
        this.zaposlenUDjelatnosti = zaposlenUDjelatnosti;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    
}
