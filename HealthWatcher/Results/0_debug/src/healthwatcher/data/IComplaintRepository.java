
//#if 1145085886 
// Compilation Unit of /IComplaintRepository.java 
 

//#if 1632231047 
package healthwatcher.data;
//#endif 


//#if 1556641963 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -1696566964 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1432525126 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 855710152 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1107542881 
import lib.util.IteratorDsk;
//#endif 


//#if -789731691 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 860474674 
public interface IComplaintRepository  { 

//#if -42944787 
public void remove(int code) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -996402008 
public void update(Complaint complaint) throws ObjectNotValidException,
               ObjectNotFoundException, ObjectNotValidException, RepositoryException;
//#endif 


//#if 1795382120 
public IteratorDsk getComplaintList() throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if -594462352 
public int insert(Complaint complaint) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
//#endif 


//#if -2044929582 
public Complaint search(int complaint) throws ObjectNotFoundException, RepositoryException;
//#endif 


//#if 1207986154 
public boolean exists(int code) throws RepositoryException;
//#endif 

 } 

//#endif 


//#endif 

