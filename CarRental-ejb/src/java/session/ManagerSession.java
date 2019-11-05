/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;

/**
 * 
 * @author Steven Ghekiere, Dries Janse
 */
@Stateless
public class ManagerSession implements ManagerSessionRemote{
    
    @Override
    public int getNumberOfReservationsBy(String clientName) {
        return 0;
    }
    
    @Override
    public int getNumberOfReservationsForCarType( String carRentalName, String carType){
        return 0;
    }
}
