/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phiservice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Fachrul Pralienka BM
 */
@WebService(serviceName = "PhiWebService")
@Stateless()
public class PhiWebService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "phi")
    public String Phi(@WebParam(name = "n") int n) {        
        
        // a = ( Math.pow(-1, n) ) / ( Math.pow(2, 10*n) );
        BigDecimal a = (new BigDecimal(-1).pow(n)).divide(new BigDecimal(2).pow(10*n)); 
        
        // menghitung panjang karakter a -> digunakan untuk menentukan panjang karakter di belakang koma nilai b sampai h
        int lengthA = a.toPlainString().length();       
        
        // b = ( Math.pow(2, 5) ) / ( (4*n)+1 );                        
        BigDecimal b = new BigDecimal(2).pow(5).divide(new BigDecimal((4*n)+1), lengthA, RoundingMode.HALF_UP);        
        
        // c = 1 / ( (4*n)+3 );                
        BigDecimal c = new BigDecimal(1).divide(new BigDecimal((4*n)+3),lengthA,RoundingMode.HALF_UP);
                
        // d = ( Math.pow(2, 8) ) / ( (10*n)+1 );       
        BigDecimal d = new BigDecimal(2).pow(8).divide(new BigDecimal((10*n)+1),lengthA,RoundingMode.HALF_UP);
        
        // e = ( Math.pow(2, 6) ) / ( (10*n)+3 );        
        BigDecimal e = new BigDecimal(2).pow(6).divide(new BigDecimal((10*n)+3),lengthA,RoundingMode.HALF_UP);
        
        // f = ( Math.pow(2, 2) ) / ( (10*n)+5 );        
        BigDecimal f = new BigDecimal(2).pow(2).divide(new BigDecimal((10*n)+5),lengthA,RoundingMode.HALF_UP);
        
        //double g = ( Math.pow(2, 2) ) / ( (10*n)+7 );        
        BigDecimal g = new BigDecimal(2).pow(2).divide(new BigDecimal((10*n)+7),lengthA,RoundingMode.HALF_UP);
        
        // h = 1 / ( (10*n)+9 );
        BigDecimal h = new BigDecimal(1).divide(new BigDecimal((10*n)+9),lengthA,RoundingMode.HALF_UP);
        
        //a * (-b -c +d -e -f -g +h)        
        BigDecimal phi = a.multiply( (d.subtract(c).subtract(b).subtract(e).subtract(f).subtract(g).add(h)) );
                
        // return nilai phi ke plain string, sehingga tidak ada penyingkatan misalnya +e
        return phi.toPlainString();
    }
}
