package healthwatcher.business;
import healthwatcher.Constants;
import healthwatcher.business.complaint.ComplaintRecord;
import healthwatcher.business.complaint.DiseaseRecord;
import healthwatcher.business.employee.EmployeeRecord;
import healthwatcher.business.healthguide.HealthUnitRecord;
import healthwatcher.business.healthguide.MedicalSpecialityRecord;
import healthwatcher.data.mem.ComplaintRepositoryArray;
import healthwatcher.data.mem.DiseaseTypeRepositoryArray;
import healthwatcher.data.mem.EmployeeRepositoryArray;
import healthwatcher.data.mem.HealthUnitRepositoryArray;
import healthwatcher.data.mem.SpecialityRepositoryArray;
import healthwatcher.data.rdb.ComplaintRepositoryRDB;
import healthwatcher.data.rdb.DiseaseTypeRepositoryRDB;
import healthwatcher.data.rdb.EmployeeRepositoryRDB;
import healthwatcher.data.rdb.HealthUnitRepositoryRDB;
import healthwatcher.data.rdb.SpecialityRepositoryRDB;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.employee.Employee;
import healthwatcher.model.healthguide.HealthUnit;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.persistence.IPersistenceMechanism;
import lib.persistence.PersistenceMechanism;
import lib.util.IteratorDsk;
public class HealthWatcherFacadeInit
{
    private ComplaintRecord complaintRecord;
    private HealthUnitRecord healthUnitRecord;
    private MedicalSpecialityRecord specialityRecord;
    private DiseaseRecord diseaseRecord;
    private EmployeeRecord employeeRecord;
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
    public void update(Employee employee) throws TransactionException, RepositoryException,
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
    public HealthWatcherFacadeInit()
    {
        this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryArray());
        if(Constants.isPersistent()) { //1
            this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
        }
        this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryArray());
        if(Constants.isPersistent()) { //2
            this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
        }
        this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryArray());
        if(Constants.isPersistent()) { //3
            this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
        }
        DiseaseTypeRepositoryArray tp = new DiseaseTypeRepositoryArray();
        this.diseaseRecord = new DiseaseRecord(tp);
        if(Constants.isPersistent()) { //4
            this.diseaseRecord = new DiseaseRecord(new DiseaseTypeRepositoryRDB(
                    (PersistenceMechanism) HealthWatcherFacade.getPm()));
        }
        EmployeeRepositoryArray er = new EmployeeRepositoryArray();
        this.employeeRecord = new EmployeeRecord(er);
        if(Constants.isPersistent()) { //5
            this.employeeRecord = new EmployeeRecord(new EmployeeRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
        }
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
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException
    {
        return healthUnitRecord.search(healthUnitCode);
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
    public IPersistenceMechanism getPm()
    {
        return HealthWatcherFacade.getPm();
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

}
