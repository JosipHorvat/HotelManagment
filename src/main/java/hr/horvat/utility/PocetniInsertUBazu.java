package hr.horvat.utility;

import com.github.javafaker.Faker;
import hr.horvat.model.Gost;
import hr.horvat.model.Hotel;
import hr.horvat.model.Osoblje;
import hr.horvat.model.Soba;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.hibernate.Session;

/**
 *
 * @author Josip
 */
public class PocetniInsertUBazu {

    // Sa ovom metodom pozivam da Hibernate odradi posao 
    // unosa podataka u bazu za Hotel i osoblje
    public static void izvediHotelIOsoblje() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

          Hotel hotelLav = new Hotel();
        hotelLav.setNaziv("Lav");
        hotelLav.setAdresa1("Mije Dzanka");
        hotelLav.setAdresa2("Baje 55");
        hotelLav.setAdresa3("Vukovar");
        hotelLav.setBrojTelefona("032555666");
        hotelLav.setBrojZvjezdica(4);
        hotelLav.setWebStranica("www.github.com");
        session.save(hotelLav);

        Hotel hotelOsijek = new Hotel();
        hotelOsijek.setNaziv("Osijek");
        hotelOsijek.setAdresa1("Vukovarska");
        hotelOsijek.setAdresa2(null);
        hotelOsijek.setAdresa3("Osijek");
        hotelOsijek.setBrojTelefona("031755696");
        hotelOsijek.setBrojZvjezdica(5);
        hotelOsijek.setWebStranica("www.github.com");
        session.save(hotelOsijek);
//==============Dovlacenje Osoblja u bazu===================
                Faker faker = new Faker();

        Osoblje o;
        for (int i = 0; i < 20; i++) {
            o = new Osoblje();
            o.setIme(faker.name().firstName());
            o.setPrezime(faker.name().lastName());
            o.setOib(Oib.getOibItCentrala());
            o.setEmail(o.getIme().toLowerCase() + "." + o.getPrezime().toLowerCase() + "@dalj.metropola.hr");
            o.setDatumRodjenja(faker.date().birthday());
            o.setZaposlenUDjelatnosti(faker.job().field());
            o.setPlaca(PomocnaMetoda.nasumicniBigDecimal(new BigDecimal(3000), new BigDecimal(9000)));
            o.setOdjel(faker.job().position());
            session.save(o);

            if (i < 10) {
                o.setHotel(hotelLav);
            }
            if (i >= 10) {
                o.setHotel(hotelOsijek);
            }

        }
        
        Soba soba;
        for (int i = 0; i < 40; i++) {
            soba = new Soba();
            soba.setRejtingSobe(faker.number().numberBetween(1, 10));
            soba.setBrojSobe(faker.number().numberBetween(1, 40));
            soba.setBrojKreveta(faker.number().numberBetween(1, 5));
            soba.setKatHotela(faker.number().numberBetween(1, 6));
            soba.setMaxBrojOsoba(faker.number().numberBetween(1, 10));
            soba.setTipSobe(PomocnaMetoda.nasumicniEnum(Soba.TipSobe.class));
            soba.setKucniLjubimci(faker.random().nextBoolean());
            soba.setPusenje(faker.random().nextBoolean());
            session.save(soba);
            
             if (i < 10) {
                soba.setHotel(hotelLav);
            }
            if (i >= 10) {
                soba.setHotel(hotelOsijek);
            }
        }
        
        
          session.getTransaction().commit();

    }
}
  
