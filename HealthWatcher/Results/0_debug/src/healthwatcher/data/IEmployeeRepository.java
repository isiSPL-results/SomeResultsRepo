
//#if 1102281785
// Compilation Unit of /IEmployeeRepository.java


//#if -1638894072
package healthwatcher.data;
//#endif


//#if 1896464620
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1914273835
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 748398629
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 1033531431
import lib.exceptions.RepositoryException;
//#endif


//#if 449980944
import healthwatcher.model.employee.Employee;
//#endif


//#if 1726423196
public interface IEmployeeRepository
{

//#if -957864395
    public void update(Employee employee) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException;
//#endif


//#if 2119660088
    public void remove(String login) throws ObjectNotFoundException, RepositoryException;
//#endif


//#if 168741186
    public void insert(Employee employee) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException;
//#endif


//#if 434565175
    public boolean exists(String login) throws RepositoryException;
//#endif


//#if -1838330218
    public Employee search(String login) throws ObjectNotFoundException, RepositoryException;
//#endif

}

//#endif


//#endif

