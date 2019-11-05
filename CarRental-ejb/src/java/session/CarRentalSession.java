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

    private List<Quote> quotes;

    public CarRentalSession() {
        setQuotes(new ArrayList<Quote>());
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

}
