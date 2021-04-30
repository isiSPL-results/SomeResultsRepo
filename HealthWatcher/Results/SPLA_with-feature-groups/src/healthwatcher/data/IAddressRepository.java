// Compilation Unit of /IAddressRepository.java 
 
package healthwatcher.data;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import healthwatcher.model.address.Address;
public interface IAddressRepository  { 
public boolean exists(int code) throws RepositoryException;
public Address search(int complaint) throws ObjectNotFoundException, RepositoryException;
public void update(Address address) throws ObjectNotValidException,
               ObjectNotFoundException, ObjectNotValidException, RepositoryException;
public int insert(Address address) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
public void remove(int code) throws ObjectNotFoundException, RepositoryException;
 } 


