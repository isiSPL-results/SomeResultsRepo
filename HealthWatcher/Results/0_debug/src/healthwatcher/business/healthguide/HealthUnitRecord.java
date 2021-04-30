
//#if -670085588 
// Compilation Unit of /HealthUnitRecord.java 
 

//#if 1261130719 
package healthwatcher.business.healthguide;
//#endif 


//#if 894422351 
import healthwatcher.data.IHealthUnitRepository;
//#endif 


//#if -1674924533 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if 1891244 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -1163983962 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -2133740504 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1737431764 
import lib.util.ConcreteIterator;
//#endif 


//#if 455607745 
import lib.util.IteratorDsk;
//#endif 


//#if 219259467 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 2110229142 
public class HealthUnitRecord  { 

//#if 2142825986 
private IHealthUnitRepository healthUnitRep;
//#endif 


//#if 1821005630 
public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException
    { 

//#if 2129650815 
return healthUnitRep.getHealthUnitListBySpeciality(code);
//#endif 

} 

//#endif 


//#if -1554513902 
public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException
    { 

//#if -54104777 
return healthUnitRep.getPartialHealthUnitList();
//#endif 

} 

//#endif 


//#if 305080617 
public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException
    { 

//#if -639480045 
return healthUnitRep.getHealthUnitList();
//#endif 

} 

//#endif 


//#if 712670749 
public IteratorDsk searchSpecialityByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException
    { 

//#if 2017399140 
HealthUnit us = healthUnitRep.search(code);
//#endif 


//#if 38778054 
return new ConcreteIterator(us.getSpecialities());
//#endif 

} 

//#endif 


//#if 1827510545 
public void insert(HealthUnit us) throws ObjectNotValidException,
        ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    { 

//#if 1692353883 
healthUnitRep.insert(us);
//#endif 

} 

//#endif 


//#if 59096267 
public HealthUnitRecord(IHealthUnitRepository repUnidadeSaude)
    { 

//#if -1266659869 
this.healthUnitRep = repUnidadeSaude;
//#endif 

} 

//#endif 


//#if -1737815919 
public void update(HealthUnit unit) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    { 

//#if 1465210769 
healthUnitRep.update(unit);
//#endif 

} 

//#endif 


//#if 463342493 
public HealthUnit search(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException
    { 

//#if 1383160224 
return healthUnitRep.search(healthUnitCode);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

