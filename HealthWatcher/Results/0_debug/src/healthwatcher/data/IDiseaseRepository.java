
//#if -1720697704 
// Compilation Unit of /IDiseaseRepository.java 
 

//#if 1951511605 
package healthwatcher.data;
//#endif 


//#if -1927712551 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -1680461602 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1448630488 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 2144957018 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1879661709 
import lib.util.IteratorDsk;
//#endif 


//#if 545291192 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if -508309867 
public interface IDiseaseRepository  { 

//#if -23619893 
public void update(DiseaseType td) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException;
//#endif 


//#if 1069206496 
public DiseaseType search(int code) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -1391170036 
public void insert(DiseaseType td) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
//#endif 


//#if 543643958 
public IteratorDsk getDiseaseTypeList() throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if 620329777 
public boolean exists(int code) throws RepositoryException;
//#endif 

 } 

//#endif 


//#endif 

