
//#if 616965462 
// Compilation Unit of /AbstractRepositoryFactory.java 
 
package healthwatcher.data.factories;

//#if -384137679 
import healthwatcher.data.IComplaintRepository;
//#endif 


//#if 1109427072 
import healthwatcher.data.IDiseaseRepository;
//#endif 


//#if 1231011736 
import healthwatcher.data.IEmployeeRepository;
//#endif 


//#if -1898474554 
import healthwatcher.data.IHealthUnitRepository;
//#endif 


//#if -937923247 
import healthwatcher.data.ISpecialityRepository;
//#endif 


//#if -1421604685 
import healthwatcher.data.ISymptomRepository;
//#endif 

public abstract class AbstractRepositoryFactory  { 
public abstract IDiseaseRepository createDiseaseRepository();
public abstract ISpecialityRepository createMedicalSpecialityRepository();
public abstract IComplaintRepository createComplaintRepository();
public abstract IHealthUnitRepository createHealthUnitRepository();
public abstract IEmployeeRepository createEmployeeRepository();

//#if 1855699223 
public abstract ISymptomRepository createSymptomRepository();
//#endif 

 } 


//#endif 

