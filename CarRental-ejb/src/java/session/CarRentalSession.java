package session;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateful;
import rental.CarType;
import rental.Quote;
import rental.RentalStore;
import rental.Reservation;

@Stateful
public class CarRentalSession implements CarRentalSessionRemote {

    /**
     * The (String) name of the client.
     */
    private String clientName;
    
    /**
     * The list of quotes for this session.
     */
    private List<Quote> quotes;
    
    public CarRentalSession(String clientName) {
        setQuotes(new ArrayList<Quote>());
        setClientName(clientName);
    }
    
    public CarRentalSession(){
        this("CarRentalSession");
    }

    @Override
    public Set<String> getAllRentalCompanies() {
        return new HashSet<String>(RentalStore.getRentals().keySet());
    }

    @Override
    public List<CarType> getAvailableCarTypes(Date start, Date end) {
        return null;
    }

    @Override
    public Quote createQuote(String name, Date start, Date end, String carType, String region) {
        return null;
    }

    @Override
    public List<Quote> getCurrenQuotes() {
        return getQuotes();
    }

    @Override
    public List<Reservation> confirmQuotes(String name) {
        return null;
    }

    //Setters & Getters
    public List<Quote> getQuotes() {
        return this.quotes;
    }

    private void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    
}
