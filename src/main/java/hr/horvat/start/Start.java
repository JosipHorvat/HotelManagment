/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.start;

import hr.horvat.controller.ObradaHotel;
import hr.horvat.model.Hotel;
import hr.horvat.utility.HibernateUtil;
import hr.horvat.utility.Iznimka;
import hr.horvat.utility.PocetniInsertUBazu;
import hr.horvat.view.Hoteli;
import java.util.Scanner;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Josip
 */
public class Start {
    
    
    
    public static void main(String[] args) {
    
        
        //hotel start
        new Hoteli().setVisible(true);
        
        
        
        
        
//================TEST OBRADA HOTEL================      
   // test
//   Hotel hotel = new Hotel();
//   ObradaHotel obradaHotel = new ObradaHotel(hotel);
//   // kontrola naziva radi
//   hotel.setNaziv("T");
//   //radi
//   hotel.setAdresa1("dddd  ");
//   hotel.setAdresa2("ddddd ");
//   
//   hotel.setBrojZvjezdica(4);
//  
//        try {
//             obradaHotel.kreiraj();
//        } catch (Iznimka e) {
//            System.out.println(e.getPoruka());
//        }
//  
//         
        
//============POCETNI INSERT U BAZU============================  
             //  PocetniInsertUBazu.izvedi(); 
       // Ako je potrebno dropnit bazu ili dodati nove podatke 
       // prvo se mora izmijeniti hibernate.cfg.xml
       // HibernateUtil.getSessionFactory().openSession();
                  
    }
   
}
