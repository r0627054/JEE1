/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import rental.CarType;
import rental.Quote;
import rental.Reservation;

/**
 * 
 * @author Dries Janse, Steven Ghekiere
 */
@Remote
public class ReservationSession extends Session {
    public List<CarType> getAvailableCarTypes(Date start, Date end){
        return null;
    }
    
    public Quote createQuote(String name, Date start, Date end, String carType, String region){
        return null;
    }
    
    public List<Reservation> confirmQuotes(String name){
        return null;
    }
}
