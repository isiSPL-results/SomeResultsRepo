package healthwatcher.data;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
import healthwatcher.model.complaint.Complaint;
public interface IComplaintRepository  { 
public void remove(int code) throws ObjectNotFoundException, RepositoryException;public void update(Complaint complaint) throws ObjectNotValidException,
               ObjectNotFoundException, ObjectNotValidException, RepositoryException;public IteratorDsk getComplaintList() throws ObjectNotFoundException, RepositoryException;public int insert(Complaint complaint) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;public Complaint search(int complaint) throws ObjectNotFoundException, RepositoryException;public boolean exists(int code) throws RepositoryException;
 } 
