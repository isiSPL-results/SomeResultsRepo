package healthwatcher.business;
import healthwatcher.Constants;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.employee.Employee;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.IOException;
import lib.exceptions.InsertEntryException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.persistence.IPersistenceMechanism;
import lib.persistence.PersistenceMechanism;
import lib.util.IteratorDsk;
import java.rmi.RemoteException;
import lib.patterns.observer.Subject;
import healthwatcher.business.complaint.ComplaintRecord;
import healthwatcher.business.complaint.DiseaseRecord;
import healthwatcher.business.employee.EmployeeRecord;
import healthwatcher.business.healthguide.HealthUnitRecord;
import healthwatcher.business.healthguide.MedicalSpecialityRecord;
import healthwatcher.data.factories.AbstractRepositoryFactory;
import healthwatcher.data.factories.RepositoryFactory;
import healthwatcher.business.complaint.SymptomRecord;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.model.healthguide.MedicalSpeciality;
import lib.exceptions.CommunicationException;
public class HealthWatcherFacade implements IFacade
{
    private static HealthWatcherFacade singleton;
    private static IPersistenceMechanism pm = null;
    private static boolean pmCreated = false;
    private ComplaintRecord complaintRecord;
    private HealthUnitRecord healthUnitRecord;
    private MedicalSpecialityRecord specialityRecord;
    private DiseaseRecord diseaseRecord;
    private EmployeeRecord employeeRecord;
    private SymptomRecord symptomRecord;
    public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
               TransactionException
    {
        MedicalSpeciality s = null;
        try { //1
            getPm().beginTransaction();
            s = specialityRecord.search(numSpeciality);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return s;
    }
    public void updateComplaint(Complaint complaint) throws TransactionException,
        RepositoryException, ObjectNotFoundException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            complaintRecord.update(complaint);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
    }
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = symptomRecord.getSymptomList();
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return lista;
    }
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.searchSpecialityByHealthUnit(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }
        return lista;
    }
    public static IPersistenceMechanism getPm()
    {
        if(!pmCreated) { //1
            pm = pmInit();
            if(pm != null) { //1
                pmCreated = true;
            }
        }
        return pm;
    }
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = this.diseaseRecord.getDiseaseTypeList();
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return lista;
    }
    public Employee searchEmployee(String login) throws ObjectNotFoundException,
        TransactionException
    {
        Employee employee = null;
        try { //1
            getPm().beginTransaction();
            employee = employeeRecord.search(login);
            getPm().commitTransaction();
            return employee;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return employee;
    }
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            healthUnitRecord.insert(us);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }
    }
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            symptomRecord.update(symptom);
            getPm().commitTransaction();
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
    }
    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException
    {
        int retorno = 0;
        try { //1
            getPm().beginTransaction();
            retorno = complaintRecord.insert(complaint);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }
        return retorno;
    }
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        try { //1
            getPm().beginTransaction();
            healthUnitRecord.update(unit);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
    }
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.getHealthUnitList();
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return lista;
    }
    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException
    {
        try { //1
            getPm().beginTransaction();
            employeeRecord.insert(employee);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
    }
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        DiseaseType tp = null;
        try { //1
            getPm().beginTransaction();
            tp = this.diseaseRecord.search(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return tp;
    }
    static IPersistenceMechanism pmInit()
    {
        IPersistenceMechanism returnValue = null;
        if(Constants.isPersistent()) { //1
            try { //1
                returnValue = PersistenceMechanism.getInstance();
                returnValue.connect();
            } catch (PersistenceMechanismException e) { //1
                e.printStackTrace();
            } catch (Exception e) { //1
                try { //1
                    if(getPm() != null) { //1
                        getPm().disconnect();
                    }
                } catch (PersistenceMechanismException mpe) { //1
                    mpe.printStackTrace();
                } catch (RepositoryException re) { //1
                    re.printStackTrace();
                }
            }
        }
        return returnValue;
    }
    public synchronized static HealthWatcherFacade getInstance()
    throws RepositoryException, IOException, java.rmi.RemoteException
    {
        if(singleton == null) { //1
            getPm();
            singleton = new HealthWatcherFacade();
        }
        return singleton;
    }
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException
    {
        IteratorDsk list = null;
        try { //1
            getPm().beginTransaction();
            list = complaintRecord.getComplaintList();
            getPm().commitTransaction();
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return list;
    }
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        Symptom s = null;
        try { //1
            getPm().beginTransaction();
            s = symptomRecord.search(numSymptom);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return s;
    }
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            diseaseRecord.insert(diseaseType);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }
    }
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.searchHealthUnitsBySpeciality(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return lista;
    }
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            symptomRecord.insert(symptom);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }
    }
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {
        HealthUnit unit = null;
        try { //1
            getPm().beginTransaction();
            unit = healthUnitRecord.search(healthUnitCode);
            getPm().commitTransaction();
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return unit;
    }
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        Complaint q = null;
        try { //1
            getPm().beginTransaction();
            q = this.complaintRecord.search(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return q;
    }
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = specialityRecord.getListaEspecialidade();
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return lista;
    }
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.getPartialHealthUnitList();
            getPm().commitTransaction();
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
        return lista;
    }
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            specialityRecord.insert(speciality);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }
    }
    public HealthWatcherFacade()
    {
        AbstractRepositoryFactory factory = RepositoryFactory.getRepositoryFactory();
        this.complaintRecord = new ComplaintRecord(factory.createComplaintRepository());
        this.healthUnitRecord = new HealthUnitRecord(factory.createHealthUnitRepository());
        this.specialityRecord = new MedicalSpecialityRecord(factory.createMedicalSpecialityRepository());
        this.diseaseRecord = new DiseaseRecord(factory.createDiseaseRepository());
        this.employeeRecord = new EmployeeRecord(factory.createEmployeeRepository());
        this.symptomRecord = new SymptomRecord(factory.createSymptomRepository());
    }
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            specialityRecord.update(speciality);
            getPm().commitTransaction();
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
    }
    public void notify(Subject subject) throws TransactionException, ObjectNotFoundException,
        RepositoryException, RemoteException, ObjectNotValidException
    {
    }
    public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            employeeRecord.update(employee);
            getPm().commitTransaction();
        } catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) { //1
            getPm().rollbackTransaction();
        }
    }

}
