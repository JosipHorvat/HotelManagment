
package hr.horvat.controller;

import hr.horvat.model.Hotel;
import hr.horvat.utility.Iznimka;
import java.math.BigDecimal;
import java.util.List;
/**
 * 
 * @author Josip
 */


// Kada extendam Obrada uvijek cu morati parametrizirati klasu koja ce se kontrolirati.
//Nakon toga potrebno je implementirati sve metode iz nad klase Obrada. To su create read update i delete 

public class ObradaHotel extends Obrada<Hotel>{

    public ObradaHotel(Hotel hotel) {
        super(hotel);
    }
    
    public ObradaHotel(){
        super();
    }

    @Override
     public List<Hotel>getPodaci(){
        return session.createQuery("from Hotel").list();
    }
  

    @Override
    protected void kontrolaKreiraj() throws Iznimka {
        
        kontrolaNaziv();
        //ova metoda kontrolira prva 2 polja za adresu, trece polje je nebitno :(
        kontrolaAdrese();
        kontrolaBrojZvjezdica();
    
      
    }

    @Override
    protected void kontrolaIzmijeni() throws Iznimka {
        // pozivom metode kontrola kreiraj kontroliram sve 
        // iz kontrole kreiraj i u kontroli izmijeni
        kontrolaKreiraj();
       
        
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
        kontrolaSobe();
        kontrolaOsoblje();
    }
    
    private void kontrolaNaziv() throws Iznimka{
       kontrolaNull(entitet.getNaziv(), "Naziv nije definiran! ");
        
        // regex ce rijesiti i ovu iznimku ali upisao sam je zbog ispravne poruke
        if(entitet.getNaziv().trim().isEmpty()){
            throw new Iznimka("Naziv ne moze biti prazan!");
        }
        
        //regex kontrola naziv ne moze sadrzavati brojeve i znakove
        if (!entitet.getNaziv().matches("[a-žA-Ž\\s]+")) {
            throw new Iznimka("Naziv ne može sadržavati brojeve ili znakove!");
        }
        if(entitet.getNaziv().length()>50){
            throw new Iznimka("Dužina naziva ne može biti veća od 50 znakova!");
        }
    }
    
    private void kontrolaAdrese() throws Iznimka{
        kontrolaNull(entitet.getAdresa1(), "Prvo polje adrese nije definirano! ");
        kontrolaNull(entitet.getAdresa2(), "Drugo polje adrese nije definirano! ");
        
         if(entitet.getAdresa1().trim().isEmpty()){
            throw new Iznimka("Prvo polje za adresu ne moze biti prazno!");
        }
           if(entitet.getAdresa2().trim().isEmpty()){
            throw new Iznimka("Drugo polje za adresu ne moze biti prazno!");
        }
         
         if(entitet.getAdresa1().length()>100){
            throw new Iznimka("Dužina adrese ne može biti veća od 100 znakova!");
        }
          if(entitet.getAdresa2().length()>100){
            throw new Iznimka("Dužina adrese ne može biti veća od 100 znakova!");
        }
         
        
    }
    
    private void kontrolaBrojZvjezdica() throws Iznimka{
        kontrolaNull(entitet.getBrojZvjezdica(), "Nije odredjen broj zvjezdica hotela");
           if(entitet.getBrojZvjezdica()==0){
            throw new Iznimka("Oznaci koliko hotel ima zvjezdica");
        }
       
    }
    
    private void kontrolaOsoblje() throws Iznimka{
        if(entitet.getOsoblje().size()>0){
            throw new Iznimka("Hotel se ne moze obrisati jer nije uklonjeno osoblje iz baze.");
        }
    }
    private void kontrolaSobe() throws Iznimka{
        if(entitet.getSobe().size()>0){
            throw new Iznimka("Hotel se ne moze obrisati jer nisu uklonjene sobe iz baze");
        }
    }
    
        
     
    
    private void kontrolaNull(Object o, String poruka) throws Iznimka{
        if(o == null){
            throw new Iznimka(poruka);
        }
    }
    
    
}
