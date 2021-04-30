
//#if -1524230215 
// Compilation Unit of /IAddressRepository.java 
 

//#if 1453548535 
package healthwatcher.data;
//#endif 


//#if 369955355 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 2014615004 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 848739798 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 949880408 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1485246067 
import healthwatcher.model.address.Address;
//#endif 


//#if 1370633483 
public interface IAddressRepository  { 

//#if -1868197974 
public boolean exists(int code) throws RepositoryException;
//#endif 


//#if 1945959337 
public Address search(int complaint) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -756074360 
public void update(Address address) throws ObjectNotValidException,
               ObjectNotFoundException, ObjectNotValidException, RepositoryException;
//#endif 


//#if 331946384 
public int insert(Address address) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
//#endif 


//#if 1101391661 
public void remove(int code) throws ObjectNotFoundException, RepositoryException;
//#endif 

 } 

//#endif 


//#endif 

