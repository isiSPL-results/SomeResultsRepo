package healthwatcher.view;

import healthwatcher.business.IFacadeRMITargetAdapter;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.employee.Employee;
import healthwatcher.model.healthguide.HealthUnit;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;

import lib.exceptions.CommunicationException;
import lib.exceptions.InsertEntryException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.exceptions.UpdateEntryException;
import lib.patterns.observer.Subject;
import lib.util.IteratorDsk;

/*
 * TODO - describe this file
 *
 */
public class RMIServletAdapter implements IFacade, Serializable
{

    protected IFacadeRMITargetAdapter facade = null;

    public RMIServletAdapter(String server) throws CommunicationException
    {
        connect(server);
    }

    public void connect(String server) throws CommunicationException
    {
        try {
            System.out.println("About to lookup...");
            facade= (IFacadeRMITargetAdapter) Naming.lookup(server);
            System.out.println("Remote DisqueSaude found");

        } catch (java.rmi.RemoteException rmiEx) {
            rmiInitExceptionHandling(rmiEx);
            throw new CommunicationException(rmiEx.getMessage());
        } catch (java.rmi.NotBoundException rmiEx) {
            rmiInitExceptionHandling(rmiEx);
            throw new CommunicationException(rmiEx.getMessage());
        } catch (java.net.MalformedURLException rmiEx) {
            rmiInitExceptionHandling(rmiEx);
            throw new CommunicationException(rmiEx.getMessage());
        }
    }

    protected void rmiInitExceptionHandling(Throwable exception)
    {
        String error =  "<p>****************************************************<br>" +
                        "Error during servlet initialization!<br>" +
                        "The exception message is:<br><dd>" + exception.getMessage() +
                        "<p>You may have to restart the servlet container.<br>" +
                        "*******************************************************";
        System.out.println(error);
    }

    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException
    {
        try {
            facade.updateComplaint(q);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        try {
            return facade.searchSpecialitiesByHealthUnit(code);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try {
            return facade.searchComplaint(code);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, CommunicationException, TransactionException
    {
        try {
            return facade.searchDiseaseType(code);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, CommunicationException
    {
        try {
            return facade.searchHealthUnitsBySpeciality(code);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try {
            return facade.getSpecialityList();
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try {
            return facade.getDiseaseTypeList();
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try {
            return facade.getHealthUnitList();
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, CommunicationException, TransactionException
    {
        try {
            return facade.getPartialHealthUnitList();
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, CommunicationException, TransactionException,
        ObjectNotValidException
    {
        try {
            return facade.insertComplaint(complaint);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException
    {
        try {
            facade.updateHealthUnit(unit);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException
    {
        try {
            return facade.getComplaintList();
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
        InsertEntryException, TransactionException, CommunicationException
    {
        try {
            facade.insert(e);
        } catch (RemoteException ex) {
            throw new CommunicationException(ex.getMessage());
        }
    }

    public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
        CommunicationException
    {
        try {
            facade.updateEmployee(e);
        } catch (RemoteException ex) {
            throw new CommunicationException(ex.getMessage());
        }
    }

    public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
        CommunicationException
    {
        try {
            return facade.searchEmployee(login);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException
    {
        try {
            return facade.searchHealthUnit(healthUnitCode);
        } catch (RemoteException e) {
            throw new CommunicationException(e.getMessage());
        }
    }

    public void notify(Subject subject) throws TransactionException, ObjectNotFoundException,
        RepositoryException, RemoteException, ObjectNotValidException
    {
        try {
            if (subject instanceof Complaint) {
                Complaint complaint = (Complaint) subject;
                updateComplaint(complaint);

            } else if (subject instanceof Employee) {
                Employee employee = (Employee) subject;
                updateEmployee(employee);

            } else if (subject instanceof HealthUnit) {
                HealthUnit healthUnit = (HealthUnit) subject;
                updateHealthUnit(healthUnit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
