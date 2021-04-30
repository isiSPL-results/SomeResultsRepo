
//#if 1198648057 
// Compilation Unit of /HealthWatcherFacade.java 
 

//#if 705501182 
package healthwatcher.business;
//#endif 


//#if -947580042 
import healthwatcher.Constants;
//#endif 


//#if -1596408222 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -335244009 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if 2084616156 
import healthwatcher.model.employee.Employee;
//#endif 


//#if 150023358 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if -1791425353 
import healthwatcher.view.IFacade;
//#endif 


//#if -1387218614 
import java.io.IOException;
//#endif 


//#if 327954272 
import lib.exceptions.InsertEntryException;
//#endif 


//#if 1545847480 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1048357855 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -117517351 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 1817941963 
import lib.exceptions.PersistenceMechanismException;
//#endif 


//#if -919628325 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1493292741 
import lib.exceptions.TransactionException;
//#endif 


//#if -998254768 
import lib.exceptions.UpdateEntryException;
//#endif 


//#if -341475796 
import lib.persistence.IPersistenceMechanism;
//#endif 


//#if 68125293 
import lib.persistence.PersistenceMechanism;
//#endif 


//#if 2082639028 
import lib.util.IteratorDsk;
//#endif 


//#if -1932788926 
import java.rmi.RemoteException;
//#endif 


//#if 1684903489 
import lib.patterns.observer.Subject;
//#endif 


//#if -641972858 
import healthwatcher.business.complaint.ComplaintRecord;
//#endif 


//#if 1610150229 
import healthwatcher.business.complaint.DiseaseRecord;
//#endif 


//#if -1198857024 
import healthwatcher.business.employee.EmployeeRecord;
//#endif 


//#if 107934040 
import healthwatcher.business.healthguide.HealthUnitRecord;
//#endif 


//#if -18878666 
import healthwatcher.business.healthguide.MedicalSpecialityRecord;
//#endif 


//#if -1303096828 
import healthwatcher.data.mem.ComplaintRepositoryArray;
//#endif 


//#if 369891055 
import healthwatcher.data.mem.DiseaseTypeRepositoryArray;
//#endif 


//#if 645581773 
import healthwatcher.data.mem.EmployeeRepositoryArray;
//#endif 


//#if 464063071 
import healthwatcher.data.mem.HealthUnitRepositoryArray;
//#endif 


//#if -482775116 
import healthwatcher.data.mem.SpecialityRepositoryArray;
//#endif 


//#if 1109286120 
import healthwatcher.data.rdb.ComplaintRepositoryRDB;
//#endif 


//#if -2132646445 
import healthwatcher.data.rdb.DiseaseTypeRepositoryRDB;
//#endif 


//#if -28364197 
import healthwatcher.data.rdb.EmployeeRepositoryRDB;
//#endif 


//#if -2110767059 
import healthwatcher.data.rdb.HealthUnitRepositoryRDB;
//#endif 


//#if 601093826 
import healthwatcher.data.rdb.SpecialityRepositoryRDB;
//#endif 


//#if 1571287101 
import healthwatcher.data.factories.AbstractRepositoryFactory;
//#endif 


//#if 462547067 
import healthwatcher.data.factories.RepositoryFactory;
//#endif 


//#if -885192696 
import healthwatcher.business.complaint.SymptomRecord;
//#endif 


//#if 2063659300 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if 2140093010 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if 1065421565 
import lib.exceptions.CommunicationException;
//#endif 


//#if -798740894 
public class HealthWatcherFacade extends 
//#if 121865132 
java.rmi.server.UnicastRemoteObject
//#endif 

 implements 
