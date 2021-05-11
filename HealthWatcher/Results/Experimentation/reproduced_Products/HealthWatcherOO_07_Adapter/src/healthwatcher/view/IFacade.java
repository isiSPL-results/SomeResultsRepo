package healthwatcher.view;
import lib.exceptions.CommunicationException;
import lib.exceptions.InsertEntryException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.exceptions.UpdateEntryException;
import lib.util.IteratorDsk;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.employee.Employee;
import healthwatcher.model.healthguide.HealthUnit;
import lib.patterns.observer.Observer;
public interface IFacade extends Observer
{
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, CommunicationException;
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException;
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
    public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException;
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException;
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, CommunicationException;
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               CommunicationException;
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException;
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
               RepositoryException, TransactionException, CommunicationException;
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException;
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
    public int insertComplaint(Complaint complaint) throws RepositoryException,
               ObjectAlreadyInsertedException, CommunicationException, TransactionException,
               ObjectNotValidException;
    public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException;
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
               ObjectNotFoundException, CommunicationException;
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
}
