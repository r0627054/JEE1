package session;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import rental.CarType;
import rental.Quote;
import rental.Reservation;

@Remote
public interface CarRentalSessionRemote {

    Set<String> getAllRentalCompanies();

    List<CarType> getAvailableCarTypes(Date start, Date end);
    
    Quote createQuote(String name, Date start, Date end, String carType, String region);
    
    List<Quote> getCurrenQuotes();
    
    List<Reservation> confirmQuotes(String name);

}
