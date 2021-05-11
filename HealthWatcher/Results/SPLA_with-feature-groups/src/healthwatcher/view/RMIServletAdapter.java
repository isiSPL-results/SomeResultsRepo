
//#if 1931561646
// Compilation Unit of /RMIServletAdapter.java

package healthwatcher.view;

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

public class RMIServletAdapter implements IFacade
    , Serializable
{
    protected IFacadeRMITargetAdapter facade = null;
    protected void rmiInitExceptionHandling(Throwable exception)
    {
        String error =  "<p>****************************************************<br>" +
                        "Error during servlet initialization!<br>" +
                        "The exception message is:<br><dd>" + exception.getMessage() +
                        "<p>You may have to restart the servlet container.<br>" +
                        "*******************************************************";
        System.out.println(error);
    }

    public void updateComplaint(Complaint q) throws TransactionException, RepositoryException,
               ObjectNotFoundException, ObjectNotValidException, CommunicationException
    {
        try { //1
            facade.updateComplaint(q);
        }

//#if -1566315585
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try { //1
            return facade.searchComplaint(code);
        }

//#if 1671019710
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

    public void updateHealthUnit(HealthUnit unit) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException
    {
        try { //1
            facade.updateHealthUnit(unit);
        }

//#if 115277163
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException, CommunicationException
    {
        try { //1
            return facade.searchHealthUnitsBySpeciality(code);
        }

//#if 1433300242
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

    public void notify(Subject subject) throws TransactionException, ObjectNotFoundException,
        RepositoryException, RemoteException, ObjectNotValidException
    {
        try { //1
            if(subject instanceof Complaint) { //1
                Complaint complaint = (Complaint) subject;
                updateComplaint(complaint);
            } else

//#if 883795552
                if(subject instanceof Employee) { //1
                    Employee employee = (Employee) subject;
                    updateEmployee(employee);
                } else

//#if -996888953
                    if(subject instanceof HealthUnit) { //1
                        HealthUnit healthUnit = (HealthUnit) subject;
                        updateHealthUnit(healthUnit);
                    } else

//#if 1048684761
                        if(subject instanceof MedicalSpeciality) { //1
                            updateMedicalSpeciality((MedicalSpeciality) subject);
                        } else

//#if -840740959
                            if(subject instanceof Symptom) { //1
                                updateSymptom((Symptom) subject);
                            }

//#endif


//#endif


//#endif


//#endif


        }

//#if -417988979
        catch (Exception e) { //1
            e.printStackTrace();
        }

//#endif


    }

    public Employee searchEmployee(String login) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
        CommunicationException
    {
        try { //1
            return facade.searchEmployee(login);
        }

//#if 1068406858
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }


//#if 2060701463
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
        InsertEntryException, TransactionException, CommunicationException
    {
        try { //1
            facade.insert(e);
        }

//#if 2115783258
        catch (RemoteException ex) { //1
            throw new CommunicationException(ex.getMessage());
        }

//#endif


    }

//#endif

    public void connect(String server) throws CommunicationException
    {
        try { //1
            System.out.println("About to lookup...");
            facade= (IFacadeRMITargetAdapter) Naming.lookup(server);
            System.out.println("Remote DisqueSaude found");
        }

//#if 702281205
        catch (java.rmi.RemoteException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
            throw new CommunicationException(rmiEx.getMessage());
        }

//#endif


//#if -84232294
        catch (java.rmi.NotBoundException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
            throw new CommunicationException(rmiEx.getMessage());
        }

//#endif


//#if -157861836
        catch (java.net.MalformedURLException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
            throw new CommunicationException(rmiEx.getMessage());
        }

//#endif


    }


//#if 1313144549
    public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try { //1
            return facade.getSymptomList();
        }

//#if 86589165
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif


//#if 1812072677
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException
    {
        try { //1
            return facade.searchHealthUnit(healthUnitCode);
        }

//#if -1228850796
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif


//#if 332840107
    public MedicalSpeciality searchSpecialitiesByCode(int numSpeciality)
    throws ObjectNotFoundException, RepositoryException, CommunicationException,
        TransactionException
    {
        try { //1
            return facade.searchSpecialitiesByCode(numSpeciality);
        }

//#if 1588033537
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif


//#if 1122482782
    public Symptom searchSymptom(int numSymptom) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        try { //1
            return facade.searchSymptom(numSymptom);
        }

//#if -1289038722
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif

    public RMIServletAdapter(String server) throws CommunicationException
    {
        connect(server);
    }

    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, CommunicationException, TransactionException,
        ObjectNotValidException
    {
        try { //1
            return facade.insertComplaint(complaint);
        }

//#if 1608599596
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }


//#if -494883116
    public void insert(MedicalSpeciality speciality) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, InsertEntryException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            facade.insert(speciality);
        }

//#if -343035721
        catch (RemoteException ex) { //1
            throw new CommunicationException(ex.getMessage());
        }

//#endif


    }

//#endif


//#if 1381871289
    public void updateMedicalSpeciality(MedicalSpeciality speciality) throws RepositoryException,
        TransactionException, ObjectNotFoundException, CommunicationException,
        ObjectNotValidException
    {
        try { //1
            facade.updateMedicalSpeciality(speciality);
        }

//#if -1813951240
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif


//#if -40588731
    public void insert(Symptom symptom) throws ObjectAlreadyInsertedException,
        InsertEntryException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            facade.insert(symptom);
        }

//#if 2027940438
        catch (RemoteException ex) { //1
            throw new CommunicationException(ex.getMessage());
        }

//#endif


    }

//#endif

    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        try { //1
            return facade.searchSpecialitiesByHealthUnit(code);
        }

//#if 965161019
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }


//#if 1938370419
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            return facade.getComplaintList();
        }

//#if 455327301
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif


//#if 1490246617
    public void updateSymptom(Symptom symptom) throws RepositoryException, TransactionException,
        ObjectNotFoundException, CommunicationException, ObjectNotValidException
    {
        try { //1
            facade.updateSymptom(symptom);
        }

//#if 1644165729
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif


//#if -111860240
    public void insert(Employee e) throws ObjectAlreadyInsertedException, ObjectNotValidException,
        InsertEntryException, TransactionException, CommunicationException, RepositoryException
    {
        try { //1
            facade.insert(e);
        }

//#if 1617283436
        catch (RemoteException ex) { //1
            throw new CommunicationException(ex.getMessage());
        }

//#endif


    }

//#endif

    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try { //1
            return facade.getSpecialityList();
        }

//#if -1225446562
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }


//#if -525212269
    public void insert(HealthUnit us) throws InsertEntryException, ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException, CommunicationException, RepositoryException
    {
        try { //1
            facade.insert(us);
        }

//#if 1038408198
        catch (RemoteException ex) { //1
            throw new CommunicationException(ex.getMessage());
        }

//#endif


    }

//#endif


//#if 1029686680
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException, CommunicationException, TransactionException
    {
        try { //1
            return facade.searchHealthUnit(healthUnitCode);
        }

//#if -122865989
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif

    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
        ObjectNotFoundException, CommunicationException, TransactionException
    {
        try { //1
            return facade.searchDiseaseType(code);
        }

//#if -1181161135
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try { //1
            return facade.getDiseaseTypeList();
        }

//#if -1087383785
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }


//#if 1551114485
    public void insert(DiseaseType diseaseType) throws InsertEntryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException,
        CommunicationException, RepositoryException
    {
        try { //1
            facade.insert(diseaseType);
        }

//#if 2105269791
        catch (RemoteException ex) { //1
            throw new CommunicationException(ex.getMessage());
        }

//#endif


    }

//#endif

    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, CommunicationException, TransactionException
    {
        try { //1
            return facade.getPartialHealthUnitList();
        }

//#if -1257525994
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        CommunicationException, TransactionException
    {
        try { //1
            return facade.getHealthUnitList();
        }

//#if 1577733918
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }


//#if 648771610
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException,
        CommunicationException
    {
        try { //1
            return facade.getComplaintList();
        }

//#if 1600551464
        catch (RemoteException e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

//#endif

    public void updateEmployee(Employee e) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException, UpdateEntryException,
        CommunicationException
    {
        try { //1
            facade.updateEmployee(e);
        }

//#if 1176081174
        catch (RemoteException ex) { //1
            throw new CommunicationException(ex.getMessage());
        }

//#endif


    }

}


//#endif

