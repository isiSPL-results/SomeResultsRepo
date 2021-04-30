package healthwatcher.data;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
import healthwatcher.model.healthguide.HealthUnit;
public interface IHealthUnitRepository  { 
public HealthUnit search(int code) throws ObjectNotFoundException, RepositoryException;public IteratorDsk getHealthUnitListBySpeciality(int codEspecialidade)
    throws ObjectNotFoundException, RepositoryException;public boolean exists(int num) throws RepositoryException;public IteratorDsk getHealthUnitList() throws ObjectNotFoundException, RepositoryException;public void remove(int code) throws ObjectNotFoundException, RepositoryException;public void update(HealthUnit us) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException;public IteratorDsk getPartialHealthUnitList() throws ObjectNotFoundException,
               RepositoryException;public void insert(HealthUnit us) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
 } 
