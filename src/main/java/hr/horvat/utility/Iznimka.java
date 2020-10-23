
package hr.horvat.utility;

/**
 *
 * @author Josip
 */
public class Iznimka extends Exception{
    
    private final String poruka;

    public Iznimka(String poruka) {
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }
    
    
}
