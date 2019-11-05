/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import rental.CarRentalCompany;
import rental.RentalStore;
import rental.ReservationException;

/**
 *
 * @author Steven Ghekiere, Dries Janse
 */
@Stateless
public class ManagerSession implements ManagerSessionRemote {

    @Override
    public int getNumberOfReservationsBy(String clientName) {
        int result = 0;

        for (CarRentalCompany company : RentalStore.getRentals().values()) {
            result += company.getReservationsByRenter(clientName).size();
        }

        return result;
    }

    @Override
    public int getNumberOfReservationsForCarType(String carRentalName, String carType) throws ReservationException {
        try {
            return RentalStore.getRental(carRentalName).getNumberOfReservationsForCarType(carType);
        } catch (ReservationException e) {
            throw e;
        }
    }
}
