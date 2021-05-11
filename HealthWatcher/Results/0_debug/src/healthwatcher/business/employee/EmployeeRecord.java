
//#if 1169631442
// Compilation Unit of /EmployeeRecord.java


//#if 852219346
package healthwatcher.business.employee;
//#endif


//#if -909048553
import lib.concurrency.ConcurrencyManager;
//#endif


//#if 1620033179
import lib.exceptions.ExceptionMessages;
//#endif


//#if -171032798
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -1466764619
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1662327471
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 301381553
import lib.exceptions.RepositoryException;
//#endif


//#if 1928388202
import healthwatcher.data.IEmployeeRepository;
//#endif


//#if -1183105466
import healthwatcher.model.employee.Employee;
//#endif


//#if 1237184397
public class EmployeeRecord
{

//#if 1958763804
    private IEmployeeRepository employeeRepository;
//#endif


//#if -218481788
    private ConcurrencyManager manager = new ConcurrencyManager();
//#endif


//#if 1124587830
    public EmployeeRecord(IEmployeeRepository rep)
    {

//#if -1303520036
        this.employeeRepository = rep;
//#endif

    }

//#endif


//#if 1522380264
    public void insert(Employee employee) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    {

//#if 1804637638
        manager.beginExecution(employee.getLogin());
//#endif


//#if -1175452506
        if(employeeRepository.exists(employee.getLogin())) { //1

//#if 568222587
            throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
//#endif

        } else {

//#if -820194118
            employeeRepository.insert(employee);
//#endif

        }

//#endif


//#if 1667383700
        manager.endExecution(employee.getLogin());
//#endif

    }

//#endif


//#if -1423142833
    public void update(Employee employee) throws ObjectNotValidException, ObjectNotFoundException,
        ObjectNotValidException, RepositoryException
    {

//#if -755770813
        employeeRepository.update(employee);
//#endif

    }

//#endif


//#if -1583325892
    public Employee search(String login) throws ObjectNotFoundException, RepositoryException
    {

//#if -1656302198
        return employeeRepository.search(login);
//#endif

    }

//#endif

}

//#endif


//#endif

