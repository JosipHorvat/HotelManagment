/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 *
 * @author Josip
 */
@Entity
public class Soba extends Entitet{
    
   private Integer brojSobe;
   private Integer brojKreveta;
   private Integer maxBrojOsoba;
   private Integer rejtingSobe;
   private Integer katHotela;
   private Boolean pusenje;
   private Boolean kucniLjubimci;
   
    @Enumerated(EnumType.STRING)
    private TipSobe tipSobe;

    public static enum TipSobe {
        Single,Double,Triple,
        Quad,Queen,King,Twin,
        DoubleDouble
         }
           
         @ManyToOne
    private Hotel hotel;

    public Integer getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(Integer brojSobe) {
        this.brojSobe = brojSobe;
    }

    public Integer getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(Integer brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public Integer getMaxBrojOsoba() {
        return maxBrojOsoba;
    }

    public void setMaxBrojOsoba(Integer maxBrojOsoba) {
        this.maxBrojOsoba = maxBrojOsoba;
    }

    public Integer getRejtingSobe() {
        return rejtingSobe;
    }

    public void setRejtingSobe(Integer rejtingSobe) {
        this.rejtingSobe = rejtingSobe;
    }

    public Integer getKatHotela() {
        return katHotela;
    }

    public void setKatHotela(Integer katHotela) {
        this.katHotela = katHotela;
    }

    public Boolean getPusenje() {
        return pusenje;
    }

    public void setPusenje(Boolean pusenje) {
        this.pusenje = pusenje;
    }

    public Boolean getKucniLjubimci() {
        return kucniLjubimci;
    }

    public void setKucniLjubimci(Boolean kucniLjubimci) {
        this.kucniLjubimci = kucniLjubimci;
    }

    public TipSobe getTipSobe() {
        return tipSobe;
    }

    public void setTipSobe(TipSobe tipSobe) {
        this.tipSobe = tipSobe;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
         
}
