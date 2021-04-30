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
import healthwatcher.view.IFacade;

import java.io.IOException;
import java.rmi.RemoteException;

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.patterns.observer.Subject;
import lib.persistence.IPersistenceMechanism;
import lib.persistence.PersistenceMechanism;
import lib.util.IteratorDsk;





public class HealthWatcherFacade implements IFacade
{

    private ComplaintRecord complaintRecord;

    private HealthUnitRecord healthUnitRecord;

    private MedicalSpecialityRecord specialityRecord;

    private DiseaseRecord diseaseRecord;

    private EmployeeRecord employeeRecord;

    private static IPersistenceMechanism pm = null;

    private static boolean pmCreated = false;

    private static HealthWatcherFacade singleton;

    public HealthWatcherFacade()
    {

        this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryArray());
        if (Constants.isPersistent()) {
            this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryRDB(getPm()));
        }
        this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryArray());
        if (Constants.isPersistent()) {
            this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryRDB(getPm()));
        }
        this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryArray());
        if (Constants.isPersistent()) {
            this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryRDB(getPm()));
        }
        DiseaseTypeRepositoryArray tp = new DiseaseTypeRepositoryArray();
        this.diseaseRecord = new DiseaseRecord(tp);
        if (Constants.isPersistent()) {
            this.diseaseRecord = new DiseaseRecord(new DiseaseTypeRepositoryRDB(getPm()));
        }
        EmployeeRepositoryArray er = new EmployeeRepositoryArray();
        this.employeeRecord = new EmployeeRecord(er);
        if (Constants.isPersistent()) {
            this.employeeRecord = new EmployeeRecord(new EmployeeRepositoryRDB(getPm()));
        }
    }

    public synchronized static HealthWatcherFacade getInstance()
    throws PersistenceMechanismException, IOException, java.rmi.RemoteException
    {
        if (singleton == null) {
            // Obtain valid persistence mechanism instace
            getPm();
            singleton = new HealthWatcherFacade();
        }
        return singleton;
    }

    public static IPersistenceMechanism getPm()
    {
        if (!pmCreated) {
            pm = pmInit();
            if (pm != null) {
                pmCreated = true;
            }
        }
        return pm;
    }

    static boolean isPersistent()
    {
        return Constants.isPersistent();
    }

    static IPersistenceMechanism pmInit()
    {
        IPersistenceMechanism returnValue = null;
        if (isPersistent()) {
            try {
                returnValue = PersistenceMechanism.getInstance();
                // Persistence mechanism connection
                returnValue.connect();
            } catch (PersistenceMechanismException e) {
                e.printStackTrace();
            } catch (Exception e) {
                // Persistence mechanism desconnection for resource release
                try {
                    if (getPm() != null) {
                        getPm().disconnect();
                    }
                } catch (PersistenceMechanismException mpe) {
                    mpe.printStackTrace();
                }
            }
        }
        return returnValue;
    }

    public void updateHealthUnit(HealthUnit unit) throws RepositoryException,
               ObjectNotFoundException, TransactionException
    {
        try {
            getPm().beginTransaction();
            healthUnitRecord.update(unit);
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
    }

    public void updateComplaint(Complaint complaint) throws TransactionException,
        RepositoryException, ObjectNotFoundException, ObjectNotValidException
    {
        try {
            getPm().beginTransaction();
            complaintRecord.update(complaint);
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
    }

    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {
        IteratorDsk lista = null;
        try {
            getPm().beginTransaction();
            lista = healthUnitRecord.searchSpecialityByHealthUnit(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        }
        return lista;
    }

    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        Complaint q = null;
        try {
            getPm().beginTransaction();
            q = this.complaintRecord.search(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return q;
    }

    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        DiseaseType tp = null;
        try {
            getPm().beginTransaction();
            tp = this.diseaseRecord.search(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return tp;
    }

    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {
        IteratorDsk lista = null;
        try {
            getPm().beginTransaction();
            lista = healthUnitRecord.searchHealthUnitsBySpeciality(code);
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return lista;
    }

    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try {
            getPm().beginTransaction();
            lista = specialityRecord.getListaEspecialidade();
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return lista;
    }

    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try {
            getPm().beginTransaction();
            lista = this.diseaseRecord.getDiseaseTypeList();
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return lista;
    }

    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException
    {
        return healthUnitRecord.search(healthUnitCode);
    }

    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try {
            getPm().beginTransaction();
            lista = healthUnitRecord.getHealthUnitList();
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return lista;
    }

    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        IteratorDsk lista = null;
        try {
            getPm().beginTransaction();
            lista = healthUnitRecord.getPartialHealthUnitList();
            getPm().commitTransaction();
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return lista;
    }

    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException
    {
        try {
            getPm().beginTransaction();
            employeeRecord.insert(employee);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
    }

    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException
    {
        int retorno = 0;
        try {
            getPm().beginTransaction();
            retorno = complaintRecord.insert(complaint);
            getPm().commitTransaction();
        } catch (ObjectAlreadyInsertedException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (RepositoryException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        }
        return retorno;
    }

    public Employee searchEmployee(String login) throws ObjectNotFoundException,
        TransactionException
    {
        Employee employee = null;
        try {
            getPm().beginTransaction();
            employee = employeeRecord.search(login);
            getPm().commitTransaction();
            return employee;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return employee;
    }

    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException
    {
        IteratorDsk list = null;
        try {
            getPm().beginTransaction();
            list = complaintRecord.getComplaintList();
            getPm().commitTransaction();
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
        return list;
    }

    public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    {
        try {
            getPm().beginTransaction();
            employeeRecord.update(employee);
            getPm().commitTransaction();
        } catch (TransactionException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotValidException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (ObjectNotFoundException e) {
            getPm().rollbackTransaction();
            throw e;
        } catch (Exception e) {
            getPm().rollbackTransaction();
        }
    }

    public void notify(Subject subject) throws TransactionException, ObjectNotFoundException,
        RepositoryException, RemoteException, ObjectNotValidException
    {
        // Does nothing, because the client side part will perform the updates
    }
}