
package controller;

import hr.horvat.model.Hotel;
import hr.horvat.utility.Iznimka;
/**
 * 
 * @author Josip
 */


// Kada extendam Obrada uvijek cu morati parametrizirati klasu koja ce se kontrolirati.
//Nakon toga potrebno je implementirati sve metode iz nad klase Obrada. To su create read update i delete 
// naravno na Hrvatskom jeziku ;)
public class ObradaHotel extends Obrada<Hotel>{

    public ObradaHotel(Hotel entitet) {
        super(entitet);
    }
    
    

    @Override
    protected void kontrolaKreiraj() throws Iznimka {
        if(entitet.getNaziv()== null){
            throw new Iznimka("Naziv ne moze ostati prazan ili naziv nije postavljen");
            // Ovo sada testiram u main metodi u startu 
        }
    }

    @Override
    protected void kontrolaIzmijeni() throws Iznimka {
        
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
        
    }
    
}
