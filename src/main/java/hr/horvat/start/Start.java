/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.start;

import hr.horvat.utility.HibernateUtil;

/**
 *
 * @author Josip
 */
public class Start {
    
    public static void main(String[] args) {
        
        HibernateUtil.getSessionFactory().openSession();
    }
}
