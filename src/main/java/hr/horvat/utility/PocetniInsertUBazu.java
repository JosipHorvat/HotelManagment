package hr.horvat.utility;

import com.github.javafaker.Faker;
import hr.horvat.model.Dostavnica;
import hr.horvat.model.Gost;
import hr.horvat.model.Hotel;
import hr.horvat.model.Osoblje;
import hr.horvat.model.Rezervacija;
import hr.horvat.model.Soba;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Josip
 */
public class PocetniInsertUBazu {

    // Sa ovom metodom podatke u sve tablice na bazi
    // koristeci faker, metode iz klase PomocnaMetoda, OIB i Random()
    public static void izvedi() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Random random = new Random();
        Faker faker = new Faker();

//=========Postavljena 2 hotela u bazu===============       
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
        Osoblje o;
        List<Osoblje> osobljeZaBazu = new ArrayList<>();
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
            if (i < 20) {
                osobljeZaBazu.add(o);
            }

            if (i < 10) {
                o.setHotel(hotelLav);
            }
            if (i >= 10) {
                o.setHotel(hotelOsijek);
            }

        }
//==============Dovlacenje gostiju u bazu===========================     
        //broj kred. kartice je skriptiran u bazi
        Gost gost;
        List<Gost> gosti = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            gost = new Gost();
            gost.setIme(faker.name().firstName());
            gost.setPrezime(faker.name().lastName());
            gost.setBrojKreditneKartice(BCrypt.gensalt());
            gost.setBrojTelefona(faker.phoneNumber().cellPhone());
            gost.setDrzava(faker.country().name());
            gost.setDatumRodjenja(faker.date().birthday());
            gost.setOib(Oib.getOibItCentrala());
            gost.setVrstaPlacanja(PomocnaMetoda.nasumicniEnum(Gost.VrstaPlacanja.class));
            gost.setEmail(gost.getIme() + "." + gost.getPrezime() + "@net.hr");
            session.save(gost);
            // lista se puni sa gostima
            if (j < 100) {
                gosti.add(gost);
            }
        }
//===========Dovlacenje rezervacija u bazu ====================================
        Rezervacija r;
        List<Rezervacija> rezervacijeZaBazu = new ArrayList<>();
        List<Rezervacija> rezervacijeZaBazu2 = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            r = new Rezervacija();
            r.setBrojGostiju(faker.random().nextInt(1, 10));
            r.setBrojSoba(faker.random().nextInt(1, 10));
            r.setDatumDolaskaGosta(faker.date().future(2021, TimeUnit.DAYS));
            r.setDatumOdlaskaGosta(faker.date().future(2022, TimeUnit.DAYS));
            r.setDatumRezervacije(faker.date().birthday());

            // Nasumicni gosti iz liste gosti ce ovdje popunit rezervacije
            int index = random.nextInt(gosti.size());
            Gost randomGost = gosti.get(index);
            r.setGost(randomGost);

            session.save(r);

            if (i < 10) {
                rezervacijeZaBazu.add(r);
            }
            if (i > 10 && i < 20) {
                rezervacijeZaBazu2.add(r);
            }
        }

//==========Dovlacenje soba u bazu=====================================
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
            soba.setRezervacije(rezervacijeZaBazu);
            session.save(soba);

            if (i < 10) {
                soba.setHotel(hotelLav);
            }
            if (i >= 10) {
                soba.setHotel(hotelOsijek);
            }
        }
//===========Dovlacenje dostavnica u bazu=======================
        Dostavnica d;
        for (int i = 0; i < 10; i++) {
            d = new Dostavnica();
            d.setDatumPrimitka(faker.date().birthday());
//  Liste gdje su popunjeni nasumicni podaci nalaze se kod pripadajucih unosa 
            int index = random.nextInt(gosti.size());
            Gost randomGost = gosti.get(index);
            d.setGost(randomGost);

            int index1 = random.nextInt(rezervacijeZaBazu2.size());
            Rezervacija randomRez = rezervacijeZaBazu2.get(index1);
            d.setRezervacija(randomRez);

            int index2 = random.nextInt(osobljeZaBazu.size());
            Osoblje randomOsoblje = osobljeZaBazu.get(index2);
            d.setOsoblje(randomOsoblje);
            session.save(d);

        }
 // session commit 
        session.getTransaction().commit();
    }
}
