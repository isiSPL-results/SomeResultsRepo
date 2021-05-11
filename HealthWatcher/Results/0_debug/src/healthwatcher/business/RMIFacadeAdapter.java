
//#if 1215500240
// Compilation Unit of /RMIFacadeAdapter.java


//#if -1778182715
package healthwatcher.business;
//#endif


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


//#if 1400021272
public class RMIFacadeAdapter extends
//#if -17497005
    UnicastRemoteObject
//#endif

    implements
//#if 2142716402
    IFacadeRMITargetAdapter
//#endif

{

//#if -170040377
    private static RMIFacadeAdapter singleton;
//#endif


//#if -273251102
    private IFacade fCid;
//#endif


//#if -1837875155
    public Employee searchEmployee(String login) throws ObjectNotFoundException, TransactionException,
               CommunicationException, RepositoryException, ObjectNotValidException, UpdateEntryException
    {

//#if -1498667598
        return fCid.searchEmployee(login);
//#endif

    }

//#endif


//#if -1364689771
    public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
        TransactionException
    {

//#if 1569963687
        return fCid.searchSpecialitiesByCode(numSpeciality);
//#endif

    }

//#endif


//#if -171424066
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    {

//#if -1704817499
        fCid.insert(speciality);
//#endif

    }

//#endif


//#if 1460802420
    public void updateEmployee(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException, CommunicationException
    {

//#if 753818398
        fCid.updateEmployee(employee);
//#endif

    }

//#endif


//#if -2112619971
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if -2085014503
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif


//#if -781094695
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getHealthUnitList();
//#endif


//#if -271023476
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif


//#if 983096979
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif


//#if -991952132
        return sa;
//#endif

    }

//#endif


//#if -1492207895
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    {

//#if 1031765193
        fCid.insert(us);
//#endif

    }

//#endif


//#if 330983044
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException
    {

//#if 1399167669
        return fCid.getComplaintList();
//#endif

    }

//#endif


//#if 527682235
    private RMIFacadeAdapter() throws PersistenceMechanismException, IOException
    {

//#if 291585361
        this.fCid = new HealthWatcherFacade();
//#endif


//#if 434241072
        try { //1

//#if 2052247415
            System.out.println("Creating RMI server...");
//#endif


//#if -2028534533
            System.out.println("Object exported");
//#endif


//#if 1114539429
            System.out.println(healthwatcher.Constants.SYSTEM_NAME);
//#endif


//#if -1706370881
            java.rmi.Naming.rebind("//" + healthwatcher.Constants.SERVER_NAME + "/"
                                   + healthwatcher.Constants.SYSTEM_NAME, this);
//#endif


//#if 35898576
            System.out.println("Server created and ready.");
//#endif

        }

//#if 1748913038
        catch (java.rmi.RemoteException rmiEx) { //1

//#if -1207003418
            rmiFacadeExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#if 1925134093
        catch (java.net.MalformedURLException rmiEx) { //1

//#if 2093968496
            rmiFacadeExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -2061750092
    private void rmiFacadeExceptionHandling(Throwable exception)
    {

//#if -826187336
        System.out.println("**************************************************");
//#endif


//#if 415429773
        System.out.println("* Error during server initialization!            *");
//#endif


//#if -393127361
        System.out.println("* The exception message is:                      *");
//#endif


//#if 87421032
        System.out.println("      " + exception.getMessage());
//#endif


//#if 1606659964
        System.out.println("* You may have to restart the server or registry.*");
//#endif


//#if 1510693274
        System.out.println("**************************************************");
//#endif


//#if -681842143
        exception.printStackTrace();
//#endif

    }

//#endif


//#if 64960827
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException
    {

//#if -1683670747
        return fCid.searchHealthUnit(healthUnitCode);
//#endif

    }

//#endif


//#if 279307535
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    {

//#if 776176825
        fCid.updateMedicalSpeciality(speciality);
//#endif

    }

//#endif


//#if -208005048
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {

//#if -13222755
        return fCid.searchSymptom(numSymptom);
//#endif

    }

//#endif


//#if 337787243
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if -573139118
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif


//#if -1366140325
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid
                                          .searchSpecialitiesByHealthUnit(code);
//#endif


//#if 1023385029
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif


//#if 608510220
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif


//#if 348051381
        return sa;
//#endif

    }

//#endif


//#if -482285873
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {

//#if 1034081862
        return fCid.getSymptomList();
//#endif

    }

//#endif


//#if -1701593397
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {

//#if -343074268
        fCid.insert(diseaseType);
//#endif

    }

//#endif


//#if -332094339
    public synchronized static RMIFacadeAdapter getInstance()
    throws PersistenceMechanismException, IOException, java.rmi.RemoteException
    {

//#if 1466630945
        if(singleton == null) { //1

//#if 671176174
            singleton = new RMIFacadeAdapter();
//#endif

        }

//#endif


//#if -1888506254
        return singleton;
//#endif

    }

//#endif


//#if 1036536850
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if 601263018
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif


//#if -1572586061
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getSpecialityList();
//#endif


//#if 1127272989
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif


//#if 404931428
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif


//#if 1589637133
        return sa;
//#endif

    }

//#endif


//#if -1188379427
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException, RepositoryException
    {

//#if 61998406
        return fCid.getComplaintList();
//#endif

    }

//#endif


//#if 976961281
    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    {

//#if -292787655
        fCid.insert(employee);
//#endif

    }

//#endif


//#if -498130017
    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, CommunicationException
    {

//#if -1563352305
        this.fCid.updateComplaint(q);
//#endif

    }

//#endif


//#if 1212967175
    public void updateHealthUnit(HealthUnit hu) throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if 140081795
        fCid.updateHealthUnit(hu);
//#endif

    }

//#endif


//#if 1925386494
    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        java.rmi.RemoteException, CommunicationException
    {

//#if -627318377
        return fCid.insertComplaint(complaint);
//#endif

    }

//#endif


//#if -946238378
    public static void main(String[] args)
    {

//#if -507675913
        try { //1

//#if 1389695091
            new RMIFacadeAdapter();
//#endif

        }

//#if 359485473
        catch (Exception e) { //1

//#if 2081269631
            e.printStackTrace();
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1846021699
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    {

//#if 998091128
        fCid.updateSymptom(symptom);
//#endif

    }

//#endif


//#if 1703757570
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {

//#if -1697201925
        return fCid.searchHealthUnit(healthUnitCode);
//#endif

    }

//#endif


//#if -1610449381
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {

//#if -2086452684
        fCid.insert(symptom);
//#endif

    }

//#endif


//#if -738178961
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if -1085554069
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif


//#if 1858372667
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getDiseaseTypeList();
//#endif


//#if -1219526434
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif


//#if -477101211
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif


//#if 735167566
        return sa;
//#endif

    }

//#endif


//#if 583686824
    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException, CommunicationException
    {

//#if 929928369
        fCid.insert(employee);
//#endif

    }

//#endif


//#if 337683499
    private RMIFacadeAdapter() throws RepositoryException, IOException
    {

//#if -1935135835
        this.fCid = new HealthWatcherFacade();
//#endif


//#if 287453020
        try { //1

//#if 1479356844
            System.out.println("Creating RMI server...");
//#endif


//#if 1746957040
            System.out.println("Object exported");
//#endif


//#if -521264752
            System.out.println(healthwatcher.Constants.SYSTEM_NAME);
//#endif


//#if 59930218
            java.rmi.Naming.rebind("//" + healthwatcher.Constants.SERVER_NAME + "/"
                                   + healthwatcher.Constants.SYSTEM_NAME, this);
//#endif


//#if -756126267
            System.out.println("Server created and ready.");
//#endif

        }

//#if -1043954926
        catch (java.rmi.RemoteException rmiEx) { //1

//#if -206879395
            rmiFacadeExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#if 1136180113
        catch (java.net.MalformedURLException rmiEx) { //1

//#if 1171577268
            rmiFacadeExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 250676986
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if 1727334030
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif


//#if 316116467
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.getPartialHealthUnitList();
//#endif


//#if 335949057
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif


//#if -940164280
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif


//#if -275697423
        return sa;
//#endif

    }

//#endif


//#if -923781426
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if 1272667483
        lib.distribution.rmi.IteratorRMISourceAdapter sa = null;
//#endif


//#if 1310831361
        lib.util.LocalIterator iterator = (lib.util.LocalIterator) fCid.searchHealthUnitsBySpeciality(code);
//#endif


//#if 1569692622
        lib.distribution.rmi.IteratorRMITargetAdapter iteratorTA = new lib.distribution.rmi.IteratorRMITargetAdapter(
            iterator, 3);
//#endif


//#if 1871694421
        sa = new lib.distribution.rmi.IteratorRMISourceAdapter(iteratorTA, iterator, 3);
//#endif


//#if 226887486
        return sa;
//#endif

    }

//#endif


//#if -576974899
    public synchronized static RMIFacadeAdapter getInstance()
    throws RepositoryException, IOException, java.rmi.RemoteException
    {

//#if 2094851951
        if(singleton == null) { //1

//#if -928461909
            singleton = new RMIFacadeAdapter();
//#endif

        }

//#endif


//#if -1744935616
        return singleton;
//#endif

    }

//#endif


//#if -509888449
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if 806945115
        return this.fCid.searchComplaint(code);
//#endif

    }

//#endif


//#if 1454740767
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, TransactionException, java.rmi.RemoteException, CommunicationException
    {

//#if -1295004777
        return fCid.searchDiseaseType(code);
//#endif

    }

//#endif

}

//#endif


//#endif

