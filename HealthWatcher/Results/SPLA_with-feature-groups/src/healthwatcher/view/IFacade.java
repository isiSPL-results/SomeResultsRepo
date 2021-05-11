// Compilation Unit of /IFacade.java

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

//#if 1251474592
import lib.patterns.observer.Observer;
//#endif


//#if -2051762025
import healthwatcher.model.complaint.Symptom;
//#endif


//#if -1277407931
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif

public interface IFacade extends
//#if -1757712670
    java.rmi.Remote
//#endif

    ,
//#if 1245975078
    Observer
//#endif

{

//#if 1184738768
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, CommunicationException;
//#endif


//#if 674048161
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException;
//#endif


//#if 915927267
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
//#endif


//#if 1508474352
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, java.rmi.RemoteException;
//#endif


//#if 56150836
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, java.rmi.RemoteException;
//#endif


//#if 83711059
    public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException, java.rmi.RemoteException;
//#endif


//#if 1774568081
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
//#endif


//#if 111340708
    public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
               TransactionException;
//#endif


//#if 273247478
    public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException;
//#endif


//#if -1631538025
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException;
//#endif


//#if 1883722462
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
//#endif


//#if 2011807003
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException,
               java.rmi.RemoteException;
//#endif


//#if -858545159
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if 507930924
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               CommunicationException, RepositoryException;
//#endif


//#if 1506707130
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
               ObjectNotValidException, TransactionException, CommunicationException, RepositoryException;
//#endif


//#if 435412876
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, CommunicationException;
//#endif


//#if 1420702951
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
               RepositoryException, TransactionException, CommunicationException,
               java.rmi.RemoteException;
//#endif


//#if -1606285229
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               CommunicationException;
//#endif


//#if -347312815
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException;
//#endif


//#if 1785328430
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException;
//#endif


//#if 1243689938
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
//#endif


//#if -1451817641
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException;
//#endif


//#if 1009331682
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
               RepositoryException, TransactionException, CommunicationException;
//#endif


//#if 2018262672
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
//#endif


//#if -657306010
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException;
//#endif


//#if 739754241
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
//#endif


//#if 2119991048
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
//#endif


//#if -1122905497
    public int insertComplaint(Complaint complaint) throws RepositoryException,
               ObjectAlreadyInsertedException, CommunicationException, TransactionException,
               ObjectNotValidException, java.rmi.RemoteException;
//#endif


//#if 287265316
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if -972198359
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, CommunicationException, RepositoryException;
//#endif


//#if -1326751646
    public int insertComplaint(Complaint complaint) throws RepositoryException,
               ObjectAlreadyInsertedException, CommunicationException, TransactionException,
               ObjectNotValidException;
//#endif


//#if -1512915620
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
               ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
               CommunicationException, RepositoryException;
//#endif


//#if 1445983000
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if -1869868376
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if -949404592
    public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException;
//#endif


//#if 1521301010
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
               ObjectNotFoundException, CommunicationException, ObjectNotValidException;
//#endif


//#if 701526456
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
               ObjectNotFoundException, CommunicationException;
//#endif


//#if -1482245427
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
               ObjectNotValidException, InsertEntryException, TransactionException,
               CommunicationException, RepositoryException;
//#endif


//#if -1134074784
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
               TransactionException, ObjectNotFoundException, CommunicationException,
               ObjectNotValidException;
//#endif


//#if -1621385671
    public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException, java.rmi.RemoteException;
//#endif


//#if -506040827
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException;
//#endif


//#if -1576165972
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
               InsertEntryException, ObjectNotValidException, TransactionException,
               CommunicationException, RepositoryException;
//#endif


//#if -454413028
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
               ObjectNotFoundException, java.rmi.RemoteException;
//#endif


//#if -2058317577
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               java.rmi.RemoteException;
//#endif

}


