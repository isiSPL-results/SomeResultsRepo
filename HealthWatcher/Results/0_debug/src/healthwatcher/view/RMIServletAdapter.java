
//#if 1931561646 
// Compilation Unit of /RMIServletAdapter.java 
 

//#if -887400784 
package healthwatcher.view;
//#endif 


//#if -945309835 
import healthwatcher.business.IFacadeRMITargetAdapter;
//#endif 


//#if 2110423129 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 1401795918 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if -539456621 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -1836313753 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if -1874450515 
import java.io.Serializable;
//#endif 


//#if -752813798 
import java.rmi.Naming;
//#endif 


//#if 1410558507 
import java.rmi.RemoteException;
//#endif 


//#if -1558651212 
import lib.exceptions.CommunicationException;
//#endif 


//#if 530810071 
import lib.exceptions.InsertEntryException;
//#endif 


//#if -1658589329 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1306480392 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 140605186 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 749483396 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1696148540 
import lib.exceptions.TransactionException;
//#endif 


//#if -795398969 
import lib.exceptions.UpdateEntryException;
//#endif 


//#if 1412698360 
import lib.patterns.observer.Subject;
//#endif 


//#if -213919715 
import lib.util.IteratorDsk;
//#endif 


//#if -560413477 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if -1230228599 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if -1312391145 
public class RMIServletAdapter implements 
//#if -316048148 
IFacade
//#endif 

