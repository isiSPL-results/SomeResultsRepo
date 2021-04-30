
//#if 1331571812 
// Compilation Unit of /ISymptomRepository.java 
 

//#if 282524647 
package healthwatcher.data;
//#endif 


//#if -489894025 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if 862035467 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -802383892 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -1968259098 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -190214040 
import lib.exceptions.RepositoryException;
//#endif 


//#if -2078649855 
import lib.util.IteratorDsk;
//#endif 


//#if 1813996304 
public interface ISymptomRepository  { 

//#if -405411180 
public boolean exists(int code) throws RepositoryException;
//#endif 


//#if -1461696581 
public void insert(Symptom s) throws ObjectNotValidException, ObjectAlreadyInsertedException,
               ObjectNotValidException, RepositoryException;
//#endif 


//#if 1112433283 
public void remove(int code) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -1336068458 
public Symptom search(int code) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if 2107637212 
public void update(Symptom s) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException;
//#endif 


//#if 35905280 
public IteratorDsk getSymptomList() throws ObjectNotFoundException, RepositoryException;
//#endif 

 } 

//#endif 


//#endif 

