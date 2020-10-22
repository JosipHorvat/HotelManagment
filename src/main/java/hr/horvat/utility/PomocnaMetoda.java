/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.horvat.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Josip
 */
public class PomocnaMetoda {
    
    public static BigDecimal randomBigDecimal(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, RoundingMode.UP);
    }
}