//#if -413594854 
IFacade
//#endif 

  { 

//#if 1899256098 
private static HealthWatcherFacade singleton;
//#endif 


//#if 1011691987 
private HealthWatcherFacadeInit fCid;
//#endif 


//#if 29384655 
private static IPersistenceMechanism pm = null;
//#endif 


//#if 2012547914 
private static boolean pmCreated = false;
//#endif 


//#if 974447105 
private ComplaintRecord complaintRecord;
//#endif 


//#if 1432923743 
private HealthUnitRecord healthUnitRecord;
//#endif 


//#if -893923944 
private MedicalSpecialityRecord specialityRecord;
//#endif 


//#if 1205013601 
private DiseaseRecord diseaseRecord;
//#endif 


//#if 1923657923 
private EmployeeRecord employeeRecord;
//#endif 


//#if -1279604927 
private SymptomRecord symptomRecord;
//#endif 


//#if -639894851 
public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
        TransactionException
    { 

//#if -996045839 
MedicalSpeciality s = null;
//#endif 


//#if -595670621 
try //1
{ 

//#if 1062186047 
getPm().beginTransaction();
//#endif 


//#if -1139322593 
s = specialityRecord.search(numSpeciality);
//#endif 


//#if -1185833831 
getPm().commitTransaction();
//#endif 

} 

//#if -275382369 
catch (RepositoryException e) //1
{ 

//#if -84919752 
getPm().rollbackTransaction();
//#endif 


//#if -985863138 
throw e;
//#endif 

} 

//#endif 


//#if 713939109 
catch (TransactionException e) //1
{ 

//#if 1698491798 
getPm().rollbackTransaction();
//#endif 


//#if -379377024 
throw e;
//#endif 

} 

//#endif 


//#if 1934416547 
catch (ObjectNotFoundException e) //1
{ 

//#if 978243027 
getPm().rollbackTransaction();
//#endif 


//#if -1895855389 
throw e;
//#endif 

} 

//#endif 


//#if -1126454667 
catch (Exception e) //1
{ 

//#if 494213293 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 871443205 
return s;
//#endif 

} 

//#endif 


//#if 1971430057 
public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException
    { 

//#if -796472032 
fCid.update(employee);
//#endif 

} 

//#endif 


//#if 907616868 
public void updateComplaint(Complaint complaint) throws TransactionException,
        RepositoryException, ObjectNotFoundException, ObjectNotValidException
    { 

//#if 1031399782 
try //1
{ 

//#if 1925803971 
getPm().beginTransaction();
//#endif 


//#if -1757630248 
complaintRecord.update(complaint);
//#endif 


//#if -183481963 
getPm().commitTransaction();
//#endif 

} 

//#if 594392080 
catch (RepositoryException e) //1
{ 

//#if 20849618 
getPm().rollbackTransaction();
//#endif 


//#if 2147174340 
throw e;
//#endif 

} 

//#endif 


//#if -765268332 
catch (ObjectNotFoundException e) //1
{ 

//#if 947584809 
getPm().rollbackTransaction();
//#endif 


//#if -529620403 
throw e;
//#endif 

} 

//#endif 


//#if 1907143252 
catch (TransactionException e) //1
{ 

//#if -437633852 
getPm().rollbackTransaction();
//#endif 


//#if -2095589614 
throw e;
//#endif 

} 

//#endif 


//#if -1012660186 
catch (Exception e) //1
{ 

//#if -1984325246 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -756932722 
public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    { 

//#if 1882486275 
return this.fCid.searchComplaint(code);
//#endif 

} 

//#endif 


//#if 617678046 
public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    { 

//#if 1007661684 
this.fCid.updateComplaint(q);
//#endif 

} 

//#endif 


//#if 1958151415 
public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    { 

//#if -1183627629 
IteratorDsk lista = null;
//#endif 


//#if -1338091619 
try //1
{ 

//#if 1007441048 
getPm().beginTransaction();
//#endif 


//#if -38965400 
lista = symptomRecord.getSymptomList();
//#endif 


//#if 1412038496 
getPm().commitTransaction();
//#endif 

} 

//#if -710466017 
catch (RepositoryException e) //1
{ 

//#if -1369126216 
getPm().rollbackTransaction();
//#endif 


//#if 612428702 
throw e;
//#endif 

} 

//#endif 


//#if 111247909 
catch (TransactionException e) //1
{ 

//#if 819412104 
getPm().rollbackTransaction();
//#endif 


//#if -69844018 
throw e;
//#endif 

} 

//#endif 


//#if 124174627 
catch (ObjectNotFoundException e) //1
{ 

//#if -1747406159 
getPm().rollbackTransaction();
//#endif 


//#if -1652406331 
throw e;
//#endif 

} 

//#endif 


//#if -126684939 
catch (Exception e) //1
{ 

//#if 1106197936 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 1752047087 
return lista;
//#endif 

} 

//#endif 


//#if 147264530 
public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException
    { 

//#if -476027196 
return fCid.searchHealthUnit(healthUnitCode);
//#endif 


//#if 1159405981 
return healthUnitRecord.search(healthUnitCode);
//#endif 

} 

//#endif 


//#if 2096130007 
public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    { 

//#if -644331946 
IteratorDsk lista = null;
//#endif 


//#if -9880224 
try //1
{ 

//#if 2019529028 
getPm().beginTransaction();
//#endif 


//#if -792343849 
lista = healthUnitRecord.searchSpecialityByHealthUnit(code);
//#endif 


//#if -1572972492 
getPm().commitTransaction();
//#endif 

} 

//#if 1469188037 
catch (RepositoryException e) //1
{ 

//#if -520395564 
getPm().rollbackTransaction();
//#endif 


//#if 470712578 
throw e;
//#endif 

} 

//#endif 


//#if -1038953153 
catch (TransactionException e) //1
{ 

//#if -1588214905 
getPm().rollbackTransaction();
//#endif 


//#if -968495185 
throw e;
//#endif 

} 

//#endif 


//#if -266575927 
catch (ObjectNotFoundException e) //1
{ 

//#if 1637371085 
getPm().rollbackTransaction();
//#endif 


//#if -1744380631 
throw e;
//#endif 

} 

//#endif 


//#endif 


//#if 1853384050 
return lista;
//#endif 

} 

//#endif 


//#if 623897262 
public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException
    { 

//#if 1015554342 
return fCid.searchDiseaseType(code);
//#endif 

} 

//#endif 


//#if -438291183 
public static IPersistenceMechanism getPm()
    { 

//#if 55963293 
if(!pmCreated)//1
{ 

//#if 1404985961 
pm = pmInit();
//#endif 


//#if 1289325943 
if(pm != null)//1
{ 

//#if -836878800 
pmCreated = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1159952942 
return pm;
//#endif 

} 

//#endif 


//#if 1724871563 
public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    { 

//#if -347396229 
IteratorDsk lista = null;
//#endif 


//#if 1267009669 
try //1
{ 

//#if -374359605 
getPm().beginTransaction();
//#endif 


//#if 1460947973 
lista = this.diseaseRecord.getDiseaseTypeList();
//#endif 


//#if 1525891213 
getPm().commitTransaction();
//#endif 

} 

//#if 1495221399 
catch (RepositoryException e) //1
{ 

//#if -1161055925 
getPm().rollbackTransaction();
//#endif 


//#if -1066455445 
throw e;
//#endif 

} 

//#endif 


//#if -231918931 
catch (TransactionException e) //1
{ 

//#if -1768314779 
getPm().rollbackTransaction();
//#endif 


//#if -431051631 
throw e;
//#endif 

} 

//#endif 


//#if -1136991333 
catch (ObjectNotFoundException e) //1
{ 

//#if 1802607870 
getPm().rollbackTransaction();
//#endif 


//#if -1961512936 
throw e;
//#endif 

} 

//#endif 


//#if -1773124243 
catch (Exception e) //1
{ 

//#if -353913908 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 815169751 
return lista;
//#endif 

} 

//#endif 


//#if 1435721290 
public synchronized static HealthWatcherFacade getInstance()
    throws PersistenceMechanismException, IOException, java.rmi.RemoteException
    { 

//#if 1916198720 
if(singleton == null)//1
{ 

//#if -531113015 
getPm();
//#endif 


//#if -1655647604 
singleton = new HealthWatcherFacade();
//#endif 

} 

//#endif 


//#if -1226912303 
return singleton;
//#endif 

} 

//#endif 


//#if -143131217 
public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        java.rmi.RemoteException
    { 

//#if 903973412 
return fCid.insertComplaint(complaint);
//#endif 

} 

//#endif 


//#if -473384372 
public Employee searchEmployee(String login) throws ObjectNotFoundException,
        TransactionException
    { 

//#if 1571722629 
return fCid.searchEmployee(login);
//#endif 


//#if 227076317 
Employee employee = null;
//#endif 


//#if 1341248416 
try //1
{ 

//#if -530364553 
getPm().beginTransaction();
//#endif 


//#if -1518332881 
employee = employeeRecord.search(login);
//#endif 


//#if 984705121 
getPm().commitTransaction();
//#endif 


//#if -2123406967 
return employee;
//#endif 

} 

//#if 2026266157 
catch (TransactionException e) //1
{ 

//#if 1668581719 
getPm().rollbackTransaction();
//#endif 


//#if 1279095775 
throw e;
//#endif 

} 

//#endif 


//#if 382208027 
catch (ObjectNotFoundException e) //1
{ 

//#if -449043436 
getPm().rollbackTransaction();
//#endif 


//#if 1264839106 
throw e;
//#endif 

} 

//#endif 


//#if 1136609773 
catch (Exception e) //1
{ 

//#if -346827420 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 1441854067 
return employee;
//#endif 

} 

//#endif 


//#if 1817333185 
public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    { 

//#if 173173143 
try //1
{ 

//#if -100009662 
getPm().beginTransaction();
//#endif 


//#if -1922291957 
healthUnitRecord.insert(us);
//#endif 


//#if 1440804854 
getPm().commitTransaction();
//#endif 

} 

//#if -1643722862 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -427409840 
getPm().rollbackTransaction();
//#endif 


//#if 1004774150 
throw e;
//#endif 

} 

//#endif 


//#if 332555491 
catch (ObjectNotValidException e) //1
{ 

//#if -1143436809 
getPm().rollbackTransaction();
//#endif 


//#if 1189455679 
throw e;
//#endif 

} 

//#endif 


//#if -931626523 
catch (RepositoryException e) //1
{ 

//#if 329373713 
getPm().rollbackTransaction();
//#endif 


//#if 620736101 
throw e;
//#endif 

} 

//#endif 


//#if 1845206815 
catch (TransactionException e) //1
{ 

//#if -328455917 
getPm().rollbackTransaction();
//#endif 


//#if -1921525853 
throw e;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2042141068 
private void rmiFacadeExceptionHandling(Throwable exception)
    { 

//#if 1938975120 
System.out.println("**************************************************");
//#endif 


//#if 915319909 
System.out.println("* Error during server initialization!            *");
//#endif 


//#if 978354199 
System.out.println("* The exception message is:                      *");
//#endif 


//#if -561074288 
System.out.println("      " + exception.getMessage());
//#endif 


//#if -727059292 
System.out.println("* You may have to restart the server or registry.*");
//#endif 


//#if 992682690 
System.out.println("**************************************************");
//#endif 


//#if 951165769 
exception.printStackTrace();
//#endif 

} 

//#endif 


//#if 416609899 
public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    { 

//#if 252021535 
try //1
{ 

//#if -1948525760 
getPm().beginTransaction();
//#endif 


//#if 1752197051 
symptomRecord.update(symptom);
//#endif 


//#if -28619336 
getPm().commitTransaction();
//#endif 

} 

//#if 842492984 
catch (TransactionException e) //1
{ 

//#if -1047405317 
getPm().rollbackTransaction();
//#endif 


//#if 551839931 
throw e;
//#endif 

} 

//#endif 


//#if -17640150 
catch (ObjectNotValidException e) //1
{ 

//#if 518674418 
getPm().rollbackTransaction();
//#endif 


//#if 2125412260 
throw e;
//#endif 

} 

//#endif 


//#if 572078640 
catch (ObjectNotFoundException e) //1
{ 

//#if -1302704659 
getPm().rollbackTransaction();
//#endif 


//#if -1159225335 
throw e;
//#endif 

} 

//#endif 


//#if 2114622658 
catch (Exception e) //1
{ 

//#if -1625162751 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1222618086 
public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException
    { 

//#if 1539102283 
int retorno = 0;
//#endif 


//#if -1774020195 
try //1
{ 

//#if 426972611 
getPm().beginTransaction();
//#endif 


//#if 819355808 
retorno = complaintRecord.insert(complaint);
//#endif 


//#if 597386133 
getPm().commitTransaction();
//#endif 

} 

//#if 585008371 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -537010433 
getPm().rollbackTransaction();
//#endif 


//#if -1949738185 
throw e;
//#endif 

} 

//#endif 


//#if 676364962 
catch (ObjectNotValidException e) //1
{ 

//#if -1199621773 
getPm().rollbackTransaction();
//#endif 


//#if 1622651715 
throw e;
//#endif 

} 

//#endif 


//#if -1678682332 
catch (RepositoryException e) //1
{ 

//#if -418946513 
getPm().rollbackTransaction();
//#endif 


//#if -536367609 
throw e;
//#endif 

} 

//#endif 


//#if 161313216 
catch (TransactionException e) //1
{ 

//#if 380376844 
getPm().rollbackTransaction();
//#endif 


//#if 1832644042 
throw e;
//#endif 

} 

//#endif 


//#endif 


//#if -383407379 
return retorno;
//#endif 

} 

//#endif 


//#if 479914332 
public void updateHealthUnit(HealthUnit unit) throws RepositoryException,
               ObjectNotFoundException, TransactionException
    { 

//#if 1034798333 
try //1
{ 

//#if 231604699 
getPm().beginTransaction();
//#endif 


//#if -775083416 
healthUnitRecord.update(unit);
//#endif 


//#if -1164051843 
getPm().commitTransaction();
//#endif 

} 

//#if 1725621458 
catch (RepositoryException e) //1
{ 

//#if 2010897262 
getPm().rollbackTransaction();
//#endif 


//#if 1523904424 
throw e;
//#endif 

} 

//#endif 


//#if 1181085270 
catch (ObjectNotFoundException e) //1
{ 

//#if 571792435 
getPm().rollbackTransaction();
//#endif 


//#if 2022844547 
throw e;
//#endif 

} 

//#endif 


//#if -1679451694 
catch (TransactionException e) //1
{ 

//#if 455618622 
getPm().rollbackTransaction();
//#endif 


//#if 569623768 
throw e;
//#endif 

} 

//#endif 


//#if -1104092312 
catch (Exception e) //1
{ 

//#if 289577328 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1661881884 
private HealthWatcherFacade() throws PersistenceMechanismException, IOException
    { 

//#if -1627081182 
this.fCid = new HealthWatcherFacadeInit();
//#endif 


//#if -1472507249 
try //1
{ 

//#if -1625583660 
System.out.println("Creating RMI server...");
//#endif 


//#if -1608872168 
System.out.println("Object exported");
//#endif 


//#if -2022701976 
System.out.println(healthwatcher.Constants.SYSTEM_NAME);
//#endif 


//#if 1908328258 
java.rmi.Naming.rebind("//" + healthwatcher.Constants.SERVER_NAME + "/"
                                   + healthwatcher.Constants.SYSTEM_NAME, this);
//#endif 


//#if 398320109 
System.out.println("Server created and ready.");
//#endif 

} 

//#if 500510937 
catch (java.rmi.RemoteException rmiEx) //1
{ 

//#if -395677407 
rmiFacadeExceptionHandling(rmiEx);
//#endif 

} 

//#endif 


//#if -1840662504 
catch (java.net.MalformedURLException rmiEx) //1
{ 

//#if -88414788 
rmiFacadeExceptionHandling(rmiEx);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -632969070 
public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException
    { 

//#if 441587840 
lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif 


//#if 695422601 
lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid
                                          .searchSpecialitiesByHealthUnit(code);
//#endif 


//#if -1789219085 
lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif 


//#if 1436773306 
sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif 


//#if -1745590813 
return sa;
//#endif 

} 

//#endif 


//#if 1025013929 
public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    { 

//#if 2098848683 
IteratorDsk lista = null;
//#endif 


//#if 590488757 
try //1
{ 

//#if -610648713 
getPm().beginTransaction();
//#endif 


//#if 1269542677 
lista = healthUnitRecord.getHealthUnitList();
//#endif 


//#if -1504103839 
getPm().commitTransaction();
//#endif 

} 

//#if 943793158 
catch (RepositoryException e) //1
{ 

//#if 376745461 
getPm().rollbackTransaction();
//#endif 


//#if -1780045567 
throw e;
//#endif 

} 

//#endif 


//#if -146325218 
catch (TransactionException e) //1
{ 

//#if 97923133 
getPm().rollbackTransaction();
//#endif 


//#if -2115496007 
throw e;
//#endif 

} 

//#endif 


//#if 1869706122 
catch (ObjectNotFoundException e) //1
{ 

//#if 2053155941 
getPm().rollbackTransaction();
//#endif 


//#if 1830561937 
throw e;
//#endif 

} 

//#endif 


//#if 164549532 
catch (Exception e) //1
{ 

//#if 953723432 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if -332809977 
return lista;
//#endif 

} 

//#endif 


//#if 638140179 
public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException
    { 

//#if -1550833620 
try //1
{ 

//#if 1537755655 
getPm().beginTransaction();
//#endif 


//#if 783124004 
employeeRecord.insert(employee);
//#endif 


//#if 671922129 
getPm().commitTransaction();
//#endif 

} 

//#if -212696486 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 127012478 
getPm().rollbackTransaction();
//#endif 


//#if -1154027880 
throw e;
//#endif 

} 

//#endif 


//#if -189023461 
catch (ObjectNotValidException e) //1
{ 

//#if -1050590746 
getPm().rollbackTransaction();
//#endif 


//#if 2077454384 
throw e;
//#endif 

} 

//#endif 


//#if -1578847257 
catch (TransactionException e) //1
{ 

//#if -1587999681 
getPm().rollbackTransaction();
//#endif 


//#if -207088137 
throw e;
//#endif 

} 

//#endif 


//#if 1694319731 
catch (Exception e) //1
{ 

//#if 963215529 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -771006917 
public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException
    { 

//#if 282642448 
DiseaseType tp = null;
//#endif 


//#if 1634182895 
try //1
{ 

//#if -1197523249 
getPm().beginTransaction();
//#endif 


//#if -575954733 
tp = this.diseaseRecord.search(code);
//#endif 


//#if 1777622025 
getPm().commitTransaction();
//#endif 

} 

//#if 1576517988 
catch (RepositoryException e) //1
{ 

//#if 418827368 
getPm().rollbackTransaction();
//#endif 


//#if -1740435474 
throw e;
//#endif 

} 

//#endif 


//#if -2006691968 
catch (TransactionException e) //1
{ 

//#if -1948912993 
getPm().rollbackTransaction();
//#endif 


//#if 961993623 
throw e;
//#endif 

} 

//#endif 


//#if 1941844456 
catch (ObjectNotFoundException e) //1
{ 

//#if 931189023 
getPm().rollbackTransaction();
//#endif 


//#if 803491095 
throw e;
//#endif 

} 

//#endif 


//#if -234164614 
catch (Exception e) //1
{ 

//#if -472126618 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 551866166 
return tp;
//#endif 

} 

//#endif 


//#if -1399114374 
static IPersistenceMechanism pmInit()
    { 

//#if 960436705 
IPersistenceMechanism returnValue = null;
//#endif 


//#if -2105320695 
if(isPersistent())//1
{ 

//#if -1020731267 
try //1
{ 

//#if -1344648333 
returnValue = PersistenceMechanism.getInstance();
//#endif 


//#if 1974700465 
returnValue.connect();
//#endif 

} 

//#if -1745639283 
catch (PersistenceMechanismException e) //1
{ 

//#if 1525125290 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 329089779 
catch (Exception e) //1
{ 

//#if -1177437021 
try //1
{ 

//#if -976781813 
if(getPm() != null)//1
{ 

//#if -1469982403 
getPm().disconnect();
//#endif 

} 

//#endif 

} 

//#if -1869865914 
catch (PersistenceMechanismException mpe) //1
{ 

//#if -2127470615 
mpe.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1133497192 
if(Constants.isPersistent())//1
{ 

//#if 1461632529 
try //1
{ 

//#if 1223692772 
returnValue = PersistenceMechanism.getInstance();
//#endif 


//#if -1784852960 
returnValue.connect();
//#endif 

} 

//#if -936432406 
catch (PersistenceMechanismException e) //1
{ 

//#if -1072694372 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -530638896 
catch (Exception e) //1
{ 

//#if 1400239519 
try //1
{ 

//#if -966980609 
if(getPm() != null)//1
{ 

//#if -1385786478 
getPm().disconnect();
//#endif 

} 

//#endif 

} 

//#if 1527919018 
catch (PersistenceMechanismException mpe) //1
{ 

//#if 1522605204 
mpe.printStackTrace();
//#endif 

} 

//#endif 


//#if 82691115 
catch (RepositoryException re) //1
{ 

//#if -1218388661 
re.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1288652662 
return returnValue;
//#endif 

} 

//#endif 


//#if 121800822 
public void updateHealthUnit(HealthUnit hu) throws RepositoryException,
               ObjectNotFoundException, TransactionException, java.rmi.RemoteException
    { 

//#if 1653104866 
fCid.updateHealthUnit(hu);
//#endif 

} 

//#endif 


//#if -938134054 
public synchronized static HealthWatcherFacade getInstance()
    throws RepositoryException, IOException, java.rmi.RemoteException
    { 

//#if 1591672844 
if(singleton == null)//1
{ 

//#if -1639788109 
getPm();
//#endif 


//#if -1471841694 
singleton = new HealthWatcherFacade();
//#endif 

} 

//#endif 


//#if -919439459 
return singleton;
//#endif 

} 

//#endif 


//#if 14262731 
public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    { 

//#if 1900498416 
lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif 


//#if -1349369939 
lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getSpecialityList();
//#endif 


//#if 1810654307 
lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif 


//#if -1857688278 
sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif 


//#if -674495661 
return sa;
//#endif 

} 

//#endif 


//#if -2052532923 
public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException
    { 

//#if -346524875 
fCid.insert(employee);
//#endif 

} 

//#endif 


//#if 815122432 
public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    { 

//#if 425498000 
lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif 


//#if -219947774 
lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getHealthUnitList();
//#endif 


//#if -1644909565 
lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif 


//#if -333726518 
sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif 


//#if -996263181 
return sa;
//#endif 

} 

//#endif 


//#if 1524537753 
public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException
    { 

//#if -1539357867 
return fCid.getComplaintList();
//#endif 


//#if -1622334065 
IteratorDsk list = null;
//#endif 


//#if 675376906 
try //1
{ 

//#if -1802068362 
getPm().beginTransaction();
//#endif 


//#if 114876907 
list = complaintRecord.getComplaintList();
//#endif 


//#if 216592706 
getPm().commitTransaction();
//#endif 

} 

//#if -1652557030 
catch (ObjectNotFoundException e) //1
{ 

//#if 1247462798 
getPm().rollbackTransaction();
//#endif 


//#if 1108011400 
throw e;
//#endif 

} 

//#endif 


//#if -901749874 
catch (TransactionException e) //1
{ 

//#if -1911572415 
getPm().rollbackTransaction();
//#endif 


//#if -834780107 
throw e;
//#endif 

} 

//#endif 


//#if -650979540 
catch (Exception e) //1
{ 

//#if -1173809781 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if -1970216871 
return list;
//#endif 

} 

//#endif 


//#if -557609360 
public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    { 

//#if 431957276 
Symptom s = null;
//#endif 


//#if -1418358447 
try //1
{ 

//#if 1659487985 
getPm().beginTransaction();
//#endif 


//#if 42151837 
s = symptomRecord.search(numSymptom);
//#endif 


//#if 150657063 
getPm().commitTransaction();
//#endif 

} 

//#if -1135893971 
catch (RepositoryException e) //1
{ 

//#if 847602454 
getPm().rollbackTransaction();
//#endif 


//#if -1945049856 
throw e;
//#endif 

} 

//#endif 


//#if -192116777 
catch (TransactionException e) //1
{ 

//#if -927183410 
getPm().rollbackTransaction();
//#endif 


//#if 674081096 
throw e;
//#endif 

} 

//#endif 


//#if -801995215 
catch (ObjectNotFoundException e) //1
{ 

//#if -1992500142 
getPm().rollbackTransaction();
//#endif 


//#if -2130567356 
throw e;
//#endif 

} 

//#endif 


//#if -17660285 
catch (Exception e) //1
{ 

//#if -1911586165 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 542424883 
return s;
//#endif 

} 

//#endif 


//#if -1983207517 
public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    { 

//#if 1003959423 
try //1
{ 

//#if 1142423357 
getPm().beginTransaction();
//#endif 


//#if 779699528 
diseaseRecord.insert(diseaseType);
//#endif 


//#if 1301522779 
getPm().commitTransaction();
//#endif 

} 

//#if -198991416 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -1897470540 
getPm().rollbackTransaction();
//#endif 


//#if -888505310 
throw e;
//#endif 

} 

//#endif 


//#if 191036269 
catch (ObjectNotValidException e) //1
{ 

//#if 1721025103 
getPm().rollbackTransaction();
//#endif 


//#if -541330969 
throw e;
//#endif 

} 

//#endif 


//#if -1356993169 
catch (RepositoryException e) //1
{ 

//#if -1965370145 
getPm().rollbackTransaction();
//#endif 


//#if 1226015063 
throw e;
//#endif 

} 

//#endif 


//#if 1543742677 
catch (TransactionException e) //1
{ 

//#if -276108840 
getPm().rollbackTransaction();
//#endif 


//#if 1908887678 
throw e;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1878706710 
public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    { 

//#if -1565343928 
IteratorDsk lista = null;
//#endif 


//#if 1084742226 
try //1
{ 

//#if 2131927446 
getPm().beginTransaction();
//#endif 


//#if 294043614 
lista = healthUnitRecord.searchHealthUnitsBySpeciality(code);
//#endif 


//#if 1911378466 
getPm().commitTransaction();
//#endif 

} 

//#if 355465553 
catch (RepositoryException e) //1
{ 

//#if -379701538 
getPm().rollbackTransaction();
//#endif 


//#if -48713160 
throw e;
//#endif 

} 

//#endif 


//#if -1204611789 
catch (TransactionException e) //1
{ 

//#if -2115758123 
getPm().rollbackTransaction();
//#endif 


//#if -1051665631 
throw e;
//#endif 

} 

//#endif 


//#if -485577899 
catch (ObjectNotFoundException e) //1
{ 

//#if -1114138037 
getPm().rollbackTransaction();
//#endif 


//#if 1217750379 
throw e;
//#endif 

} 

//#endif 


//#if 1247722151 
catch (Exception e) //1
{ 

//#if 839166015 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if -1762261788 
return lista;
//#endif 

} 

//#endif 


//#if 480735070 
public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    { 

//#if -2106570771 
lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif 


//#if 1345426109 
lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getDiseaseTypeList();
//#endif 


//#if 1325856352 
lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif 


//#if 1703058279 
sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif 


//#if 1156809936 
return sa;
//#endif 

} 

//#endif 


//#if 582729459 
public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    { 

//#if -462318437 
try //1
{ 

//#if 1100911022 
getPm().beginTransaction();
//#endif 


//#if 1876742269 
symptomRecord.insert(symptom);
//#endif 


//#if 14640394 
getPm().commitTransaction();
//#endif 

} 

//#if 830939681 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -1745170248 
getPm().rollbackTransaction();
//#endif 


//#if 2109318558 
throw e;
//#endif 

} 

//#endif 


//#if -1274135244 
catch (ObjectNotValidException e) //1
{ 

//#if -2041411479 
getPm().rollbackTransaction();
//#endif 


//#if -1048018675 
throw e;
//#endif 

} 

//#endif 


//#if -188273994 
catch (RepositoryException e) //1
{ 

//#if 1208871909 
getPm().rollbackTransaction();
//#endif 


//#if 444619025 
throw e;
//#endif 

} 

//#endif 


//#if -880668562 
catch (TransactionException e) //1
{ 

//#if -170942212 
getPm().rollbackTransaction();
//#endif 


//#if 116445658 
throw e;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1505158157 
static boolean isPersistent()
    { 

//#if -2066568967 
return Constants.isPersistent();
//#endif 

} 

//#endif 


//#if 574711947 
public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    { 

//#if -636197856 
HealthUnit unit = null;
//#endif 


//#if 422498683 
try //1
{ 

//#if -365964189 
getPm().beginTransaction();
//#endif 


//#if 1367070099 
unit = healthUnitRecord.search(healthUnitCode);
//#endif 


//#if 1786149109 
getPm().commitTransaction();
//#endif 

} 

//#if 1940746109 
catch (TransactionException e) //1
{ 

//#if -2005169587 
getPm().rollbackTransaction();
//#endif 


//#if 1436209065 
throw e;
//#endif 

} 

//#endif 


//#if -429935413 
catch (ObjectNotFoundException e) //1
{ 

//#if -200109522 
getPm().rollbackTransaction();
//#endif 


//#if -759901976 
throw e;
//#endif 

} 

//#endif 


//#if 1486219933 
catch (Exception e) //1
{ 

//#if -2067353542 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 570773602 
return unit;
//#endif 

} 

//#endif 


//#if 1092793139 
public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException
    { 

//#if 592871392 
lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif 


//#if -620219707 
lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getPartialHealthUnitList();
//#endif 


//#if -1351346605 
lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif 


//#if -890631398 
sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif 


//#if 1585864003 
return sa;
//#endif 

} 

//#endif 


//#if -1447705121 
public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException
    { 

//#if -1155581522 
lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif 


//#if 1882357966 
lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.searchHealthUnitsBySpeciality(code);
//#endif 


//#if -184066015 
lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif 


//#if 1750816360 
sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif 


//#if -1553230831 
return sa;
//#endif 

} 

//#endif 


//#if -1757254309 
public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException
    { 

//#if 834277490 
Complaint q = null;
//#endif 


//#if -2124135637 
try //1
{ 

//#if -615297523 
getPm().beginTransaction();
//#endif 


//#if 2017026471 
q = this.complaintRecord.search(code);
//#endif 


//#if -1648216949 
getPm().commitTransaction();
//#endif 

} 

//#if -787875990 
catch (RepositoryException e) //1
{ 

//#if 1434147002 
getPm().rollbackTransaction();
//#endif 


//#if -160598052 
throw e;
//#endif 

} 

//#endif 


//#if 2006506042 
catch (TransactionException e) //1
{ 

//#if -347319518 
getPm().rollbackTransaction();
//#endif 


//#if 431755892 
throw e;
//#endif 

} 

//#endif 


//#if 119141614 
catch (ObjectNotFoundException e) //1
{ 

//#if -219892850 
getPm().rollbackTransaction();
//#endif 


//#if -694895736 
throw e;
//#endif 

} 

//#endif 


//#if -1660824576 
catch (Exception e) //1
{ 

//#if -1824880740 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 895377999 
return q;
//#endif 

} 

//#endif 


//#if 503949438 
public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    { 

//#if 637731032 
IteratorDsk lista = null;
//#endif 


//#if -246596638 
try //1
{ 

//#if 593179366 
getPm().beginTransaction();
//#endif 


//#if -1604633763 
lista = specialityRecord.getListaEspecialidade();
//#endif 


//#if 1454828242 
getPm().commitTransaction();
//#endif 

} 

//#if -1537443899 
catch (RepositoryException e) //1
{ 

//#if -921462764 
getPm().rollbackTransaction();
//#endif 


//#if -1612778046 
throw e;
//#endif 

} 

//#endif 


//#if 244737343 
catch (TransactionException e) //1
{ 

//#if 1510771443 
getPm().rollbackTransaction();
//#endif 


//#if 745017795 
throw e;
//#endif 

} 

//#endif 


//#if -231813175 
catch (ObjectNotFoundException e) //1
{ 

//#if -81838800 
getPm().rollbackTransaction();
//#endif 


//#if -569909210 
throw e;
//#endif 

} 

//#endif 


//#if -1821574629 
catch (Exception e) //1
{ 

//#if -689193752 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 1976564340 
return lista;
//#endif 

} 

//#endif 


//#if -52293098 
public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException
    { 

//#if -1114514755 
IteratorDsk lista = null;
//#endif 


//#if 231636935 
try //1
{ 

//#if 490245664 
getPm().beginTransaction();
//#endif 


//#if -394649543 
lista = healthUnitRecord.getPartialHealthUnitList();
//#endif 


//#if -1736116520 
getPm().commitTransaction();
//#endif 

} 

//#if -696846457 
catch (RepositoryException e) //1
{ 

//#if -419463432 
getPm().rollbackTransaction();
//#endif 


//#if 910950238 
throw e;
//#endif 

} 

//#endif 


//#if 533454269 
catch (TransactionException e) //1
{ 

//#if -436729852 
getPm().rollbackTransaction();
//#endif 


//#if 492680146 
throw e;
//#endif 

} 

//#endif 


//#if -1885364597 
catch (ObjectNotFoundException e) //1
{ 

//#if 969286988 
getPm().rollbackTransaction();
//#endif 


//#if 642049930 
throw e;
//#endif 

} 

//#endif 


//#if 120448093 
catch (Exception e) //1
{ 

//#if -1270398633 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 


//#if 17170073 
return lista;
//#endif 

} 

//#endif 


//#if 1832461542 
public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    { 

//#if -1951209079 
try //1
{ 

//#if 1447119731 
getPm().beginTransaction();
//#endif 


//#if 670490886 
specialityRecord.insert(speciality);
//#endif 


//#if -2137791515 
getPm().commitTransaction();
//#endif 

} 

//#if -779072262 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -1814143154 
getPm().rollbackTransaction();
//#endif 


//#if 1117865928 
throw e;
//#endif 

} 

//#endif 


//#if 1703322747 
catch (ObjectNotValidException e) //1
{ 

//#if -2016725363 
getPm().rollbackTransaction();
//#endif 


//#if -622335127 
throw e;
//#endif 

} 

//#endif 


//#if 917261693 
catch (RepositoryException e) //1
{ 

//#if -1614199362 
getPm().rollbackTransaction();
//#endif 


//#if -58925224 
throw e;
//#endif 

} 

//#endif 


//#if -968800633 
catch (TransactionException e) //1
{ 

//#if 1481530919 
getPm().rollbackTransaction();
//#endif 


//#if 318687503 
throw e;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 177933161 
public HealthWatcherFacade()
    { 

//#if 1759440877 
this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryArray());
//#endif 


//#if -1627605435 
if(Constants.isPersistent())//1
{ 

//#if -95873587 
this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryRDB(getPm()));
//#endif 

} 

//#endif 


//#if 1456202116 
this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryArray());
//#endif 


//#if -2107633076 
if(Constants.isPersistent())//2
{ 

//#if -344533402 
this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryRDB(getPm()));
//#endif 

} 

//#endif 


//#if -1973234584 
this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryArray());
//#endif 


//#if -2107603284 
if(Constants.isPersistent())//3
{ 

//#if -789486876 
this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryRDB(getPm()));
//#endif 

} 

//#endif 


//#if 1729307930 
DiseaseTypeRepositoryArray tp = new DiseaseTypeRepositoryArray();
//#endif 


//#if 163776600 
this.diseaseRecord = new DiseaseRecord(tp);
//#endif 


//#if -2107573492 
if(Constants.isPersistent())//4
{ 

//#if -428732722 
this.diseaseRecord = new DiseaseRecord(new DiseaseTypeRepositoryRDB(getPm()));
//#endif 

} 

//#endif 


//#if 267595131 
EmployeeRepositoryArray er = new EmployeeRepositoryArray();
//#endif 


//#if -1147636091 
this.employeeRecord = new EmployeeRecord(er);
//#endif 


//#if -2107543700 
if(Constants.isPersistent())//5
{ 

//#if 501364365 
this.employeeRecord = new EmployeeRecord(new EmployeeRepositoryRDB(getPm()));
//#endif 

} 

//#endif 


//#if -152929472 
AbstractRepositoryFactory factory = RepositoryFactory.getRepositoryFactory();
//#endif 


//#if 1920601086 
this.complaintRecord = new ComplaintRecord(factory.createComplaintRepository());
//#endif 


//#if 875860255 
this.healthUnitRecord = new HealthUnitRecord(factory.createHealthUnitRepository());
//#endif 


//#if -1610544152 
this.specialityRecord = new MedicalSpecialityRecord(factory.createMedicalSpecialityRepository());
//#endif 


//#if 1222518127 
this.diseaseRecord = new DiseaseRecord(factory.createDiseaseRepository());
//#endif 


//#if -209093391 
this.employeeRecord = new EmployeeRecord(factory.createEmployeeRepository());
//#endif 


//#if -1489012996 
this.symptomRecord = new SymptomRecord(factory.createSymptomRepository());
//#endif 

} 

//#endif 


//#if -774097282 
public static void main(String[] args)
    { 

//#if -606550376 
try //1
{ 

//#if -286134525 
new HealthWatcherFacade();
//#endif 

} 

//#if -1628564196 
catch (Exception e) //1
{ 

//#if 1336615749 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -904769561 
public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    { 

//#if 563112121 
try //1
{ 

//#if 24589353 
getPm().beginTransaction();
//#endif 


//#if -407287552 
specialityRecord.update(speciality);
//#endif 


//#if 1008407023 
getPm().commitTransaction();
//#endif 

} 

//#if -720477793 
catch (TransactionException e) //1
{ 

//#if 1271588967 
getPm().rollbackTransaction();
//#endif 


//#if -1581201713 
throw e;
//#endif 

} 

//#endif 


//#if -739601821 
catch (ObjectNotValidException e) //1
{ 

//#if -887508122 
getPm().rollbackTransaction();
//#endif 


//#if -1453543760 
throw e;
//#endif 

} 

//#endif 


//#if -149883031 
catch (ObjectNotFoundException e) //1
{ 

//#if 514491322 
getPm().rollbackTransaction();
//#endif 


//#if 305310940 
throw e;
//#endif 

} 

//#endif 


//#if -1139344965 
catch (Exception e) //1
{ 

//#if 1317355864 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1070549396 
public void notify(Subject subject) throws TransactionException, ObjectNotFoundException,
        RepositoryException, RemoteException, ObjectNotValidException
    { 

//#if 1765339147 
try //1
{ 

//#if 1556204577 
if(subject instanceof Complaint)//1
{ 

//#if -911929708 
Complaint complaint = (Complaint) subject;
//#endif 


//#if 1903594139 
updateComplaint(complaint);
//#endif 

} 
else

//#if -682706361 
if(subject instanceof Employee)//1
{ 

//#if -236851948 
Employee employee = (Employee) subject;
//#endif 


//#if 1545592418 
updateEmployee(employee);
//#endif 

} 
else

//#if -413079383 
if(subject instanceof HealthUnit)//1
{ 

//#if 2065388838 
HealthUnit healthUnit = (HealthUnit) subject;
//#endif 


//#if -635662102 
updateHealthUnit(healthUnit);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#if -349889461 
catch (Exception e) //1
{ 

//#if -1070817104 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -500955031 
public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    { 

//#if 1886241125 
try //1
{ 

//#if 879914985 
getPm().beginTransaction();
//#endif 


//#if 310304114 
employeeRecord.update(employee);
//#endif 


//#if 1753697839 
getPm().commitTransaction();
//#endif 

} 

//#if -1520963547 
catch (TransactionException e) //1
{ 

//#if 1451439627 
getPm().rollbackTransaction();
//#endif 


//#if 1780351403 
throw e;
//#endif 

} 

//#endif 


//#if 1942695453 
catch (ObjectNotValidException e) //1
{ 

//#if -1628689417 
getPm().rollbackTransaction();
//#endif 


//#if 1690322239 
throw e;
//#endif 

} 

//#endif 


//#if -1762553053 
catch (ObjectNotFoundException e) //1
{ 

//#if 774106780 
getPm().rollbackTransaction();
//#endif 


//#if 1018910778 
throw e;
//#endif 

} 

//#endif 


//#if -1418378507 
catch (Exception e) //1
{ 

//#if 36680458 
getPm().rollbackTransaction();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

