/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import hr.horvat.utility.StarRater;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Josip
 */
public class Test {
    
//     public static void main(String[] args) {
//     
//      JFrame frame = new JFrame();
//      JPanel panel = new JPanel();
//      panel.add(new StarRater());
//      frame.getContentPane().add(panel);
//      frame.pack();
//      frame.setVisible(true);
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    
//  }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        StarRater starRater = new StarRater(5, 2, 1);
        starRater.addStarListener(
            new StarRater.StarListener()   {

                public void handleSelection(int selection) {
                    System.out.println(selection);
                }
            });
        panel.add(starRater);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
