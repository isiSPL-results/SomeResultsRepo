
//#if -429036845 
// Compilation Unit of /ArrayRepositoryFactory.java 
 
package healthwatcher.data.factories;

//#if 70547090 
import healthwatcher.data.IComplaintRepository;
//#endif 


//#if -1509091295 
import healthwatcher.data.IDiseaseRepository;
//#endif 


//#if 1661320983 
import healthwatcher.data.IEmployeeRepository;
//#endif 


//#if -688148603 
import healthwatcher.data.IHealthUnitRepository;
//#endif 


//#if 272402704 
import healthwatcher.data.ISpecialityRepository;
//#endif 


//#if -900076063 
import healthwatcher.data.mem.ComplaintRepositoryArray;
//#endif 


//#if 1125789580 
import healthwatcher.data.mem.DiseaseTypeRepositoryArray;
//#endif 


//#if 1905508432 
import healthwatcher.data.mem.EmployeeRepositoryArray;
//#endif 


//#if 72804898 
import healthwatcher.data.mem.HealthUnitRepositoryArray;
//#endif 


//#if -874033289 
import healthwatcher.data.mem.SpecialityRepositoryArray;
//#endif 


//#if 254844244 
import healthwatcher.data.ISymptomRepository;
//#endif 


//#if 1534485983 
import healthwatcher.data.mem.SymptomRepositoryArray;
//#endif 

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


//#if 1811632617 
public ISymptomRepository createSymptomRepository()
    { 
return new SymptomRepositoryArray();
} 

//#endif 

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


//#endif 

