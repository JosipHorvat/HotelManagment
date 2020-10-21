
package hr.horvat.utility;

import hr.horvat.model.Hotel;
import org.hibernate.Session;

/**
 *
 * @author Josip
 */
public class PocetniInsertUBazu {
    
    // Sa ovom metodom pozivam da Hibernate odradi posao 
    // unosa podataka u bazu 
    public static void izvedi(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Hotel osijek = kreirajHotel("Osijek", "Ulica Vukovarska", "Osijek", null, "095555675", 4, "www.github.com");
        Hotel lav = kreirajHotel("Lav", "Mije Dzanka", "Baje 55", "Vukovar", "031345456", 5, "https://github.com/JosipHorvat/HotelManagment");
        
        
        session.beginTransaction();
        session.save(osijek);
        session.save(lav);
        session.getTransaction().commit();
    }
   
    
    private static Hotel kreirajHotel(String naziv, String adresa1, String adresa2, String adresa3,
            String brojTelefona, int brojZvjezdica, String webStranica  ){
            
        Hotel hotel = new Hotel();
        hotel.setNaziv(naziv);
        hotel.setAdresa1(adresa1);
        hotel.setAdresa2(adresa2);
        hotel.setAdresa3(adresa3);
        hotel.setBrojTelefona(brojTelefona);
        hotel.setBrojZvjezdica(brojZvjezdica);
        hotel.setWebStranica(webStranica);
        return hotel;
    }
}
