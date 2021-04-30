package healthwatcher.data.factories;
import healthwatcher.data.IComplaintRepository;
import healthwatcher.data.IDiseaseRepository;
import healthwatcher.data.IEmployeeRepository;
import healthwatcher.data.IHealthUnitRepository;
import healthwatcher.data.ISpecialityRepository;
import healthwatcher.data.mem.ComplaintRepositoryArray;
import healthwatcher.data.mem.DiseaseTypeRepositoryArray;
import healthwatcher.data.mem.EmployeeRepositoryArray;
import healthwatcher.data.mem.HealthUnitRepositoryArray;
import healthwatcher.data.mem.SpecialityRepositoryArray;
import healthwatcher.data.ISymptomRepository;
import healthwatcher.data.mem.SymptomRepositoryArray;
public class ArrayRepositoryFactory extends AbstractRepositoryFactory
  { 
public IHealthUnitRepository createHealthUnitRepository()
    { 
return new HealthUnitRepositoryArray();
} 
public IComplaintRepository createComplaintRepository()
    { 
return new ComplaintRepositoryArray();
} 
public ISymptomRepository createSymptomRepository()
    { 
return new SymptomRepositoryArray();
} 
public IDiseaseRepository createDiseaseRepository()
    { 
return new DiseaseTypeRepositoryArray();
} 
public IEmployeeRepository createEmployeeRepository()
    { 
return new EmployeeRepositoryArray();
} 
public ISpecialityRepository createMedicalSpecialityRepository()
    { 
return new SpecialityRepositoryArray();
} 

 } 
