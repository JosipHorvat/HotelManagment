
package hr.horvat.controller;

import hr.horvat.utility.HibernateUtil;
import hr.horvat.utility.Iznimka;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Josip
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    
    // Glavne metode obrade koje ce svi entiteti u obradi morati imati.
    public abstract List<T> getPodaci();
    protected abstract void kontrolaKreiraj() throws Iznimka;
    protected abstract void kontrolaIzmijeni() throws Iznimka;
    protected abstract void kontrolaObrisi() throws Iznimka;

    //Prvi konstruktor za buduce klase koji se zove entitet
    public Obrada(T entitet) {
        this();
        this.entitet = entitet;
    }

    // Drugi konstruktor je za session 
    public Obrada() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    public T kreiraj() throws Iznimka{
        kontrolaKreiraj();      
        save();
        return entitet;
    }
    
    public T kreirajSve(List<T> lista ) throws Iznimka{
        session.beginTransaction();
        for(T t : lista){
            setEntitet(t);
            session.save(t);
        }
        session.getTransaction().commit();
        
        return entitet;
    }
    
    public T izmijeni() throws Iznimka{
        kontrolaIzmijeni();
        save();
        return entitet;
    }
    
    public boolean obrisi() throws Iznimka{
        kontrolaObrisi();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        return true;
    }

    private void save() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
       } 

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
}
