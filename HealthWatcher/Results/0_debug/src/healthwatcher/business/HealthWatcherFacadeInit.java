
//#if -710023711
// Compilation Unit of /HealthWatcherFacadeInit.java


//#if -173249610
package healthwatcher.business;
//#endif


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


//#if 201571914
public class HealthWatcherFacadeInit
{

//#if 192656664
    private ComplaintRecord complaintRecord;
//#endif


//#if 1751586742
    private HealthUnitRecord healthUnitRecord;
//#endif


//#if -1494776735
    private MedicalSpecialityRecord specialityRecord;
//#endif


//#if -288029960
    private DiseaseRecord diseaseRecord;
//#endif


//#if 1627872666
    private EmployeeRecord employeeRecord;
//#endif


//#if 2136981188
    public DiseaseType searchDiseaseType(int code) throws RepositoryException,
               ObjectNotFoundException, TransactionException
    {

//#if 1391388236
        DiseaseType tp = null;
//#endif


//#if -1592715469
        try { //1

//#if -18248670
            getPm().beginTransaction();
//#endif


//#if -511120602
            tp = this.diseaseRecord.search(code);
//#endif


//#if -319571690
            getPm().commitTransaction();
//#endif

        }

//#if -765513797
        catch (RepositoryException e) { //1

//#if 1157273570
            getPm().rollbackTransaction();
//#endif


//#if 1141646772
            throw e;
//#endif

        }

//#endif


//#if -1595233271
        catch (TransactionException e) { //1

//#if -571946259
            getPm().rollbackTransaction();
//#endif


//#if 1956758281
            throw e;
//#endif

        }

//#endif


//#if 1871223999
        catch (ObjectNotFoundException e) { //1

//#if -1318953799
            getPm().rollbackTransaction();
//#endif


//#if 134039229
            throw e;
//#endif

        }

//#endif


//#if 2143358353
        catch (Exception e) { //1

//#if 1146020328
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if -2019276686
        return tp;
//#endif

    }

//#endif


//#if -2079662059
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {

//#if 214208253
        IteratorDsk lista = null;
//#endif


//#if 1467069447
        try { //1

//#if 567623210
            getPm().beginTransaction();
//#endif


//#if -1996292959
            lista = specialityRecord.getListaEspecialidade();
//#endif


//#if 662587406
            getPm().commitTransaction();
//#endif

        }

//#if 508832093
        catch (RepositoryException e) { //1

//#if 236352960
            getPm().rollbackTransaction();
//#endif


//#if 864094614
            throw e;
//#endif

        }

//#endif


//#if -745216345
        catch (TransactionException e) { //1

//#if -177966043
            getPm().rollbackTransaction();
//#endif


//#if 1095637201
            throw e;
//#endif

        }

//#endif


//#if 1598289249
        catch (ObjectNotFoundException e) { //1

//#if 1950062994
            getPm().rollbackTransaction();
//#endif


//#if -872461820
            throw e;
//#endif

        }

//#endif


//#if 1198606771
        catch (Exception e) { //1

//#if -1527044863
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if 1107362521
        return lista;
//#endif

    }

//#endif


//#if -809000612
    public void insert(Employee employee) throws ObjectAlreadyInsertedException,
        ObjectNotValidException, TransactionException
    {

//#if -1457003063
        try { //1

//#if 760787458
            getPm().beginTransaction();
//#endif


//#if 1517675273
            employeeRecord.insert(employee);
//#endif


//#if -1939255498
            getPm().commitTransaction();
//#endif

        }

//#if -676966250
        catch (ObjectAlreadyInsertedException e) { //1

//#if -1507417575
            getPm().rollbackTransaction();
//#endif


//#if -1971090083
            throw e;
//#endif

        }

//#endif


//#if 1669412959
        catch (ObjectNotValidException e) { //1

//#if -1110507233
            getPm().rollbackTransaction();
//#endif


//#if -1177805545
            throw e;
//#endif

        }

//#endif


//#if 457039139
        catch (TransactionException e) { //1

//#if -232601150
            getPm().rollbackTransaction();
//#endif


//#if -335638572
            throw e;
//#endif

        }

//#endif


//#if -1270773577
        catch (Exception e) { //1

//#if 390359191
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -18449820
    public Complaint searchComplaint(int code) throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {

//#if -1425173499
        Complaint q = null;
//#endif


//#if -1771531650
        try { //1

//#if 548252241
            getPm().beginTransaction();
//#endif


//#if -532114973
            q = this.complaintRecord.search(code);
//#endif


//#if 62087367
            getPm().commitTransaction();
//#endif

        }

//#if 907558304
        catch (RepositoryException e) { //1

//#if 1112747875
            getPm().rollbackTransaction();
//#endif


//#if 449162067
            throw e;
//#endif

        }

//#endif


//#if -1269605692
        catch (TransactionException e) { //1

//#if 1195078601
            getPm().rollbackTransaction();
//#endif


//#if -1901272659
            throw e;
//#endif

        }

//#endif


//#if 311308324
        catch (ObjectNotFoundException e) { //1

//#if 8598561
            getPm().rollbackTransaction();
//#endif


//#if -1655659435
            throw e;
//#endif

        }

//#endif


//#if 1754416566
        catch (Exception e) { //1

//#if 1328344666
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if 445393122
        return q;
//#endif

    }

//#endif


//#if -1558597568
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {

//#if -221127403
        IteratorDsk lista = null;
//#endif


//#if 1246638623
        try { //1

//#if 660035860
            getPm().beginTransaction();
//#endif


//#if -536874830
            lista = healthUnitRecord.getHealthUnitList();
//#endif


//#if -767587740
            getPm().commitTransaction();
//#endif

        }

//#if -1786620876
        catch (RepositoryException e) { //1

//#if 1440422874
            getPm().rollbackTransaction();
//#endif


//#if -209536836
            throw e;
//#endif

        }

//#endif


//#if 1110185648
        catch (TransactionException e) { //1

//#if -598534353
            getPm().rollbackTransaction();
//#endif


//#if 1048811783
            throw e;
//#endif

        }

//#endif


//#if -350036808
        catch (ObjectNotFoundException e) { //1

//#if 1894877619
            getPm().rollbackTransaction();
//#endif


//#if 1309321987
            throw e;
//#endif

        }

//#endif


//#if -1319647926
        catch (Exception e) { //1

//#if 754092112
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if -425947407
        return lista;
//#endif

    }

//#endif


//#if -1439272289
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {

//#if -1428493290
        IteratorDsk lista = null;
//#endif


//#if 271541024
        try { //1

//#if 527763083
            getPm().beginTransaction();
//#endif


//#if 844980078
            lista = healthUnitRecord.getPartialHealthUnitList();
//#endif


//#if -573076531
            getPm().commitTransaction();
//#endif

        }

//#if 319649953
        catch (RepositoryException e) { //1

//#if 1647025026
            getPm().rollbackTransaction();
//#endif


//#if -175196652
            throw e;
//#endif

        }

//#endif


//#if 1980071907
        catch (TransactionException e) { //1

//#if 1706843155
            getPm().rollbackTransaction();
//#endif


//#if 933561507
            throw e;
//#endif

        }

//#endif


//#if -1401159003
        catch (ObjectNotFoundException e) { //1

//#if 62759845
            getPm().rollbackTransaction();
//#endif


//#if 615799121
            throw e;
//#endif

        }

//#endif


//#if 837033463
        catch (Exception e) { //1

//#if 1683072899
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if 1174092594
        return lista;
//#endif

    }

//#endif


//#if 1399345315
    public int insertComplaint(Complaint complaint) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException, TransactionException
    {

//#if 1851897612
        int retorno = 0;
//#endif


//#if -1338335236
        try { //1

//#if 1783310837
            getPm().beginTransaction();
//#endif


//#if -1999560146
            retorno = complaintRecord.insert(complaint);
//#endif


//#if -305801821
            getPm().commitTransaction();
//#endif

        }

//#if -821109042
        catch (ObjectAlreadyInsertedException e) { //1

//#if -1947649227
            getPm().rollbackTransaction();
//#endif


//#if -759692351
            throw e;
//#endif

        }

//#endif


//#if 506706215
        catch (ObjectNotValidException e) { //1

//#if -1199833243
            getPm().rollbackTransaction();
//#endif


//#if -796772975
            throw e;
//#endif

        }

//#endif


//#if -1743349719
        catch (RepositoryException e) { //1

//#if -1951357655
            getPm().rollbackTransaction();
//#endif


//#if 52149325
            throw e;
//#endif

        }

//#endif


//#if -1843375781
        catch (TransactionException e) { //1

//#if -639278193
            getPm().rollbackTransaction();
//#endif


//#if -675825497
            throw e;
//#endif

        }

//#endif


//#endif


//#if 723313228
        return retorno;
//#endif

    }

//#endif


//#if 890730925
    public void updateComplaint(Complaint complaint) throws TransactionException,
        RepositoryException, ObjectNotFoundException, ObjectNotValidException
    {

//#if -1401006901
        try { //1

//#if 1826953386
            getPm().beginTransaction();
//#endif


//#if -1704753647
            complaintRecord.update(complaint);
//#endif


//#if 1047117198
            getPm().commitTransaction();
//#endif

        }

//#if -819312662
        catch (RepositoryException e) { //1

//#if 933943453
            getPm().rollbackTransaction();
//#endif


//#if -1286513831
            throw e;
//#endif

        }

//#endif


//#if 1671300462
        catch (ObjectNotFoundException e) { //1

//#if -2101488158
            getPm().rollbackTransaction();
//#endif


//#if -1248417868
            throw e;
//#endif

        }

//#endif


//#if 1031969210
        catch (TransactionException e) { //1

//#if -765839963
            getPm().rollbackTransaction();
//#endif


//#if -2108422319
            throw e;
//#endif

        }

//#endif


//#if -139148160
        catch (Exception e) { //1

//#if 1696656895
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 492302754
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, TransactionException
    {

//#if -146290716
        IteratorDsk list = null;
//#endif


//#if -1730998955
        try { //1

//#if -325371201
            getPm().beginTransaction();
//#endif


//#if 1685079106
            list = complaintRecord.getComplaintList();
//#endif


//#if -1250435559
            getPm().commitTransaction();
//#endif

        }

//#if 1632387402
        catch (ObjectNotFoundException e) { //1

//#if -442007537
            getPm().rollbackTransaction();
//#endif


//#if 737913895
            throw e;
//#endif

        }

//#endif


//#if 1733643102
        catch (TransactionException e) { //1

//#if 1645612078
            getPm().rollbackTransaction();
//#endif


//#if 1351784168
            throw e;
//#endif

        }

//#endif


//#if -1910460068
        catch (Exception e) { //1

//#if 1813614761
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if -364021522
        return list;
//#endif

    }

//#endif


//#if -1511517965
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {

//#if 307696237
        IteratorDsk lista = null;
//#endif


//#if 265885559
        try { //1

//#if -1775861366
            getPm().beginTransaction();
//#endif


//#if -84029486
            lista = healthUnitRecord.searchHealthUnitsBySpeciality(code);
//#endif


//#if 1029009582
            getPm().commitTransaction();
//#endif

        }

//#if 1666004874
        catch (RepositoryException e) { //1

//#if -1474469655
            getPm().rollbackTransaction();
//#endif


//#if -202950515
            throw e;
//#endif

        }

//#endif


//#if 767401498
        catch (TransactionException e) { //1

//#if -605248031
            getPm().rollbackTransaction();
//#endif


//#if 330574485
            throw e;
//#endif

        }

//#endif


//#if 1199580430
        catch (ObjectNotFoundException e) { //1

//#if -1106422097
            getPm().rollbackTransaction();
//#endif


//#if 578472327
            throw e;
//#endif

        }

//#endif


//#if 1915796512
        catch (Exception e) { //1

//#if -393220558
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if -20180407
        return lista;
//#endif

    }

//#endif


//#if 594079214
    public IteratorDsk searchSpecialitiesByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException, TransactionException
    {

//#if 1619503204
        IteratorDsk lista = null;
//#endif


//#if -615875730
        try { //1

//#if -495744870
            getPm().beginTransaction();
//#endif


//#if 841509057
            lista = healthUnitRecord.searchSpecialityByHealthUnit(code);
//#endif


//#if 2057915294
            getPm().commitTransaction();
//#endif

        }

//#if -1187083552
        catch (RepositoryException e) { //1

//#if 330756409
            getPm().rollbackTransaction();
//#endif


//#if 1796588093
            throw e;
//#endif

        }

//#endif


//#if -1778993788
        catch (TransactionException e) { //1

//#if 1974722479
            getPm().rollbackTransaction();
//#endif


//#if 1866096775
            throw e;
//#endif

        }

//#endif


//#if -750002844
        catch (ObjectNotFoundException e) { //1

//#if -912321336
            getPm().rollbackTransaction();
//#endif


//#if 1215083406
            throw e;
//#endif

        }

//#endif


//#endif


//#if -997564160
        return lista;
//#endif

    }

//#endif


//#if -1348428558
    public void update(Employee employee) throws TransactionException, RepositoryException,
        ObjectNotFoundException, ObjectNotValidException
    {

//#if -156369007
        try { //1

//#if -720416939
            getPm().beginTransaction();
//#endif


//#if -1268727418
            employeeRecord.update(employee);
//#endif


//#if -611951549
            getPm().commitTransaction();
//#endif

        }

//#if -1065333207
        catch (TransactionException e) { //1

//#if -1577595239
            getPm().rollbackTransaction();
//#endif


//#if -295014179
            throw e;
//#endif

        }

//#endif


//#if -765468263
        catch (ObjectNotValidException e) { //1

//#if 2067975136
            getPm().rollbackTransaction();
//#endif


//#if 1135810422
            throw e;
//#endif

        }

//#endif


//#if -175749473
        catch (ObjectNotFoundException e) { //1

//#if 1501347109
            getPm().rollbackTransaction();
//#endif


//#if 244576209
            throw e;
//#endif

        }

//#endif


//#if 1633386353
        catch (Exception e) { //1

//#if -970703133
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -422359710
    public HealthWatcherFacadeInit()
    {

//#if 1851532627
        this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryArray());
//#endif


//#if 276285867
        if(Constants.isPersistent()) { //1

//#if -1236544198
            this.complaintRecord = new ComplaintRecord(new ComplaintRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
//#endif

        }

//#endif


//#if 477424222
        this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryArray());
//#endif


//#if 1675001126
        if(Constants.isPersistent()) { //2

//#if 660750641
            this.healthUnitRecord = new HealthUnitRecord(new HealthUnitRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
//#endif

        }

//#endif


//#if 1136722510
        this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryArray());
//#endif


//#if 1675030918
        if(Constants.isPersistent()) { //3

//#if -1440259764
            this.specialityRecord = new MedicalSpecialityRecord(new SpecialityRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
//#endif

        }

//#endif


//#if -353713664
        DiseaseTypeRepositoryArray tp = new DiseaseTypeRepositoryArray();
//#endif


//#if -615487566
        this.diseaseRecord = new DiseaseRecord(tp);
//#endif


//#if 1675060710
        if(Constants.isPersistent()) { //4

//#if 1217007838
            this.diseaseRecord = new DiseaseRecord(new DiseaseTypeRepositoryRDB(
                    (PersistenceMechanism) HealthWatcherFacade.getPm()));
//#endif

        }

//#endif


//#if -1050415391
        EmployeeRepositoryArray er = new EmployeeRepositoryArray();
//#endif


//#if 1598777183
        this.employeeRecord = new EmployeeRecord(er);
//#endif


//#if 1675090502
        if(Constants.isPersistent()) { //5

//#if 568616720
            this.employeeRecord = new EmployeeRecord(new EmployeeRepositoryRDB(
                        (PersistenceMechanism) HealthWatcherFacade.getPm()));
//#endif

        }

//#endif

    }

//#endif


//#if -396110925
    public void updateHealthUnit(HealthUnit unit) throws RepositoryException,
        ObjectNotFoundException, TransactionException
    {

//#if 392349908
        try { //1

//#if 1141240809
            getPm().beginTransaction();
//#endif


//#if 1245599130
            healthUnitRecord.update(unit);
//#endif


//#if 1264863791
            getPm().commitTransaction();
//#endif

        }

//#if 1655925290
        catch (RepositoryException e) { //1

//#if 756706403
            getPm().rollbackTransaction();
//#endif


//#if 371134035
            throw e;
//#endif

        }

//#endif


//#if -313784402
        catch (ObjectNotFoundException e) { //1

//#if -648823402
            getPm().rollbackTransaction();
//#endif


//#if -222930304
            throw e;
//#endif

        }

//#endif


//#if 454934394
        catch (TransactionException e) { //1

//#if -205734174
            getPm().rollbackTransaction();
//#endif


//#if 216653492
            throw e;
//#endif

        }

//#endif


//#if 328709824
        catch (Exception e) { //1

//#if 592463627
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -141326103
    public HealthUnit searchHealthUnit(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException
    {

//#if 397618917
        return healthUnitRecord.search(healthUnitCode);
//#endif

    }

//#endif


//#if -1057673516
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException,
        TransactionException
    {

//#if 1867957113
        IteratorDsk lista = null;
//#endif


//#if 177496195
        try { //1

//#if -1399818787
            getPm().beginTransaction();
//#endif


//#if 184754867
            lista = this.diseaseRecord.getDiseaseTypeList();
//#endif


//#if -198572357
            getPm().commitTransaction();
//#endif

        }

//#if -878111550
        catch (RepositoryException e) { //1

//#if 648160295
            getPm().rollbackTransaction();
//#endif


//#if 435274511
            throw e;
//#endif

        }

//#endif


//#if -790796318
        catch (TransactionException e) { //1

//#if 1746625578
            getPm().rollbackTransaction();
//#endif


//#if 456755820
            throw e;
//#endif

        }

//#endif


//#if 934979142
        catch (ObjectNotFoundException e) { //1

//#if 716328310
            getPm().rollbackTransaction();
//#endif


//#if -524015968
            throw e;
//#endif

        }

//#endif


//#if -468893864
        catch (Exception e) { //1

//#if -1150801792
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if -487103915
        return lista;
//#endif

    }

//#endif


//#if -395953222
    public IPersistenceMechanism getPm()
    {

//#if -319157657
        return HealthWatcherFacade.getPm();
//#endif

    }

//#endif


//#if 670574485
    public Employee searchEmployee(String login) throws ObjectNotFoundException,
        TransactionException
    {

//#if 1490041286
        Employee employee = null;
//#endif


//#if 1164056201
        try { //1

//#if -897883269
            getPm().beginTransaction();
//#endif


//#if -1991963221
            employee = employeeRecord.search(login);
//#endif


//#if -1818440483
            getPm().commitTransaction();
//#endif


//#if 1911448461
            return employee;
//#endif

        }

//#if 1589235471
        catch (TransactionException e) { //1

//#if 1423761239
            getPm().rollbackTransaction();
//#endif


//#if -939663905
            throw e;
//#endif

        }

//#endif


//#if -1153084423
        catch (ObjectNotFoundException e) { //1

//#if -1387026560
            getPm().rollbackTransaction();
//#endif


//#if 961073110
            throw e;
//#endif

        }

//#endif


//#if -1387687349
        catch (Exception e) { //1

//#if -812760340
            getPm().rollbackTransaction();
//#endif

        }

//#endif


//#endif


//#if -998054486
        return employee;
//#endif

    }

//#endif

}

//#endif


//#endif

