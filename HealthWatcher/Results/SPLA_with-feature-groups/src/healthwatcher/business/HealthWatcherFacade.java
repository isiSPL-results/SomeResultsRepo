// Compilation Unit of /HealthWatcherFacade.java

package healthwatcher.business;
import healthwatcher.Constants;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.employee.Employee;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.IOException;

//#if 327954272
import lib.exceptions.InsertEntryException;
//#endif

import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;

//#if -998254768
import lib.exceptions.UpdateEntryException;
//#endif

import lib.persistence.IPersistenceMechanism;
import lib.persistence.PersistenceMechanism;
import lib.util.IteratorDsk;

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

public class HealthWatcherFacade extends
//#if 121865132
    java.rmi.server.UnicastRemoteObject
//#endif

    implements IFacade
{
    private static HealthWatcherFacade singleton;

//#if 1011691987
    private HealthWatcherFacadeInit fCid;
//#endif

    private static IPersistenceMechanism pm = null;
    private static boolean pmCreated = false;

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
        MedicalSpeciality s = null;
        try { //1
            getPm().beginTransaction();
            s = specialityRecord.search(numSpeciality);
            getPm().commitTransaction();
        }

//#if -275382369
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 713939109
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1934416547
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1126454667
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return s;
    }

//#endif


//#if 1971430057
    public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException
    {
        fCid.update(employee);
    }

//#endif


//#if 907616868
    public void updateComplaint(Complaint complaint) throws TransactionException,
        RepositoryException, ObjectNotFoundException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            complaintRecord.update(complaint);
            getPm().commitTransaction();
        }

//#if 594392080
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -765268332
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1907143252
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1012660186
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

//#endif


//#if -756932722
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    {
        return this.fCid.searchComplaint(code);
    }

//#endif


//#if 617678046
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    {
        this.fCid.updateComplaint(q);
    }

//#endif


//#if 1958151415
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = symptomRecord.getSymptomList();
            getPm().commitTransaction();
        }

//#if -710466017
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 111247909
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 124174627
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -126684939
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return lista;
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
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.searchSpecialityByHealthUnit(code);
            getPm().commitTransaction();
        }

//#if 1469188037
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1038953153
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -266575927
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


        return lista;
    }

//#endif


//#if 623897262
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException
    {
        return fCid.searchDiseaseType(code);
    }

//#endif

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


//#if 1724871563
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = this.diseaseRecord.getDiseaseTypeList();
            getPm().commitTransaction();
        }

//#if 1495221399
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -231918931
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1136991333
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1773124243
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return lista;
    }

//#endif


//#if 1435721290
    public synchronized static HealthWatcherFacade getInstance()
    throws PersistenceMechanismException, IOException, java.rmi.RemoteException
    {
        if(singleton == null) { //1
            getPm();
            singleton = new HealthWatcherFacade();
        }

        return singleton;
    }

//#endif


//#if -143131217
    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        java.rmi.RemoteException
    {
        return fCid.insertComplaint(complaint);
    }

//#endif

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
        try { //1
            getPm().beginTransaction();
            employee = employeeRecord.search(login);
            getPm().commitTransaction();
            return employee;
        }

//#if 2026266157
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 382208027
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1136609773
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


//#endif


//#if 1441854067
        return employee;
//#endif

    }


//#if 1817333185
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            healthUnitRecord.insert(us);
            getPm().commitTransaction();
        }

//#if -1643722862
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 332555491
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -931626523
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1845206815
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


    }

//#endif


//#if 2042141068
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

//#endif


//#if 416609899
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            symptomRecord.update(symptom);
            getPm().commitTransaction();
        }

//#if 842492984
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -17640150
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 572078640
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 2114622658
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

//#endif


//#if -1222618086
    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException
    {
        int retorno = 0;
        try { //1
            getPm().beginTransaction();
            retorno = complaintRecord.insert(complaint);
            getPm().commitTransaction();
        }

//#if 585008371
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 676364962
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1678682332
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 161313216
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


        return retorno;
    }

//#endif


//#if 479914332
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        try { //1
            getPm().beginTransaction();
            healthUnitRecord.update(unit);
            getPm().commitTransaction();
        }

//#if 1725621458
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1181085270
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1679451694
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1104092312
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

//#endif


