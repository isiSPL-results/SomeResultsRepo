// Compilation Unit of /ISymptomRepository.java

package healthwatcher.data;
import healthwatcher.model.complaint.Symptom;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;

//#if -2078649855
import lib.util.IteratorDsk;
//#endif

public interface ISymptomRepository
{
    public boolean exists(int code) throws RepositoryException;
    public void insert(Symptom s) throws ObjectNotValidException, ObjectAlreadyInsertedException,
               ObjectNotValidException, RepositoryException;
    public void remove(int code) throws ObjectNotFoundException, RepositoryException;
    public Symptom search(int code) throws ObjectNotFoundException, RepositoryException;
    public void update(Symptom s) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException;

//#if 35905280
    public IteratorDsk getSymptomList() throws ObjectNotFoundException, RepositoryException;
//#endif

}


