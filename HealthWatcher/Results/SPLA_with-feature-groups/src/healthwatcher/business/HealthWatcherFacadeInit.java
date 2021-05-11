
//#if -710023711
// Compilation Unit of /HealthWatcherFacadeInit.java

package healthwatcher.business;

//#if -1826330834
import healthwatcher.Constants;
//#endif


//#if -651947826
import healthwatcher.business.complaint.ComplaintRecord;
//#endif


//#if -1813320035
import healthwatcher.business.complaint.DiseaseRecord;
//#endif


//#if -327359992
import healthwatcher.business.employee.EmployeeRecord;
//#endif


//#if -703594224
import healthwatcher.business.healthguide.HealthUnitRecord;
//#endif


//#if 1670922366
import healthwatcher.business.healthguide.MedicalSpecialityRecord;
//#endif


//#if -56492612
import healthwatcher.data.mem.ComplaintRepositoryArray;
//#endif


//#if 60667047
import healthwatcher.data.mem.DiseaseTypeRepositoryArray;
//#endif


//#if 1517078805
import healthwatcher.data.mem.EmployeeRepositoryArray;
//#endif


//#if 454088103
import healthwatcher.data.mem.HealthUnitRepositoryArray;
//#endif


//#if -492750084
import healthwatcher.data.mem.SpecialityRepositoryArray;
//#endif


//#if 1691588256
import healthwatcher.data.rdb.ComplaintRepositoryRDB;
//#endif


//#if -886042229
import healthwatcher.data.rdb.DiseaseTypeRepositoryRDB;
//#endif


//#if 128967075
import healthwatcher.data.rdb.EmployeeRepositoryRDB;
//#endif


//#if -1239270027
import healthwatcher.data.rdb.HealthUnitRepositoryRDB;
//#endif


//#if 1472590858
import healthwatcher.data.rdb.SpecialityRepositoryRDB;
//#endif


//#if 1535746586
import healthwatcher.model.complaint.Complaint;
//#endif


//#if -1106548017
import healthwatcher.model.complaint.DiseaseType;
//#endif


//#if -1094243948
import healthwatcher.model.employee.Employee;
//#endif


//#if 2009402886
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if 2128149616
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1287942439
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 122067233
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -193118429
import lib.exceptions.RepositoryException;
//#endif


//#if -1754704259
import lib.exceptions.TransactionException;
//#endif


//#if 774631396
import lib.persistence.IPersistenceMechanism;
//#endif


//#if -1835533899
import lib.persistence.PersistenceMechanism;
//#endif


//#if 366121980
import lib.util.IteratorDsk;
//#endif

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
        }

//#if -765513797
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1595233271
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1871223999
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 2143358353
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if 508832093
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -745216345
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1598289249
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1198606771
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return lista;
    }

    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException
    {
        try { //1
            getPm().beginTransaction();
            employeeRecord.insert(employee);
            getPm().commitTransaction();
        }

//#if -676966250
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1669412959
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 457039139
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1270773577
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        Complaint q = null;
        try { //1
            getPm().beginTransaction();
            q = this.complaintRecord.search(code);
            getPm().commitTransaction();
        }

//#if 907558304
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1269605692
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 311308324
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1754416566
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if -1786620876
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1110185648
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -350036808
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1319647926
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if 319649953
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1980071907
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1401159003
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 837033463
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if -821109042
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 506706215
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1743349719
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1843375781
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


        return retorno;
    }

    public void updateComplaint(Complaint complaint) throws TransactionException,
        RepositoryException, ObjectNotFoundException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            complaintRecord.update(complaint);
            getPm().commitTransaction();
        }

//#if -819312662
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1671300462
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1031969210
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -139148160
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException
    {
        IteratorDsk list = null;
        try { //1
            getPm().beginTransaction();
            list = complaintRecord.getComplaintList();
            getPm().commitTransaction();
        }

//#if 1632387402
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1733643102
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1910460068
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if 1666004874
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 767401498
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1199580430
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1915796512
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if -1187083552
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1778993788
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -750002844
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


        return lista;
    }

    public void update(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            employeeRecord.update(employee);
            getPm().commitTransaction();
        }

//#if -1065333207
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -765468263
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -175749473
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1633386353
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if 1655925290
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -313784402
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 454934394
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 328709824
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if -878111550
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -790796318
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 934979142
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -468893864
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


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
        }

//#if 1589235471
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1153084423
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1387687349
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return employee;
    }

}


//#endif

