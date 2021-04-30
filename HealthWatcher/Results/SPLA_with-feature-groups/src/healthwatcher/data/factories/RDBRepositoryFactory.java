
//#if 835694403 
// Compilation Unit of /RDBRepositoryFactory.java 
 
package healthwatcher.data.factories;

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

public class RDBRepositoryFactory extends AbstractRepositoryFactory
  { 
protected IPersistenceMechanism pm = null;
public IEmployeeRepository createEmployeeRepository()
    { 
return new EmployeeRepositoryRDB(pm);
} 

public ISpecialityRepository createMedicalSpecialityRepository()
    { 
return new SpecialityRepositoryRDB(pm);
} 

public IHealthUnitRepository createHealthUnitRepository()
    { 
return new HealthUnitRepositoryRDB(pm);
} 

public IDiseaseRepository createDiseaseRepository()
    { 
return new DiseaseTypeRepositoryRDB(pm);
} 

public IComplaintRepository createComplaintRepository()
    { 
return new ComplaintRepositoryRDB(pm);
} 


//#if 1650814747 
public ISymptomRepository createSymptomRepository()
    { 
return new SymptomRepositoryRDB(pm);
} 

//#endif 

public RDBRepositoryFactory(IPersistenceMechanism pm)
    { 
this.pm = pm;
} 

 } 


//#endif 

