package healthwatcher.business;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.employee.Employee;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import lib.exceptions.CommunicationException;
import lib.exceptions.InsertEntryException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.exceptions.UpdateEntryException;
import lib.util.IteratorDsk;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.model.healthguide.MedicalSpeciality;
public class RMIFacadeAdapter extends UnicastRemoteObject
    implements IFacadeRMITargetAdapter
{
    private static RMIFacadeAdapter singleton;
    private IFacade fCid;
    public Employee searchEmployee(String login) throws ObjectNotFoundException, TransactionException,
               CommunicationException, RepositoryException, ObjectNotValidException, UpdateEntryException
    {
        return fCid.searchEmployee(login);
    }
    public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
        TransactionException
    {
        return fCid.searchSpecialitiesByCode(numSpeciality);
    }
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    {
        fCid.insert(speciality);
    }
    public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException, CommunicationException
    {
        fCid.updateEmployee(employee);
    }
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getHealthUnitList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    {
        fCid.insert(us);
    }
    private void rmiFacadeExceptionHandling(Throwable exception)
    {
        System.out.println("**************************************************");
        System.out.println("* Error during server initialization!            *");
        System.out.println("* The exception message is:                      *");
        System.out.println("      " + exception.getMessage());
        System.out.println("* You may have to restart the server or registry.*");
        System.out.println("**************************************************");
        exception.printStackTrace();
    }
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    {
        fCid.updateMedicalSpeciality(speciality);
    }
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        return fCid.searchSymptom(numSymptom);
    }
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException, CommunicationException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid
                                          .searchSpecialitiesByHealthUnit(code);
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        return fCid.getSymptomList();
    }
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        fCid.insert(diseaseType);
    }
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getSpecialityList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException, RepositoryException
    {
        return fCid.getComplaintList();
    }
    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    {
        fCid.insert(employee);
    }
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, CommunicationException
    {
        this.fCid.updateComplaint(q);
    }
    public void updateHealthUnit(HealthUnit hu) throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException, CommunicationException
    {
        fCid.updateHealthUnit(hu);
    }
    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        java.rmi.RemoteException, CommunicationException
    {
        return fCid.insertComplaint(complaint);
    }
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    {
        fCid.updateSymptom(symptom);
    }
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        return fCid.searchHealthUnit(healthUnitCode);
    }
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        fCid.insert(symptom);
    }
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getDiseaseTypeList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }
    private RMIFacadeAdapter() throws RepositoryException, IOException
    {
        this.fCid = new HealthWatcherFacade();
        try { //1
            System.out.println("Creating RMI server...");
            System.out.println("Object exported");
            System.out.println(healthwatcher.Constants.SYSTEM_NAME);
            java.rmi.Naming.rebind("//" + healthwatcher.Constants.SERVER_NAME + "/"
                                   + healthwatcher.Constants.SYSTEM_NAME, this);
            System.out.println("Server created and ready.");
        } catch (java.rmi.RemoteException rmiEx) { //1
            rmiFacadeExceptionHandling(rmiEx);
        } catch (java.net.MalformedURLException rmiEx) { //1
            rmiFacadeExceptionHandling(rmiEx);
        }
    }
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException, CommunicationException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getPartialHealthUnitList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException, CommunicationException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.searchHealthUnitsBySpeciality(code);
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }
    public synchronized static RMIFacadeAdapter getInstance()
    throws RepositoryException, IOException, java.rmi.RemoteException
    {
        if(singleton == null) { //1
            singleton = new RMIFacadeAdapter();
        }
        return singleton;
    }
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {
        return this.fCid.searchComplaint(code);
    }
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException, CommunicationException
    {
        return fCid.searchDiseaseType(code);
    }

}
