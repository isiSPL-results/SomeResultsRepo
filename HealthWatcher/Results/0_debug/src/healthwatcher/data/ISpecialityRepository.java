
//#if 871000878
// Compilation Unit of /ISpecialityRepository.java


//#if -2008470280
package healthwatcher.data;
//#endif


//#if -1293243428
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -884866245
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -2050741451
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 1360984887
import lib.exceptions.RepositoryException;
//#endif


//#if -85048560
import lib.util.IteratorDsk;
//#endif


//#if -659230346
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if -2017943437
public interface ISpecialityRepository
{

//#if -728994384
    public void insert(MedicalSpeciality esp) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
//#endif


//#if 514889910
    public void remove(int codigo) throws ObjectNotFoundException, RepositoryException;
//#endif


//#if -1643925180
    public boolean exists(int num) throws RepositoryException;
//#endif


//#if -1327167097
    public void update(MedicalSpeciality esp) throws ObjectNotValidException,
               ObjectNotFoundException, ObjectNotValidException, RepositoryException;
//#endif


//#if -708247944
    public MedicalSpeciality search(int codigo) throws ObjectNotFoundException, RepositoryException;
//#endif


//#if -988181289
    public IteratorDsk getSpecialityList() throws ObjectNotFoundException, RepositoryException;
//#endif

}

//#endif


//#endif

