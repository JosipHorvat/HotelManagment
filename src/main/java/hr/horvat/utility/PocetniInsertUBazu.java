package hr.horvat.utility;

import com.github.javafaker.Faker;
import hr.horvat.model.Gost;
import hr.horvat.model.Hotel;
import hr.horvat.model.Osoblje;
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
    // unosa podataka u bazu 
    public static void izvedi() {

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

        Faker faker = new Faker();

        String[] oibi = {"44879378548", "38714462960", "48653367511",
            "07463739447", "55376858772", "57121746664", "45088797644", "97067197029",
            "36388448333", "13633152331"};

        Osoblje o;
        for (int i = 0; i < 10; i++) {
            o = new Osoblje();
            o.setIme(faker.name().firstName());
            o.setPrezime(faker.name().lastName());
            o.setOib(oibi[i]);
            o.setEmail(o.getIme().toLowerCase() + "." + o.getPrezime().toLowerCase() + "@dalj.metropola.hr");
            o.setDatumRodjenja(faker.date().birthday());
            o.setZaposlenUDjelatnosti(faker.job().field());
            o.setPlaca(PomocnaMetoda.randomBigDecimal(new BigDecimal(3000), new BigDecimal(9000)));
            o.setOdjel(faker.job().position());
            session.save(o);

            if (i < 5) {
                o.setHotel(hotelLav);
            }
            if (i >= 5) {
                o.setHotel(hotelOsijek);
            }

        }
          session.getTransaction().commit();

    }

    
}
