
//#if 472599367 
// Compilation Unit of /IHealthUnitRepository.java 
 

//#if -583094901 
package healthwatcher.data;
//#endif 


//#if -2121479505 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 222993352 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -942881854 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 1228661316 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1151915229 
import lib.util.IteratorDsk;
//#endif 


//#if -570228697 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if 123239473 
public interface IHealthUnitRepository  { 

//#if 2126791219 
public HealthUnit search(int code) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -1702603861 
public IteratorDsk getHealthUnitListBySpeciality(int codEspecialidade)
    throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -1846323075 
public boolean exists(int num) throws RepositoryException;
//#endif 


//#if 212106163 
public IteratorDsk getHealthUnitList() throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -1092274237 
public void remove(int code) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if 1421660368 
public void update(HealthUnit us) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException;
//#endif 


//#if -1745065144 
public IteratorDsk getPartialHealthUnitList() throws ObjectNotFoundException,
               RepositoryException;
//#endif 


//#if -154566073 
public void insert(HealthUnit us) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
//#endif 

 } 

//#endif 


//#endif 