//#if -1661881884
    private HealthWatcherFacade() throws PersistenceMechanismException, IOException
    {
        this.fCid = new HealthWatcherFacadeInit();
        try { //1
            System.out.println("Creating RMI server...");
            System.out.println("Object exported");
            System.out.println(healthwatcher.Constants.SYSTEM_NAME);
            java.rmi.Naming.rebind("//" + healthwatcher.Constants.SERVER_NAME + "/"
                                   + healthwatcher.Constants.SYSTEM_NAME, this);
            System.out.println("Server created and ready.");
        }

//#if 500510937
        catch (java.rmi.RemoteException rmiEx) { //1
            rmiFacadeExceptionHandling(rmiEx);
        }

//#endif


//#if -1840662504
        catch (java.net.MalformedURLException rmiEx) { //1
            rmiFacadeExceptionHandling(rmiEx);
        }

//#endif


    }

//#endif


//#if -632969070
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid
                                          .searchSpecialitiesByHealthUnit(code);
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }

//#endif


//#if 1025013929
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.getHealthUnitList();
            getPm().commitTransaction();
        }

//#if 943793158
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -146325218
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1869706122
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 164549532
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return lista;
    }

//#endif


//#if 638140179
    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException
    {
        try { //1
            getPm().beginTransaction();
            employeeRecord.insert(employee);
            getPm().commitTransaction();
        }

//#if -212696486
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -189023461
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1578847257
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1694319731
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

//#endif


//#if -771006917
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        DiseaseType tp = null;
        try { //1
            getPm().beginTransaction();
            tp = this.diseaseRecord.search(code);
            getPm().commitTransaction();
        }

//#if 1576517988
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -2006691968
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1941844456
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -234164614
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return tp;
    }

//#endif

    static IPersistenceMechanism pmInit()
    {
        IPersistenceMechanism returnValue = null;

//#if -2105320695
        if(isPersistent()) { //1
            try { //1
                returnValue = PersistenceMechanism.getInstance();
                returnValue.connect();
            }

//#if -1745639283
            catch (PersistenceMechanismException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 329089779
            catch (Exception e) { //1
                try { //1
                    if(getPm() != null) { //1
                        getPm().disconnect();
                    }

                }

//#if -1869865914
                catch (PersistenceMechanismException mpe) { //1
                    mpe.printStackTrace();
                }

//#endif


            }

//#endif


        }

//#endif


//#if 1133497192
        if(Constants.isPersistent()) { //1
            try { //1
                returnValue = PersistenceMechanism.getInstance();
                returnValue.connect();
            }

//#if -936432406
            catch (PersistenceMechanismException e) { //1
                e.printStackTrace();
            }

//#endif


//#if -530638896
            catch (Exception e) { //1
                try { //1
                    if(getPm() != null) { //1
                        getPm().disconnect();
                    }

                }

//#if 1527919018
                catch (PersistenceMechanismException mpe) { //1
                    mpe.printStackTrace();
                }

//#endif


//#if 82691115
                catch (RepositoryException re) { //1
                    re.printStackTrace();
                }

//#endif


            }

//#endif


        }

//#endif

        return returnValue;
    }


//#if 121800822
    public void updateHealthUnit(HealthUnit hu) throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException
    {
        fCid.updateHealthUnit(hu);
    }

//#endif


//#if -938134054
    public synchronized static HealthWatcherFacade getInstance()
    throws RepositoryException, IOException, java.rmi.RemoteException
    {
        if(singleton == null) { //1
            getPm();
            singleton = new HealthWatcherFacade();
        }

        return singleton;
    }

//#endif


//#if 14262731
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getSpecialityList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }

//#endif


//#if -2052532923
    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException
    {
        fCid.insert(employee);
    }

//#endif


//#if 815122432
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getHealthUnitList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }

//#endif

    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException
    {

//#if -1539357867
        return fCid.getComplaintList();
//#endif


//#if -1622334065
        IteratorDsk list = null;
//#endif


//#if 675376906
        try { //1
            getPm().beginTransaction();
            list = complaintRecord.getComplaintList();
            getPm().commitTransaction();
        }

//#if -1652557030
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -901749874
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -650979540
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


//#endif


//#if -1970216871
        return list;
//#endif

    }


//#if -557609360
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        Symptom s = null;
        try { //1
            getPm().beginTransaction();
            s = symptomRecord.search(numSymptom);
            getPm().commitTransaction();
        }

//#if -1135893971
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -192116777
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -801995215
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -17660285
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return s;
    }

//#endif


//#if -1983207517
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            diseaseRecord.insert(diseaseType);
            getPm().commitTransaction();
        }

//#if -198991416
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 191036269
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1356993169
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1543742677
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


    }

//#endif


//#if -1878706710
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.searchHealthUnitsBySpeciality(code);
            getPm().commitTransaction();
        }

//#if 355465553
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1204611789
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -485577899
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1247722151
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return lista;
    }

//#endif


//#if 480735070
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getDiseaseTypeList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }

//#endif


//#if 582729459
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            symptomRecord.insert(symptom);
            getPm().commitTransaction();
        }

