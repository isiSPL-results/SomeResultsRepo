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
import healthwatcher.model.complaint.Symptom;
import healthwatcher.model.healthguide.MedicalSpeciality;
public interface IFacade extends Observer
  { 
public DiseaseType searchDiseaseType(int code) throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException;public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
               TransactionException;public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException;public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException;public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               CommunicationException, RepositoryException;public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
               ObjectNotValidException, TransactionException, CommunicationException, RepositoryException;public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException;public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException;public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException;public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
               RepositoryException, TransactionException, CommunicationException;public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException;public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, CommunicationException, RepositoryException;public int insertComplaint(Complaint complaint) throws RepositoryException,
               ObjectAlreadyInsertedException, CommunicationException, TransactionException,
               ObjectNotValidException;public void insert(DiseaseType diseaseType) throws InsertEntryException,
               ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
               CommunicationException, RepositoryException;public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException;public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
               ObjectNotFoundException, CommunicationException, ObjectNotValidException;public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
               ObjectNotFoundException, CommunicationException;public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
               ObjectNotValidException, InsertEntryException, TransactionException,
               CommunicationException, RepositoryException;public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
               TransactionException, ObjectNotFoundException, CommunicationException,
               ObjectNotValidException;public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
               InsertEntryException, ObjectNotValidException, TransactionException,
               CommunicationException, RepositoryException;
 } 
