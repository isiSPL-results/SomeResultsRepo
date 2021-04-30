
//#if -429036845 
// Compilation Unit of /ArrayRepositoryFactory.java 
 

//#if -977315529 
package healthwatcher.data.factories;
//#endif 


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


//#if -573765086 
public class ArrayRepositoryFactory extends 
//#if 2129119234 
AbstractRepositoryFactory
//#endif 

  { 

//#if 21169237 
public IHealthUnitRepository createHealthUnitRepository()
    { 

//#if -58821095 
return new HealthUnitRepositoryArray();
//#endif 

} 

//#endif 


//#if -34472471 
public IComplaintRepository createComplaintRepository()
    { 

//#if -381007012 
return new ComplaintRepositoryArray();
//#endif 

} 

//#endif 


//#if 1811632617 
public ISymptomRepository createSymptomRepository()
    { 

//#if -1338420017 
return new SymptomRepositoryArray();
//#endif 

} 

//#endif 


//#if 1391088777 
public IDiseaseRepository createDiseaseRepository()
    { 

//#if -386092917 
return new DiseaseTypeRepositoryArray();
//#endif 

} 

//#endif 


//#if 1672607025 
public IEmployeeRepository createEmployeeRepository()
    { 

//#if -1675134209 
return new EmployeeRepositoryArray();
//#endif 

} 

//#endif 


//#if -84391214 
public ISpecialityRepository createMedicalSpecialityRepository()
    { 

//#if -1206325292 
return new SpecialityRepositoryArray();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