//#if 830939681
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1274135244
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -188273994
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -880668562
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


    }

//#endif


//#if -1505158157
    static boolean isPersistent()
    {
        return Constants.isPersistent();
    }

//#endif


//#if 574711947
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {
        HealthUnit unit = null;
        try { //1
            getPm().beginTransaction();
            unit = healthUnitRecord.search(healthUnitCode);
            getPm().commitTransaction();
        }

//#if 1940746109
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -429935413
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1486219933
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return unit;
    }

//#endif


//#if 1092793139
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getPartialHealthUnitList();
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }

//#endif


//#if -1447705121
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException
    {
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.searchHealthUnitsBySpeciality(code);
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
        return sa;
    }

//#endif


//#if -1757254309
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        Complaint q = null;
        try { //1
            getPm().beginTransaction();
            q = this.complaintRecord.search(code);
            getPm().commitTransaction();
        }

//#if -787875990
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 2006506042
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 119141614
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1660824576
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return q;
    }

//#endif


//#if 503949438
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = specialityRecord.getListaEspecialidade();
            getPm().commitTransaction();
        }

//#if -1537443899
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 244737343
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -231813175
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1821574629
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return lista;
    }

//#endif


//#if -52293098
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {
        IteratorDsk lista = null;
        try { //1
            getPm().beginTransaction();
            lista = healthUnitRecord.getPartialHealthUnitList();
            getPm().commitTransaction();
        }

//#if -696846457
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 533454269
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1885364597
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 120448093
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


        return lista;
    }

//#endif


//#if 1832461542
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            getPm().beginTransaction();
            specialityRecord.insert(speciality);
            getPm().commitTransaction();
        }

//#if -779072262
        catch (ObjectAlreadyInsertedException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1703322747
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 917261693
        catch (RepositoryException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -968800633
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

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
        if(Constants.isPersistent()) { //1
            this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryRDB(getPm()));
        }

//#endif


//#if 1456202116
        this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryArray());
//#endif


//#if -2107633076
        if(Constants.isPersistent()) { //2
            this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryRDB(getPm()));
        }

//#endif


//#if -1973234584
        this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryArray());
//#endif


//#if -2107603284
        if(Constants.isPersistent()) { //3
            this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryRDB(getPm()));
        }

//#endif


//#if 1729307930
        DiseaseTypeRepositoryArray tp = new DiseaseTypeRepositoryArray();
//#endif


//#if 163776600
        this.diseaseRecord = new DiseaseRecord(tp);
//#endif


//#if -2107573492
        if(Constants.isPersistent()) { //4
            this.diseaseRecord = new DiseaseRecord(new DiseaseTypeRepositoryRDB(getPm()));
        }

//#endif


//#if 267595131
        EmployeeRepositoryArray er = new EmployeeRepositoryArray();
//#endif


//#if -1147636091
        this.employeeRecord = new EmployeeRecord(er);
//#endif


//#if -2107543700
        if(Constants.isPersistent()) { //5
            this.employeeRecord = new EmployeeRecord(new EmployeeRepositoryRDB(getPm()));
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
        try { //1
            new HealthWatcherFacade();
        }

//#if -1628564196
        catch (Exception e) { //1
            e.printStackTrace();
        }

//#endif


    }

//#endif


//#if -904769561
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            specialityRecord.update(speciality);
            getPm().commitTransaction();
        }

//#if -720477793
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -739601821
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -149883031
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1139344965
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

//#endif


//#if 1070549396
    public void notify(Subject subject) throws TransactionException, ObjectNotFoundException,
        RepositoryException, RemoteException, ObjectNotValidException
    {

//#if 1765339147
        try { //1
            if(subject instanceof Complaint) { //1
                Complaint complaint = (Complaint) subject;
                updateComplaint(complaint);
            } else if(subject instanceof Employee) { //1
                Employee employee = (Employee) subject;
                updateEmployee(employee);
            } else if(subject instanceof HealthUnit) { //1
                HealthUnit healthUnit = (HealthUnit) subject;
                updateHealthUnit(healthUnit);
            }



        } catch (Exception e) { //1
            e.printStackTrace();
        }


//#endif

    }

//#endif


//#if -500955031
    public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    {
        try { //1
            getPm().beginTransaction();
            employeeRecord.update(employee);
            getPm().commitTransaction();
        }

//#if -1520963547
        catch (TransactionException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if 1942695453
        catch (ObjectNotValidException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1762553053
        catch (ObjectNotFoundException e) { //1
            getPm().rollbackTransaction();
            throw e;
        }

//#endif


//#if -1418378507
        catch (Exception e) { //1
            getPm().rollbackTransaction();
        }

//#endif


    }

//#endif

}


