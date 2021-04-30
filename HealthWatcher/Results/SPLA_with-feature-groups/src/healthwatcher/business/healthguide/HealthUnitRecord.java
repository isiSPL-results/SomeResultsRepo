// Compilation Unit of /HealthUnitRecord.java 
 
package healthwatcher.business.healthguide;
import healthwatcher.data.IHealthUnitRepository;
import healthwatcher.model.healthguide.HealthUnit;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;

//#if 219259467 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 

public class HealthUnitRecord  { 
private IHealthUnitRepository healthUnitRep;
public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
        RepositoryException
    { 
return healthUnitRep.getHealthUnitListBySpeciality(code);
} 

public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException
    { 
return healthUnitRep.getPartialHealthUnitList();
} 

public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException
    { 
return healthUnitRep.getHealthUnitList();
} 

public IteratorDsk searchSpecialityByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException
    { 
HealthUnit us = healthUnitRep.search(code);
return new ConcreteIterator(us.getSpecialities());
} 


//#if 1827510545 
public void insert(HealthUnit us) throws ObjectNotValidException,
        ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    { 
healthUnitRep.insert(us);
} 

//#endif 

public HealthUnitRecord(IHealthUnitRepository repUnidadeSaude)
    { 
this.healthUnitRep = repUnidadeSaude;
} 

public void update(HealthUnit unit) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    { 
healthUnitRep.update(unit);
} 

public HealthUnit search(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException
    { 
return healthUnitRep.search(healthUnitCode);
} 

 } 


