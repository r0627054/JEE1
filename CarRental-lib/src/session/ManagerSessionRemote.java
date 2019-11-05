/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Remote;
import rental.ReservationException;

/**
 *
 * @author Steven Ghekiere, Dries Janse
 */
@Remote
public interface ManagerSessionRemote {

    int getNumberOfReservationsBy(String clientName) throws ReservationException ;

    int getNumberOfReservationsForCarType(String carRentalName, String carType) throws ReservationException ;

}