, 
//#if -870124522 
Serializable
//#endif 

  { 

//#if 1461952653 
protected IFacadeRMITargetAdapter facade = null;
//#endif 


//#if -448071021 
protected void rmiInitExceptionHandling(Throwable exception)
    { 

//#if 160853922 
String error =  "<p>****************************************************<br>" +
                        "Error during servlet initialization!<br>" +
                        "The exception message is:<br><dd>" + exception.getMessage() +
                        "<p>You may have to restart the servlet container.<br>" +
                        "*******************************************************";
//#endif 


//#if -1455525760 
System.out.println(error);
//#endif 

} 

//#endif 


//#if 1771888309 
public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException
    { 

//#if -1866587075 
try //1
{ 

//#if 1543013979 
facade.updateComplaint(q);
//#endif 

} 

//#if -1566315585 
catch (RemoteException e) //1
{ 

//#if -692167102 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -93320248 
public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    { 

//#if -1236920399 
try //1
{ 

//#if -1477558410 
return facade.searchComplaint(code);
//#endif 

} 

//#if 1671019710 
catch (RemoteException e) //1
{ 

//#if -699088027 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1099539055 
public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException
    { 

//#if -774207040 
try //1
{ 

//#if 1875332551 
facade.updateHealthUnit(unit);
//#endif 

} 

//#if 115277163 
catch (RemoteException e) //1
{ 

//#if 300764858 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 683215529 
public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, CommunicationException
    { 

//#if -185573232 
try //1
{ 

//#if 1101210292 
return facade.searchHealthUnitsBySpeciality(code);
//#endif 

} 

//#if 1433300242 
catch (RemoteException e) //1
{ 

//#if 1375336489 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1774737534 
public void notify(Subject subject) throws TransactionException, ObjectNotFoundException,
        RepositoryException, RemoteException, ObjectNotValidException
    { 

//#if -1290328259 
try //1
{ 

//#if 975450753 
if(subject instanceof Complaint)//1
{ 

//#if -981017972 
Complaint complaint = (Complaint) subject;
//#endif 


//#if 968657315 
updateComplaint(complaint);
//#endif 

} 
else

//#if 883795552 
if(subject instanceof Employee)//1
{ 

//#if 606623970 
Employee employee = (Employee) subject;
//#endif 


//#if 993399728 
updateEmployee(employee);
//#endif 

} 
else

//#if -996888953 
if(subject instanceof HealthUnit)//1
{ 

//#if 1751289382 
HealthUnit healthUnit = (HealthUnit) subject;
//#endif 


//#if -709801494 
updateHealthUnit(healthUnit);
//#endif 

} 
else

//#if 1048684761 
if(subject instanceof MedicalSpeciality)//1
{ 

//#if 180939074 
updateMedicalSpeciality((MedicalSpeciality) subject);
//#endif 

} 
else

//#if -840740959 
if(subject instanceof Symptom)//1
{ 

//#if -1011847510 
updateSymptom((Symptom) subject);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#if -417988979 
catch (Exception e) //1
{ 

//#if 389392332 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1505773745 
public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
        CommunicationException
    { 

//#if -1825393890 
try //1
{ 

//#if -492439483 
return facade.searchEmployee(login);
//#endif 

} 

//#if 1068406858 
catch (RemoteException e) //1
{ 

//#if -1223738086 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2060701463 
public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
        InsertEntryException, TransactionException, CommunicationException
    { 

//#if 1573537897 
try //1
{ 

//#if -2056930612 
facade.insert(e);
//#endif 

} 

//#if 2115783258 
catch (RemoteException ex) //1
{ 

//#if -546790396 
throw new CommunicationException(ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -357220919 
public void connect(String server) throws CommunicationException
    { 

//#if 1603531753 
try //1
{ 

//#if 1040783871 
System.out.println("About to lookup...");
//#endif 


//#if -2121047785 
facade= (IFacadeRMITargetAdapter) Naming.lookup(server);
//#endif 


//#if 1887188536 
System.out.println("Remote DisqueSaude found");
//#endif 

} 

//#if 702281205 
catch (java.rmi.RemoteException rmiEx) //1
{ 

//#if -1120599900 
rmiInitExceptionHandling(rmiEx);
//#endif 


//#if -961033053 
throw new CommunicationException(rmiEx.getMessage());
//#endif 

} 

//#endif 


//#if -84232294 
catch (java.rmi.NotBoundException rmiEx) //1
{ 

//#if 277360920 
rmiInitExceptionHandling(rmiEx);
//#endif 


//#if 1644937135 
throw new CommunicationException(rmiEx.getMessage());
//#endif 

} 

//#endif 


//#if -157861836 
catch (java.net.MalformedURLException rmiEx) //1
{ 

//#if -1690651652 
rmiInitExceptionHandling(rmiEx);
//#endif 


//#if 555280971 
throw new CommunicationException(rmiEx.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1313144549 
public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    { 

//#if 1653548101 
try //1
{ 

//#if 663986497 
return facade.getSymptomList();
//#endif 

} 

//#if 86589165 
catch (RemoteException e) //1
{ 

//#if 1749060785 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1812072677 
public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException
    { 

//#if 1317332690 
try //1
{ 

//#if 1336337288 
return facade.searchHealthUnit(healthUnitCode);
//#endif 

} 

//#if -1228850796 
catch (RemoteException e) //1
{ 

//#if -1630257831 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 332840107 
public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
        TransactionException
    { 

//#if 152501217 
try //1
{ 

//#if 123297913 
return facade.searchSpecialitiesByCode(numSpeciality);
//#endif 

} 

//#if 1588033537 
catch (RemoteException e) //1
{ 

//#if -1081822553 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1122482782 
public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    { 

//#if 464477472 
try //1
{ 

//#if 1313936482 
return facade.searchSymptom(numSymptom);
//#endif 

} 

//#if -1289038722 
catch (RemoteException e) //1
{ 

//#if 761155904 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -612111157 
public RMIServletAdapter(String server) throws CommunicationException
    { 

//#if 1484156907 
connect(server);
//#endif 

} 

//#endif 


//#if -35908695 
public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, CommunicationException, TransactionException,
        ObjectNotValidException
    { 

//#if 13588152 
try //1
{ 

//#if -399289001 
return facade.insertComplaint(complaint);
//#endif 

} 

//#if 1608599596 
catch (RemoteException e) //1
{ 

//#if 256473878 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -494883116 
public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    { 

//#if 1111401489 
try //1
{ 

//#if 886496697 
facade.insert(speciality);
//#endif 

} 

//#if -343035721 
catch (RemoteException ex) //1
{ 

//#if -280598136 
throw new CommunicationException(ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1381871289 
public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    { 

//#if 45085300 
try //1
{ 

//#if 723043344 
facade.updateMedicalSpeciality(speciality);
//#endif 

} 

//#if -1813951240 
catch (RemoteException e) //1
{ 

//#if -1456134310 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -40588731 
public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    { 

//#if -1470904973 
try //1
{ 

//#if 2060633210 
facade.insert(symptom);
//#endif 

} 

//#if 2027940438 
catch (RemoteException ex) //1
{ 

//#if -1602065013 
throw new CommunicationException(ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1143763120 
public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    { 

//#if 1639203840 
try //1
{ 

//#if 1580371217 
return facade.searchSpecialitiesByHealthUnit(code);
//#endif 

} 

//#if 965161019 
catch (RemoteException e) //1
{ 

//#if 93373805 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1938370419 
public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException, RepositoryException
    { 

//#if 1678660718 
try //1
{ 

//#if -269790517 
return facade.getComplaintList();
//#endif 

} 

//#if 455327301 
catch (RemoteException e) //1
{ 

//#if 703270482 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1490246617 
public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    { 

//#if 443589212 
try //1
{ 

//#if -1646799219 
facade.updateSymptom(symptom);
//#endif 

} 

//#if 1644165729 
catch (RemoteException e) //1
{ 

//#if 331849346 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -111860240 
public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
        InsertEntryException, TransactionException, CommunicationException, RepositoryException
    { 

//#if -934649779 
try //1
{ 

//#if 1902237925 
facade.insert(e);
//#endif 

} 

//#if 1617283436 
catch (RemoteException ex) //1
{ 

//#if 326186667 
throw new CommunicationException(ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -882753239 
public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    { 

//#if -2134199045 
try //1
{ 

//#if -1349489360 
return facade.getSpecialityList();
//#endif 

} 

//#if -1225446562 
catch (RemoteException e) //1
{ 

//#if 1485477443 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -525212269 
public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    { 

//#if -777750504 
try //1
{ 

//#if -56228717 
facade.insert(us);
//#endif 

} 

//#if 1038408198 
catch (RemoteException ex) //1
{ 

//#if 249204698 
throw new CommunicationException(ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1029686680 
public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    { 

//#if -714854873 
try //1
{ 

//#if -229625135 
return facade.searchHealthUnit(healthUnitCode);
//#endif 

} 

//#if -122865989 
catch (RemoteException e) //1
{ 

//#if -1949113321 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 675592168 
public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, CommunicationException, TransactionException
    { 

//#if 1330363100 
try //1
{ 

//#if 1194078708 
return facade.searchDiseaseType(code);
//#endif 

} 

//#if -1181161135 
catch (RemoteException e) //1
{ 

//#if -2083973694 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2037388056 
public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    { 

//#if -552744316 
try //1
{ 

//#if -459275255 
return facade.getDiseaseTypeList();
//#endif 

} 

//#if -1087383785 
catch (RemoteException e) //1
{ 

//#if 1648535583 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1551114485 
public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    { 

//#if 225367524 
try //1
{ 

//#if 2018088595 
facade.insert(diseaseType);
//#endif 

} 

//#if 2105269791 
catch (RemoteException ex) //1
{ 

//#if 1051381797 
throw new CommunicationException(ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -655762003 
public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, CommunicationException, TransactionException
    { 

//#if 1622379313 
try //1
{ 

//#if -779871724 
return facade.getPartialHealthUnitList();
//#endif 

} 

//#if -1257525994 
catch (RemoteException e) //1
{ 

//#if -536693770 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 887910558 
public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    { 

//#if -435095693 
try //1
{ 

//#if 889723055 
return facade.getHealthUnitList();
//#endif 

} 

//#if 1577733918 
catch (RemoteException e) //1
{ 

//#if -114336562 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 648771610 
public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException
    { 

//#if 1469209590 
try //1
{ 

//#if 1638510765 
return facade.getComplaintList();
//#endif 

} 

//#if 1600551464 
catch (RemoteException e) //1
{ 

//#if 344416370 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -48726679 
public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
        CommunicationException
    { 

//#if 1379587078 
try //1
{ 

//#if 1612907585 
facade.updateEmployee(e);
//#endif 

} 

//#if 1176081174 
catch (RemoteException ex) //1
{ 

//#if 1922094081 
throw new CommunicationException(ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

