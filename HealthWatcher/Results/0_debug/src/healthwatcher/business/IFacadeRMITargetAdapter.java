
//#if -474536105
// Compilation Unit of /IFacadeRMITargetAdapter.java


//#if 1829838537
package healthwatcher.business;
//#endif


//#if 1304678189
import healthwatcher.model.complaint.Complaint;
//#endif


//#if 175021858
import healthwatcher.model.complaint.DiseaseType;
//#endif


//#if -1916829849
import healthwatcher.model.employee.Employee;
//#endif


//#if -1211603949
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if 822584304
import java.rmi.Remote;
//#endif


//#if 1358942856
import lib.exceptions.CommunicationException;
//#endif


//#if 614292907
import lib.exceptions.InsertEntryException;
//#endif


//#if -1022111933
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1557583284
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 391708078
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 2137649712
import lib.exceptions.RepositoryException;
//#endif


//#if 1779631376
import lib.exceptions.TransactionException;
//#endif


//#if -711916133
import lib.exceptions.UpdateEntryException;
//#endif


//#if -390991415
import lib.util.IteratorDsk;
//#endif


//#if -1937786705
import healthwatcher.model.complaint.Symptom;
//#endif


//#if -1623193251
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if -1488794907
public interface IFacadeRMITargetAdapter extends
//#if 170109220
    Remote
//#endif

{

//#if -49326259
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
               ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
               CommunicationException, java.rmi.RemoteException, RepositoryException;
//#endif


//#if 1089477194
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if 515427975
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if -745669316
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, java.rmi.RemoteException,
               CommunicationException, RepositoryException;
//#endif


//#if -38895775
    public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException, java.rmi.RemoteException;
//#endif


//#if -1831490617
    public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
               CommunicationException, java.rmi.RemoteException;
//#endif


//#if 1645680003
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, java.rmi.RemoteException, CommunicationException;
//#endif


//#if -1918984551
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               java.rmi.RemoteException, CommunicationException, RepositoryException;
//#endif


//#if -5438439
    public int insertComplaint(Complaint complaint) throws RepositoryException,
               ObjectAlreadyInsertedException, CommunicationException, TransactionException,
               ObjectNotValidException, java.rmi.RemoteException;
//#endif


//#if -164303569
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
               ObjectNotValidException, TransactionException, CommunicationException,
               java.rmi.RemoteException, RepositoryException;
//#endif


//#if -138748163
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
               InsertEntryException, ObjectNotValidException, TransactionException,
               CommunicationException, java.rmi.RemoteException, RepositoryException;
//#endif


//#if 1465942688
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
               ObjectNotValidException, InsertEntryException, TransactionException,
               CommunicationException, java.rmi.RemoteException, RepositoryException;
//#endif


//#if -1582078022
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
               RepositoryException, java.rmi.RemoteException, CommunicationException, TransactionException;
//#endif


//#if 2082828137
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
               ObjectNotFoundException, CommunicationException, ObjectNotValidException,
               java.rmi.RemoteException;
//#endif


//#if 1323400343
    public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
               TransactionException, java.rmi.RemoteException;
//#endif


//#if 1661238450
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if 2035706517
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
//#endif


//#if -1741129404
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
//#endif


//#if -1352608969
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
               TransactionException, ObjectNotFoundException, CommunicationException,
               ObjectNotValidException, java.rmi.RemoteException;
//#endif


//#if -861566112
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
               RepositoryException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
//#endif


//#if 1317791703
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
               ObjectNotFoundException, java.rmi.RemoteException, CommunicationException;
//#endif


//#if -1055196998
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
               ObjectNotFoundException, CommunicationException, TransactionException,
               java.rmi.RemoteException;
//#endif


//#if 798602137
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
               RepositoryException, TransactionException, CommunicationException,
               java.rmi.RemoteException;
//#endif


//#if 838301248
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
               java.rmi.RemoteException, CommunicationException;
//#endif


//#if 1339289165
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException,
               java.rmi.RemoteException;
//#endif


//#if 909505437
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif


//#if 359679075
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               InsertEntryException, TransactionException, java.rmi.RemoteException, CommunicationException;
//#endif


//#if -874564262
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
               CommunicationException, TransactionException, java.rmi.RemoteException;
//#endif

}

//#endif


//#endif

