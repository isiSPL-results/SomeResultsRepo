// Compilation Unit of /EmployeeRepositoryArray.java

package healthwatcher.data.mem;
import healthwatcher.data.IEmployeeRepository;
import healthwatcher.model.employee.Employee;
import lib.exceptions.ObjectNotFoundException;
public class EmployeeRepositoryArray implements IEmployeeRepository
{
    private static final long serialVersionUID = 1L;
    private Employee[] vector;
    private int index;
    private int iteratorIndex;
    public void insert(Employee employee)
    {
        synchronized (this) { //1
            if(employee == null) { //1
                throw new IllegalArgumentException();
            }

            this.vector[index] = employee;
            index++;
        }

    }

    private int getIndex(String login)
    {
        synchronized (this) { //1
            String temp;
            boolean flag = false;
            int i = 0;
            while ((!flag) && (i < index)) { //1
                temp = vector[i].getLogin();
                if(temp.equals(login)) { //1
                    flag = true;
                } else {
                    i = i + 1;
                }

            }

            return i;
        }

    }

    public void remove(String login) throws ObjectNotFoundException
    {
        synchronized (this) { //1
            int i = getIndex(login);
            if(i == index) { //1
                throw new ObjectNotFoundException("Employee not found");
            } else {
                vector[i] = vector[index - 1];
                index = index - 1;
            }

        }

    }

    public EmployeeRepositoryArray()
    {
        vector = new Employee[5000];
        index = 0;
    }

    public void reset()
    {
        synchronized (this) { //1
            this.iteratorIndex = 0;
        }

    }

    public boolean exists(String login)
    {
        synchronized (this) { //1
            int i = getIndex(login);
            return (i != index);
        }

    }

    public void update(Employee employee) throws ObjectNotFoundException
    {
        synchronized (this) { //1
            int i = getIndex(employee.getLogin());
            if(i == index) { //1
                throw new ObjectNotFoundException("Employee not found");
            } else {
                vector[i] = employee;
            }

        }

    }

    public boolean hasNext()
    {
        synchronized (this) { //1
            return (iteratorIndex < index);
        }

    }

    public Employee search(String login) throws ObjectNotFoundException
    {
        synchronized (this) { //1
            Employee response = null;
            int i = getIndex(login);
            if(i == index) { //1
                throw new ObjectNotFoundException("Employee not found");
            } else {
                response = vector[i];
            }

            return response;
        }

    }

    public Object next()
    {
        synchronized (this) { //1
            if(iteratorIndex >= index) { //1
                return null;
            } else {
                return vector[iteratorIndex++];
            }

        }

    }

}


