/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Remote;

/**
 *
 * @author Dries Janse
 */
@Remote
public class ManagerSession extends Session {
    
    public int getNumberOfReservationsBy(String clientName) {
        return 0;
    }
    
    int getNumberOfReservationsForCarType( String carRentalName, String carType){
        return 0;
    }
}
