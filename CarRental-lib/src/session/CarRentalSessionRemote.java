package session;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import rental.CarType;
import rental.Quote;
import rental.Reservation;
import rental.ReservationException;

@Remote
public interface CarRentalSessionRemote {

    void setClientName(String clientName);

    Set<String> getAllRentalCompanies();

    List<CarType> getAvailableCarTypes(Date start, Date end);

    Quote createQuote(String name, Date start, Date end, String carType, String region) throws ReservationException;

    List<Quote> getCurrenQuotes();

    List<Reservation> confirmQuotes(String name) throws ReservationException;

}
