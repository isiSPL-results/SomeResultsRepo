package healthwatcher.business;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.employee.Employee;
import healthwatcher.model.healthguide.HealthUnit;
import java.rmi.Remote;
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
public interface IFacadeRMITargetAdapter extends Remote
{
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
               ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
               CommunicationException, java.rmi.RemoteException, RepositoryException;
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, java.rmi.RemoteException,
               CommunicationException, RepositoryException;
    public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException, java.rmi.RemoteException;
    public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException, java.rmi.RemoteException;
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               java.rmi.RemoteException, CommunicationException, RepositoryException;
    public int insertComplaint(Complaint complaint) throws RepositoryException,
               ObjectAlreadyInsertedException, CommunicationException, TransactionException,
               ObjectNotValidException, java.rmi.RemoteException;
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
               ObjectNotValidException, TransactionException, CommunicationException,
               java.rmi.RemoteException, RepositoryException;
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
               InsertEntryException, ObjectNotValidException, TransactionException,
               CommunicationException, java.rmi.RemoteException, RepositoryException;
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
               ObjectNotValidException, InsertEntryException, TransactionException,
               CommunicationException, java.rmi.RemoteException, RepositoryException;
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, java.rmi.RemoteException, CommunicationException, TransactionException;
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
               ObjectNotFoundException, CommunicationException, ObjectNotValidException,
               java.rmi.RemoteException;
    public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
               TransactionException, java.rmi.RemoteException;
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
               TransactionException, ObjectNotFoundException, CommunicationException,
               ObjectNotValidException, java.rmi.RemoteException;
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
               ObjectNotFoundException, java.rmi.RemoteException, CommunicationException;
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
               RepositoryException, TransactionException, CommunicationException,
               java.rmi.RemoteException;
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException,
               java.rmi.RemoteException;
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
}
