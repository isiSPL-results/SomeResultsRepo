
//#if 835694403
// Compilation Unit of /RDBRepositoryFactory.java


//#if -1117022941
package healthwatcher.data.factories;
//#endif


//#if 1290255230
import healthwatcher.data.IComplaintRepository;
//#endif


//#if -1503352819
import healthwatcher.data.IDiseaseRepository;
//#endif


//#if 1839213739
import healthwatcher.data.IEmployeeRepository;
//#endif


//#if -1531901927
import healthwatcher.data.IHealthUnitRepository;
//#endif


//#if -571350620
import healthwatcher.data.ISpecialityRepository;
//#endif


//#if 1242705905
import healthwatcher.data.rdb.ComplaintRepositoryRDB;
//#endif


//#if 1529715356
import healthwatcher.data.rdb.DiseaseTypeRepositoryRDB;
//#endif


//#if -1132438990
import healthwatcher.data.rdb.EmployeeRepositoryRDB;
//#endif


//#if 2025246276
import healthwatcher.data.rdb.HealthUnitRepositoryRDB;
//#endif


//#if 442139865
import healthwatcher.data.rdb.SpecialityRepositoryRDB;
//#endif


//#if -841127371
import lib.persistence.IPersistenceMechanism;
//#endif


//#if 260582720
import healthwatcher.data.ISymptomRepository;
//#endif


//#if 695092527
import healthwatcher.data.rdb.SymptomRepositoryRDB;
//#endif


//#if -1867914177
public class RDBRepositoryFactory extends
//#if -1708401868
    AbstractRepositoryFactory
//#endif

{

//#if -706278925
    protected IPersistenceMechanism pm = null;
//#endif


//#if 1745456611
    public IEmployeeRepository createEmployeeRepository()
    {

//#if -973362958
        return new EmployeeRepositoryRDB(pm);
//#endif

    }

//#endif


//#if 2113318624
    public ISpecialityRepository createMedicalSpecialityRepository()
    {

//#if -763437797
        return new SpecialityRepositoryRDB(pm);
//#endif

    }

//#endif


//#if 1775956999
    public IHealthUnitRepository createHealthUnitRepository()
    {

//#if 861134070
        return new HealthUnitRepositoryRDB(pm);
//#endif

    }

//#endif


//#if 1230270907
    public IDiseaseRepository createDiseaseRepository()
    {

//#if 88669198
        return new DiseaseTypeRepositoryRDB(pm);
//#endif

    }

//#endif


//#if 1254502939
    public IComplaintRepository createComplaintRepository()
    {

//#if 1601840752
        return new ComplaintRepositoryRDB(pm);
//#endif

    }

//#endif


//#if 1650814747
    public ISymptomRepository createSymptomRepository()
    {

//#if 1869935270
        return new SymptomRepositoryRDB(pm);
//#endif

    }

//#endif


//#if -1430121106
    public RDBRepositoryFactory(IPersistenceMechanism pm)
    {

//#if 1605783962
        this.pm = pm;
//#endif

    }

//#endif

}

//#endif


//#endif

