package client;

import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import rental.Reservation;
import session.CarRentalSessionRemote;
import session.ManagerSessionRemote;


public class Main extends AbstractTestAgency<CarRentalSessionRemote, ManagerSessionRemote> {

    @EJB
    static ManagerSessionRemote managerSession;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Main main = new Main("simpleTrips");
        main.run(); 
    }

    public Main(String scriptFile) {
        super(scriptFile);
    }

    @Override
    protected CarRentalSessionRemote getNewReservationSession(String name) throws Exception {
        InitialContext context = new InitialContext();
        CarRentalSessionRemote session = (CarRentalSessionRemote) context.lookup(CarRentalSessionRemote.class.getName());
        session.setClientName(name);
        return session;
    }

    @Override
    @RolesAllowed("Manager")
    protected ManagerSessionRemote getNewManagerSession(String name) throws Exception {
        return managerSession;
    }

    //CarRentalSessionRemote Methods
    @Override
    protected void getAvailableCarTypes(CarRentalSessionRemote session, Date start, Date end) throws Exception {
        session.getAvailableCarTypes(start, end);
    }

    @Override
    protected void createQuote(CarRentalSessionRemote session, String name, Date start, Date end, String carType, String region) throws Exception {
        session.createQuote(name, start, end, carType, region);
    }

    @Override
    protected List<Reservation> confirmQuotes(CarRentalSessionRemote session, String name) throws Exception {
        return session.confirmQuotes(name);
    }

    //Manager methods
    @Override
    @RolesAllowed("Manager")
    protected int getNumberOfReservationsBy(ManagerSessionRemote ms, String clientName) throws Exception {
        return ms.getNumberOfReservationsBy(clientName);
    }

    @Override
    @RolesAllowed("Manager")
    protected int getNumberOfReservationsForCarType(ManagerSessionRemote ms, String carRentalName, String carType) throws Exception {
        return ms.getNumberOfReservationsForCarType(carRentalName, carType);
    }
}
