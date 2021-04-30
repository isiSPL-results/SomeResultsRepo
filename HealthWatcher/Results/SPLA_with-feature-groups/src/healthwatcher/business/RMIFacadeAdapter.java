
//#if 1215500240 
// Compilation Unit of /RMIFacadeAdapter.java 
 
package healthwatcher.business;

//#if 390090281 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 1724337950 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if 151489891 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -427445353 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if 478174608 
import healthwatcher.view.IFacade;
//#endif 


//#if -1593658735 
import java.io.IOException;
//#endif 


//#if 2075200649 
import java.rmi.server.UnicastRemoteObject;
//#endif 


//#if -867704700 
import lib.exceptions.CommunicationException;
//#endif 


//#if 491305639 
import lib.exceptions.InsertEntryException;
//#endif 


//#if -480501441 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1250985784 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 85110578 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 921291876 
import lib.exceptions.PersistenceMechanismException;
//#endif 


//#if 1302398388 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1656644108 
import lib.exceptions.TransactionException;
//#endif 


//#if -834903401 
import lib.exceptions.UpdateEntryException;
//#endif 


//#if -22037427 
import lib.util.IteratorDsk;
//#endif 


//#if 130533035 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if -556335783 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 

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


//#if -1364689771 
public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
        TransactionException
    { 
return fCid.searchSpecialitiesByCode(numSpeciality);
} 

//#endif 


//#if -171424066 
public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    { 
fCid.insert(speciality);
} 

//#endif 

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


//#if -1492207895 
public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    { 
fCid.insert(us);
} 

//#endif 


//#if 330983044 
public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException
    { 
return fCid.getComplaintList();
} 

//#endif 


//#if 527682235 
private RMIFacadeAdapter() throws PersistenceMechanismException, IOException
    { 
this.fCid = new HealthWatcherFacade();
try //1
{ 
System.out.println("Creating RMI server...");
System.out.println("Object exported");
System.out.println(healthwatcher.Constants.SYSTEM_NAME);
java.rmi.Naming.rebind("//" + healthwatcher.Constants.SERVER_NAME + "/"
                                   + healthwatcher.Constants.SYSTEM_NAME, this);
System.out.println("Server created and ready.");
} 

//#if 1748913038 
catch (java.rmi.RemoteException rmiEx) //1
{ 
rmiFacadeExceptionHandling(rmiEx);
} 

//#endif 


//#if 1925134093 
catch (java.net.MalformedURLException rmiEx) //1
{ 
rmiFacadeExceptionHandling(rmiEx);
} 

//#endif 


} 

//#endif 

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


//#if 64960827 
public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException
    { 
return fCid.searchHealthUnit(healthUnitCode);
} 

//#endif 


//#if 279307535 
public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    { 
fCid.updateMedicalSpeciality(speciality);
} 

//#endif 


//#if -208005048 
public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    { 
return fCid.searchSymptom(numSymptom);
} 

//#endif 

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


//#if -482285873 
public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    { 
return fCid.getSymptomList();
} 

//#endif 


//#if -1701593397 
public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    { 
fCid.insert(diseaseType);
} 

//#endif 


//#if -332094339 
public synchronized static RMIFacadeAdapter getInstance()
    throws PersistenceMechanismException, IOException, java.rmi.RemoteException
    { 
if(singleton == null)//1
{ 
singleton = new RMIFacadeAdapter();
} 

return singleton;
} 

//#endif 

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


//#if -1188379427 
public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException, RepositoryException
    { 
return fCid.getComplaintList();
} 

//#endif 


//#if 976961281 
public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    { 
fCid.insert(employee);
} 

//#endif 

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


//#if -946238378 
public static void main(String[] args)
    { 
try //1
{ 
new RMIFacadeAdapter();
} 

//#if 359485473 
catch (Exception e) //1
{ 
e.printStackTrace();
} 

//#endif 


} 

//#endif 


//#if 1846021699 
public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    { 
fCid.updateSymptom(symptom);
} 

//#endif 


//#if 1703757570 
public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    { 
return fCid.searchHealthUnit(healthUnitCode);
} 

//#endif 


//#if -1610449381 
public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    { 
fCid.insert(symptom);
} 

//#endif 

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


//#if 583686824 
public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException, CommunicationException
    { 
fCid.insert(employee);
} 

//#endif 


//#if 337683499 
private RMIFacadeAdapter() throws RepositoryException, IOException
    { 
this.fCid = new HealthWatcherFacade();
try //1
{ 
System.out.println("Creating RMI server...");
System.out.println("Object exported");
System.out.println(healthwatcher.Constants.SYSTEM_NAME);
java.rmi.Naming.rebind("//" + healthwatcher.Constants.SERVER_NAME + "/"
                                   + healthwatcher.Constants.SYSTEM_NAME, this);
System.out.println("Server created and ready.");
} 
catch (java.rmi.RemoteException rmiEx) //1
{ 
rmiFacadeExceptionHandling(rmiEx);
} 

catch (java.net.MalformedURLException rmiEx) //1
{ 
rmiFacadeExceptionHandling(rmiEx);
} 


} 

//#endif 

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


//#if -576974899 
public synchronized static RMIFacadeAdapter getInstance()
    throws RepositoryException, IOException, java.rmi.RemoteException
    { 
if(singleton == null)//1
{ 
singleton = new RMIFacadeAdapter();
} 

return singleton;
} 

//#endif 

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


//#endif 

