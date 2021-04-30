package healthwatcher.data.factories;
import healthwatcher.data.IComplaintRepository;
import healthwatcher.data.IDiseaseRepository;
import healthwatcher.data.IEmployeeRepository;
import healthwatcher.data.IHealthUnitRepository;
import healthwatcher.data.ISpecialityRepository;
public abstract class AbstractRepositoryFactory  { 
public abstract IDiseaseRepository createDiseaseRepository();public abstract ISpecialityRepository createMedicalSpecialityRepository();public abstract IComplaintRepository createComplaintRepository();public abstract IHealthUnitRepository createHealthUnitRepository();public abstract IEmployeeRepository createEmployeeRepository();
 } 
