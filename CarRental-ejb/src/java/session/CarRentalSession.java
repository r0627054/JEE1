package session;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateful;
import rental.CarRentalCompany;
import rental.CarType;
import rental.Quote;
import rental.RentalStore;
import rental.Reservation;
import rental.ReservationConstraints;
import rental.ReservationException;

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

    public CarRentalSession() {
        this("CarRentalSession");
    }

    @Override
    public Set<String> getAllRentalCompanies() {
        return new HashSet<String>(RentalStore.getRentals().keySet());
    }

    @Override
    public List<CarType> getAvailableCarTypes(Date start, Date end) {
        List<CarType> result = new ArrayList<CarType>();

        for (CarRentalCompany company : RentalStore.getRentals().values()) {
            result.addAll(company.getAvailableCarTypes(start, end));
        }

        // removing duplicates, maintaining order of list
        LinkedHashSet<CarType> resultSet = new LinkedHashSet<CarType>(result);
        List<CarType> resultWithoutDuplicates = new ArrayList<CarType>(resultSet);

        return resultWithoutDuplicates;
    }

    @Override
    public Quote createQuote(String name, Date start, Date end, String carType, String region) throws ReservationException {
        for (CarRentalCompany comp : RentalStore.getRentals().values()) {
            if (comp.canCreateQuote(carType, start, end, region)) {
                Quote q = comp.createQuote(new ReservationConstraints(start, end, carType, region), name);
                this.addQuote(q);
                return q;
            }

        }
        return null;
    }

    @Override
    public List<Quote> getCurrenQuotes() {
        return getQuotes();
    }

    @Override
    public List<Reservation> confirmQuotes(String name) throws ReservationException {
        List<Reservation> result = new ArrayList<Reservation>();

        try {
            for (Quote q : getQuotes()) {
                if (q.getCarRenter().equals(name)) {

                    CarRentalCompany companyOfQuote = RentalStore.getRental(q.getCarRenter());
                    result.add(companyOfQuote.confirmQuote(q));
                }
            }
        } catch (ReservationException e) {
            System.out.println("Error with confirming quotes! All quotes will be rolled back. NAME= " + name);
            for (Reservation r : result) {
                RentalStore.getRental(r.getRentalCompany()).cancelReservation(r);
            }

            throw e;
        }
        return result;
    }

    public void addQuote(Quote quote) {
        this.getQuotes().add(quote);
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
