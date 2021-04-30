package healthwatcher.data;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
import healthwatcher.model.complaint.DiseaseType;
public interface IDiseaseRepository  { 
public void update(DiseaseType td) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException;public DiseaseType search(int code) throws ObjectNotFoundException, RepositoryException;public void insert(DiseaseType td) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;public IteratorDsk getDiseaseTypeList() throws ObjectNotFoundException, RepositoryException;public boolean exists(int code) throws RepositoryException;
 } 
