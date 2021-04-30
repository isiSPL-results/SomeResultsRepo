package healthwatcher.data.factories;
import healthwatcher.data.IComplaintRepository;
import healthwatcher.data.IDiseaseRepository;
import healthwatcher.data.IEmployeeRepository;
import healthwatcher.data.IHealthUnitRepository;
import healthwatcher.data.ISpecialityRepository;
import healthwatcher.data.rdb.ComplaintRepositoryRDB;
import healthwatcher.data.rdb.DiseaseTypeRepositoryRDB;
import healthwatcher.data.rdb.EmployeeRepositoryRDB;
import healthwatcher.data.rdb.HealthUnitRepositoryRDB;
import healthwatcher.data.rdb.SpecialityRepositoryRDB;
import lib.persistence.IPersistenceMechanism;
import healthwatcher.data.ISymptomRepository;
import healthwatcher.data.rdb.SymptomRepositoryRDB;
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
public ISymptomRepository createSymptomRepository()
    { 
return new SymptomRepositoryRDB(pm);
} 
public RDBRepositoryFactory(IPersistenceMechanism pm)
    { 
this.pm = pm;
} 

 } 
